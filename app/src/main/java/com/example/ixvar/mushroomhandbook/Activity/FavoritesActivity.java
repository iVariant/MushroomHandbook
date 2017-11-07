package com.example.ixvar.mushroomhandbook.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ixvar.mushroomhandbook.Adapter.ProductAdapter;
import com.example.ixvar.mushroomhandbook.BD.DatabaseHelper;
import com.example.ixvar.mushroomhandbook.Model.Product;
import com.example.ixvar.mushroomhandbook.R;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {


    private SQLiteDatabase db;
    private DatabaseHelper handbookDatabaseHelper;


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        handbookDatabaseHelper = new DatabaseHelper(getApplicationContext());
        db = handbookDatabaseHelper.getReadableDatabase();

        toolbar = (Toolbar) findViewById(R.id.htab_toolbar2);
        viewPager = (ViewPager) findViewById(R.id.htab_viewpager2);
        tabLayout = (TabLayout) findViewById(R.id.htab_tabs2);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(R.string.buttonFavorites);
        actionBar.setDisplayHomeAsUpEnabled(true);





        viewPagerAdapter = new FavoritesActivity.ViewPagerAdapter(getSupportFragmentManager());



 // тут изменить для каждой БД

        viewPagerAdapter.addFrag(new FavoritesActivity.DummyFragment(
                ContextCompat.getColor(this, R.color.bg_light_blue),
                getProducts(handbookDatabaseHelper.TABLE_BERRIES,handbookDatabaseHelper.COLUMN_BERRIES_FAVORITE) ), getString(R.string.buttonBerries) );


        viewPagerAdapter.addFrag(new FavoritesActivity.DummyFragment(
                ContextCompat.getColor(this, R.color.bg_light_blue),
                getProducts(handbookDatabaseHelper.TABLE_MUSHROOMS,handbookDatabaseHelper.COLUMN_MUSHROOMS_FAVORITE) ), getString(R.string.buttonMushrooms) );

        viewPagerAdapter.addFrag(new FavoritesActivity.DummyFragment(
                ContextCompat.getColor(this, R.color.bg_light_blue),
                getProducts(handbookDatabaseHelper.TABLE_HERBS,handbookDatabaseHelper.COLUMN_HERBS_FAVORITE) ), getString(R.string.buttonPlants) );



        viewPager.setAdapter(viewPagerAdapter);



        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        MainActivity.productType = "Berries";
                        break;
                    case 1:
                        MainActivity.productType = "Mushrooms";
                        break;
                    case 2:
                        MainActivity.productType = "Plants";
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

/*
    List<Product> getBerries()
    {
        Cursor cursor;
        List<Product> products;
        products = new ArrayList<>();

        cursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES + " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_FAVORITE+ " <> " + 0 , null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);

            products.add(new Product(id,cursor.getString(1),cursor.getString(2),getPictureBerrie(id)));

        }


        cursor.close();

        return products;
    }

    String getPictureBerrie(int idBerrie)
    {
        Cursor cursorPictures;
        String picture = "";


        cursorPictures = db.query (handbookDatabaseHelper.TABLE_BERRIE_PICTURES,
                new String[] {handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_URL},
                "id_berrie = ?",
                new String[] {Integer.toString(idBerrie)},
                null, null,null);

        if (cursorPictures.moveToFirst()) {
            picture = cursorPictures.getString(0);
        }



        cursorPictures.close();
        return picture;
    }

*/

    List<Product> getProducts(String table, String columnType)
    {
        Cursor cursor;
        List<Product> products;
        products = new ArrayList<>();

        cursor =  db.rawQuery("select * from " + table + " WHERE " + columnType + " <> " + 0  , null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            products.add(new Product(id,cursor.getString(1),cursor.getString(2),getPictureProduct(id,table)));
        }

        cursor.close();

        return products;
    }

    String getPictureProduct(int idProduct,String typeTable)
    {
        Cursor cursorPictures = null;
        String pictureURL = "";

        switch(typeTable) {
            case "berries":
                cursorPictures = db.query (handbookDatabaseHelper.TABLE_BERRIE_PICTURES,
                        new String[] {handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_URL},
                        handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_ID_BERRIE + " = ?",
                        new String[] {Integer.toString(idProduct)},
                        null, null,null);
                break;
            case "mushrooms":
                cursorPictures = db.query (handbookDatabaseHelper.TABLE_MUSHROOMS_PICTURES,
                        new String[] {handbookDatabaseHelper.COLUMN_MUSHROOMS_PICTURES_URL},
                        handbookDatabaseHelper.COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM + " = ?",
                        new String[] {Integer.toString(idProduct)},
                        null, null,null);
                break;
            case "herbs":
                cursorPictures = db.query (handbookDatabaseHelper.TABLE_HERBS_PICTURES,
                        new String[] {handbookDatabaseHelper.COLUMN_HERBS_PICTURES_URL},
                        handbookDatabaseHelper.COLUMN_HERBS_PICTURES_ID_HERB + " = ?",
                        new String[] {Integer.toString(idProduct)},
                        null, null,null);
                break;
        }



        if (cursorPictures.moveToFirst()) {
            pictureURL = cursorPictures.getString(0);
        }

        cursorPictures.close();
        return pictureURL;
    }










    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();
        private  List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }




        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }




        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public static class  DummyFragment extends Fragment {

        int color;
        List<Product> products;




        public DummyFragment() {
        }

        @SuppressLint("ValidFragment")
        public DummyFragment(int color, List<Product> products) {
            this.color = color;
            this.products = products;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dummy_fragment, container, false);

            final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
            frameLayout.setBackgroundColor(color);

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

//------------------===============----------------------

            ProductAdapter adapter = new ProductAdapter(products,getContext());
            recyclerView.setAdapter(adapter);



            return view;
        }



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}

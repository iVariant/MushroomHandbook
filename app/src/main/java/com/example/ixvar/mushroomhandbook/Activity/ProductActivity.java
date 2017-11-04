package com.example.ixvar.mushroomhandbook.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
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
import android.widget.ImageView;
import android.widget.Toast;


import com.example.ixvar.mushroomhandbook.Adapter.ProductAdapter;
import com.example.ixvar.mushroomhandbook.Model.Product;
import com.example.ixvar.mushroomhandbook.R;
import com.example.ixvar.mushroomhandbook.BD.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = ProductActivity.class.getSimpleName();

    private SQLiteDatabase db;
    private Cursor userCursor;
    private DatabaseHelper handbookDatabaseHelper;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
   // private ProductAdapter productAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_product);

        handbookDatabaseHelper = new DatabaseHelper(getApplicationContext());
        db = handbookDatabaseHelper.getReadableDatabase();

        ImageView imageViewHeader = (ImageView) findViewById(R.id.htab_header);

        switch(MainActivity.productType) {
            case "Berries":
                imageViewHeader.setImageResource(R.drawable.berries_header);
                break;
            case "Mushrooms":
                imageViewHeader.setImageResource(R.drawable.mushrums_header);
                break;
            case "Plants":
                imageViewHeader.setImageResource(R.drawable.plants_header);
                break;
        }

        final Toolbar toolbar = (Toolbar) findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);



        if (getSupportActionBar() != null) {
            switch(MainActivity.productType) {
                case "Berries":
                    getSupportActionBar().setTitle(R.string.buttonBerries);
                    break;
                case "Mushrooms":
                    getSupportActionBar().setTitle(R.string.buttonMushrooms);
                    break;
                case "Plants":
                    getSupportActionBar().setTitle(R.string.buttonPlants);
                    break;
            }
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.htab_tabs);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        try {

            switch(MainActivity.productType) {
                case "Berries":
                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES_TYPE, null);
                    while (userCursor.moveToNext()) {
                        viewPagerAdapter.addFrag(new DummyFragment( ContextCompat.getColor(this, R.color.bg_light_blue),getBerries(userCursor.getInt(0) ) ), userCursor.getString(1) );
                    }
                    break;
                case "Mushrooms":

                    break;
                case "Plants":

                    break;
            }



        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }



        viewPager.setAdapter(viewPagerAdapter);







        tabLayout.setupWithViewPager(viewPager);





        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);

        try {
            Bitmap bitmap = null;

            switch(MainActivity.productType) {
                case "Berries":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.berries_header);
                    break;
                case "Mushrooms":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mushrums_header);
                    break;
                case "Plants":
                    bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.plants_header);
                    break;
            }


            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                    collapsingToolbarLayout.setContentScrimColor(vibrantColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                }
            });

        } catch (Exception e) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace());

            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimaryDark)
            );
        }



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
                Log.d(TAG, "onTabSelected: pos: " + tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        // TODO: 31/03/17
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




    //=---------------------------------------

    String getColorBerrie(int idColor)
    {
        Cursor cursorColor;
        String color = "";

        cursorColor = db.query (handbookDatabaseHelper.TABLE_BERRIES_COLOR,
            new String[] {handbookDatabaseHelper.COLUMN_BERRIES_COLOR_NAME},
            "_id = ?",
            new String[] {Integer.toString(idColor)},
            null, null,null);

        if (cursorColor.moveToFirst()) {
            color = cursorColor.getString(0);
        }

        cursorColor.close();

        return color;
    }

    String getTypeBerrie(int idType)
    {
        Cursor cursorType;
        String type = "";

        cursorType = db.query (handbookDatabaseHelper.TABLE_BERRIES_TYPE,
                new String[] {handbookDatabaseHelper.COLUMN_BERRIES_TYPE_NAME},
                "_id = ?",
                new String[] {Integer.toString(idType)},
                null, null,null);

        if (cursorType.moveToFirst()) {
            type = cursorType.getString(0);
        }

        cursorType.close();

        return type;
    }

    String getSizeBerrie(int idSize)
    {
        Cursor cursorSize;
        String size = "";

        cursorSize = db.query (handbookDatabaseHelper.TABLE_BERRIES_SIZE,
                new String[] {handbookDatabaseHelper.COLUMN_BERRIES_SIZE_NAME},
                "_id = ?",
                new String[] {Integer.toString(idSize)},
                null, null,null);

        if (cursorSize.moveToFirst()) {
            size = cursorSize.getString(0);
        }

        cursorSize.close();

        return size;
    }

    String getSeasonsBerrie(int idBerrie)
    {
        Cursor cursorSeason;
        List<Integer> idSeasons = new ArrayList<>();

        String seasons = "";

        cursorSeason = db.query (handbookDatabaseHelper.TABLE_ID_BERRIE__ID_SEASON,
                new String[] {handbookDatabaseHelper.COLUMN_ID_SEASON},
                "id_berrie = ?",
                new String[] {Integer.toString(idBerrie)},
                null, null,null);

        while (cursorSeason.moveToNext()) {
            idSeasons.add(cursorSeason.getInt(0));
        }



        for(Integer idSeason : idSeasons){
            cursorSeason = db.query (handbookDatabaseHelper.TABLE_SEASONS,
                    new String[] {handbookDatabaseHelper.COLUMN_SEASONS_NAME},
                    "_id = ?",
                    new String[] {Integer.toString(idSeason)},
                    null, null,null);

            if (cursorSeason.moveToFirst()) {
                seasons += cursorSeason.getString(0) + " ";
            }
        }


        cursorSeason.close();

        return seasons;
    }



  /*  List<Integer> getPicturesBerrie(int idBerrie)
    {
        Cursor cursorPictures;

        List<Integer> pictures;
        pictures = new ArrayList<>();



        cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIE_PICTURES + " WHERE " + handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_ID_BERRIE + " = " + idBerrie , null);

        while (cursorPictures.moveToNext()) {
            pictures.add(cursorPictures.getInt(2));
            //pictures[i++] = cursorPictures.getInt(2);
        }

        cursorPictures.close();

        return pictures;
    }
*/
    /*
    List<Berrie> getBerries(int idType)
    {
        Cursor cursor;

        berries = new ArrayList<>();

        cursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES + " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_TYPE + " = " + idType , null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);

            berries.add(new Berrie(id,cursor.getString(1),cursor.getString(2),getPicturesBerrie(id),cursor.getString(3),getSizeBerrie(cursor.getInt(7)),getTypeBerrie(cursor.getInt(6)),
                    getColorBerrie(cursor.getInt(8)),cursor.getString(4),getSeasonsBerrie(id),cursor.getInt(5) > 0));

        }




        cursor.close();

        return berries;
    }
*/

    String getPictureBerrie(int idBerrie)
    {
        Cursor cursorPictures;
        String picture = "";

        /*cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIE_PICTURES +
                " WHERE " + handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_ID_BERRIE + " = " + idBerrie , null);

        while (cursorPictures.moveToNext()) {
            picture = cursorPictures.getInt(2);
            break;
        }*/
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

    List<Product> getBerries(int idType)
    {
        Cursor cursor;
        List<Product> products;
        products = new ArrayList<>();

        cursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES + " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_TYPE + " = " + idType , null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);

            products.add(new Product(id,cursor.getString(1),cursor.getString(2),getPictureBerrie(id)));

        }


        cursor.close();

        return products;
    }

    //=---------------------------------------





    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private  List<Fragment> mFragmentList = new ArrayList<>();
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


    List<Product> getBerriesFilter(int idType,String newText) {
        Cursor cursor;
        List<Product> products;
        products = new ArrayList<>();

        cursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES +
                " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_TYPE + " = " + idType +
                " and ( " + handbookDatabaseHelper.COLUMN_BERRIES_NAME + " LIKE '%" + newText + "%' " +
                        " or "+ handbookDatabaseHelper.COLUMN_BERRIES_OTHERNAMES + " LIKE '%" + newText + "%' ) "

                , null);


        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);

            products.add(new Product(id,cursor.getString(1),cursor.getString(2),getPictureBerrie(id)));

        }


        cursor.close();
        return products;
    }


    @Override
    public boolean onQueryTextChange(String newText) {



        int tabPosition = tabLayout.getSelectedTabPosition();



        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());







        try {


            switch(MainActivity.productType) {
                case "Berries":
                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES_TYPE, null);
                    while (userCursor.moveToNext()) {
                        viewPagerAdapter.addFrag(new DummyFragment( ContextCompat.getColor(this, R.color.bg_light_blue),getBerriesFilter(userCursor.getInt(0),newText ) ), userCursor.getString(1) );
                    }
                    break;
                case "Mushrooms":

                    break;
                case "Plants":

                    break;
            }

        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(tabPosition).select();








        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bd_poduct, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed

                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_info:

                AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);
                switch(MainActivity.productType) {
                    case "Berries":
                        builder.setTitle(R.string.menu_info)
                                .setMessage(R.string.menu_info_text_berries)
                                .setIcon(R.drawable.ic_spider_menu)
                                .setCancelable(false)
                                .setNegativeButton(R.string.menu_close,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        break;
                    case "Mushrooms":
                        builder.setTitle(R.string.menu_info)
                                .setMessage(R.string.menu_info_text_mushrooms)
                                .setIcon(R.drawable.ic_spider_menu)
                                .setCancelable(false)
                                .setNegativeButton(R.string.menu_close,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        break;
                    case "Plants":
                        builder.setTitle(R.string.menu_info)
                                .setMessage(R.string.menu_info_text_plants)
                                .setIcon(R.drawable.ic_spider_menu)
                                .setCancelable(false)
                                .setNegativeButton(R.string.menu_close,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        break;
                }




                AlertDialog alert = builder.create();
                alert.show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userCursor.close();
        db.close();
    }
}
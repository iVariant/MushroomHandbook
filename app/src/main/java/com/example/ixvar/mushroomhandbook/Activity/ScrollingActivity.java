package com.example.ixvar.mushroomhandbook.Activity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ixvar.mushroomhandbook.ContentFragment;
import com.example.ixvar.mushroomhandbook.Model.Product;
import com.example.ixvar.mushroomhandbook.R;
import com.example.ixvar.mushroomhandbook.BD.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private ViewPager mPager;
    private LinearLayout mLinearLayout;
    private CustomPagerAdapter2 mAdapter;
    private MyPageIndicator mIndicator;


    private SQLiteDatabase db;
    private Cursor userCursor;
    private DatabaseHelper handbookDatabaseHelper;

    private String id;
    private boolean favorite;

    TextView textViewProduct;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        handbookDatabaseHelper = new DatabaseHelper(getApplicationContext());
        db =  handbookDatabaseHelper.getReadableDatabase();

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        mPager = (ViewPager) findViewById(R.id.pager);
        textViewProduct = (TextView) findViewById(R.id.content_text);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        List<Fragment> fragments = new ArrayList<>();

        fragments = getPictures();








        mAdapter = new CustomPagerAdapter2(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mAdapter);
        mIndicator = new MyPageIndicator(this, mLinearLayout, mPager, R.drawable.indicator_circle);

        mIndicator.setPageCount(fragments.size());
        mIndicator.show();


    }

    List<Fragment> getPictures()
    {
        Cursor cursorPictures = null;

        List<Fragment> pictures;
        pictures = new ArrayList<>();


        switch(MainActivity.productType) {
            case "Berries":
                cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIE_PICTURES +
                        " WHERE " + handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_ID_BERRIE + " = " + id , null);
                break;

            case "Mushrooms":
                cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_MUSHROOMS_PICTURES +
                        " WHERE " + handbookDatabaseHelper.COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM + " = " + id , null);
                break;
            case "Plants":
                cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_HERBS_PICTURES +
                        " WHERE " + handbookDatabaseHelper.COLUMN_HERBS_PICTURES_ID_HERB + " = " + id , null);
                break;
        }



        while (cursorPictures.moveToNext()) {
            pictures.add(ContentFragment.newInstance(cursorPictures.getString(2)));
        }

        cursorPictures.close();

        return pictures;
    }

    String getSeasons(int idProduct,String table, String producTable)
    {
        Cursor cursorSeason;
        List<Integer> idSeasons = new ArrayList<>();

        String seasons = "";

        cursorSeason = db.query (table,
                new String[] {handbookDatabaseHelper.COLUMN_ID_SEASON},
                producTable + " = ?",
                new String[] {Integer.toString(idProduct)},
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
                seasons += cursorSeason.getString(0) + ", ";
            }
        }

        seasons = seasons.substring(0, seasons.length()-2);

        seasons += ".";

        cursorSeason.close();

        return seasons;
    }






    @Override
    protected void onResume() {
        super.onResume();



        try {

            String text = "";
            String seasons = "";
            List<Integer> posList;
            posList = new ArrayList<>();


            switch(MainActivity.productType) {
                case "Berries":

                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES +
                            " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_ID + " = " + id , null);

                    seasons = getSeasons(Integer.valueOf(id),handbookDatabaseHelper.TABLE_ID_BERRIE__ID_SEASON,handbookDatabaseHelper.COLUMN_ID_BERRIE);



                    break;
                case "Mushrooms":


                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_MUSHROOMS +
                            " WHERE " + handbookDatabaseHelper.COLUMN_MUSHROOMS_ID + " = " + id , null);

                    seasons = getSeasons(Integer.valueOf(id),handbookDatabaseHelper.TABLE_ID_MUSHROOM__ID_SEASON,handbookDatabaseHelper.COLUMN_ID_MUSHROOM);


                    break;
                case "Plants":


                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_HERBS +
                            " WHERE " + handbookDatabaseHelper.COLUMN_HERBS_ID + " = " + id , null);

                    seasons = getSeasons(Integer.valueOf(id),handbookDatabaseHelper.TABLE_ID_HERB__ID_SEASON,handbookDatabaseHelper.COLUMN_ID_HERB);




                    break;
            }


            while (userCursor.moveToNext()) {
                setTitle(userCursor.getString(1));

                favorite = userCursor.getInt(5) > 0;

                if(favorite == true) {
                    fab.setImageResource(R.drawable.ic_star_true);
                }
                else {
                    fab.setImageResource(R.drawable.ic_star_false);
                }


                posList.add(text.length());


                text += getString(R.string.other_names);
                posList.add(text.length());

                text += userCursor.getString(2);
                posList.add(text.length());

                text += getString(R.string.seasons);
                posList.add(text.length());

                text += seasons;
                posList.add(text.length());


                text += getString(R.string.place);
                posList.add(text.length());

                text += userCursor.getString(4);
                posList.add(text.length());

                text += getString(R.string.description);
                posList.add(text.length());

                text += userCursor.getString(3);


                Spannable textSpannable = new SpannableString(text);



                for(int i = 0; i < posList.size()/2 ;i++)
                {
                    textSpannable.setSpan(new StyleSpan(Typeface.BOLD),  posList.get(i*2),  posList.get(i*2+1), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }



                textViewProduct.setText(textSpannable);
            }


        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    ContentValues cv = new ContentValues();

                    switch(MainActivity.productType) {
                        case "Berries":


                            if(favorite == true) {
                                cv.put(handbookDatabaseHelper.COLUMN_BERRIES_FAVORITE, false);
                                db.update(handbookDatabaseHelper.TABLE_BERRIES, cv, handbookDatabaseHelper.COLUMN_BERRIES_ID + "=" + id, null);

                            } else {
                                cv.put(handbookDatabaseHelper.COLUMN_BERRIES_FAVORITE, true);
                                db.update(handbookDatabaseHelper.TABLE_BERRIES, cv, handbookDatabaseHelper.COLUMN_BERRIES_ID + "=" + id, null);
                            }

                            break;
                        case "Mushrooms":
                            if(favorite == true) {
                                cv.put(handbookDatabaseHelper.COLUMN_MUSHROOMS_FAVORITE, false);
                                db.update(handbookDatabaseHelper.TABLE_MUSHROOMS, cv, handbookDatabaseHelper.COLUMN_MUSHROOMS_ID + "=" + id, null);

                            } else {
                                cv.put(handbookDatabaseHelper.COLUMN_MUSHROOMS_FAVORITE, true);
                                db.update(handbookDatabaseHelper.TABLE_MUSHROOMS, cv, handbookDatabaseHelper.COLUMN_MUSHROOMS_ID + "=" + id, null);
                            }
                            break;
                        case "Plants":


                            if(favorite == true) {
                                cv.put(handbookDatabaseHelper.COLUMN_HERBS_FAVORITE, false);
                                db.update(handbookDatabaseHelper.TABLE_HERBS, cv, handbookDatabaseHelper.COLUMN_HERBS_ID + "=" + id, null);

                            } else {
                                cv.put(handbookDatabaseHelper.COLUMN_HERBS_FAVORITE, true);
                                db.update(handbookDatabaseHelper.TABLE_HERBS, cv, handbookDatabaseHelper.COLUMN_HERBS_ID + "=" + id, null);
                            }

                            break;
                    }

                    onResume();

                } catch(SQLiteException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIndicator.cleanup();
        userCursor.close();
        db.close();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_info:

                return true;
        }

        return super.onOptionsItemSelected(item);
    }




    static class CustomPagerAdapter2 extends FragmentStatePagerAdapter {

        List<Fragment> mFrags = new ArrayList<>();

        public CustomPagerAdapter2(FragmentManager fm, List<Fragment> frags) {
            super(fm);
            mFrags = frags;
        }

        @Override
        public Fragment getItem(int position) {
            int index = position % mFrags.size();
            return mFrags.get(index);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

    }

    private class MyPageIndicator implements ViewPager.OnPageChangeListener {
        private Context mContext;
        private LinearLayout mContainer;
        private int mDrawable;
        private int mSpacing;
        private int mSize;
        private ViewPager mViewPager;
        private int mPageCount;
        private int mInitialPage = 0;

        private int defaultSizeInDp = 12;
        private int defaultSpacingInDp = 12;

        public MyPageIndicator(@NonNull Context context, @NonNull LinearLayout containerView, @NonNull ViewPager viewPager, @DrawableRes int drawableRes) {
            if (context == null) {
                throw new IllegalArgumentException("context cannot be null");
            } else if (containerView == null) {
                throw new IllegalArgumentException("containerView cannot be null");
            } else if (viewPager == null) {
                throw new IllegalArgumentException("ViewPager cannot be null");
            } else if (viewPager.getAdapter() == null) {
                throw new IllegalArgumentException("ViewPager does not have an adapter set on it.");
            }
            mContext = context;
            mContainer = containerView;
            mDrawable = drawableRes;
            mViewPager = viewPager;

        }

        public void setPageCount(int pageCount) {
            mPageCount = pageCount;
        }

        public void setInitialPage(int page) {
            mInitialPage = page;
        }

        public void setDrawable(@DrawableRes int drawable) {
            mDrawable = drawable;
        }

        public void setSpacingRes(@DimenRes int spacingRes) {
            mSpacing = spacingRes;
        }

        public void setSize(@DimenRes int dimenRes) {
            mSize = dimenRes;
        }

        public void show() {
            initIndicators();
            setIndicatorAsSelected(mInitialPage);
        }

        private void initIndicators() {
            if (mContainer == null || mPageCount <= 0) {
                return;
            }

            mViewPager.addOnPageChangeListener(this);
            Resources res = mContext.getResources();
            mContainer.removeAllViews();
            for (int i = 0; i < mPageCount; i++) {
                View view = new View(mContext);
                int dimen = mSize != 0 ? res.getDimensionPixelSize(mSize) : ((int) res.getDisplayMetrics().density * defaultSizeInDp);
                int margin = mSpacing != 0 ? res.getDimensionPixelSize(mSpacing) : ((int) res.getDisplayMetrics().density * defaultSpacingInDp);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dimen, dimen);
                lp.setMargins(i == 0 ? 0 : margin, 0, 0, 0);
                view.setLayoutParams(lp);
                view.setBackgroundResource(mDrawable);
                view.setSelected(i == 0);
                mContainer.addView(view);
            }
        }

        private void setIndicatorAsSelected(int index) {
            if (mContainer == null) {
                return;
            }
            for (int i = 0; i < mContainer.getChildCount(); i++) {
                View view = mContainer.getChildAt(i);
                view.setSelected(i == index);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int index = position % mPageCount;
            setIndicatorAsSelected(index);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        public void cleanup() {
            mViewPager.clearOnPageChangeListeners();
        }
    }


}

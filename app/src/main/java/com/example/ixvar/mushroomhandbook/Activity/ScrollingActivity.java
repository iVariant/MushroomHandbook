package com.example.ixvar.mushroomhandbook.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ixvar.mushroomhandbook.ContentFragment;
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

    TextView textViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        handbookDatabaseHelper = new DatabaseHelper(getApplicationContext());
        db =  handbookDatabaseHelper.getReadableDatabase();

        Intent intent = getIntent();
        id = intent.getStringExtra("id");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textViewProduct = (TextView) findViewById(R.id.content_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mPager = (ViewPager) findViewById(R.id.pager);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        List<Fragment> fragments = new ArrayList<>();



        try {

            switch(MainActivity.productType) {
                case "Berries":

                    userCursor =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIES +
                            " WHERE " + handbookDatabaseHelper.COLUMN_BERRIES_ID + " = " + id , null);

                    while (userCursor.moveToNext()) {
                        setTitle(userCursor.getString(1));

                        String text = "";

                        text += getString(R.string.other_names);
                        text += userCursor.getString(2);

                        textViewProduct.setText(text);
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





        //fragments = getPicturesBerrie();



 // тут ссыоки на файлы
       fragments.add(ContentFragment.newInstance(R.drawable.autumn));
        fragments.add(ContentFragment.newInstance(R.drawable.winter));
        fragments.add(ContentFragment.newInstance(R.drawable.summer));
        fragments.add(ContentFragment.newInstance(R.drawable.spring));

        mAdapter = new CustomPagerAdapter2(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mAdapter);
        mIndicator = new MyPageIndicator(this, mLinearLayout, mPager, R.drawable.indicator_circle);

        mIndicator.setPageCount(fragments.size());
        mIndicator.show();


    }

    List<Fragment> getPicturesBerrie()
    {
        Cursor cursorPictures;

        List<Fragment> pictures;
        pictures = new ArrayList<>();

        cursorPictures =  db.rawQuery("select * from " + handbookDatabaseHelper.TABLE_BERRIE_PICTURES +
                " WHERE " + handbookDatabaseHelper.COLUMN_BERRIE_PICTURES_ID_BERRIE + " = " + id , null);

        while (cursorPictures.moveToNext()) {
            pictures.add(ContentFragment.newInstance(cursorPictures.getInt(2)));
        }

        cursorPictures.close();

        return pictures;
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

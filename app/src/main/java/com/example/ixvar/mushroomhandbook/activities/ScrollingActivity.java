package com.example.ixvar.mushroomhandbook.activities;

import android.content.Context;
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
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ixvar.mushroomhandbook.ContentFragment;
import com.example.ixvar.mushroomhandbook.R;
import com.example.ixvar.mushroomhandbook.bd.DatabaseHelper;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        handbookDatabaseHelper = new DatabaseHelper(getApplicationContext());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            db =  handbookDatabaseHelper.getReadableDatabase();

            userCursor =  db.rawQuery("select * from " + DatabaseHelper.TABLE_PICTURES , null);

            while (userCursor.moveToNext()) {
                int pictureREs = userCursor.getInt(1);
                fragments.add(ContentFragment.newInstance(pictureREs));
            }

        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


      /* fragments.add(ContentFragment.newInstance(R.drawable.autumn));
        fragments.add(ContentFragment.newInstance(R.drawable.winter));
        fragments.add(ContentFragment.newInstance(R.drawable.summer));
        fragments.add(ContentFragment.newInstance(R.drawable.spring));*/

        mAdapter = new CustomPagerAdapter2(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mAdapter);
        mIndicator = new MyPageIndicator(this, mLinearLayout, mPager, R.drawable.indicator_circle);

        mIndicator.setPageCount(fragments.size());
        mIndicator.show();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIndicator.cleanup();
        userCursor.close();
        db.close();
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

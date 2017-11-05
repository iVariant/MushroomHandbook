package com.example.ixvar.mushroomhandbook;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class ContentFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParamPicture;

    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(String paramPicture) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, paramPicture);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamPicture = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        //TextView text = (TextView) view.findViewById(R.id.text);
        //text.setText(mParam1);

        //FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.framePictures);
        //frameLayout.setBackgroundColor(Color.RED);

        //view.setBackgroundResource(mParamPicture);



        try {
            // получаем входной поток
            InputStream ims =  getContext().getAssets().open(mParamPicture);
            // загружаем как Drawable
            Drawable drawable = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            view.setBackground(drawable);
        }
        catch(IOException ex) {
            //return;
        }

        return view;
    }

    public String getmParamPicture() {
        return mParamPicture;
    }

}

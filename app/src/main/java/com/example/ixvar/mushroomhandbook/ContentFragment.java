package com.example.ixvar.mushroomhandbook;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


public class ContentFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private int mParamPicture;

    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(int paramPicture) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, paramPicture);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamPicture = getArguments().getInt(ARG_PARAM1);
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

        view.setBackgroundResource(mParamPicture);
        return view;
    }

    public int getmParamPicture() {
        return mParamPicture;
    }

}

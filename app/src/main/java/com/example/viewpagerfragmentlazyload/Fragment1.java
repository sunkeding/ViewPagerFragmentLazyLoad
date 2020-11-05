package com.example.viewpagerfragmentlazyload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends LazyFragment {
    private String TAG = "Fragment";

    public Fragment1() {
        Log.d(TAG, "Fragment1()");
    }

    @SuppressLint("ValidFragment")
    public Fragment1(int pos) {
        TAG = TAG + pos;
        Log.d(TAG, "Fragment1(int pos)");
        this.pos = pos;
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        setArguments(bundle);
    }

    int pos = -1;

    //    public Fragment1(int pos) {
//        Fragment1 fragment = new Fragment1();
//        this.pos=pos;
//        return fragment;
//    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated:");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint:" + isVisibleToUser + ",getUserVisibleHint():" + getUserVisibleHint());
    }

    @Override
    protected void lazyload() {
        TextView tv=mRootView.findViewById(R.id.tv1);
        tv.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("Fragment"+pos);
                Log.d("xxx","pos:"+pos);
            }
        },500);
        Log.d(TAG, "lazyload:");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment1_layout;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged:" + hidden);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pos = getArguments().getInt("pos");
//        TAG=TAG+pos;
        Log.d(TAG, "onAttach:");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:");

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause:");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView:");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach:");
    }
}

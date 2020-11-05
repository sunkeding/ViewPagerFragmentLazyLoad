package com.example.viewpagerfragmentlazyload;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LazyFragment extends Fragment {
    protected boolean mViewHasInit = false;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        mViewHasInit = true;
        isCanLoadData();
        return mRootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }
    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!mViewHasInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyload();
        }
    }

    protected abstract void lazyload();

    protected abstract int getContentViewId();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewHasInit = false;
    }
}

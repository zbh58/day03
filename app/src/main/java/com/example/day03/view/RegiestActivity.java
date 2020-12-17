package com.example.day03.view;

import android.util.Log;

import com.example.day03.R;
import com.example.day03.base.BaseActivity;
import com.example.day03.contract.MainContract;
import com.example.day03.model.data.NewsBean;
import com.example.day03.presenter.MainPresenterImpl;
import com.example.day03.net.URLConstant;

public class RegiestActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {



    @Override
    protected void initData() {
        //TODO 初始化
        presenter.login(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_regiest;
    }


    @Override
    public MainPresenterImpl getPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public <T> void loginRelt(T t) {
        NewsBean newsBean = (NewsBean) t;
        Log.e("TAG", "loginRelt: "+newsBean.getNews().get(0).getImageUrl());
    }

    @Override
    public void tips(String string) {
        Log.e("TAG", "tips: "+string);
    }
}
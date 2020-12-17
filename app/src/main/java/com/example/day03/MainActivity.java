package com.example.day03;

import android.util.Log;

import com.example.day03.base.BaseActivity;
import com.example.day03.contract.MainContract;
import com.example.day03.model.data.NewsBean;
import com.example.day03.presenter.MainPresenterImpl;
import com.example.day03.net.URLConstant;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {
    private ArrayList<NewsBean.NewsDTO> newslist = new ArrayList<>();
    @Override
    protected void initData() {
        presenter.login(URLConstant.NEWLIST);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenterImpl getPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public <T> void loginRelt(T t) {
        NewsBean newsBean = (NewsBean) t;
        newslist.clear();
        newslist.addAll(newsBean.getNews());
        for (int i = 0; i < newslist.size(); i++) {
            Log.e("TAG", "loginRelt: "+newslist.get(i).getImageUrl());
            Log.e("TAG", "loginRelt: "+newslist.get(i).getContent());
            Log.e("TAG", "loginRelt: "+newslist.get(i).getTile());
        }
    }

    @Override
    public void tips(String string) {
        Log.e("TAG", "tips: "+string);
    }
}
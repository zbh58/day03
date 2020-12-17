package com.example.day03.presenter;

import com.example.day03.base.BasePresenter;
import com.example.day03.contract.MainContract;
import com.example.day03.model.MainModelImpl;
import com.example.day03.model.data.NewsBean;
import com.example.day03.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter implements MainContract.IMainPresenter {

    private MainContract.IMainModel model;
    private MainContract.IMainView view;

    public MainPresenterImpl(MainContract.IMainView view) {
        this.model = new MainModelImpl(this);
        this.view = view;
    }

    @Override
    public void login(String url) {
        model.getLoginData(url, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                view.loginRelt(newsBean);
            }

            @Override
            public void onFail(String err) {
                view.tips(err);
            }
        });
    }
}

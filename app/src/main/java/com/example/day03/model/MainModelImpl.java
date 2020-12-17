package com.example.day03.model;

import com.example.day03.contract.MainContract;
import com.example.day03.model.data.NewsBean;
import com.example.day03.net.INetCallBack;
import com.example.day03.net.RetrofitUtils;

public class MainModelImpl implements MainContract.IMainModel {

    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                callBack.onSuccess((T) newsBean);
            }

            @Override
            public void onFail(String err) {
                callBack.onFail(err);
            }
        });
    }
}

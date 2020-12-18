package com.example.day12_17.model;

import com.example.day12_17.contract.MainContract;
import com.example.day12_17.utils.INetCallBack;
import com.example.day12_17.utils.RetorfitUtils;

public class MainModelImpl implements MainContract.IMainModel {
    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getList(String url, INetCallBack<T> callBack) {
        presenter.listResult("成功");
        RetorfitUtils.getRetorfitUtils().get(url,callBack);
    }
}

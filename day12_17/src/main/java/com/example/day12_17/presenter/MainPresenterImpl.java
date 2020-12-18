package com.example.day12_17.presenter;

import com.example.day12_17.base.BasePresenter;
import com.example.day12_17.bean.DatBean;
import com.example.day12_17.contract.MainContract;
import com.example.day12_17.model.MainModelImpl;
import com.example.day12_17.utils.INetCallBack;
import com.example.day12_17.utils.URLConstant;

public class MainPresenterImpl extends BasePresenter implements MainContract.IMainPresenter {
    private final MainModelImpl model;
    private MainContract.IMainView mainView;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainView = mainView;
        model = new MainModelImpl(this);
    }

    @Override
    public void getList() {
        model.getList("Girl/page/7/count/10", new INetCallBack<DatBean>() {
            @Override
            public void onSuccess(DatBean datBean) {
                mainView.getList(datBean);
            }

            @Override
            public void onFail(String error) {
                mainView.onFail(error);
            }
        });
    }

    @Override
    public void listResult(String result) {

    }
}

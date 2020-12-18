package com.example.day12_17.contract;

import com.example.day12_17.bean.DatBean;
import com.example.day12_17.utils.INetCallBack;

public class MainContract {
    public interface IMainModel{
        <T> void getList(String url, INetCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void getList();
        void listResult(String result);
    }
    public interface IMainView{
        void getList(DatBean datBean);
        void onFail(String error);
    }
}

package com.example.day03.net;

public interface INetCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String err);
}

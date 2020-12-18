package com.example.day12_17.utils;

public interface INetCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String error);
}

package com.example.day12_17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.day12_17.adapter.DataAdapter;
import com.example.day12_17.base.BaseActivity;
import com.example.day12_17.bean.DatBean;
import com.example.day12_17.contract.MainContract;
import com.example.day12_17.presenter.MainPresenterImpl;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {

    private RecyclerView rv_main;
    private ArrayList<DatBean.DataBean> list;
    private DataAdapter adapter;

    @Override
    protected void initData() {
        presenter.getList();
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new DataAdapter(this, list);
        rv_main.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        rv_main = findViewById(R.id.rv_main);
    }

    @Override
    protected MainPresenterImpl getPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void getList(DatBean datBean) {
        list.addAll(datBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
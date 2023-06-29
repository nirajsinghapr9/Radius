package com.example.redius;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.redius.adapteer.FacilityAdapter;
import com.example.redius.db.AppDatabase;
import com.example.redius.di.base.BaseActivity;
import com.example.redius.model.DataResponse;
import com.example.redius.model.FacilityResponse;
import com.example.redius.model.Option;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View, FacilityAdapter.ClickListenerFacility {

    @Inject
    MainContract.Presenter presenter;
    @Inject
    AppDatabase appDatabase;
    private FacilityAdapter facilityAdapter;
    List<FacilityResponse> facilityResponses = new ArrayList<>();
    DataResponse dataResponse;

    @Override
    public void initView() {
        super.initView();
        presenter.attach(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView ParentRecyclerViewItem = findViewById(
                R.id.parent_recyclerview);
        facilityAdapter = new FacilityAdapter(this, facilityResponses);
        facilityAdapter.setOnClickListener(this);
        presenter.getFacilites();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        ParentRecyclerViewItem
                .setAdapter(facilityAdapter);
        ParentRecyclerViewItem
                .setLayoutManager(layoutManager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void facilitesResponse(DataResponse data) {
        dataResponse = data;
        facilityAdapter.setData(data.getFacilities());


    }

    @Override
    public void onChildClick(int selectedPosition, String id, String facId) {

    }
}
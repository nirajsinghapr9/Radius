package com.example.redius;


import com.example.redius.di.base.BasePresenter;
import com.example.redius.model.DataResponse;

import java.util.List;

import dagger.Provides;

public interface MainContract {
    interface View {
        void facilitesResponse(DataResponse data);
    }

    interface Presenter extends BasePresenter<View>{
        void getFacilites();
    }
}

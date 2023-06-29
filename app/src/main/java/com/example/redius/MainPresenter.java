package com.example.redius;

import com.example.redius.db.AppDatabase;
import com.example.redius.model.DataResponse;
import com.example.redius.network.ApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    @Inject
    ApiService service;
    @Inject
    AppDatabase appDatabase;

    @Inject
    public MainPresenter() {
    }
    @Inject
    MainContract.View view;

    @Override
    public void getFacilites() {
        service.getFacilities("https://my-json-server.typicode.com/iranjith4/ad-assignment/db")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<DataResponse>>() {
                    @Override
                    public void onNext(Response<DataResponse> responseBody) {
                        if (view != null) {
                            if (responseBody.code() == 200) {
                                appDatabase.facilitiesDao().insertAll(responseBody.body().getFacilities());
                                appDatabase.facilitiesDao().insertAllOptions(responseBody.body().getFacilities().get(0).getOptions());
                                view.facilitesResponse(responseBody.body());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attach(MainContract.View view) {


    }

    @Override
    public void detach() {

    }
}

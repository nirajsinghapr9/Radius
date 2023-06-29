package com.example.redius.di.base;


public interface BasePresenter<V> {

    /**
     * to attache view
     *
     * @param view : related view
     */
    void attach(V view);

    /**
     * detached view
     */
    void detach();
}

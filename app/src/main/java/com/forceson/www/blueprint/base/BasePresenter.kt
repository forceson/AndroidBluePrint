package com.forceson.www.blueprint.base

import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BasePresenter {
    internal val compositeDisposable = CompositeDisposable()

    abstract fun onCreate()
    abstract fun onResume()
    abstract fun onDestroy()
}
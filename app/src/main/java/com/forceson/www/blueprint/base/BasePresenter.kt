package com.forceson.www.blueprint.base

abstract class BasePresenter {
    abstract fun onCreate()
    abstract fun onResume()
    abstract fun onDestroy()
}
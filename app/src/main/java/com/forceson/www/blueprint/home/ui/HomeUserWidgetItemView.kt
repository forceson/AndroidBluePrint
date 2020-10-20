package com.forceson.www.blueprint.home.ui

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.forceson.www.blueprint.R
import com.forceson.www.blueprint.data.User
import kotlinx.android.synthetic.main.home_user_widget_item_view.view.userAvatarImg
import kotlinx.android.synthetic.main.home_user_widget_item_view.view.usernameTxt

class HomeUserWidgetItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.home_user_widget_item_view, this, true)
        layoutParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setData(user: User) {
        user.avatarUrl?.let { userAvatarImg.setImageURI(Uri.parse(it)) }
        usernameTxt.text = user.name
    }
}
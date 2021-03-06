package com.aliletter.loginshare.proxy;


import android.content.Intent;
import android.support.v4.app.Fragment;

import com.aliletter.loginshare.impl.BaseLoginShare;

/**
 * Author：alilettter
 * Github: http://github.com/aliletter
 * Email: 4884280@qq.com
 * data: 2017/12/11
 */

//替身Fragment，必须要V4的才行
public class ProxyFragment extends Fragment {


    private BaseLoginShare baseLogin;

    public ProxyFragment() {
    }

    public ProxyFragment(BaseLoginShare baseLogin) {
        this.baseLogin = baseLogin;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //QQ登录的回调
        if (baseLogin.getTencent() != null) {
            baseLogin.getTencent().onActivityResultData(requestCode, resultCode, data, baseLogin.getIUIListener());
        }
        //微博登录的回调
        if (baseLogin.getSsoHandler() != null) {
            baseLogin.getSsoHandler().authorizeCallBack(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

}

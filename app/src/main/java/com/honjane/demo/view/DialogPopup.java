package com.honjane.demo.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.honjane.demo.R;
import com.honjane.demo.lib.CommonPopupWindow;

/**
 * Created by Administrator on 2016/4/10.
 */
public class DialogPopup extends CommonPopupWindow implements View.OnClickListener {

    public DialogPopup(Activity context) {
        super(context);
        mPopupView.findViewById(R.id.tv_cancel).setOnClickListener(this);
        mPopupView.findViewById(R.id.tv_ok).setOnClickListener(this);

    }

    @Override
    public void setHeight(int height) {
        super.setHeight(150);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(300);
    }

    @Override
    public View getPopupView() {
        return getPopupViewById(R.layout.dialog_layout);
    }

    @Override
    public View getDismissView() {
        return mPopupView;
    }

    @Override
    public View getInsideView() {
        return mPopupView.findViewById(R.id.inside_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_ok:
                Toast.makeText(mContext, "点击了dialog ok 按钮", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

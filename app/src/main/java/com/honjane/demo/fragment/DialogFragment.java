package com.honjane.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.honjane.demo.R;
import com.honjane.demo.lib.CommonPopupWindow;
import com.honjane.demo.view.DialogPopup;


/**
 * Created by honjane on 2016/4/10.
 */
public class DialogFragment extends Fragment implements View.OnClickListener {
    private View mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog, container, false);
        mButton = view.findViewById(R.id.btn_popup_show);
        mButton.setOnClickListener(this);
        return view;
    }

    public CommonPopupWindow getPopup() {
        return new DialogPopup(getActivity());
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_popup_show) {
            if (getPopup() != null) {
                getPopup().showPopupWindow(mButton);
            }
        }
    }
}

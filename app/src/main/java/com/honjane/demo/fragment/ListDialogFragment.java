package com.honjane.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.honjane.demo.R;
import com.honjane.demo.lib.CommonPopupWindow;
import com.honjane.demo.view.DialogPopup;
import com.honjane.demo.view.ListPopup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by honjane on 2016/4/10.
 */
public class ListDialogFragment extends Fragment implements View.OnClickListener, ListPopup.IListClickListener {
    private View mButton;
    private static List<Object> mDatas;

    static {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDatas.add("item" + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog, container, false);
        mButton = view.findViewById(R.id.btn_popup_show);
        ((TextView) view.findViewById(R.id.tv_desc)).setText("ListPopup Fragment");
        mButton.setOnClickListener(this);
        return view;
    }

    public CommonPopupWindow getPopup() {
        ListPopup popup = new ListPopup(getActivity(), mDatas);
        popup.setOnListClickListener(this);
        return popup;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_popup_show) {
            if (getPopup() != null) {
                getPopup().showPopupWindow(mButton);
            }
        }
    }

    @Override
    public void onItemClick(int id) {
        Toast.makeText(getActivity(), "点击了" + id, Toast.LENGTH_SHORT).show();
    }
}

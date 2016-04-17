package com.honjane.demo.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.honjane.demo.R;
import com.honjane.demo.lib.CommonPopupWindow;

import java.util.List;

/**
 * Created by Administrator on 2016/4/17.
 */
public class ListPopup extends CommonPopupWindow {

    private ListView mListView;
    private IListClickListener mOnListClickListener;

    public ListPopup(Activity context,List<Object> listDate) {
        super(context);
        mListView = (ListView) mPopupView.findViewById(R.id.lv_content);
        setAdapter(context, listDate);
    }

    public void setOnListClickListener(IListClickListener listener) {
        mOnListClickListener = listener;
    }
    @Override
    public View getPopupView() {
        return getPopupViewById(R.layout.list_layout);
    }

    @Override
    public View getInsideView() {
        return mPopupView.findViewById(R.id.inside_layout);
    }

    @Override
    public View getDismissView() {
        return mPopupView;
    }

    private void setAdapter(Activity context, List<Object> data) {
        if (data == null || data.isEmpty()) {
            return;
        }
        final ListBaseAdapter adapter = new ListBaseAdapter(context, data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnListClickListener != null) {
                    Object clickObj = adapter.getItemList().get(position);
                    if (clickObj instanceof String) {
                        mOnListClickListener.onItemClick(position);
                    }
                    if (clickObj instanceof clickItem) {
                        int itemId = ((clickItem) clickObj).clickId;
                        mOnListClickListener.onItemClick(itemId);
                    }
                }
            }
        });
    }

    class ListBaseAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;
        private List<Object> mItemList;

        public ListBaseAdapter(Context context, @NonNull List<Object> itemList) {
            mContext = context;
            mItemList = itemList;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mItemList == null || mItemList.isEmpty() ? 0 : mItemList.size();
        }

        @Override
        public String getItem(int position) {
            if (position < 0 || position > mItemList.size() - 1) {
                return null;
            }
            if (mItemList.get(position) instanceof String) {
                return (String) mItemList.get(position);
            }
            if (mItemList.get(position) instanceof clickItem) {
                return ((clickItem) mItemList.get(position)).getItemStr();
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh = null;
            if (convertView == null) {
                vh = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_item, parent, false);
                vh.itemContent = (TextView) convertView.findViewById(R.id.tv_content);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            vh.itemContent.setText(getItem(position));
            return convertView;
        }

        public List<Object> getItemList() {
            return this.mItemList;
        }


        class ViewHolder {
            public TextView itemContent;
        }
    }


    /**
     * 根据需求自定义model
     */
    public static class clickItem {
        private int clickId;
        private String itemStr;

        public clickItem(int clickId, String itemTx) {
            this.clickId = clickId;
            this.itemStr = itemTx;
        }

        public int getClickId() {
            return clickId;
        }

        public void setClickId(int clickId) {
            this.clickId = clickId;
        }

        public String getItemStr() {
            return itemStr;
        }

        public void setItemStr(String itemStr) {
            this.itemStr = itemStr;
        }
    }

    public interface IListClickListener {
        void onItemClick(int id);
    }


}

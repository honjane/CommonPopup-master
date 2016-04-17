# CommonPopup
A abstract class for creating custom popupwindow easily.


# HowToUse

----------

**Step 1:**
Create a class whitch extend BasePopupWindow

**Step 2:**
override some methods

etc.

```java
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

```

**Step 3:**create the object and show

etc.

```java
 new DialogPopup(context).showPopupWindow();
```

#sample
![image](https://github.com/honjane/CommonPopup-master/blob/maste/image/nomal_dialog.png)
![image](https://github.com/honjane/CommonPopup-master/blob/maste/image/list_popup.png)


#License
MIT

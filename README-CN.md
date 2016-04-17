#CommonPopup
抽象出一个方便自定义的CommonPopup类


# 依赖
点击 [here](https://github.com/honjane/CommonPopup-master/tree/master/app/src/main/java/com/honjane/demo/lib) 然后复制lib里面的文件到您的工程中。
# 使用方法

----------

**Step 1:**
新建一个类继承CommonPopup

**Step 2:**
实现必要的几个方法

例如

```java
public class DialogPopup extends CommonPopupWindow {

    public DialogPopup(Activity context) {
        super(context);
    }

    @Override
    protected View getDismissView() {
        return mPopupView;
    }

    @Override
    public View getPopupView() {
        return getPopupViewById(R.layout.popup_dialog);
    }

    @Override
    public View getInsideView() {
        return mPopupView.findViewById(R.id.inside_layout);
    }
}
```

**Step 3:**把您刚才实现的popup给new出来并调用show方法

例如

```java
 new DialogPopup(context).showPopupWindow();
```

# 方法介绍：
本项目拥有的方法如下：

 - 必须实现的抽象方法：
	+ getPopupView()：得到popupwindow的主体，一般是在xml文件写好然后inflate出来并返回
	+ getInsideView()：得到PopupView的一个根子类，用于屏蔽弹窗点击事件，展示动画的view，一般为了做到蒙层效果等功能
	+ getDismissView()：弹窗外部点击触发dismiss的view

 - show方法：
	+ showPopupWindow():默认将popup显示到当前窗口
	+ showPopupWindow(View v)：将popup显示到view上

#实例
![image](https://github.com/honjane/CommonPopup-master/blob/master/image/nomal_dialog.png)
![image](https://github.com/honjane/CommonPopup-master/blob/master/image/list_popup.png)
#License
MIT

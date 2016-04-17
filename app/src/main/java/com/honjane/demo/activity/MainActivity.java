package com.honjane.demo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.honjane.demo.R;
import com.honjane.demo.fragment.DialogFragment;
import com.honjane.demo.fragment.ListDialogFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private DialogFragment mDialogFragment;
    private ListDialogFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
    }

    private void initView() {
        mFragmentManager=getSupportFragmentManager();

        mDialogFragment = new DialogFragment();
        mListFragment = new ListDialogFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_dialog_popup:
                mFragmentManager.beginTransaction().replace(R.id.parent,mDialogFragment).commit();
                break;
            case R.id.id_list_popup:
                mFragmentManager.beginTransaction().replace(R.id.parent,mListFragment).commit();
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}

package com.you.yan.likeyou;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener{

    protected ProgressDialog waitDialog;
    /**
     * 标记标题左右两边的类型:文字
     */
    protected final int TITLE_TYPE_TEXT = 0;
    /**
     * 标记标题左右两边的类型:图片
     */
    protected final int TITLE_TYPE_IMG = 1;
    public Context application;

    private TextView actionBarTitle;
    private TextView actionBarPreTitle;
    private ImageView actionBarBack;
    private ImageView actionBarFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = getApplicationContext();
        setCustomActionBar();

    }

    //设置自定义的actionbar
    private void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar1, null);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBarTitle = (TextView) findViewById(R.id.actionbar_title);
        actionBarPreTitle = (TextView) findViewById(R.id.actionbar_pretitle);
        actionBarBack = (ImageView) findViewById(R.id.actionbar_back_icon);
        actionBarFunc = (ImageView) findViewById(R.id.actionbar_func_icon);

        actionBarBack.setOnClickListener(this);
        actionBarFunc.setOnClickListener(this);
    }

    protected void setActionBarTitle(@StringRes int resid) {
        this.actionBarTitle.setText(resid);
    }

    protected void setActionBarBack(@StringRes int resid) {
        this.actionBarBack.setVisibility(View.VISIBLE);
        this.actionBarPreTitle.setVisibility(View.VISIBLE);
        this.actionBarPreTitle.setText(resid);
    }
    protected void hideActionBarBack(){
        this.actionBarBack.setVisibility(View.INVISIBLE);
        this.actionBarPreTitle.setVisibility(View.INVISIBLE);
    }

    protected void setActionBarFunc(@DrawableRes int resid) {
        this.actionBarFunc.setVisibility(View.VISIBLE);
        this.actionBarFunc.setImageResource(resid);
    }

    protected void hideActionBarFunc(){
        this.actionBarFunc.setVisibility(View.INVISIBLE);
    }

    protected void setActionBar(Object title, boolean back, Object back_icon, Object pre_tile, boolean func, Object func_icon){
        if (!TextUtils.isEmpty((String)title) && title instanceof String){
            actionBarTitle.setText((String)title);
        }
        if (back){
            actionBarBack.setVisibility(View.VISIBLE);
            actionBarPreTitle.setVisibility(View.VISIBLE);
            if (back_icon instanceof Integer){
                actionBarBack.setImageResource((Integer) back_icon);
            }
            if (!TextUtils.isEmpty((String)pre_tile) && pre_tile instanceof String){
                actionBarPreTitle.setText((String)title);
            }
        }else {
            actionBarBack.setVisibility(View.INVISIBLE);
            actionBarPreTitle.setVisibility(View.INVISIBLE);
        }
        if (func){
            actionBarFunc.setVisibility(View.VISIBLE);
            if (func_icon instanceof Integer){
                actionBarFunc.setImageResource((Integer) back_icon);
            }
        }else {
            actionBarFunc.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.actionbar_back_icon:
                finish();
                break;
            case R.id.actionbar_func_icon:
                Toast.makeText(this,"func_icon",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

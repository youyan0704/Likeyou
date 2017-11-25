package com.you.yan.likeyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.you.yan.likeyou.NumberKeyboard.KeyboardUtil;
import com.you.yan.likeyou.NumberKeyboard.NumberKeyBoardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NumberKeyboardActivity extends AppCompatActivity {

    @BindView(R.id.et_price)
    EditText       et_price;
    @BindView(R.id.keyboard_view)
    NumberKeyBoardView keyboard_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_keyboard);
        ButterKnife.bind(this);

        final KeyboardUtil keyboardUtil = new KeyboardUtil(NumberKeyboardActivity.this);
        keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {

            }
        });
        keyboardUtil.attachTo(et_price);
        et_price.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(et_price);
                return false;
            }
        });
    }

    /*@Override
    public void onBackPressed() {
        if (ll_price_select.getVisibility() == View.VISIBLE) {
            ll_price_select.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }*/
}

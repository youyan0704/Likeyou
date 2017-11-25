package com.you.yan.likeyou;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BasicActivity {

    private TextView mTextMessage;
    private String actionbarTitle;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_wechat:
                    setActionBarTitle(R.string.wechat);
                    mTextMessage.setText(R.string.wechat);
                    hideActionBarBack();setActionBarFunc(R.drawable.ic_action_plus);
                    showWaitDialog();
                    return true;
                case R.id.navigation_address_book:
                    setActionBarTitle(R.string.address_book);
                    setActionBarBack(R.string.address_book);
                    setActionBarFunc(R.drawable.ic_action_add_person);
                    mTextMessage.setText(R.string.address_book);
                    return true;
                case R.id.navigation_discover:
                    mTextMessage.setText(R.string.discover);
                    setActionBarTitle(R.string.discover);
                    hideActionBarBack();
                    hideActionBarFunc();
                    return true;
                case R.id.navigation_me:
                    setActionBarTitle(R.string.me);
                    mTextMessage.setText(R.string.me);
                    hideActionBarBack();
                    hideActionBarFunc();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
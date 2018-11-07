package com.ayuan.registcontentobserver;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册内容的观察者
        Uri uri = Uri.parse("content://com.ayuan.provider");
        /**
         * notifyForDescentends:如果true如果为false则uri必须是一个确切的
         * observer:内容的观察者
         */
        getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
    }

    //定义一个内容的观察者
    private class MyContentObserver extends ContentObserver {

        /**
         * 创建内容观察者.
         *
         * @param handler运行{@link #onChange}的处理程序，如果没有则为null。
         */
        public MyContentObserver(Handler handler) {
            super(handler);
        }

        /**
         * 当内容发生改变的时候调用
         *
         * @param selfChange
         */
        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Log.i(TAG, "数据库的内容发生了改变");
        }
    }
}


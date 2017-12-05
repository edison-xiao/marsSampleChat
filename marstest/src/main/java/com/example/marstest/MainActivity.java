package com.example.marstest;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;

import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.xlog.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(this.getClass().getSimpleName(), "onCreate");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.appenderClose();
    }
}

package com.SecureWk.Auht;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.scottyab.rootbeer.RootBeer;

public class Drop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RootCheck();
    }
    private void RootCheck() {
        RootBeer rootBeer = new RootBeer(this);
        if (rootBeer.isRooted()) {
            Log.e("Unsafe", "Device Image Modified, check for Fake GPS Module");
            Intent msg4 = new Intent(this,Failed.class);
            startActivity(msg4);
        } else {
            Log.e("Safe", "Maybe want to check CTS, But later");
            Intent msg3 = new Intent(this,UserDetails.class);
            startActivity(msg3);
        }

    }
}
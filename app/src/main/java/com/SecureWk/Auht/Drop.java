package com.SecureWk.Auht;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.scottyab.rootbeer.RootBeer;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

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
            Failed();
        } else {
            Log.e("Safe", "Maybe want to check CTS, But later");
            datefind();
        }
    }

    private void datefind() {

        Instant jam = Instant.now();
        ZoneId dart = ZoneId.of("Asia/Kolkata");
        ZonedDateTime dart2 = ZonedDateTime.ofInstant(jam, dart);
        DateTimeFormatter dart3 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        final String fi = dart2.format(dart3);
        Log.e("Date", fi);
        SNTPClient.getDate(TimeZone.getTimeZone("Asia/Kolkata"), new SNTPClient.Listener() {
            @Override
            public void onTimeReceived(String rawDate) {
                DateCheck(fi, rawDate);
            }
            @Override
            public void onError(Exception ex) {
                Failed();
            }
        });

    }

    private void DateCheck(String fi, String rawDate) {
        Log.e("Find", fi);
        Log.e("raw", rawDate);
        if (fi.equals(rawDate)) {
            Intent msg3 = new Intent(this, UserDetails.class);
            startActivity(msg3);
        } else {
            Failed();
        }
    }
    public void Failed() {
        Intent msg4 = new Intent(this, Failed.class);
        startActivity(msg4);
    }
}


package com.SecureWk.Auht;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GeofenceBroadcastReciever extends BroadcastReceiver {
    private Context context;
    private Intent intent;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        this.intent = intent;
    }
}

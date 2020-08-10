package com.SecureWk.Auht;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

public class GeofenceBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            Log.e("Background Reciever", "Error Recieving geofencing Event");
            return;
        }
        int trans = geofencingEvent.getGeofenceTransition();
        switch (trans) {
            case Geofence.GEOFENCE_TRANSITION_ENTER:
            case Geofence.GEOFENCE_TRANSITION_DWELL:
                Log.e("User Status", "Within Radius");
                break;
            case Geofence.GEOFENCE_TRANSITION_EXIT:
                Log.e("User Status", "Outside Radius");
                break;
            default:
                Log.e("Failed", "Failed");

        }
    }
}

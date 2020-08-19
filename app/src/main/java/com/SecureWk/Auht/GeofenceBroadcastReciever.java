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
        Log.e("Entered Reciever","Awaiting");
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
                Intent msg = new Intent(context,Drop.class);
                msg.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(msg);
                break;
            case Geofence.GEOFENCE_TRANSITION_EXIT:
                Log.e("User Status", "Outside Radius");
                Intent msg2 = new Intent(context,Failed.class);
                msg2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(msg2);
                break;
            default:
                Log.e("Failed", "Failed");
                break;
        }
    }
}

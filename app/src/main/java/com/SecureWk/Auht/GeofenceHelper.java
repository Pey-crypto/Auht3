package com.SecureWk.Auht;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.maps.model.LatLng;

public class GeofenceHelper extends ContextWrapper {

    private static final int BROCODE = 10 ;
    PendingIntent pendingIntent;
    LatLng Home = new LatLng(23.591280,58.553839);


    public GeofenceHelper(Context base) {
        super(base);
    }

    public GeofencingRequest getGeofencingRequest(Geofence geofence){
        return new GeofencingRequest.Builder()
                .addGeofence(geofence)
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .build();
    }

    public Geofence getGeofence(){
        Log.e("Builder","Geofence added");
        return new Geofence.Builder()
                .setCircularRegion(Home.latitude,Home.longitude,100)
                .setRequestId("Home")
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_EXIT|Geofence.GEOFENCE_TRANSITION_ENTER|Geofence.GEOFENCE_TRANSITION_DWELL)
                .setLoiteringDelay(5000)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .build();
    }
    public PendingIntent getPendingIntent(){
        if(pendingIntent != null){
            return pendingIntent;
        }
        Intent BroaCast = new Intent(this,GeofenceBroadcastReciever.class);
        pendingIntent = PendingIntent.getBroadcast(this,BROCODE,BroaCast,PendingIntent.FLAG_UPDATE_CURRENT);
        Log.e("Pending Intent","Called Reciever");
        return  pendingIntent;
    }

    public String getErrorString(Exception jade){
        if (jade instanceof ApiException){
            ApiException apiException = (ApiException) jade;
            switch (apiException.getStatusCode()){
                case GeofenceStatusCodes
                        .GEOFENCE_NOT_AVAILABLE:
                    return "GEOFENCE_NOT_AVAILABLE";
                case GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES:
                    return "GEOFENCE_TOO_MANY_GEOFENCES";
                case GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS:
                    return "GEOFENCE_TOO_MANY_PENDING_INTENTS";
            }
        }
        return jade.getLocalizedMessage();
    }


}

package com.SecureWk.Auht.ui;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

import com.SecureWk.Auht.GeofenceBroadcastReciever;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.maps.model.LatLng;

public class GeofenceHelper extends ContextWrapper {

    PendingIntent pendingIntent;
    public GeofenceHelper(Context base){
        super(base);

    }

    public GeofencingRequest geofencingRequest(Geofence geofence){
        return null;
    }

    public Geofence getGeofence(String ID , LatLng latLng, float radius, int Trans){
        return null;
    }

    public PendingIntent getPendingIntent(){
        if(pendingIntent != null){
            return  pendingIntent;
        }
        Intent intent = new Intent(this, GeofenceBroadcastReciever.class)
    }

}

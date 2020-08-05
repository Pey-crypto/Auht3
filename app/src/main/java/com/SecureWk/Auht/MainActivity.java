package com.SecureWk.Auht;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationManagerCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationServices;
import com.scottyab.rootbeer.RootBeer;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_FINE_LOCATION = 0;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private FusedLocationProviderClient fusedLocationClient;
    private GeofencingClient geofencing;
    private ArrayList<Geofence> geofenceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        executor = ContextCompat.getMainExecutor(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        biometricPrompt = new BiometricPrompt(MainActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Auht error: " + errString, Toast.LENGTH_SHORT).show();
                System.exit(1);
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Auht Authenticated", Toast.LENGTH_SHORT).show();
                mainCheck();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Auht failed",
                        Toast.LENGTH_SHORT)
                        .show();
                System.exit(0);
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Auht")
                .setSubtitle("Login with Device Credential")
                .setDeviceCredentialAllowed(true)
                .setConfirmationRequired(false)
                .build();
        biometricPrompt.authenticate(promptInfo);

    }
    private int PreFinal(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
        }
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }
    private boolean Final() {
        geofenceList = new ArrayList<Geofence>();
        boolean k = false;
        geofencing = LocationServices.getGeofencingClient(this);
        geofenceList.add(new Geofence.Builder()
                .setRequestId("Muthoot")
                .setCircularRegion(9.963916, 76.408383, (float) 116.6)
                .setExpirationDuration(900000)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_EXIT| Geofence.GEOFENCE_TRANSITION_DWELL|Geofence.GEOFENCE_TRANSITION_ENTER)
                .setLoiteringDelay(3000)
                .build());
        Intent intent = new Intent();
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        int trans = geofencingEvent.getGeofenceTransition();
        switch (trans){
            case Geofence.GEOFENCE_TRANSITION_DWELL:
            case Geofence.GEOFENCE_TRANSITION_ENTER:
                Log.e("Entered","Within Campus");
                k = true;
                break;
            case Geofence.GEOFENCE_TRANSITION_EXIT:
                Log.e("JUST","Exited Campus");
                k = false;
                break;

            default:
                Log.e("JUST","Geofence Unknown");
                break;
        }   
        return k;
    }

    private boolean Root() {
        RootBeer rootBeer = new RootBeer(this);
        if (rootBeer.isRooted()) {
            Log.e("Unsafe", "Device Image Modified, check for Fake GPS Module");
            return false;
        } else {
            Log.e("Safe", "Maybe want to check CTS, But later");
            return true;
        }

    }


    private boolean LocaPerm() {
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = LocationManagerCompat.isLocationEnabled(lm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Please Enable GPS")
                    .setPositiveButton("Settings", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
        Log.e("Status", Boolean.toString(LocationManagerCompat.isLocationEnabled(lm)));
        return LocationManagerCompat.isLocationEnabled(lm);
    }

    private void mainCheck(){
        boolean a = Root();
        boolean b = LocaPerm();
        boolean c;
        if (!b){
            Log.e("3RD","Last permissions");
            LocaPerm();
        }
        if (b) {
            Log.e("Entered","Magice");
             c = Final();
            if (a && b == b && c) {
                Log.e( "Verified","Done");
                Intent intent = new Intent(this,UserDetails.class);
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_LONG);
        }

    }

}
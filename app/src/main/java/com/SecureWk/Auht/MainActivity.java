package com.SecureWk.Auht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.scottyab.rootbeer.RootBeer;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_BACKGROUND_LOCATION =0 ;
    private static final int REQUEST_FINE_LOCATION =0 ;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private FusedLocationProviderClient fusedLocationClient;
    private Object MainActivity;

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
                        "Auht error: " + errString, Toast.LENGTH_SHORT)
                        .show();
                System.exit(1);
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Auht Authenticated", Toast.LENGTH_SHORT).show();
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

       // This block deals with root detection

        RootBeer rootBeer = new RootBeer(this);
        if(rootBeer.isRooted()){
            Toast.makeText(getApplicationContext(),"Device is Rooted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Safe Device",Toast.LENGTH_LONG).show();
        }


        //Permissions Request Block

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Grant Access for Location",Toast.LENGTH_LONG).show();
            androidx.core.app.ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_FINE_LOCATION);
            androidx.core.app.ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION},REQUEST_BACKGROUND_LOCATION);
        }
       else {
            Toast.makeText(getApplicationContext(), "Activated", Toast.LENGTH_LONG).show();
        }




        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Toast.makeText(getApplicationContext(), "Got Location", Toast.LENGTH_SHORT)
                                .show();
                        if (location != null) {
                            Toast.makeText(getApplicationContext(), "k", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });

    }

}
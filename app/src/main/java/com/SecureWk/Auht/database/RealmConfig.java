package com.SecureWk.Auht.database;

import android.app.Application;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class RealmConfig extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        String appID = "auht_client-urpxq";
        App app = new App(new AppConfiguration.Builder(appID)
                .build();
    }
}

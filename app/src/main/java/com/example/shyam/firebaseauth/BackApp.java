package com.example.shyam.firebaseauth;

import android.app.Application;
import android.content.Intent;

public class BackApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, ExtraService.class));
    }
}
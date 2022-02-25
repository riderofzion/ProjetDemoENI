
package com.quentinrouet.swapi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.quentinrouet.swapi.bo.Planet;

import java.util.ArrayList;

public class MyBddService extends Service {
    ArrayList<Planet> alPlanet = new ArrayList<>();
    BddBinder bddBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        bddBinder = new BddBinder();
    }

    public class BddBinder extends Binder {
        public ArrayList<Planet> getArrayListPlanet(){
            return MyBddService.this.alPlanet;
        }
        public BddBinder() {
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return bddBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
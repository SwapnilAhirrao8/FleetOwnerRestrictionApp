package com.swapnil.driverestrictiontestapp.models;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.security.Provider;

/**
 * Created by Swapnil Ahirrao on 13,October,2024
 * India.
 */
public class CarRestrictionService extends Service {
    //its better to use service on Boot up for Automotive for such usecase/requirement
    //TODO
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //TODO
        return null;
    }

}

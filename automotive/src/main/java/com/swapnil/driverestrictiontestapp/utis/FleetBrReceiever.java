package com.swapnil.driverestrictiontestapp.utis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
//here we will listen to SMS event so that in case of Fleet Company owner can set
//maximum limit using sms also. Event for mat will have following format
//SpeedLimit=80 this will be parsed and set to View Model SpeedLimit field to use further
public class FleetBrReceiever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

       //TODO set max_speed_limit via listing to SMS in case no network for Fleet Owner
    }
}

package com.swapnil.driverestrictiontestapp.view;

import android.Manifest;
import android.app.Activity;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;

import com.swapnil.driverestrictiontestapp.FleetApplication;
import com.swapnil.driverestrictiontestapp.R;
import com.swapnil.driverestrictiontestapp.models.FleetVehicleProperties;
import com.swapnil.driverestrictiontestapp.utis.FleetBrReceiever;
import com.swapnil.driverestrictiontestapp.utis.FleetUtils;
import com.swapnil.driverestrictiontestapp.viewmodel.FleetViewModel;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
//Login Activity for FleetOwner to start Manually before renting car
public class FleetLoginActivity extends Activity implements FleetVehicleProperties {
    //Declaration of fields used in acrivitu
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private static final int FCM_NOTIFICATION = 1;
    private FleetBrReceiever fleetBrReceiever;
    private FleetViewModel fleetViewModel;

   //On-create Method to Load views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //below used to initiate and load view
        setContentView(R.layout.activity_fleet_login);
        inittViews();

    }

    //register interface for Vehicle properties
    private void registerFleetVehiclePropertiesEvents() {
        //TODO register interface  so that vehicle properties events can be
        // get using FleetVehicleProperties();

    }

    //Below will be used to register viewmodel instances
    private void registerViewModels() {
       fleetViewModel= ViewModelProviders(FleetApplication.
               getInstance()).get(FleetViewModel.class);

        fleetViewModel.getCarSpeedData().observe(this) {
            if(fleetViewModel.getCarSpeedData().getValue() > FleetUtils.MAX_CAR_SPEED_LIMIT){
                //Check if internet is available & firebase service is available
                if(FleetUtils.isInternetAvailable==1 && FleetUtils.isFirebaseServiceAVailable==1){
                    //TODO send notification to FleetOwner using Firebase service

                }else if (FleetUtils.isInternetAvailable==1 && FleetUtils.isAwsServiceAvailable==1 ){
                    //Check if internet is available & firebase service is available
                    //TODO send notification to FleetOwner using ASW service

                }else {
                    //in case both services not available send SMS using sim service
                    FleetUtils.sendSpeedLimitExceedSms("Speed Limit Excceeded by renter"
                            +fleetViewModel.getCarSpeedData().getValue());
                }
                //Show Notification to Driver on HMI/ Clusto-meter
                FleetUtils.showSpeedLimitExceedNotificationDriver("Your Speed Limit" +
                        " Exceeds" +fleetViewModel.getCarSpeedData();
            }
        }
    }

    //below will be used in case no network availability so that speed limit & warnings can be sent,
    //or set by the fleet owner using text message
    private void registerReceiver() {
        //TODO register Broadcast reciever events actions

        fleetBrReceiever = new FleetBrReceiever();
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(fleetBrReceiever, mIntentFilter);
    }

    //method will be used to init views
    private void inittViews() {
        //TODO register all views eg:layout views which will be used for login
        registerReceiver();
        registerViewModels();
        registerFleetVehiclePropertiesEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //here will be init resources
        checkSelfPermission();
    }

    //method to request SelfPermission
    private void checkSelfPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            }else  if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                // FCM SDK (and your app) can post notifications.
            }else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    //once permission requested if uses allows or denies permission below will be used
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission Granted.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            case FCM_NOTIFICATION: {
                //TODO in-case of other permissions
            }
        }
    }

    //this method will be used to free up resources which will not required once
    // activity destroyed
    @Override
    protected void onDestroy() {
        if (fleetBrReceiever != null) {
            unregisterReceiver(fleetBrReceiever);
            fleetBrReceiever = null;
        }
        super.onDestroy();
    }


    //below Carspeed will be set to viewmodel fields once updated
    @Override
    public void getVehicleSpeed(Integer carSpeedDetailslistener) {
        fleetViewModel.setCarSpeedData(carSpeedDetailslistener);
    }
}

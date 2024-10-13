package com.swapnil.driverestrictiontestapp.utis;
import android.telephony.SmsManager;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
//This class will be used to do small operations like sending sms
public class FleetUtils {

    //TODO implementation to be done for checking internet connection
    public static int isInternetAvailable=0;

    //TODO implementation to be done for checking firebase connection
    public static int isFirebaseServiceAVailable=0;
    //TODO implementation to be done for checking Aws connection
    public static int isAwsServiceAvailable=0;
    //CARSPEEDLIMIT set by FleetOwner
    public static int MAX_CAR_SPEED_LIMIT=0;

    //below api will be used to send sms to Fleet owner in case if internet issue
    public static void sendSpeedLimitExceedSms(String smsBody,String phoneNumber){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null);
    }

    //below api will be used to send notification to Fleet owner Firbase
    public static void sendSpeedLimitExceedNotificationViaFirebas(String speedLimitDetails){
        //TODO Send notification to Fleet owner via Firebase service
    }

    //below api will be used to send notification to Fleet owner via AWS
    public static void sendSpeedLimitExceedNotificationviaAWS(String speedLimitDetails){
        //TODO Send notification to Fleet owner via AWS service
    }

    //below api will be used to send notification to Fleet owner via AWS
    public static void showSpeedLimitExceedNotificationDriver(String speedLimitDetails){
        //TODO show notification to renter/Driver using FleetNotificationManger implementation
    }


}

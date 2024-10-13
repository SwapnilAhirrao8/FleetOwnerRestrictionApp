package com.swapnil.driverestrictiontestapp;

import android.app.Application;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
//Application class to get access for single context, init
public class FleetApplication extends Application {
    // private static instance variable to hold the singleton instance
    private static volatile FleetApplication INSTANCE = null;

    // private constructor to prevent instantiation of the class
    private FleetApplication() {}

    // public static method to retrieve the singleton instance of an application
    public static FleetApplication getInstance() {
        // Check if the instance is already created
        if(INSTANCE == null) {
            // synchronize the block to ensure only one thread can execute at a time
            synchronized (FleetApplication.class) {
                // check again if the instance is already created
                if (INSTANCE == null) {
                    // create the singleton instance
                    INSTANCE = new FleetApplication();
                }
            }
        }
        // return the singleton instance
        return INSTANCE;
    }
}

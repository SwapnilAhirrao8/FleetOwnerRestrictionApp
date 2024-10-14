package com.swapnil.driverestrictiontestapp.models;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
//Dummy class will be used to read Vehicle properties such as Speed via CarInfo class from VHAL/
// CarProperties AOSP
public interface FleetVehicleProperties extends CarInfo{
    //TODO get Vehicle speed considering it will be get from VHAL/CarProperties
    void getVehicleSpeed(Integer carSpeedDetailslistener);

}

package com.swapnil.driverestrictiontestapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.swapnil.driverestrictiontestapp.FleetApplication;
import com.swapnil.driverestrictiontestapp.models.FleetVehicleProperties;

/**
 * Created by Swapnil Ahirrao on 12,October,2024
 * India.
 */
public class FleetViewModel extends ViewModel  {

    //required fields should be added here eg: loginDetails,SppedDetails etc.
    MutableLiveData<String> vehicleChassisNo=new MutableLiveData<>();
    MutableLiveData<String> vehicleLoginId=new MutableLiveData<>();

    MutableLiveData<Integer> carSpeedData=new MutableLiveData<>();

    //TODO any other car properties have to be listed

    //Constructor for init
    public FleetViewModel(MutableLiveData<String> vehicleChassisNo, MutableLiveData<String>
            vehicleLoginId, MutableLiveData<Integer> carSpeedData) {
        this.vehicleChassisNo = vehicleChassisNo;
        this.vehicleLoginId = vehicleLoginId;
        this.carSpeedData = carSpeedData;
    }

    //init live data fields
    private void initViewModelFields() {
        carSpeedData.setValue(0);
    }

    //method to get CarspeedDetails
    public MutableLiveData<Integer> getCarSpeedData() {
        return carSpeedData;
    }
    //method to set Car speed Details
    public void setCarSpeedData(MutableLiveData<Integer> carSpeedData) {
        this.carSpeedData = carSpeedData;
    }

    //method to get VehicleChassisDetails
    public MutableLiveData<String> getVehicleChassisNo() {
        return vehicleChassisNo;
    }
    //method to set VehicleChassisDetails
    public void setVehicleChassisNo(MutableLiveData<String> vehicleChassisNo) {
        this.vehicleChassisNo = vehicleChassisNo;
    }

    //method to get VehicleLoginDetails
    public MutableLiveData<String> getVehicleLoginId() {
        return vehicleLoginId;
    }

    //method to set VehicleLoginDetails
    public void setVehicleLoginId(MutableLiveData<String> vehicleLoginId) {
        this.vehicleLoginId = vehicleLoginId;
    }
}

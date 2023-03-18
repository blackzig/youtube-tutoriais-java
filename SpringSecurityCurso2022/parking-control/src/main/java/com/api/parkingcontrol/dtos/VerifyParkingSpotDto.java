/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpotModel;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author zigui
 */
public class VerifyParkingSpotDto {
    
    private Optional<ParkingSpotModel> parkingSpotModelOptional;
    private ResponseEntity<Object> entity;

    public Optional<ParkingSpotModel> getParkingSpotModelOptional() {
        return parkingSpotModelOptional;
    }

    public void setParkingSpotModelOptional(Optional<ParkingSpotModel> parkingSpotModelOptional) {
        this.parkingSpotModelOptional = parkingSpotModelOptional;
    }

    public ResponseEntity<Object> getEntity() {
        return entity;
    }

    public void setEntity(ResponseEntity<Object> entity) {
        this.entity = entity;
    }
    
    
    
}

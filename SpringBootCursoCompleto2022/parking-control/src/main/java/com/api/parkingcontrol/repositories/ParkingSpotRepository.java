/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zigui
 */
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{
    Boolean existsByLicensePlateCar(String licensePlateCar);
    Boolean existsByParkingSpotNumber(String parkingSpotNumber);
    Boolean existsByApartmentAndBlock(String apartment, String block);
}

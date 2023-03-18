/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.parkingcontrol.verifies;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.dtos.VerifyParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author zigui
 */
public class ParkingSpotVerify {

    public ResponseEntity<Object> itsOkToSave(ParkingSpotDto dto, ParkingSpotService parkingSpotService) {
        if (parkingSpotService.existsByLicensePlateCar(dto.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        } else if (parkingSpotService.existsByParkingSpotNumber(dto.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        } else if (parkingSpotService.existsByApartmentAndBlock(dto.getApartment(), dto.getBlock())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
        }

        return ResponseEntity.status(HttpStatus.CONTINUE).body("OK");
    }

    public ResponseEntity<Object> findParkingSpot(UUID id, ParkingSpotService parkingSpotService) {
        VerifyParkingSpotDto vps = thisDataExist(id, parkingSpotService);
        if (vps.getParkingSpotModelOptional().isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(vps.getParkingSpotModelOptional().get());
        }
        return vps.getEntity();
    }

    public ResponseEntity<Object> deleteRegisterParkingSpot(UUID id, ParkingSpotService parkingSpotService) {
        VerifyParkingSpotDto vps = thisDataExist(id, parkingSpotService);
        if (vps.getParkingSpotModelOptional().isPresent()) {
            parkingSpotService.delete(vps.getParkingSpotModelOptional().get());
            return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
        }
        return vps.getEntity();
    }

    public ResponseEntity<Object> updateRegisterParkingSpot(UUID id, ParkingSpotService parkingSpotService, ParkingSpotDto dto) {
        VerifyParkingSpotDto vps = thisDataExist(id, parkingSpotService);
        if (vps.getParkingSpotModelOptional().isPresent()) {
            var parkingSpotModel = new ParkingSpotModel();
            BeanUtils.copyProperties(dto, parkingSpotModel);
            parkingSpotModel.setId(vps.getParkingSpotModelOptional().get().getId());
            parkingSpotModel.setRegistrationDate(vps.getParkingSpotModelOptional().get().getRegistrationDate());
            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
        }
        return vps.getEntity();
    }

    private VerifyParkingSpotDto thisDataExist(UUID id, ParkingSpotService parkingSpotService) {
        VerifyParkingSpotDto vps = new VerifyParkingSpotDto();
        ResponseEntity<Object> entity = ResponseEntity.status(HttpStatus.CONTINUE).body("OK");
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        vps.setEntity(entity);
        vps.setParkingSpotModelOptional(parkingSpotModelOptional);
        return vps;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.UserModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zigui
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
    public Optional<UserModel> findByusername(String username);
    
}

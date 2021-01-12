/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phone.repos;

import com.phone.entity.Phone;
import com.phone.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Root
 * репозиторий телефонов
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer>{    
    List<Phone> findByPhone(String phone);
    List<Phone> findByUser(User user);
    
}

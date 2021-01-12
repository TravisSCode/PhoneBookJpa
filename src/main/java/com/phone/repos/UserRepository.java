/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phone.repos;

import com.phone.entity.User;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Root
 * репозиторий пользователей
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    
    List<User> findAllByFirstName(String firstName,Sort sort);
    List<User> findAllByLastName(String lastName,Sort sort);
    List<User> findAllByFirstNameAndLastName(String firstName,String lastName,Sort sort);
    List<User> findByPhones_Phone(String phone,Sort sort);
}

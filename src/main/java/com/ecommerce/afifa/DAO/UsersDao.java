package com.ecommerce.afifa.DAO;

import com.ecommerce.afifa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersDao extends JpaRepository<Users, Integer>{

    Users findByLoginName(String loginName);

}
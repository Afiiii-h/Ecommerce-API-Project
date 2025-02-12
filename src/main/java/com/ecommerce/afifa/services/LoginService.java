package com.ecommerce.afifa.services;


import com.ecommerce.afifa.DAO.UsersDao;
import com.ecommerce.afifa.DTO.LoginResponse;
import com.ecommerce.afifa.DTO.LoginRequest;
import com.ecommerce.afifa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.ecommerce.afifa.Utils.JavaUtils.isNotNull;

@Component
public class LoginService {

    @Autowired
    UsersDao userDao;

    public LoginResponse login(LoginRequest loginBody) {

        LoginResponse response=new LoginResponse();
        Users userReceivedFromDb= userDao.findByLoginName(loginBody.loginName);

        if(isNotNull(userReceivedFromDb)) {

            if(userReceivedFromDb.getLoginName().equals(loginBody.loginName)
                    && userReceivedFromDb.getPassword().equals(loginBody.password) ){
                response.errorCode="0000";
                response.message="Login Success";
                response.firstName=userReceivedFromDb.getFirstName();
                response.lastName=userReceivedFromDb.getLastName();
                response.loginName=userReceivedFromDb.getLoginName();

                return response;

            }
            else {
                response.errorCode="911";
                response.message="Login Failed!!";
                return response;
            }

        }

        else {
            response.errorCode="911";
            response.message="User Not Found!!";
            return response;
        }


    }

}

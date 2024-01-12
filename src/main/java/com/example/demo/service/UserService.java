package com.example.demo.service;

import com.example.demo.api.model.security.RegistrationBody;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.LocalUser;
import com.example.demo.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;


    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }



    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()||
                localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //TODO: Encrypt password!!
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);

    }
}

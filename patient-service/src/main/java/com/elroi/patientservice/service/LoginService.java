package com.elroi.patientservice.service;

import com.elroi.patientservice.repository.LoginRepository;

public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean isValidLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        var userLogin = loginRepository.findByUsernameAndPassword(username, password);
        if (userLogin.isEmpty()) {
            throw new IllegalArgumentException("Username or password is invalid");
        }

        return true;
    }
}

package com.example.demo.service;

public interface SecurityService {
    String fingLoggedInUsername();
    void autoLogin(String name, String password);
}

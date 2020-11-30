package com.example.demo.dtos;

public class UserDto {
    private long id;
    private String username;
    private String password;
    private String confirmPassword;
    private String roles;

    public UserDto(long id, String username, String password, String confirmPassword, String roles){
        this.id=id;
        this.username=username;
        this.confirmPassword=confirmPassword;
        this.roles=roles;
    }
    public UserDto(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}

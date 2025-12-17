package com.bappi.ecommercebackend.enums;

public enum Role {
    Admin("admin"),
    User("user");
    private String role;
    Role(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}

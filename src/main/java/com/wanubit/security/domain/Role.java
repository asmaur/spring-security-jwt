package com.wanubit.security.domain;

import lombok.Getter;

@Getter
public enum Role {
    USER("USER"),
    ADMIN("ADMIN"),
    MANAGER("MANAGER");

    private  final String role;

    Role(String role){
        this.role = role;
    }
}

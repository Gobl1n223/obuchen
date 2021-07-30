package com.example.obuchen.entities;

public enum Permission {
    USERS_RIGHTS("user:rights"),
    ADMIN_RIGHTS("admin:rights");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

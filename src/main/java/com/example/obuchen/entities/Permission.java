package com.example.obuchen.entities;

public enum Permission {
    USERS_RIGHTS("users:rights"),
    ADMIN_RIGHTS("admins:rights");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

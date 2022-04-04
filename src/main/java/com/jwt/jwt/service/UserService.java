package com.jwt.jwt.service;

import java.util.List;

import com.jwt.jwt.domain.AppUser;
import com.jwt.jwt.domain.Role;

public interface UserService {
    AppUser getUser(String username);

    List<AppUser> getUsers();

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
}

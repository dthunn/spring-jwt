package com.jwt.jwt.api;

import com.jwt.jwt.domain.AppUser;
import com.jwt.jwt.domain.Role;
import com.jwt.jwt.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveRole(role));
    }

    @PostMapping("/roles/addtouser")
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {

    private String username;
    private String roleName;

}

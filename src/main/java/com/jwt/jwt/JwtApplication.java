package com.jwt.jwt;

import com.jwt.jwt.domain.AppUser;
import com.jwt.jwt.domain.Role;
import com.jwt.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "Gon Freeks", "gon", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Dylan Thunn", "dylan", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Sam Smith", "same", "1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Ashley Watts", "ashley", "1234", new ArrayList<>()));

            userService.addRoleToUser("gon", "ROLE_USER");
            userService.addRoleToUser("gon", "ROLE_MANAGER");
            userService.addRoleToUser("ashley", "ROLE_USER");
            userService.addRoleToUser("same", "ROLE_USER");
            userService.addRoleToUser("dylan", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("dylan", "ROLE_ADMIN");
            userService.addRoleToUser("dylan", "ROLE_MANAGER");
        };
    }
}

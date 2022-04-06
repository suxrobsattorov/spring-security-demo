package com.example;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new RoleEntity(null, "ROLE_USER"));
            userService.saveRole(new RoleEntity(null, "ROLE_MANAGER"));
            userService.saveRole(new RoleEntity(null, "ROLE_ADMIN"));
            userService.saveRole(new RoleEntity(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new UserEntity(null, "Ali", "ali", "1234", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Vali", "vali", "1234", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Eshmat", "eshmat", "1234", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Toshmat", "toshmat", "1234", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Furqat", "furqat", "1234", new ArrayList<>()));

            userService.addRoleToUser("ali", "ROLE_USER");
            userService.addRoleToUser("ali", "ROLE_MANAGER");
            userService.addRoleToUser("vali", "ROLE_MANAGER");
            userService.addRoleToUser("eshmat", "ROLE_ADMIN");
            userService.addRoleToUser("toshmat", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("toshmat", "ROLE_ADMIN");
            userService.addRoleToUser("toshmat", "ROLE_USER");
            userService.addRoleToUser("furqat", "ROLE_USER");
        };
    }
}

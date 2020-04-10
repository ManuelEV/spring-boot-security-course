package com.example.demo.contoller;

import com.example.demo.auth.ApplicationUser;
import com.example.demo.auth.CustomUserDetails;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.security.ApplicationUserRole.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAllStudents() {
        String password = passwordEncoder.encode("password");
        CustomUserDetails user1 = new CustomUserDetails("admin",
                password, true,
                true,
                true,
                true,
        ADMIN);

        CustomUserDetails user2 = new CustomUserDetails("admintrainee",
                password, true,
                true,
                true,
                true,
                ADMINTRAINEE);
        CustomUserDetails user3 = new CustomUserDetails("student",
                password, true,
                true,
                true,
                true,
                STUDENT);

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);

        return "OK";
    }

}

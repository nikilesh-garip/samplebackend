package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepository ur;

    @GetMapping("/demo")
    String demo(){
        return "Pani chesthundi thi";
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(@RequestParam(required = false) String param) {
        return this.ur.findAll();
    }
    

    @PostMapping("/reg")
    ResponseEntity<String> register(@RequestBody Users nu)
    {
        Users u = this.ur.findByEmail(nu.getEmail());

        if (u != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        this.ur.save(nu);
        return ResponseEntity
                .status(HttpStatus.CREATED)//201
                .body("Registration successful");
    }
}

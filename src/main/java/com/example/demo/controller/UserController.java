package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping(path = "/findAll")
    @ResponseBody
    public String findAllUser() {

        StringBuffer retBuf = new StringBuffer();

        List<UserAccount> userAccountList = (List<UserAccount>) userAccountRepository.findAll();

        if (userAccountList != null) {
            for (UserAccount userAccount : userAccountList) {
                retBuf.append("user name = ");
                retBuf.append(userAccount.getUsername());
                retBuf.append(", password = ");
                retBuf.append(userAccount.getPassword());
                retBuf.append(", email = ");
                retBuf.append(userAccount.getEmail());
                retBuf.append("\r\n");
            }
        }

        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        } else {
            retBuf.insert(0, "<pre>");
            retBuf.append("</pre>");
        }

        return retBuf.toString();
    }
    

    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
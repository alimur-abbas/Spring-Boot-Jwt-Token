package com.Spring.controller;
import com.Spring.Model.JwtRequest;
import com.Spring.Dao.UserDaoRepository;
import com.Spring.Model.DaoRequest;
import com.Spring.Model.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@RestController
public class HelloWorldController {
    @Autowired
    private UserDaoRepository userDaoRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private DaoUser daoUser;

  @RequestMapping( "/hello" )
    public String firstPage() {
        return "Hello World";
    }

    @PostMapping("/register")
    public DaoUser save (@RequestBody DaoRequest daoRequest)
    {
        DaoUser daoUser = new DaoUser();
        daoUser.setUserName(daoRequest.getUserName());
        daoUser.setPassword(bcryptEncoder.encode(daoRequest.getPassword()));
        return userDaoRepository.saveUser(daoUser);

    }
    
}

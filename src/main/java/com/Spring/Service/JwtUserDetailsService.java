package com.Spring.Service;

import java.util.ArrayList;

import com.Spring.Dao.UserDaoRepository;
import com.Spring.Model.DaoRequest;
import com.Spring.Model.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDaoRepository userDaoRepository;
    public void setUserDaoRepository(UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       DaoUser userName= null;
       try {
           userName = userDaoRepository.findUserByUserName(username);
       }catch (Exception throwable){
           throw new RuntimeException(throwable);
       }
        if (userName != null) {
            return new User(userName.getUserName(),userName.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("LoginUser not found with username: " + username);
        }
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        if ("Alimur".equals(username))
//        {
//            return new User("Alimur", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else
//        {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }

    }

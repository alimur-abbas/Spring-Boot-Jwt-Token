package com.Spring.Dao;

import com.Spring.Model.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class UserDaoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private  final String INSERT ="INSERT INTO USER (USERNAME , PASSWORD) VALUES (? ?)" ;
    private final String SELECT_USER_BY_USERNAME = "SELECT * FROM USER WHERE USERNAME = ?";

    public DaoUser saveUser(DaoUser daoUser){
        Object[] objects = new Object[]{daoUser.getUserName(), daoUser.getPassword()};
        int rows = jdbcTemplate.update(INSERT, objects);
        System.out.println("rows inserted"+rows);
        return(daoUser);
    }


    public  DaoUser findUserByUserName(String userName){
        Object[] objects = new Object[]{userName};
        return jdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new UserRowMapper(), objects);
    }
    private static class UserRowMapper implements RowMapper<DaoUser> {

        @Override
        public DaoUser mapRow(ResultSet resultSet, int i) throws SQLException {
            String username = resultSet.getString("USERNAME");
            String password = resultSet.getString("PASSWORD");


            DaoUser daoUser = new DaoUser();
            daoUser.setUserName(username);
            daoUser.setPassword(password);
            return (daoUser);

        }
    }
}

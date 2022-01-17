package com.Spring.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRequest extends DaoUser {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    private final String SELECT_USER_BY_USERNAME = "SELECT * FROM USER WHERE USERNAME = ?";
//    public  DaoUser findUserByUserName(String userName){
//        Object[] objects = new Object[]{userName};
//        return jdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new UserRowMapper(), objects);
//    }
//    private static class UserRowMapper implements RowMapper<DaoUser>{
//
//        @Override
//        public DaoUser mapRow(ResultSet resultSet, int i) throws SQLException {
//            String username = resultSet.getString("USERNAME");
//            String password = resultSet.getString("PASSWORD");
//
//
//             DaoUser daoUser = new DaoUser();
//            daoUser.setUserName(username);
//            daoUser.setPassword(password);
//            return (daoUser);
//
//        }
//    }

}

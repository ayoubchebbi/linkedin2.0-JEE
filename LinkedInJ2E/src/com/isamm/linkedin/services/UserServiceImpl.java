package com.isamm.linkedin.services;

import java.util.List;

import com.isamm.linkedin.DAO.*;
import com.isamm.linkedin.beans.*;

public class UserServiceImpl implements UserService{

    UserDAO userdao = new UserDAOImpl();

    @Override
    public boolean add(Users users){
        try {
            return userdao.add(users);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Users users){
        try {
            return userdao.delete(users);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean edit(Users users){
        try {
            return userdao.edit(users);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Users> getAll() {
        try {
            return userdao.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Users users(int id) {
        try {
            return userdao.users(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Users login(String email, String password) {
        return userdao.login(email,password);
    }
}

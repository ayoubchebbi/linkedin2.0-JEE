package com.isamm.linkedin.services;

import com.isamm.linkedin.beans.*;

import java.util.List;

public interface UserService {

	public boolean add(Users users);
	public boolean delete(Users users);
	public boolean edit(Users users);
	public List<Users> getAll();
	public Users users(int id) ;
	public Users login(String email, String password) ;
}

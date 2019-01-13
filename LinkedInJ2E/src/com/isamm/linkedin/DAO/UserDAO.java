package com.isamm.linkedin.DAO;


import com.isamm.linkedin.beans.*;

import java.util.List;

public interface UserDAO {


	public boolean add(Users users);
	public boolean delete(Users users);
	public boolean edit(Users users);
	public List<Users> getAll();
	public Users users(int id) throws Exception ;
	public Users login(String email, String password) ;
	public List<Users> searshFriends(String name);
}

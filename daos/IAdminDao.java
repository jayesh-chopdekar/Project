package com.app.daos;

import java.util.List;

import com.app.pojos.User;
import com.app.pojos.UserAdd;

public interface IAdminDao 
{
	public UserAdd addUser(UserAdd u);
	public List<User> showAllUsers();
	public void remUser(Integer id);
	public UserAdd editUser(Integer id,UserAdd u);
}

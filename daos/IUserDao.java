package com.app.daos;

import com.app.pojos.User;

public interface IUserDao 
{
	public User validateUser(String email,String pass);

}

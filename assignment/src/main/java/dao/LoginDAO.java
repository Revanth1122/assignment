package dao;

import exceptions.UserNotFoundException;
import model.UserDetail;

public interface LoginDAO {
	
	public UserDetail createUser(UserDetail user);
	
	public UserDetail getUserDetailsByUserName(String username)throws UserNotFoundException;
	

}
package service;

import exceptions.PasswordMismatchException;
import exceptions.UserNotFoundException;
import model.UserDetail;

public interface LoginService {

	public UserDetail createUser(UserDetail user);
	
	public UserDetail getUserDetailsByUserName(String username)throws UserNotFoundException;
	
	public boolean verifyUserNameAndPassword(UserDetail user)throws PasswordMismatchException, UserNotFoundException;

}
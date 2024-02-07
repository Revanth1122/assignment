package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.UserNotFoundException;
import model.UserDetail;
import utility.DBConnectionUtility;
import utility.QueryMapper;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public UserDetail createUser(UserDetail user) {
		try {
			PreparedStatement pStmt = DBConnectionUtility.getDBConnection().prepareStatement(QueryMapper.ADD_USERDETAIL);
			
			pStmt.setString(2, user.getUserName());
			pStmt.setString(3, user.getPassword());
			
			int rows = pStmt.executeUpdate();
			if(rows>0) {
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDetail getUserDetailsByUserName(String username) throws UserNotFoundException{
		PreparedStatement pStmt;
		UserDetail user = null;
		try {
			pStmt = DBConnectionUtility.getDBConnection().prepareStatement(QueryMapper.GET_USERDETAIL_BY_USERNAME);
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				user = new UserDetail();
				
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}else {
				throw new UserNotFoundException("User with username --- "+username+" doesn't exists in database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	

}

package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.UsersBO;
import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public class UsersBOImpl extends BaseBOImpl implements UsersBO {

	// get List Users
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	//get User by id
	public Users getUserById(int id) {
		return usersDAO.getUserById(id);
	}
	
	/**
	 * Check Login
	 */
	public Users validateInformation(String email, String password){
		return usersDAO.validateInformation(email, password);
	}
}

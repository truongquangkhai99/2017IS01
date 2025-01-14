package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public interface UsersDAO extends BaseDAO {
	/**
	 * Get users list
	 * @return
	 */
	public List<Users> getAllUsers();
	
	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	public Users getUserById(int id);
	
	/**
	 * @param email
	 * @param password
	 * @return
	 */
	public Users validateInformation(String email, String password);
	
}

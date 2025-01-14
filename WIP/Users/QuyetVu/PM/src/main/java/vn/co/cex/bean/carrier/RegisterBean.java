package vn.co.cex.bean.carrier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import vn.co.cex.bo.CarierBO;

@ManagedBean(name = "registerBean", eager = true)
@ViewScoped
public class RegisterBean {
	@ManagedProperty(value = "#{carierBO}")
	private CarierBO carierBO;
	private String name;
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the carierBO
	 */
	public CarierBO getCarierBO() {
		return carierBO;
	}

	/**
	 * @param carierBO the carierBO to set
	 */
	public void setCarierBO(CarierBO carierBO) {
		this.carierBO = carierBO;
	}

	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}
	public String registerCarier() {
		try {
			carierBO.register(null);
			
		} catch (Exception ex) {
			
		}
		return null;
	}
}

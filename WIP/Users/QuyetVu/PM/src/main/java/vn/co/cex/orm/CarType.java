package vn.co.cex.orm;

// Generated Mar 7, 2015 10:20:43 AM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * CarType generated by hbm2java
 */
public class CarType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8492363997286481553L;
	private Integer carTypeId;
	private CarMaker carMaker;
	private Integer carMakerId;
	private String carTitle;
	private String level;
	private String status; //Active or Closed (when care type has produced forever)
	private int capacity;
	private String createdBy;
	private Date createdDate;
	private String lastModifiedBy;
	private Date lastModifiedDate;

	public CarType() {
	}

	public CarType(CarMaker carMaker, String carTitle, int capacity,
			String createdBy, Date createdDate, String lastModifiedBy,
			Date lastModifiedDate) {
		this.carMaker = carMaker;
		this.carTitle = carTitle;
		this.capacity = capacity;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	public CarType(CarMaker carMaker, String carTitle, String level,
			int capacity, String createdBy, Date createdDate,
			String lastModifiedBy, Date lastModifiedDate) {
		this.carMaker = carMaker;
		this.carTitle = carTitle;
		this.level = level;
		this.capacity = capacity;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCarTypeId() {
		return this.carTypeId;
	}

	public void setCarTypeId(Integer carTypeId) {
		this.carTypeId = carTypeId;
	}

	public CarMaker getCarMaker() {
		return this.carMaker;
	}

	public void setCarMaker(CarMaker carMaker) {
		this.carMaker = carMaker;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCarTitle() {
		return carTitle;
	}

	public void setCarTitle(String carTitle) {
		this.carTitle = carTitle;
	}

	/**
	 * @return the carMakerId
	 */
	public Integer getCarMakerId() {
		return carMakerId;
	}

	/**
	 * @param carMakerId the carMakerId to set
	 */
	public void setCarMakerId(Integer carMakerId) {
		this.carMakerId = carMakerId;
	}

}
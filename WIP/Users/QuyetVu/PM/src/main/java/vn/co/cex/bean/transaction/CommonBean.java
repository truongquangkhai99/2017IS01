package vn.co.cex.bean.transaction;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import vn.co.cex.bo.TransactionsBO;
import vn.co.cex.orm.Transactions;
import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
@ManagedBean(name = "commonBean", eager = true)
@ViewScoped
public class CommonBean {
	@ManagedProperty(value = "#{transactionsBO}")
	private TransactionsBO transactionsBO;

	private List<Transactions> transactionsList;
	private Integer goodsTypeId;
	private Integer packagedFormId;
	private Float weight;
	private Float volume;
	private String departureProvinceCode;
	private String arrivalProvinceCode;
	private Date departureDate;
	private Date arrivalDate;
	private int timeRemaining;

	@PostConstruct
	public void init() {
		try {
			transactionsList = transactionsBO.getAllTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CommonBean() {

	}

	public TransactionsBO getTransactionsBO() {
		return transactionsBO;
	}

	public void setTransactionsBO(TransactionsBO transactionsBO) {
		this.transactionsBO = transactionsBO;
	}

	public List<Transactions> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<Transactions> transactionsList) {
		this.transactionsList = transactionsList;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getPackagedFormId() {
		return packagedFormId;
	}

	public void setPackagedFormId(Integer packagedFormId) {
		this.packagedFormId = packagedFormId;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public String getDepartureProvinceCode() {
		return departureProvinceCode;
	}

	public void setDepartureProvinceCode(String departureProvinceCode) {
		this.departureProvinceCode = departureProvinceCode;
	}

	public String getArrivalProvinceCode() {
		return arrivalProvinceCode;
	}

	public void setArrivalProvinceCode(String arrivalProvinceCode) {
		this.arrivalProvinceCode = arrivalProvinceCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public long secondsRemaining(Date date) {
		Date dateNow = new Date();
		long secondsRemaining = (date.getTime() - dateNow.getTime()) / 1000;
		return secondsRemaining;
	}

	/**
	 * Search transactions by condition
	 */
	public void searchTransaction() {
		try {
			if (goodsTypeId != 0 || packagedFormId != 0 || weight != 0 || volume != 0
					|| !departureProvinceCode.equals("") || !arrivalProvinceCode.equals("") || departureDate != null
					|| departureDate != null) {

				transactionsList = transactionsBO.searchTransaction(goodsTypeId, packagedFormId, weight, volume,
						departureProvinceCode, arrivalProvinceCode, departureDate, arrivalDate);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Template
	
}

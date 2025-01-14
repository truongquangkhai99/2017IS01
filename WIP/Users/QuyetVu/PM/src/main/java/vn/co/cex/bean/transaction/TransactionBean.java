package vn.co.cex.bean.transaction;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.TransactionsBO;
import vn.co.cex.dto.TransactionsDTO;
import vn.co.cex.orm.Transactions;

@SuppressWarnings("restriction")
@ManagedBean(name = "transactionBean", eager = true)
@ViewScoped
public class TransactionBean extends BaseBean{

	@ManagedProperty(value = "#{transactionsBO}")
	private TransactionsBO transactionsBO;
	
	private List<Transactions> transactionsList;
	private Transactions data;
	
	private Integer goodsTypeId;
	private Integer packagedFormId;
	private String weight;
	private String volume;
	
	private Integer departureProvinceId;
	private Integer arrivalProvinceId;
	private String departureDate;
	private String arrivalDate;
	
	@PostConstruct
	public void init(){
		try{
			transactionsList = transactionsBO.getAllTransaction();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TransactionBean(){
		
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Integer getDepartureProvinceId() {
		return departureProvinceId;
	}

	public void setDepartureProvinceId(Integer departureProvinceId) {
		this.departureProvinceId = departureProvinceId;
	}

	public Integer getArrivalProvinceId() {
		return arrivalProvinceId;
	}

	public void setArrivalProvinceId(Integer arrivalProvinceId) {
		this.arrivalProvinceId = arrivalProvinceId;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public Transactions getData() {
		return data;
	}

	public void setData(Transactions data) {
		this.data = data;
	}

	/**
	 * Get transaction by id
	 */
	public TransactionsDTO getTransactionById(int id){
		return transactionsBO.getTransactionsDTOById(id);
	}
}

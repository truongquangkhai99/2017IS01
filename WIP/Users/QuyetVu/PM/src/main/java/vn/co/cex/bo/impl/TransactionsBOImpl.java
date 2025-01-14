package vn.co.cex.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bo.TransactionsBO;
import vn.co.cex.dto.TransactionsDTO;
import vn.co.cex.orm.Transactions;

public class TransactionsBOImpl extends BaseBOImpl implements TransactionsBO {

	private static final Logger log = LogManager.getLogger(TransactionsBOImpl.class);

	/**
	 * Get transaction list
	 */
	public List<Transactions> getAllTransaction() {
		return transactionsDAO.getAllTransaction();
	}

	/**
	 * Search transactions by condition
	 */
	public List<Transactions> searchTransaction(int goodsTypeId, int packagedFormId, float weight, float volume,
			String departureProvinceCode, String arrivalProvinceCode, Date departureDate, Date arrivalDate) {

		return transactionsDAO.searchTransaction(goodsTypeId, packagedFormId, weight, volume, departureProvinceCode,
				arrivalProvinceCode, departureDate, arrivalDate);
	}

	/**
	 * Add new transaction
	 */
	public boolean addNewTransaction(Transactions data) {
		// TODO Auto-generated method stub
		return transactionsDAO.addNewTransaction(data);
	}
	
	public boolean updateTransactions(Transactions data){
		return transactionsDAO.updateTransactions(data);
	}
	
	/**
	 * Get transactions by id
	 */
	public Transactions getTransactionsById(int id){
		return transactionsDAO.getTransactionsById(id);
	}
	
	/**
	 * Get transaction by id
	 */
	public TransactionsDTO getTransactionsDTOById(int id){
		return transactionsDAO.getTransactionsDTOById(id);
	}
}

package vn.co.cex.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.dao.TransactionsDAO;
import vn.co.cex.dto.TransactionsDTO;
import vn.co.cex.orm.GoodsType;
import vn.co.cex.orm.PackagedForm;
import vn.co.cex.orm.Transactions;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

/**
 * @author DUONGLV
 *
 */
public class TransactionsDAOImpl extends BaseDAOImpl implements TransactionsDAO {

	private static final Logger log = LogManager.getLogger(TransactionsDAOImpl.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 697166325646229506L;

	/**
	 * Get transactions list
	 */
	@Transactional
	public List<Transactions> getAllTransaction() {
		List<Transactions> result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();

			String sqlSelect = "select gt.Name as 'GoodsTypeName', pf.Name as 'PackagedFormName',  tr.* "
					+ " from transactions tr join goodstype gt on tr.GoodsTypeId = gt.id "
					+ " join packagedform pf on tr.PackagedFormId = pf.id";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setResultTransformer(new AliasToBeanResultTransformer(TransactionsDTO.class));
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Search transaction by condition
	 */
	@Transactional
	public List<Transactions> searchTransaction(int goodsTypeId, int packagedFormId, float weight, float volume,
			String departureProvinceCode, String arrivalProvinceCode, Date departureDate, Date arrivalDate) {
		List<Transactions> result = new ArrayList<Transactions>();
		try {

			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" select gt.Name as 'GoodsTypeName', pf.Name as 'PackagedFormName',  tr.* ");
			sqlQueryString.append(" from transactions tr ");
			sqlQueryString.append(" join goodstype gt on tr.GoodsTypeId = gt.id ");
			sqlQueryString.append(" join packagedform pf on tr.PackagedFormId = pf.id ");
			sqlQueryString.append(" where tr.status = 1 ");
			if (goodsTypeId > 0) {
				sqlQueryString.append(String.format(" and tr.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId > 0) {
				sqlQueryString.append(String.format(" and tr.packagedFormId = %s ", packagedFormId));
			}
			if (weight > 0) {
				sqlQueryString.append(String.format(" and tr.weight < %s ", weight));
			}
			if (volume > 0) {
				sqlQueryString.append(String.format(" and tr.volume < %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" and tr.departureDate = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" and tr.arrivalDate = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(TransactionsDTO.class));

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;

	}

	/**
	 * Add new transactions
	 */
	@Transactional
	public boolean addNewTransaction(Transactions data) {
		boolean result = false;
		try {
			Session session = getSessionFactory().getCurrentSession();

			data.setGoodsType(new GoodsType(data.getGoodsTypeId()));
			data.setPackagedForm(new PackagedForm(data.getPackagedFormId()));
			data.setStatus(ConstantUtils.TRAN_DANG_DAU_GIA);
			session.save(data);

			result = true;
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Update transaction
	 */
	public boolean updateTransactions(Transactions data) {
		try {
			Session session = getSessionFactory().getCurrentSession();

			data.setGoodsType(new GoodsType(data.getGoodsTypeId()));
			data.setPackagedForm(new PackagedForm(data.getPackagedFormId()));
			session.saveOrUpdate(data);

			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Get transactions by id
	 */
	public Transactions getTransactionsById(int id) {
		Transactions result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();

			String sqlSelect = "select gt.Name as 'GoodsTypeName', pf.Name as 'PackagedFormName',  tr.* "
					+ " from transactions tr join goodstype gt on tr.GoodsTypeId = gt.id "
					+ " join packagedform pf on tr.PackagedFormId = pf.id " + " where tr.id = ? ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(Transactions.class));
			result = (Transactions) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get transaction by id
	 */
	public TransactionsDTO getTransactionsDTOById(int id) {
		TransactionsDTO result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();

			String sqlSelect = "select gt.Name as 'GoodsTypeName', pf.Name as 'PackagedFormName',  tr.* "
					+ " from transactions tr join goodstype gt on tr.GoodsTypeId = gt.id "
					+ " join packagedform pf on tr.PackagedFormId = pf.id " + " where tr.id = ? ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(TransactionsDTO.class));
			result = (TransactionsDTO) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
}

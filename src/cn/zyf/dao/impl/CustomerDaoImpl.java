package cn.zyf.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.zyf.dao.ICustomerDao;
import cn.zyf.entity.Customer;


public class CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao {
	@Override
	public void add(Customer customer) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.save(customer);

	}

	@Override
	public List<Customer> query() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		return list;
	}

	@Override
	public void delete(Customer customer) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.delete(customer);
	}

	@Override
	public void update(Customer customer) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		session.update(customer);

	}

	@Override
	public Customer queryById(String id) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("custId", id));
		List<Customer> list = criteria.list();
		return list.size()>0?list.get(0):null;
	}

	@Override
	public int updateStatus(Customer cust) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("update Customer set custTime=:custTime ,"
				+ "custStatus=:custStatus,year=:year,month=:month,day=:day"
				+ " where custId=:id");
		query.setString("id", cust.getCustId());
		query.setTimestamp("custTime", cust.getCustTime());
		query.setString("custStatus", cust.getCustStatus());
		query.setString("year", cust.getYear());
		query.setString("month", cust.getMonth());
		query.setString("day", cust.getDay());
		return query.executeUpdate();
	}

	@Override
	public List<Customer> queryStatusIsNull() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Customer where custStatus IS NULL OR custStatus=''");
		List<Customer> list = query.list();
		return list;
	}

	/**
	 * 所有的客户状态
	 *  无效  未通 死单  上门  紧跟 ...
	 */
	@Override
	public int countStatus(String custStatus) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(1) from Customer where custStatus=:status");
		query.setString("status", custStatus);
		Number uniqueResult = (Number) query.uniqueResult();
		return uniqueResult.intValue();
	}

	/**
	 * 本月的客户状态
	 *  无效  未通 死单  上门  紧跟 ...
	 */
	@Override
	public int countStatusCurrMon(String custStatus) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(1) from Customer where custStatus=:status and "
				+ "DATE_FORMAT( custTime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
		query.setString("status", custStatus);
		Number uniqueResult = (Number) query.uniqueResult();
		return uniqueResult.intValue();
	}
	/**
	 * 今日的客户状态
	 *  无效  未通 死单  上门  紧跟 ...
	 */
	@Override
	public int countStatusCurrDay(String custStatus) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select count(1) from Customer where custStatus=:status and "
				+ "TO_DAYS(custTime) = TO_DAYS(NOW())");
		query.setString("status", custStatus);
		Number uniqueResult = (Number) query.uniqueResult();
		return uniqueResult.intValue();
	}

	@Override
	public List<Customer> queryStatusGOIN() throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select new Customer(custId,custName,custTel,custStatus,custTime) from"
				+ " Customer where custStatus='上门'");
		return query.list();
	}
	
	@Override
	public List<Customer> queryStatusGOINByName(String name) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select new Customer(custId,custName,custTel,custStatus,custTime) from"
				+ " Customer where custStatus='上门' and custName like :custName");
		query.setString("custName", "%"+name+"%");
		return query.list();
	}
	
	@Override
	public List<Customer> queryStatusGOINByTel(String tel) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("select new Customer(custId,custName,custTel,custStatus,custTime) from"
				+ " Customer where custStatus='上门' and custTel like :custTel");
		query.setString("custTel", "%"+tel+"%");
		return query.list();
	}
	
	@Override
	public List<Customer> queryStatusGOINByTime(String time) throws Exception {
		String[] split = time.split("-");
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("custStatus", "上门"));
		if(split.length==1){
			criteria.add(Restrictions.like("year", split[0]));
		}else if(split.length==2){
			criteria.add(Restrictions.like("year", split[0]));
			criteria.add(Restrictions.like("month", split[1]));
		}else{
			criteria.add(Restrictions.like("year", split[0]));
			criteria.add(Restrictions.like("month", split[1]));
			criteria.add(Restrictions.like("day", split[2]));
		}
		List<Customer> list = criteria.list();
		return list;
	}
}

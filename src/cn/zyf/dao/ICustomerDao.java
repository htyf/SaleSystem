package cn.zyf.dao;

import java.util.Date;
import java.util.List;

import cn.zyf.entity.Customer;

public interface ICustomerDao {
	public void add(Customer customer) throws Exception;
	
	public void delete(Customer customer) throws Exception;
	
	public void update(Customer customer) throws Exception;
	
	public List<Customer> query() throws Exception;
	
	public Customer queryById(String id) throws Exception;
	
	public int updateStatus(Customer cust) throws Exception;

	public List<Customer> queryStatusIsNull() throws Exception;
	
	public int countStatus(String custStatus) throws Exception;
	
	public int countStatusCurrMon(String custStatus) throws Exception;
	
	public int countStatusCurrDay(String custStatus) throws Exception;
	/**
	 * 查看上门状态的客户信息
	 * @return
	 * @throws Exception
	 */
	public List<Customer> queryStatusGOIN() throws Exception;
	
	public List<Customer> queryStatusGOINByName(String name) throws Exception;
	
	public List<Customer> queryStatusGOINByTel(String tel) throws Exception;
	
	public List<Customer> queryStatusGOINByTime(String time) throws Exception ;
}

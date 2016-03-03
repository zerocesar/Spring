package mx.com.att.dao;

import mx.com.att.vo.CustomerVO;

public interface LoginDAO {

	CustomerVO getCustomerInfo(final String telephoneNum);
	
	int deleteUserLdap(final String telephoneNum);
	String getDecriptedPassword(final String telephoneNum);
}
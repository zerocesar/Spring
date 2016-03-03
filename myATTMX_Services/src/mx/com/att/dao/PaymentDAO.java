package mx.com.att.dao;

import mx.com.att.vo.BankReferenceVO;


public interface PaymentDAO {
	
	BankReferenceVO[] getBankReference(BankReferenceVO bankReferenceVO);
	
}

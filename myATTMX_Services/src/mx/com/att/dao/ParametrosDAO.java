package mx.com.att.dao;

import java.util.Map;

import mx.com.att.vo.orange.ClassificationVO;
 
public interface ParametrosDAO {
	Map<String, String> getParameterWP();
	Map<String, String> getParameterFVM();
	
	ClassificationVO[] getClassification(ClassificationVO c);
}
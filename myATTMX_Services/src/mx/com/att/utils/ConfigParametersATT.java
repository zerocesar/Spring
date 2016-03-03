package mx.com.att.utils;

import mx.com.att.business.CommercialConfigBusiness;
import mx.com.att.business.ParametrosBusiness;
import mx.com.att.vo.orange.ClassificationVO;

public class ConfigParametersATT {
	
	public void configureParameters() {
		final ParametrosBusiness parametroBusiness = new ParametrosBusiness();
		ATTConstants.setPARAMETERS_WP(parametroBusiness.getConfigurationParameterWP());
		ATTConstants.setPARAMETERS_FVM(parametroBusiness.getConfigurationParameterFVM());
		
		ATTConstants.IS_ACTIVE_ENCRYPTION = new Boolean (ATTConstants.getPARAMETERS_WP().get(ATTConstants.ACTIVE_ENCRYPTION));
		ATTConstants.IS_ACTIVE_OPERADOR_CONSULTASNUM = new Boolean (ATTConstants.getPARAMETERS_WP().get(ATTConstants.ACTIVE_OPERADOR_CONSULTASNUM));
		
		ATTConstants.MAX_PADRES = Integer.parseInt(ATTConstants.getPARAMETERS_WP().get(ATTConstants.MAX_PADRES_STR));
		ATTConstants.MAX_HIJOS = Integer.parseInt(ATTConstants.getPARAMETERS_WP().get(ATTConstants.MAX_HIJOS_STR));
		ATTConstants.BUCKET_TYPE = ATTConstants.getPARAMETERS_WP().get(ATTConstants.BUCKET).split(",");
		ATTConstants.TIME_OUT = Integer.parseInt(ATTConstants.getPARAMETERS_WP().get(ATTConstants.STRING_TIME_OUT));
		
		ATTConstants.URL_WS_ECOMMERCE = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_ECOMMERCE);
		ATTConstants.URL_WS_IUSACEL = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_IUSACEL);
		ATTConstants.URL_WS_MAP = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_MAP);
		ATTConstants.URL_WS_POSTPAID = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_POSTPAID);
		ATTConstants.URL_WS_PAPERLESS = ATTConstants.getPARAMETERS_FVM().get(ATTConstants.URL_WS_PAPERLESS);
		ATTConstants.URL_WS_ESTADOCUENTA = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_ESTADOCUENTA);
		ATTConstants.URL_WS_MAIL = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_MAIL);
		ATTConstants.URL_WS_GPAY = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_GPAY);
		ATTConstants.URL_WS_PAYMENT_GATEWAY = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_PAYMENT_GATEWAY);
		ATTConstants.URL_WS_RATE_SHARING = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_RATE_SHARING);
		ATTConstants.URL_WS_CONSULTASNUM = ATTConstants.getPARAMETERS_WP().get(ATTConstants.URL_WS_CONSULTASNUM);
		
		ATTConstants.MAX_CHARGE_BILL = ATTConstants.getPARAMETERS_WP().get(ATTConstants.MAX_CHARGE_BILL);
		ATTConstants.NUM_MAX_CONTR = Integer.parseInt(ATTConstants.getPARAMETERS_WP().get(ATTConstants.STRING_NUM_MAX_CONTR));
		
		//Carga de parametros de exclusión
		try{
			ClassificationVO classif = null;
					
			classif = new ClassificationVO();
			classif.setMetaCatalogType(ATTConstants.EXCLUSIONES_TMCODE);
			ClassificationVO[] arrTmcodes = (ClassificationVO[]) (new CommercialConfigBusiness()).getClassification(classif).getObjectResponse();
			for(int i = 0; i<arrTmcodes.length; i++)
				ATTConstants.EXCLUSIONES_TMCODE_ARR.add(arrTmcodes[i]);
			
			classif = new ClassificationVO();
			classif.setMetaCatalogType(ATTConstants.EXCLUSIONES_PAYMENT);
			ClassificationVO[] arrPayments = (ClassificationVO[]) (new CommercialConfigBusiness()).getClassification(classif).getObjectResponse();
			for(int i = 0; i<arrPayments.length; i++)
				ATTConstants.EXCLUSIONES_PAYMENT_ARR.add(arrPayments[i]);
			
		}catch(Exception ex){
		}
	}
}
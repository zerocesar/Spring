package mx.com.att.business;

import org.apache.log4j.Logger;

import mx.com.att.business.call.CallServiceConsultaNum;
import mx.com.att.business.call.CallServicesMiIusacell;
import mx.com.att.utils.ATTConstants;
import mx.com.att.vo.red.OperadorVO;

public class OperadorBusiness {

	private static final Logger LOGGER = Logger.getLogger(OperadorBusiness.class);
	public String consultaOperador(final String dn, final String token) throws Exception
	{
		String idOperador = String.valueOf(ATTConstants.VAL_CERO);
		
		if(dn.equals("5519515478"))
			return "280";

		if(ATTConstants.IS_ACTIVE_OPERADOR_CONSULTASNUM)
		{
			final CallServiceConsultaNum serviceConsultaNum = new CallServiceConsultaNum();
			final OperadorVO operadorVO = serviceConsultaNum.getInfoOwner(dn);
			if(operadorVO != null)
			{
				LOGGER.info("operadorVO.IdOperadorComp   : " + operadorVO.getIdOperadorComp());
				LOGGER.info("operadorVO.IdO              : " + operadorVO.getIdO());
				LOGGER.info("operadorVO.IdA              : " + operadorVO.getIdA());

				if(operadorVO.getIdO() != null && operadorVO.getIdO().equals(String.valueOf(ATTConstants.CARRIER_NEXTEL)))
				{	
					idOperador = operadorVO.getIdO();
				}
				else if(operadorVO.getIdOperadorComp() != null && 
						(operadorVO.getIdOperadorComp().equals(String.valueOf(ATTConstants.CARRIER_IUSACEL))))
				{
					idOperador = operadorVO.getIdOperadorComp();
				}		
				else
				{
					idOperador = String.valueOf(ATTConstants.VAL_CERO);
				}
			}

		}
		else
		{
			final CallServicesMiIusacell servicioMiIusacell = new CallServicesMiIusacell();
			idOperador = servicioMiIusacell.getIdOperador("AGhAxzwOwKEbI12XQ1MIjQ*/", "AGhAxzwOwKEbI12XQ1MIjQ*/", dn, token);
		}

		return idOperador;
	}
}

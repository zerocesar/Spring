package mx.com.att.business.orange;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import mx.com.att.utils.ATTConstants;
import mx.com.nextel.portal.constants.ContractType;
import mx.com.nextel.www.wppp.exceptions.WPPPntException;
import mx.com.nextel.www.wppp.ws.contratos.ContratosWPPPLocator;
import mx.com.nextel.www.wppp.ws.contratos.ContratosWPPPSoapBindingStub;
import mx.com.nextel.www.wppp.ws.vo.ContractVO;
import mx.com.nextel.www.wppp.ws.vo.DeviceVO;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;


public class BsnContract {
	private static final Logger LOGGER = Logger.getLogger(BsnContract.class);

	/**
	 * Este metodo obtiene  la informacion del tipo de contracto, se consulta la 
	 * URL de los servicios web de postpago, tomando como ContratosWPPPLocator de
	 *  proxy.
	 * @author Ernesto Gonzalez - MindBits Desarrollo (16/OCT/2013) 
	 * @param String  dn-- es el numero telefonico del usuario.
	 * @return ContractVO que contiene la informacion del contrato dependiendo 
	 * 	si es hibrido, prepago y postpago
	 * @throws EcommerceWSException 
	 * 
	 */
	public ContractVO getContractDetails(String dn) {
		LOGGER.debug(">> BsnContract: (getContractDetails).");
		DeviceVO recurso = new DeviceVO();//SE CREA UN OBJETO DEVICEVO
		ContractVO contrato = null;

		recurso.setDn(dn);//
		LOGGER.info("DN " + recurso.getDn());
		LOGGER.info(ATTConstants.URL_WS_POSTPAID);
		String endPoint = ATTConstants.URL_WS_POSTPAID+"SrvWPPospago/ContratosWPPP?wsdl";//CONEXION A LA URL DE POSPAGO
		LOGGER.info("URL del WSDL a consumir: " + endPoint);
		ContratosWPPPLocator proxy = new  ContratosWPPPLocator();// CONEXION A LA URL
		ContratosWPPPSoapBindingStub fnfStub;
		//try {
			try {
				fnfStub = new ContratosWPPPSoapBindingStub(new URL(endPoint), proxy);
				try {
					contrato = fnfStub.consultaContratoRecurso(recurso);
				} catch (WPPPntException e) {
					LOGGER.error("Error WPPPntException en el metodo getContractDetails ",e);
				} catch (RemoteException e) {
					LOGGER.error("Error RemoteException en el metodo getContractDetails ",e);
				}
			} catch (AxisFault e1) {
				LOGGER.error("Error AxisFault en el metodo getContractDetails: ",e1);
			} catch (MalformedURLException e1) {
				LOGGER.error("Error MalformedURLException en el metodo getContractDetails: ",e1);
			}
			
		return contrato;
	}
	/**
	 * Este metodo obtiene  la informacion del tipo de contrato dependiendo
	 *  si es  postpago, hibrido
	 * y prepago.
	 * @author Ernesto Gonzalez - MindBits Desarrollo (16/OCT/2013)
	 * @param  int idTipoContrato-- es el id del tipo de contrato
	 * @return String   donde se valida el postpago, hibrido  y prepago.
	 * 
	 */

	public String contractTypeToString(int idTipoContrato){
		String tipoContrato=null;

		switch(idTipoContrato){//SE EVALIA EL TIPO DE CONTRATO
		case ContractType.POSTPAGO: //SI ES 1 
			tipoContrato = "POSTPAGO";
			break;
		case ContractType.HIBRIDO://SI ES 2
			tipoContrato = "HIBRIDO";
			break;
		case ContractType.PREPAGO://SI ES 3
			tipoContrato = "PREPAGO";
			break;
		default:
			tipoContrato = "INVALIDO";
		}
		return tipoContrato;
	}
}
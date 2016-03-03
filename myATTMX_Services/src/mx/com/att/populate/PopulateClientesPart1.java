package mx.com.att.populate;

import com.google.gson.Gson;

import mx.com.att.vo.gpay.ClienteTDCVO;
import mx.com.att.vo.gpay.ClienteVO;
import mx.com.nextel.pggpay.ops.service.impl.CambioContraClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.CambioContraClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.ModificaClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.ModificaClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistroClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistroClienteResponse;


public class PopulateClientesPart1 {

	public ClienteTDCVO addResp(final RegistroClienteResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setChecksum(responseVO.getChecksum());
		requestVO.setStatus(responseVO.isStatus());
		if( responseVO.getData() == null){
			requestVO.setData(new ClienteVO[0]);
		} else{
			final String clienteJSON = new Gson().toJson(responseVO.getData());
			final ClienteVO[] clienteVO = new Gson().fromJson(clienteJSON, ClienteVO[].class);
			
			requestVO.setData(clienteVO);
		}
		
		return requestVO;
	}
	
	public RegistroClienteRequest addReq(final ClienteTDCVO requestVO){
		final RegistroClienteRequest responseVO = new RegistroClienteRequest();

		responseVO.setApMaterno(requestVO.getApMaterno());
		responseVO.setApPaterno(requestVO.getApPaterno());
		responseVO.setCorreo(requestVO.getCorreo());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setNombres(requestVO.getNombres());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setTelefono(requestVO.getTelefono());
		responseVO.setCuenta(requestVO.getCuenta());
		
		return responseVO;
	}
	
	public ClienteTDCVO changeResp(final CambioContraClienteResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
	
	public CambioContraClienteRequest changeReq(final ClienteTDCVO requestVO){
		final CambioContraClienteRequest responseVO = new CambioContraClienteRequest();

		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setNcredencial(requestVO.getNcredencial());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO deleteResp(final DesactivaClienteResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
	
	public DesactivaClienteRequest deleteReq(final ClienteTDCVO requestVO){
		final DesactivaClienteRequest responseVO = new DesactivaClienteRequest();
		
		responseVO.setCausa(requestVO.getCausa());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO editResp(final ModificaClienteResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
	
	public ModificaClienteRequest editReq(final ClienteTDCVO requestVO){
		final ModificaClienteRequest responseVO = new ModificaClienteRequest();
		
		responseVO.setApMaterno(requestVO.getApMaterno());
		responseVO.setApPaterno(requestVO.getApPaterno());
		responseVO.setCorreo(requestVO.getCorreo());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setNombres(requestVO.getNombres());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setTelefono(requestVO.getTelefono());
		responseVO.setCuenta(requestVO.getCuenta());
		
		return responseVO;
	}
}
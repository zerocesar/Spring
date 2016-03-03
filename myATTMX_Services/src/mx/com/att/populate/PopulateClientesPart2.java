package mx.com.att.populate;

import com.google.gson.Gson;

import mx.com.att.vo.gpay.ClienteTDCVO;
import mx.com.att.vo.gpay.ClienteVO;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaInfClienteRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaInfClienteResponse;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTokenRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTokenResponse;
import mx.com.nextel.pggpay.ops.service.impl.EstadoRegistroRequest;
import mx.com.nextel.pggpay.ops.service.impl.EstadoRegistroResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistroContrasenaRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistroContrasenaResponse;

public class PopulateClientesPart2 {

	public ClienteTDCVO infoResp(final ConsultaInfClienteResponse responseVO){
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
	
	public ConsultaInfClienteRequest infoReq(final ClienteTDCVO requestVO){
		final ConsultaInfClienteRequest responseVO = new ConsultaInfClienteRequest();

		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO signupResp(final EstadoRegistroResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
	
	public EstadoRegistroRequest signupReq(final ClienteTDCVO requestVO){
		final EstadoRegistroRequest responseVO = new EstadoRegistroRequest();

		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO getTokenResp(final ConsultaTokenResponse responseVO){
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
	
	public ConsultaTokenRequest getTokenReq(final ClienteTDCVO requestVO){
		final ConsultaTokenRequest responseVO = new ConsultaTokenRequest();

		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO setCredentialsResp(final RegistroContrasenaResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
	
	public RegistroContrasenaRequest setCredentialsReq(final ClienteTDCVO requestVO){
		final RegistroContrasenaRequest responseVO = new RegistroContrasenaRequest();

		responseVO.setCredencial(requestVO.getCredencial());				
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		
		return responseVO;
	}
	
	public ClienteTDCVO getResponse(final ConsultaTokenResponse responseVO){
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
	
	public ClienteTDCVO getResponse(final RegistroContrasenaResponse responseVO){
		final ClienteTDCVO requestVO = new ClienteTDCVO();
		
		requestVO.setStatus(responseVO.isStatus());
		
		return requestVO;
	}
}
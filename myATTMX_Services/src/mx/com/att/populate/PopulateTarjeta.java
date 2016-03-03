package mx.com.att.populate;

import com.google.gson.Gson;

import mx.com.att.validator.ValidatorGPAY;
import mx.com.att.vo.gpay.TarjetaTDCVO;
import mx.com.att.vo.gpay.TarjetaVO;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsultaTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.DesactivaTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.PredetTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.PredetTDCResponse;
import mx.com.nextel.pggpay.ops.service.impl.RegistraTDCRequest;
import mx.com.nextel.pggpay.ops.service.impl.RegistraTDCResponse;

public class PopulateTarjeta {

	public RegistraTDCRequest addCustReq(final TarjetaTDCVO requestVO){
		final RegistraTDCRequest responseVO = new RegistraTDCRequest();
		final ValidatorGPAY validator = new ValidatorGPAY();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setTipo(requestVO.getTipo());
		responseVO.setTarjetaHabiente(requestVO.getTarjetaHabiente());
		responseVO.setNumero(requestVO.getNumero());
		responseVO.setVigencia(requestVO.getVigencia());
		responseVO.setCodigo(requestVO.getCodigo());
		if (validator.isNotEmpty(requestVO.getNip())){
			responseVO.setNip(requestVO.getNip());
		}
		
		return responseVO;
	}
	
	public TarjetaTDCVO addCustRes(final RegistraTDCResponse requestVO){
		final TarjetaTDCVO responseVO = new TarjetaTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		responseVO.setChecksum(requestVO.getChecksum());
		if( requestVO.getData() == null){
			responseVO.setData(new TarjetaVO[0]);
		} else{
			final String tarjetaJSON = new Gson().toJson(requestVO.getData());
			final TarjetaVO[] tarjetaVO = new Gson().fromJson(tarjetaJSON, TarjetaVO[].class);
			
			responseVO.setData(tarjetaVO);
		}
		
		return responseVO;
	}
	
	public PredetTDCRequest defaultCustReq(final TarjetaTDCVO requestVO){
		final PredetTDCRequest responseVO = new PredetTDCRequest();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setId(requestVO.getIdTarjeta());
		
		return responseVO;
	}
	
	public TarjetaTDCVO defaultCustRes(final PredetTDCResponse requestVO){
		final TarjetaTDCVO responseVO = new TarjetaTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		
		return responseVO;
	}
	
	public ConsultaTDCRequest getCustReq(final TarjetaTDCVO requestVO){
		final ConsultaTDCRequest responseVO = new ConsultaTDCRequest();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		
		return responseVO;
	}
	
	public TarjetaTDCVO getCustRes(final ConsultaTDCResponse requestVO){
		final TarjetaTDCVO responseVO = new TarjetaTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		responseVO.setChecksum(requestVO.getChecksum());
		if( requestVO.getData() == null){
			responseVO.setData(new TarjetaVO[0]);
		} else{
			final String tarjetaJSON = new Gson().toJson(requestVO.getData());
			final TarjetaVO[] tarjetaVO = new Gson().fromJson(tarjetaJSON, TarjetaVO[].class);
			
			responseVO.setData(tarjetaVO);
		}
		
		return responseVO;
	}
	
	public DesactivaTDCRequest deleteCustReq(final TarjetaTDCVO requestVO){
		final DesactivaTDCRequest responseVO = new DesactivaTDCRequest();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setId(requestVO.getIdTarjeta());
		responseVO.setCausa(requestVO.getCausa());
		
		return responseVO;
	}
	
	public TarjetaTDCVO deleteCustRes(final DesactivaTDCResponse requestVO){
		final TarjetaTDCVO responseVO = new TarjetaTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		
		return responseVO;
	}
}
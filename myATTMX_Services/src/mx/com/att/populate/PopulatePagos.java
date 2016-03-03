package mx.com.att.populate;

import com.google.gson.Gson;
import com.nextel.pgw.ws.vo.BankTransResWPVO;
import com.nextel.pgw.ws.vo.ServiceOrderWPVO;

import mx.com.att.validator.ValidatorGPAY;
import mx.com.att.vo.gpay.PagoTDCVO;
import mx.com.att.vo.gpay.PagoVO;
import mx.com.nextel.pggpay.ops.service.impl.ConsTransaccionesRequest;
import mx.com.nextel.pggpay.ops.service.impl.ConsTransaccionesResponse;
import mx.com.nextel.pggpay.ops.service.impl.PagoLineaRequest;
import mx.com.nextel.pggpay.ops.service.impl.PagoLineaResponse;

public class PopulatePagos {

	
	public PagoLineaRequest addTransReq(final PagoTDCVO requestVO){
		final PagoLineaRequest responseVO = new PagoLineaRequest();
		final ValidatorGPAY validator = new ValidatorGPAY();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setId(requestVO.getIdTarjeta());
		responseVO.setCodigo(requestVO.getCodigo());
		responseVO.setReferencia(requestVO.getReferencia());
		responseVO.setMonto(requestVO.getMonto());
		responseVO.setDescripcion(requestVO.getDescripcion());
		responseVO.setIdServicio(requestVO.getIdServicio());
		if (validator.isNotEmpty(requestVO.getNip())){
			responseVO.setNip(requestVO.getNip());
		}
		
		return responseVO;
	}
	
	public PagoTDCVO addTransRes(final PagoLineaResponse requestVO){
		final PagoTDCVO responseVO = new PagoTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		responseVO.setChecksum(requestVO.getChecksum());
		if( requestVO.getData() == null){
			responseVO.setData(new PagoVO[0]);
		} else{
			final String pagoJSON = new Gson().toJson(requestVO.getData());
			final PagoVO[] pagoVO = new Gson().fromJson(pagoJSON, PagoVO[].class);
			
			responseVO.setData(pagoVO);
		}
		
		return responseVO;
	}
	
	public ConsTransaccionesRequest getTransReq(final PagoTDCVO requestVO){
		final ConsTransaccionesRequest responseVO = new ConsTransaccionesRequest();
		
		responseVO.setPrincipalApp(requestVO.getPrincipalApp());
		responseVO.setCredencialApp(requestVO.getCredencialApp());
		responseVO.setPrincipal(requestVO.getPrincipal());
		responseVO.setCredencial(requestVO.getCredencial());
		responseVO.setReferencia(requestVO.getReferencia());
		
		return responseVO;
	}
	
	public PagoTDCVO getTransRes(final ConsTransaccionesResponse requestVO){
		final PagoTDCVO responseVO = new PagoTDCVO();
		
		responseVO.setStatus(requestVO.isStatus());
		responseVO.setChecksum(requestVO.getChecksum());
		if( requestVO.getData() == null){
			responseVO.setData(new PagoVO[0]);
		} else{
			final String pagoJSON = new Gson().toJson(requestVO.getData());
			final PagoVO[] pagoVO = new Gson().fromJson(pagoJSON, PagoVO[].class);
			
			responseVO.setData(pagoVO);
		}
		
		return responseVO;
	}
	
	public BankTransResWPVO getBankTransReq(final mx.com.att.vo.gpay.BankTransResWPVO requestVO){
		final BankTransResWPVO responseVO = new BankTransResWPVO();
		
		responseVO.setOrderId(requestVO.getOrderId());
		responseVO.setTxnResponseCode(requestVO.getTxnResponseCode());
		responseVO.setAuthorizeId(requestVO.getAuthorizeId());
		responseVO.setMessage(requestVO.getMessage());
		
		return responseVO;
	}
	
	public ServiceOrderWPVO getServiceOrderReq(final mx.com.att.vo.orange.ServiceOrderWPVO requestVO){
		final ServiceOrderWPVO responseVO = new ServiceOrderWPVO();
		
		responseVO.setOrderId(requestVO.getOrderId());
		responseVO.setOrderStatusId(requestVO.getOrderStatusId());
		
		return responseVO;
	}
}
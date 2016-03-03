package mx.com.att.vo.orange;

import java.util.List;

/**@author Mindbits**/
public class ServicioActivoVO {

	/**@param purchaseServicesVO**/
	private DetailPurchaseServicesVO[] purchaseServicesVO;
	/**@param listaServicios**/
	private List<Servicio> listaServicios;
	
	public ServicioActivoVO() {
		
	}
	
	
	public ServicioActivoVO(DetailPurchaseServicesVO[] purchaseServicesVO,
			List<Servicio> listaServicios) {
		if( purchaseServicesVO instanceof DetailPurchaseServicesVO[]){
			this.purchaseServicesVO = (DetailPurchaseServicesVO[])purchaseServicesVO.clone();
		} else{
			this.purchaseServicesVO = new DetailPurchaseServicesVO[0];
		}
		
		this.listaServicios = listaServicios;
	}


	public DetailPurchaseServicesVO[] getPurchaseServicesVO() {
		if( this.purchaseServicesVO instanceof DetailPurchaseServicesVO[]){
			return (DetailPurchaseServicesVO []) purchaseServicesVO.clone();
		} else{
			return new DetailPurchaseServicesVO[0];
		}
	}


	public void setPurchaseServicesVO(DetailPurchaseServicesVO[] purchaseServicesVO) {
		if( purchaseServicesVO instanceof DetailPurchaseServicesVO[]){
			this.purchaseServicesVO = (DetailPurchaseServicesVO[]) purchaseServicesVO.clone();
		} else{
			this.purchaseServicesVO = new DetailPurchaseServicesVO[0];
		}
	}


	public List<Servicio> getListaServicios() {
		return listaServicios;
	}
	public void setListaServicios(List<Servicio> listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	
}

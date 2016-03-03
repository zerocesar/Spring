package mx.com.att.vo.orange;

import java.io.Serializable;

public class OrdenesWPVO implements Serializable{
	
	   private final static long serialVersionUID = 1L;
	   private String orderID;
	   private String nombre;
	   private String descripcion;
	   private String orderStatus;
	   
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(final String orderID) {
		this.orderID = orderID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(final String orderStatus) {
		this.orderStatus = orderStatus;
	}
	   

}

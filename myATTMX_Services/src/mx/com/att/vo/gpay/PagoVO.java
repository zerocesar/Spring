package mx.com.att.vo.gpay;

import java.io.Serializable;
import java.util.Calendar;

public class PagoVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String desc;

	private String id; //NOPMD

	private Float monto;

    private String ref;

    private Boolean status;
    
    private Calendar fecha;
    
    public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(final Calendar fecha) {
		this.fecha = fecha;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(final String desc) {
		this.desc = desc;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(final Float monto) {
		this.monto = monto;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(final Boolean status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(final String id) { //NOPMD
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(final String ref) {
		this.ref = ref;
	}
}
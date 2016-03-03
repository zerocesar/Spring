package mx.com.att.vo.orange;

import java.io.Serializable;

import mx.com.nextel.www.ws.vo.SaldoVO;


public class ConsultaSaldoVO implements Serializable{
	 private final static long serialVersionUID = 1L;
	    
	    protected String id;
	    
	    protected String idSistema;
	    
	    protected String dn;
	    
	    protected String ufmi;
	    
	    protected String code;
	    
	    protected String messageCode;
	    
	    protected SaldoVO[] saldos;

	    /**
	     * Gets the value of the id property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getId() {
	        return id;
	    }

	    /**
	     * Sets the value of the id property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setId(final String value) {
	        this.id = value;
	    }

	    /**
	     * Gets the value of the idSistema property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getIdSistema() {
	        return idSistema;
	    }

	    /**
	     * Sets the value of the idSistema property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setIdSistema(final String value) {
	        this.idSistema = value;
	    }

	    /**
	     * Gets the value of the dn property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getDn() {
	        return dn;
	    }

	    /**
	     * Sets the value of the dn property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setDn(final String value) {
	        this.dn = value;
	    }

	    /**
	     * Gets the value of the ufmi property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getUfmi() {
	        return ufmi;
	    }

	    /**
	     * Sets the value of the ufmi property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setUfmi(final String value) {
	        this.ufmi = value;
	    }

	    /**
	     * Gets the value of the code property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getCode() {
	        return code;
	    }

	    /**
	     * Sets the value of the code property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setCode(final String value) {
	        this.code = value;
	    }

	    /**
	     * Gets the value of the messageCode property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getMessageCode() {
	        return messageCode;
	    }

	    /**
	     * Sets the value of the messageCode property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setMessageCode(final String value) {
	        this.messageCode = value;
	    }

	    /**
	     * Gets the value of the saldoVO property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link SaldoVO }
	     *     
	     */
	    public SaldoVO[] getSaldos() {
	    	if( saldos instanceof SaldoVO[]){
	    		return (SaldoVO[]) saldos.clone();
	    	} else{
	    		return new SaldoVO[0];
	    	}
	    }

	    /**
	     * Sets the value of the saldoVO property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link SaldoVO }
	     *     
	     */
	    public void setSaldos(final SaldoVO[] value) {
	    	if( value instanceof SaldoVO[] ){
	    		this.saldos = (SaldoVO[]) value.clone();
	    	} else{
	    		this.saldos = new SaldoVO[0];
	    	}
	        
	    }
}

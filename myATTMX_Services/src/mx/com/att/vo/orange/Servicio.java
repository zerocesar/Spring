package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;


public class Servicio implements Serializable, Comparable<Servicio> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idService;
	private String sncode;
	private String spcode;
	private String description;
	private int status;
	private Date actualStatusDate;
	private String title;
	private boolean avaliable = true;
	private double cost;
	private String costString = "0.00";
	private boolean family;

	
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}


	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}


	/**
	 * @return the sncode
	 */
	public String getSnCode() {
		return sncode;
	}


	/**
	 * @param sncode the sncode to set
	 */
	public void setSnCode(String sncode) {
		this.sncode = sncode;
	}


	/**
	 * @return the spcode
	 */
	public String getSpCode() {
		return spcode;
	}


	/**
	 * @param spcode the spcode to set
	 */
	public void setSpCode(String spcode) {
		this.spcode = spcode;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the actualStatusDate
	 */
	public Date getActualStatusDate() {
		return actualStatusDate;
	}


	/**
	 * @param actualStatusDate the actualStatusDate to set
	 */
	public void setActualStatusDate(Date actualStatusDate) {
		this.actualStatusDate = actualStatusDate;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the avaliable
	 */
	public boolean isAvaliable() {
		return avaliable;
	}


	/**
	 * @param avaliable the avaliable to set
	 */
	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	
	public boolean isFamily() {
		return family;
	}

	public void setFamily(boolean family) {
		this.family = family;
	}


	public boolean equals(Object obj){
		boolean retorno = false;
		if(obj instanceof Servicio){
			Servicio service = (Servicio)obj;
			if( ( service.getSnCode() !=null &&  service.getSnCode().equals(this.sncode) && service.getSpCode().equals(this.spcode)) || (this.idService>0 && service.getIdService() == this.idService) ){
				retorno = true;
			}
		}
		return retorno;
	}
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + this.idService;
		return hash;
	}
	
	public Servicio(){
	
	}

	public Servicio(String sncode, String spcode, String description,
			String title, boolean avaliable) {
		super();
		this.sncode = sncode;
		this.spcode = spcode;
		this.description = description;
		this.title = title;
		this.avaliable = avaliable;
	}
	
	/**
	 * @return the idService
	 */
	public int getIdService() {
		return idService;
	}


	/**
	 * @param idService the idService to set
	 */
	public void setIdService(int idService) {
		this.idService = idService;
	}


	/**
	 * @return the costString
	 */
	public String getCostString() {
		if (cost  < 1){
			return this.costString;
		}
		this.costString = String.valueOf(cost);
		StringTokenizer stk = new StringTokenizer(this.costString, ".");
		String stPrePoint = stk.nextToken();
		String stPostPoint = stk.nextToken() + "00";

		return stPrePoint + "." + stPostPoint.substring(0, 2) ;
	}


	/**
	 * @param costString the costString to set
	 */
	public void setCostString(String costString) {
		this.costString = costString;
	}


	public String toString(){
		
		return idService + "\tSnCode: " + this.sncode + "; \tSpCode : "+ this.spcode  + "; \tStatus : " + this.status 
				 + "; \tCost : " + this.getCost() + "; \tAvaliable : "+this.avaliable
		         + "; \tDescripcion : " + this.description + "; \tTitle : " + this.title ;
	}


	@Override
	public int compareTo(Servicio service) {
		return this.title.toLowerCase().compareTo(service.getTitle().toLowerCase());
	}
	

	
	
}

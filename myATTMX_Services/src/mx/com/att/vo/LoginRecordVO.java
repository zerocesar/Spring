package mx.com.att.vo;

import java.io.Serializable;

public class LoginRecordVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String commonName; //commonName Nombre del usuario
	
	private String lastName; //lastName Apellidos del usuario
	
	private String businessCategory;
	
	private String description; //description Descripcion del registro
	
	private String employeeType; //employeeType Sexo y fecha de nacimiento del usuario
	
	private String givenName; //givenName Nickname del usuario
	
	private String initials;
	
	private String mail; //mail Correo eletronico del usuario
	
	private String uid;
	
	private String oldPassword; //Password anterior para cambio de password
	
	private String userPassword;
	
	private String respuesta; //respuesta Respuesta del servicio LDAP
	
	private String error; //error Descripcion de error  del servicio LDAP

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(final String commonName) {
		this.commonName = commonName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(final String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(final String employeeType) {
		this.employeeType = employeeType;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(final String givenName) {
		this.givenName = givenName;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(final String initials) {
		this.initials = initials;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(final String mail) {
		this.mail = mail;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(final String uid) {
		this.uid = uid;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(final String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}
}
package mx.com.att.vo.red;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LoginRegisterBean
{
    private String dn = "";
    private String key = "";
    private String keyBis = "";
    
    private String pin = "";
    private String nombre = "";
    private String paterno = "";
    private String materno = "";
    private String email = "";
    private String nacimiento = "";
    
    private String fotografia = "";
    
    private boolean pinOkPin;
    
    /*---------------------------------------------------------------
     *   C o n s t r u c t o r   a n d   C l a s s   M e t h o d s
     *------------------------------------------------------------ */
    
    public boolean validarKey(){
        if(key != null && key.length() > 7){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarKeyBis(){
        if(keyBis != null && keyBis.length() > 7){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean validarNombre(){
        if(nombre != null && nombre.length() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarPaterno(){
        if(paterno != null && paterno.length() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarMaterno(){
        if(materno != null && materno.length() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validateEmail(){
        if(email != null && email.length() > 0){
            return true;
        }else{
            return false;
        }
    }
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public boolean validaFormatoEmail(){
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public boolean validarNacimiento(){
        if(nacimiento != null && nacimiento.length() == 10){
            return true;
        }else{
            return false;
        }
    }
    
    /*---------------------------------------------------------------
     *              G e t t e r s   &   s e t t e r s
     *------------------------------------------------------------ */
    
    public String getDn() {
        return dn;
    }
    public void setDn(final String dn) {
        this.dn = dn;
    }
    public String getKey() {
        return key;
    }
    public void setKey(final String key) {
        this.key = key;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(final String pin) {
        this.pin = pin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(final String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    public String getPaterno() {
        return paterno;
    }
    public void setPaterno(final String paterno) {
        this.paterno = paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public void setMaterno(final String materno) {
        this.materno = materno;
    }
    public String getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(final String nacimiento) {
        this.nacimiento = nacimiento;
    }
    public boolean isPinOkPin() {
        return pinOkPin;
    }
    public void seValidoPinService(final boolean valido){
        this.pinOkPin = valido;
    }
    public String getFotografia() {
        return fotografia;
    }
    public void setFotografia(final String fotografia) {
        this.fotografia = fotografia;
    }
    public String getKeyBis() {
        return keyBis;
    }
    public void setKeyBis(final String keyBis) {
        this.keyBis = keyBis;
    }
}

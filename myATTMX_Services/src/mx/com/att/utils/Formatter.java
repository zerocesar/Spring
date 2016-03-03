package mx.com.att.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Formatter {

  private static DecimalFormatSymbols unusualSymbols;
  private static DecimalFormat        formatoMoneda;
  static {
    unusualSymbols = new DecimalFormatSymbols();
    unusualSymbols.setDecimalSeparator('.');
    unusualSymbols.setGroupingSeparator(',');
    formatoMoneda = new DecimalFormat("###.##", unusualSymbols);
  }

  public double roundTwoDecimals(double number) {
    return Double.valueOf(formatoMoneda.format(number));
  }
  public String timerFormatter(String timeSUM) {
    while (timeSUM.length() <= 3)
      timeSUM = "0" + timeSUM;
    return timeSUM;
  }
  public String formatoMoneda(String number) {
    String formatedNumber = "0";
    if (isNumeric(number)) formatedNumber = formatoMoneda.format(Double.parseDouble(number));
    return formatedNumber;
  }
  private static boolean isNumeric(String cadena) {
    try {
      Double.parseDouble(cadena.replace(".", ""));
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }
  
  public static String pintaLogCadenasLargas(String dato){
    if(dato != null && dato.length() > 0){
     if(dato.length() > 15)
       return dato.substring(0,10);
    return dato;
    }
    return "";

  }
  
  public static boolean validaContainsArreglo(String cadenaParsear, String busqueda){
    boolean respuesta = false;
    
    if(cadenaParsear != null && !cadenaParsear.trim().equals("")){
      String[] datos = cadenaParsear.split(",");
      if(datos.length > 0){
        for (String perfil : datos) {
          if(perfil != null){
            if(perfil.trim().equals(busqueda))
                return true;
          }
        }
      }
      else{
        if(cadenaParsear.equals(busqueda))
          return true;
      }
    }
    return respuesta;
  }
  
  public static String limpiaException(String cadena){
    String resultado = "";
    if(cadena != null && !cadena.trim().equals("")){
      Pattern pattern = Pattern.compile("(.+?)\n");
      Matcher match = pattern.matcher(cadena);
      if(match.find()){
        if(match.group(1) != null)
          resultado = match.group(1);
      }
    }
    if(!resultado.equals(""))
      resultado = cadena;
    return resultado;
  }
  
}

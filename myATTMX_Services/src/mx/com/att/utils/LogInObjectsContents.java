package mx.com.att.utils;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;


public class LogInObjectsContents {

  private static final Logger LOGGER = Logger.getLogger(LogInObjectsContents.class);
  private String objetoArray = "List";
  private String objetoEnum = "Enum";
  private String objetoSystem = "System";
  private String objetoJavaLang = "java.lang";
  private String stringFormatHeader = "     %s %s :";
  private String stringFormat = "     %s %s : %s";
  private String objectDate = "Date";
  private String objetoJavaMath = "java.math";

  @SuppressWarnings("unchecked")
  public void logObject(Object object, String parentProperty){
    try
    {
    	LOGGER.info("----------------------------------------------------------------------------");
      if(object != null)
      { 
        if(object.getClass().toString().contains(objetoArray)){
          //logger = LoggerFactory.getLogger(object.getClass());
          //            System.out.println(String.format(stringFormatHeader, object.getClass().getSimpleName()));
          LOGGER.info(String.format(stringFormatHeader, parentProperty, object.getClass().getSimpleName()));
          List<Object> lista = (List<Object>) object;
          for (Object listObject : lista) {
            trackObject(listObject, objetoArray + listObject.getClass().getSimpleName());
          }
        }
        else          
          trackObject(object, parentProperty);
      }
      else
        LOGGER.info(String.format(stringFormatHeader, "Object NULL"));
    }
    catch (Exception e) {
      LOGGER.info("     E R R O R  : (Exception) " + e.getLocalizedMessage());
    }  
    finally{
    	LOGGER.info("----------------------------------------------------------------------------");
    }
  }

  @SuppressWarnings("unchecked")
  private void trackObject(Object object, String parentProperty){
    LOGGER.info(String.format(stringFormatHeader, parentProperty, object.getClass().getSimpleName()));
    Field[] attributes = object.getClass().getDeclaredFields();
    for(Field att : attributes){
      att.setAccessible(true);
      try {
        String nameClass = att.getType().getName();
        if(att.get(object) != null && !nameClass.contains(objetoSystem) && !nameClass.contains(objetoJavaLang)
        	&& !nameClass.contains(objectDate)
        	&& !nameClass.contains(objetoJavaMath)
            && att.getType().getGenericSuperclass() != null
            && !att.getType().getGenericSuperclass().toString().contains(objetoEnum)) {
        	//Valida si el objeto es Array
        	if(att.get(object).getClass().isArray()){
        		Object[] array = (Object[]) att.get(object);         		        		
                if(array != null) {
                  for (Object listObject : array) {
                    trackObject(listObject, parentProperty + " " + objetoArray + listObject.getClass().getSimpleName());
                  }
                }else
                  LOGGER.info(String.format(stringFormat, objetoArray, att.getName(), att.get(object)));
        	}
        	else{
        		trackObject(att.get(object), parentProperty + " " + att.getType().getSimpleName());
        	}
        }
        else if(nameClass.contains(objetoArray)) {
          List<Object> lista = (List<Object>) att.get(object);
          if(lista != null) {
            for (Object listObject : lista) {
              trackObject(listObject, parentProperty + " " + objetoArray + listObject.getClass().getSimpleName());
            }
          }else
            LOGGER.info(String.format(stringFormat, parentProperty + objetoArray, att.getName(), att.get(object)));
        }
        else {
        	if(att.get(object) != null && att.get(object).getClass().isArray()){
        		Object[] array = (Object[]) att.get(object);         		        		
                if(array != null) {
                  for (Object listObject : array) {
                    LOGGER.info(String.format(stringFormat, parentProperty, att.getName() + objetoArray + " " +listObject.getClass().getSimpleName(), listObject));
                  }
                }else
                  LOGGER.info(String.format(stringFormat, parentProperty, att.getName(), att.get(object)));
        	}
        	else{
        		LOGGER.info(String.format(stringFormat, parentProperty, att.getName(), att.get(object)));
        	}
        }
      } catch (IllegalAccessException e) {
        LOGGER.info("\n     E R R O R  : (IllegalAccessException) " + e.getLocalizedMessage());
      }
      catch (Exception e) {
        LOGGER.info("\n     E R R O R  : (Exception) " + e.getLocalizedMessage());
      }
    }
  }
}

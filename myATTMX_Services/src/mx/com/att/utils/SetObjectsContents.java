package mx.com.att.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class SetObjectsContents {

	private static final Logger LOGGER = Logger.getLogger(SetObjectsContents.class);
	private String objetoArray = "List";
	private String objetoEnum = "Enum";
	private String objetoSystem = "System";
	private String objetoJavaLang = "java.lang";
//	private String stringFormatHeader = "     %s :";
//	private String stringFormat = "     %s %s : %s";
	private String objetoJavaMath = "java.math";
	private String objetoBigDecimal = "BigDecimal";	
	private String objetoBigInteger = "BigInteger";
	private String objectDate = "Date";

	private String valueDefaultString = "Valor1";
	private BigInteger valueBigInteger = new BigInteger("54872");
	private BigDecimal valueBigDecimal = new BigDecimal(10.5);
	private int valueInt = 123456;
	private double valueDouble = 254.25;
	private boolean valueBoolean = true;
	private float valueFloat = 19.58f;
	private long valueLong = 957824l;
	private short valueShort = 1200;
	private byte valueByte = 15;
	private Character valueChar = 'C';

	@SuppressWarnings("unchecked")
	public void fillObject(Object object, String parentProperty, boolean crearArrays){
		try
		{
			LOGGER.info("----------------------------------------------------------------------------");
			if(object != null)
			{ 
				if(object.getClass().toString().contains(objetoArray)){
					//logger = LoggerFactory.getLogger(object.getClass());
					//            System.out.println(String.format(stringFormatHeader, object.getClass().getSimpleName()));
					//LOGGER.info(String.format(stringFormatHeader, object.getClass().getSimpleName()));
					List<Object> lista = (List<Object>) object;
					for (Object listObject : lista) {
						trackObject(listObject, objetoArray + listObject.getClass().getSimpleName(), crearArrays);
					}
				}
				else          
					trackObject(object, parentProperty, crearArrays);
			}
			//else
				//LOGGER.info(String.format(stringFormatHeader, "Object NULL"));
		}
		catch (Exception e) {
			LOGGER.info("     E R R O R  : (Exception) " + e.getLocalizedMessage());
		}  
		finally{
			LOGGER.info("----------------------------------------------------------------------------");
		}
	}

	@SuppressWarnings("unchecked")
	private void trackObject(Object object, String parentProperty, boolean crearArrays){
		//LOGGER.info(String.format(stringFormatHeader, object.getClass().getSimpleName()));
		Field[] attributes = object.getClass().getDeclaredFields();
		for(Field att : attributes){
			att.setAccessible(true);
			try {

				String nameClass = att.getType().getName();

				if(!nameClass.contains(objetoSystem) && !nameClass.contains(objetoJavaLang)
						&& !nameClass.contains(objectDate)
						&& !nameClass.contains(objetoJavaMath)						
						&& att.getType().getGenericSuperclass() != null
						&& !att.getType().getGenericSuperclass().toString().contains(objetoEnum)) {

					try{
						if(att.getType().isArray() )
						{	
							if(att.get(object) == null && crearArrays){	
								if(!att.getType().getComponentType().isPrimitive())
								{									
									Class<?> newClass = Class.forName(att.getType().getComponentType().getName());
									//Se valida que el objeto del atributo no sea igual al objeto que lo contiene 
									if(!newClass.getName().equals(object.getClass().getName()) ){
										//Se crea un Array con un solo elemento
										Object array = Array.newInstance(newClass, 1);
										for(int pos = 0; pos < 1; pos++){	
											Object obj = newClass.newInstance();
											Array.set(array, pos, obj);
										}
										Object arrayFinal = (Object[]) array;
										att.set(object,arrayFinal);
									}
								}
							}

							//Se realiza recursividad de los objectos del array
							Object[] arrayIterar = (Object[]) att.get(object);         		        		
							if(arrayIterar != null) {
								for (Object listObject : arrayIterar) {
									trackObject(listObject, objetoArray + listObject.getClass().getSimpleName(), crearArrays);
								}
							}else{								
								//LOGGER.info(String.format(stringFormat, objetoArray, att.getName(), att.get(object)));									
							}
						}	
						else{
							//Se valida que el objeto del atributo no sea igual al objeto que lo contiene 
							if(!nameClass.equals(object.getClass().getName()) ){
								//Se crea instancia del objeto
								Object instance = att.getType().newInstance();
								att.set(object,instance);
							}
							if(att.get(object) != null){
								//Se realiza recursividad del objeto
								trackObject(att.get(object), att.getType().getSimpleName(), crearArrays);
							}else{								
								//LOGGER.info(String.format(stringFormat, "OBJECT", att.getName(), att.get(object)));									
							}
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}				
				}
				else if(nameClass.contains(objetoArray)) {
					// Se crea una Lista con un solo elemento					
					if(att.get(object) == null && crearArrays){
						String claseBase = att.getGenericType().toString();
						claseBase = claseBase.substring(claseBase.indexOf("<")+1, claseBase.indexOf(">"));
						Class<?> newClass = Class.forName(claseBase);
						Object listObject = newClass.newInstance();	
						//Se valida que el objeto del atributo no sea igual al objeto que lo contiene 
						if(!newClass.getName().equals(object.getClass().getName()) ){
							List<Object> myList = new ArrayList<Object>();
							myList.add(listObject);
							att.set(object, myList);
						}
					}

					// Se realiza La recursividad de la lista
					List<Object> lista = (List<Object>) att.get(object);
					if(lista != null) {
						for (Object listObject : lista) {
							trackObject(listObject, objetoArray + listObject.getClass().getSimpleName(), crearArrays);
						}
					}
					//else
						//LOGGER.info(String.format(stringFormat, objetoArray, att.getName(), att.get(object)));
				}
				else {					
					if(nameClass.contains(objetoBigDecimal)){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueBigDecimal);
						}
						else
						att.set(object, valueBigDecimal);
					}
					else if(nameClass.contains(objetoBigInteger)){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueBigInteger);
						}
						else
						att.set(object, valueBigInteger);
					}
					else if(nameClass.contains("Integer") || att.get(object) instanceof Integer){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueInt);
						}
						else
						att.set(object, valueInt);
					}
					else if(nameClass.contains("Boolean") || att.get(object) instanceof Boolean){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueBoolean);
						}
						else
						att.set(object, valueBoolean);
					}
					else if(nameClass.contains("Double") || att.get(object) instanceof Double){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueDouble);
						}
						else
						att.set(object, valueDouble);
					}
					else if(nameClass.contains("Float") || att.get(object) instanceof Float){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueFloat);
						}
						else
						att.set(object, valueFloat);
					}
					else if((nameClass.contains("Long") || att.get(object) instanceof Long) ){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueLong);
						}
						else
						att.set(object, valueLong);
					}
					else if(nameClass.contains("Character") || att.get(object) instanceof Character){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueChar);
						}
						else
						att.set(object, valueChar);
					}
					else if(nameClass.contains("Short") || att.get(object) instanceof Short){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueShort);
						}
						else
						att.set(object, valueShort);
					}
					else if(nameClass.contains("Byte") || att.get(object) instanceof Byte){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueByte);
						}
						else
						att.set(object, valueByte);
					}
					else if(nameClass.contains("String") || att.get(object) instanceof String){
						if(att.getType().isArray() )
						{	
							createPrimitiveArray(att, object, valueDefaultString);
						}
						else
							att.set(object,valueDefaultString);
					}
					else if (nameClass.contains(objectDate)){
						Object instance = att.getType().newInstance();
						att.set(object,instance);
					}
					//LOGGER.info(String.format(stringFormat, parentProperty, att.getName(), att.get(object)));
				}

			} catch (IllegalAccessException e) {
				LOGGER.info("\n     E R R O R  : (IllegalAccessException) " + e.getLocalizedMessage());
			}
			catch (Exception e) {
				LOGGER.info("\n     E R R O R  : (Exception) " + e.getLocalizedMessage());
			}
		}
	}
	
	private void createPrimitiveArray(Field att,Object objectParent , Object value) throws Exception{
		if(att.get(objectParent) == null){	
			int numeroElementos = 2;
			Class<?> newClass = Class.forName(att.getType().getComponentType().getName());			
			//Se crea un Array con un solo elemento
			Object array = Array.newInstance(newClass, numeroElementos);
			for(int pos = 0; pos < numeroElementos; pos++){							
				Array.set(array, pos, value);
			}			
			att.set(objectParent,(Object[]) array);
		}	
	}
}

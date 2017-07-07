package mx.com.att.utils;

import java.util.ArrayList;
import java.util.List;

import mx.com.att.vo.amdocs.PreguntaVo;

public class MasterObjectsContents {

	//genera un numero del 0 al 5
	public static int genNumAleatorio(){
		int respuesta=0;
		int inicio=1;
		int limite=6;
		respuesta= inicio + (int) (Math.random() * ((limite + 1) - inicio));
		return respuesta;
	}
	
	public List<Integer> crearArrayList(List<Integer> lista){
		
		int aleatorio=genNumAleatorio();
		
		if(lista.isEmpty()){
			lista.add(aleatorio);
		}else{
			if(lista.contains(aleatorio)){
				return crearArrayList(lista);
			}else{
				lista.add(aleatorio);
			}			
		}
		return lista;
	}
	
	public static PreguntaVo obtenerPreguntas(int i){
		ArrayList<String> respuesta=new ArrayList<String>();
		PreguntaVo objeto= new PreguntaVo();
		respuesta.add("0");
		respuesta.add("Marcar el numero de radios registrados actualmente a tu cuenta");
		respuesta.add("Indica los seis primeros digitos del RFC registrado en tu cuenta");
		respuesta.add("Marca el codigo postal de tu domicilio de entrega de correspondecia");
		respuesta.add("Marca el codigo postal de tu domicilio fiscal");
		respuesta.add("Escribe el nombre del responsable de la cuenta como esta en la factura");
		respuesta.add("¿Has registrado algun correo electronico an la cuenta?");
		objeto.setTextoPregunta(respuesta.get(i));
		objeto.setPreguntaId(i);
		return objeto;
	}
	
	public List<PreguntaVo> totaldePreguntas(int totalPreguntas, List<PreguntaVo>listaFinal,List<Integer>listaNumeros){
		int i=0;
		totalPreguntas=totalPreguntas+1;
		PreguntaVo objeto= new PreguntaVo();
		
		if(totalPreguntas>=8){
			totalPreguntas=7;
		}		
		for(i=1;i<totalPreguntas;i++){
			crearArrayList(listaNumeros);
		}
		
		for(i=0;i<listaNumeros.size();i++){
			objeto=obtenerPreguntas(listaNumeros.get(i));
			listaFinal.add(objeto);
		}
		return listaFinal;
	}
	
	
}

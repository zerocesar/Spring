package mx.com.att.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import mx.com.att.vo.orange.ClassificationVO;

public final class ATTConstants {

	private static final ResourceBundle RESOURCE = ResourceBundle.getBundle("/ApplicationResourceATT");
	
	private static Map<String, String> PARAMETERS_WP  = new HashMap<String, String>();
	private static Map<String, String> PARAMETERS_FVM  = new HashMap<String, String>();
	
	public static final String ACTIVE_ENCRYPTION = "ACTIVE_ENCRYPTION";
	public static boolean IS_ACTIVE_ENCRYPTION = false;
	
	public static final String ACTIVE_OPERADOR_CONSULTASNUM = "ACTIVE_OPERADOR_CONSULTASNUM";
	public static boolean IS_ACTIVE_OPERADOR_CONSULTASNUM = false;
	
	//Codigos Carrier
	public static final int CARRIER_NEXTEL = Integer.parseInt(RESOURCE.getString("CARRIER_NEXTEL"));
	public static final int CARRIER_IUSACEL = Integer.parseInt(RESOURCE.getString("CARRIER_IUSACEL"));
	public static final String DESC_CARRIER_NEXTEL = RESOURCE.getString("DESC_CARRIER_NEXTEL");
	public static final String DESC_CARRIER_IUSACEL = RESOURCE.getString("DESC_CARRIER_IUSACEL");
	
	//Codigos
	public static final String VERSION_MY_ATT = RESOURCE.getString("VERSION_MY_ATT");
	public static final String VERSION_MY_NEXTEL = RESOURCE.getString("VERSION_MY_NEXTEL");
	public static final String CODIGO_EXITO = RESOURCE.getString("CODIGO_EXITO");
	public static final String CODIGO_EXITO_LOGIN = RESOURCE.getString("CODIGO_EXITO_LOGIN");
	public static final String CODIGO_EXITO_MAIL = RESOURCE.getString("CODIGO_EXITO_MAIL");
	
	public static final String CODIGO_ERROR_REMOTE_EXCEPTION = RESOURCE.getString("CODIGO_ERROR_REMOTE_EXCEPTION");
	public static final String CODIGO_ERROR_NUM_INV = RESOURCE.getString("CODIGO_ERROR_NUM_INV");
	public static final String CODIGO_ERROR_NUM_NO_ENCONT = RESOURCE.getString("CODIGO_ERROR_NUM_NO_ENCONT");
	public static final String CODIGO_ERROR_NO_REGISTRO = RESOURCE.getString("CODIGO_ERROR_NO_REGISTRO");
	public static final String CODIGO_ERROR_VER_INCOR = RESOURCE.getString("CODIGO_ERROR_VER_INCOR");
	public static final String CODIGO_ERROR_LDAP = RESOURCE.getString("CODIGO_ERROR_LDAP");
	public static final String CODIGO_ERROR_MONEDEROS = RESOURCE.getString("CODIGO_ERROR_MONEDEROS");
	public static final String CODIGO_ERROR_MPIN = RESOURCE.getString("CODIGO_ERROR_MPIN");
	public static final String CODIGO_ERROR_NAVIGATION_LOG = RESOURCE.getString("CODIGO_ERROR_NAVIGATION_LOG");
	public static final String CODIGO_ERROR_TOOLS = RESOURCE.getString("CODIGO_ERROR_TOOLS");
	public static final String CODIGO_ERROR_RECHARGE = RESOURCE.getString("CODIGO_ERROR_RECHARGE");
	public static final String CODIGO_ERROR_BILLING_BALANCE = RESOURCE.getString("CODIGO_ERROR_BILLING_BALANCE");
	public static final String CODIGO_ERROR_PAYMENT = RESOURCE.getString("CODIGO_ERROR_PAYMENT");
	public static final String CODIGO_ERROR_COMMCONFIG = RESOURCE.getString("CODIGO_ERROR_COMMCONFIG");
	public static final String CODIGO_ERROR_PASS_INC = RESOURCE.getString("CODIGO_ERROR_PASS_INC");
	public static final String CODIGO_PASS_INC = "El usuario ha ingresado contraseña. no valida. ";
	public static final String CODIGO_PASS_INC2 = " El usuario alcanzó el 4° intento attempt: usuario|0@4";
	public static final String CODIGO_PASS_TEMP = " Debe de cambiar la contraseña";
	public static final String CODIGO_ERROR_PAPERLESS = RESOURCE.getString("CODIGO_ERROR_PAPERLESS");
	public static final String CODIGO_ERROR_NUM_FREC = RESOURCE.getString("CODIGO_ERROR_NUM_FREC");
	public static final String CODIGO_ERROR_WEB_PORTAL = RESOURCE.getString("CODIGO_ERROR_WEB_PORTAL");
	public static final String CODIGO_ERROR_PASS_TEMP = RESOURCE.getString("CODIGO_ERROR_PASS_TEMP");
	public static final String CODIGO_ERROR_CLIENTE_NO_PERMITIDO = RESOURCE.getString("CODIGO_ERROR_CLIENTE_NO_PERMITIDO");
	public static final String CODIGO_ERROR_MAIL = RESOURCE.getString("CODIGO_ERROR_MAIL");
	public static final String CODIGO_ERROR_PACKAGES_LOG = RESOURCE.getString("CODIGO_ERROR_PACKAGES_LOG");
	public static final String CODIGO_ERROR_CUSTOMERS = RESOURCE.getString("CODIGO_ERROR_CUSTOMERS");
	public static final String CODIGO_ERROR_CSQ_REGISTER = RESOURCE.getString("CODIGO_ERROR_CSQ_REGISTER");
	
	public static final String CODIGO_ERROR_PARAM_ENTRADA = RESOURCE.getString("CODIGO_ERROR_PARAM_ENTRADA");
	public static final String CODIGO_SISTEMA_NO_DISPONIBLE = RESOURCE.getString("CODIGO_SISTEMA_NO_DISPONIBLE");
	public static final String CODIGO_ERROR_SIN_INFORMACION = RESOURCE.getString("CODIGO_ERROR_SIN_INFORMACION");
	public static final String CODIGO_ERROR_NO_MAX_NUM_FREC = RESOURCE.getString("CODIGO_ERROR_NO_MAX_NUM_FREC");
	public static final String CODIGO_ERROR_GET_SALDO_CUENTA = RESOURCE.getString("CODIGO_ERROR_GET_SALDO_CUENTA");

	//Descripción de codigos
	public static final String DESC_EXITO = RESOURCE.getString("DESC_EXITO");
	
	public static final String DESC_ERROR_NUM_INV = RESOURCE.getString("DESC_ERROR_NUM_INV");
	public static final String DESC_ERROR_NUM_NO_ENCONT = RESOURCE.getString("DESC_ERROR_NUM_NO_ENCONT");
	public static final String DESC_ERROR_NO_REGISTRO = RESOURCE.getString("DESC_ERROR_NO_REGISTRO");
	public static final String DESC_ERROR_VER_INCOR = RESOURCE.getString("DESC_ERROR_VER_INCOR");
	public static final String DESC_SISTEMA_NO_DISPONIBLE = RESOURCE.getString("DESC_SISTEMA_NO_DISPONIBLE");
	public static final String DESC_PASSWORD_INCORRECT = RESOURCE.getString("DESC_PASSWORD_INCORRECT");
	public static final String DESC_CODIGO_ERROR_CLIENTE_NO_PERMITIDO = RESOURCE.getString("DESC_CODIGO_ERROR_CLIENTE_NO_PERMITIDO");
	public static final String DESC_INCORRECT_OPERATION = RESOURCE.getString("DESC_INCORRECT_OPERATION");
	public static final String DESC_ERROR_SIN_INFORMACION = RESOURCE.getString("DESC_ERROR_SIN_INFORMACION");
	public static final String DESC_ERROR_SIN_INFORMACION_ORDEN = RESOURCE.getString("DESC_ERROR_SIN_INFORMACION_ORDEN");
	public static final String DESC_CODIGO_ERROR_MONEDEROS = RESOURCE.getString("DESC_CODIGO_ERROR_MONEDEROS");
	public static final String DESC_CODIGO_ERROR_NO_MAX_NUM_FREC = RESOURCE.getString("DESC_CODIGO_ERROR_NO_MAX_NUM_FREC");
	public static final String DESC_CODIGO_ERROR_PAPERLESS = RESOURCE.getString("DESC_CODIGO_ERROR_PAPERLESS");
	public static final String DESC_CODIGO_ERROR_MPIN = RESOURCE.getString("DESC_CODIGO_ERROR_MPIN");
	public static final String DESC_CODIGO_CSQ_REGISTER = RESOURCE.getString("DESC_CODIGO_CSQ_REGISTER");
	public static final String DESC_ERROR_SERVICIO = RESOURCE.getString("DESC_ERROR_SERVICIO");

	//Constantes LDAP
	public static final String LDAP02 = RESOURCE.getString("LDAP02");
	public static final String LDAP44 = RESOURCE.getString("LDAP44");
	public static final String LDAP50 = RESOURCE.getString("LDAP50");
	
	//Constantes ComparteNextel
	public static final String MAX_PADRES_STR = "SHARE_NXTL_NUM_PARENTS";
	public static final String MAX_HIJOS_STR = "SHARE_NXTL_NUM_CHILDREN";
	public static final String BUCKET = "SHARE_NXTL_BUCKETS";
	public static int MAX_PADRES = 0;
	public static int MAX_HIJOS = 0;
	public static String[] BUCKET_TYPE = null;
	
	//Constantes Canal de Venta
	public static final Long ID_IOS = Long.parseLong(RESOURCE.getString("ID_IOS"));
	public static final Long ID_MVL = Long.parseLong(RESOURCE.getString("ID_MVL"));
	public static final Long ID_WPN = Long.parseLong(RESOURCE.getString("ID_WPN"));
	public static final String ETIQUETA_IOS = RESOURCE.getString("ETIQUETA_IOS");
	public static final String ETIQUETA_MVL = RESOURCE.getString("ETIQUETA_MVL");
	public static final String ETIQUETA_WPN = RESOURCE.getString("ETIQUETA_WPN");
	
	// EXCLUSIONES ROJO-VERDE
	public static String EXCLUSIONES_TMCODE = "LIBERTAD_TM_EXC";
	public static String EXCLUSIONES_PAYMENT = "LIBERTAD_PY_EXC";
	public static String META_CATALOG_TYPE_LIBERTAD = "TMCODE_LIBERTAD";
	public static List<ClassificationVO> EXCLUSIONES_TMCODE_ARR = new ArrayList<ClassificationVO>();
	public static List<ClassificationVO> EXCLUSIONES_PAYMENT_ARR = new ArrayList<ClassificationVO>();
	
	//Constantes HARDCODE
	public static final int VAL_CERO = Integer.parseInt(RESOURCE.getString("VAL_CERO"));
	public static final int ESTATUS_TRANS_WP_EXITO = Integer.parseInt(RESOURCE.getString("ESTATUS_TRANS_WP_EXITO"));
	
	//Constantes TIME OUT
	public static final String STRING_TIME_OUT = "STRING_TIME_OUT";
	public static int TIME_OUT = ATTConstants.VAL_CERO;
	
	//Constantes Contratos Asociados
	public static final String STRING_NUM_MAX_CONTR = "NUM_MAX_CONTR";
	public static int NUM_MAX_CONTR = ATTConstants.VAL_CERO;
	
	//Constantes BD
	public static final String DESC_CODIGO_ERROR_EJECUCION_CONSULTA_DB = RESOURCE.getString("DESC_CODIGO_ERROR_EJECUCION_CONSULTA_DB");
	
	//Constantes URLs
	public static String URL_WS_ECOMMERCE = "URL_WS_ECOMMERCE";
	public static String URL_WS_IUSACEL = "URL_WS_IUSACEL";
	public static String URL_WS_MAP = "URL_WS_MAP";
	public static String URL_WS_POSTPAID = "URL_WS_POSTPAID";
	public static String URL_WS_PAPERLESS = "URL_WS_PAPERLESS";
	public static String URL_WS_ESTADOCUENTA = "URL_WS_ESTADOCUENTA";
	public static String URL_WS_MAIL = "URL_WS_MAIL";
	public static String URL_WS_GPAY = "URL_WS_GPAY";
	public static String URL_WS_PAYMENT_GATEWAY = "URL_WS_PAYMENT_GATEWAY";
	public static String URL_WS_RATE_SHARING = "URL_WS_RATE_SHARING";
	public static String URL_WS_CONSULTASNUM = "URL_WS_CONSULTASNUM";
	
	//Constantes Monederos
	public static final String VALOR_KB = RESOURCE.getString("VALOR_KB");
	public static final String VALOR_MB = RESOURCE.getString("VALOR_MB");
	public static final String VALOR_GB = RESOURCE.getString("VALOR_GB");
	public static final String VALOR_TB = RESOURCE.getString("VALOR_TB");
	public static final int VALOR_CONVERSION_BYTES = Integer.parseInt(RESOURCE.getString("VALOR_CONVERSION_BYTES"));
	
	public static final String ABONO_PESOS = RESOURCE.getString("ABONO_PESOS");
	public static final String ABONO_PESOS_3G = RESOURCE.getString("ABONO_PESOS_3G");
	public static final String ADD_SMS = RESOURCE.getString("ADD_SMS");
	public static final String ADD_WAP_TETH = RESOURCE.getString("ADD_WAP_TETH");
	public static final String ADD_TELCEL = RESOURCE.getString("ADD_TELCEL");
	
	//Constantes IDs Tipo de Contrato
	public static final String POSPAGO = RESOURCE.getString("POSPAGO");
	public static final String HIBRIDO = RESOURCE.getString("HIBRIDO");
	public static final String PREPAGO = RESOURCE.getString("PREPAGO");
	
	//Constantes de Recargas
	public static String MAX_CHARGE_BILL = "MAX_CHARGE_BILL";
	
	// --------------------- CODIGOS GPAY ---------------------------------
	//Codigos
	public static final String COD_EXITO = RESOURCE.getString("CODIGO_EXITO");
	public static final int EXITO_1 = Integer.parseInt(RESOURCE.getString("COD_EXITO_1"));
	public static final int EXITO_200 = Integer.parseInt(RESOURCE.getString("COD_EXITO_200"));
	public static final int EXITO_202 = Integer.parseInt(RESOURCE.getString("COD_EXITO_202"));
	public static final int EXITO_203 = Integer.parseInt(RESOURCE.getString("COD_EXITO_203"));
	public static final int EXITO_204 = Integer.parseInt(RESOURCE.getString("COD_EXITO_204"));
		
	public static final String COD_ERROR = RESOURCE.getString("CODIGO_ERROR");
	public static final int COD_ERR_1 = Integer.parseInt(RESOURCE.getString("COD_ERR_1"));
	public static final int COD_ERR_0 = Integer.parseInt(RESOURCE.getString("COD_ERR_0"));
	public static final int COD_ERR_400 = Integer.parseInt(RESOURCE.getString("COD_ERR_400"));
	public static final int COD_ERR_401 = Integer.parseInt(RESOURCE.getString("COD_ERR_401"));
	public static final int COD_ERR_402 = Integer.parseInt(RESOURCE.getString("COD_ERR_402"));
	public static final int COD_ERR_403 = Integer.parseInt(RESOURCE.getString("COD_ERR_403"));
	public static final int COD_ERR_404 = Integer.parseInt(RESOURCE.getString("COD_ERR_404"));
	public static final int COD_ERR_405 = Integer.parseInt(RESOURCE.getString("COD_ERR_405"));
	public static final int COD_ERR_406 = Integer.parseInt(RESOURCE.getString("COD_ERR_406"));
		
	public static final int COD_ERR_500 = Integer.parseInt(RESOURCE.getString("COD_ERR_500"));
		
	public static final int COD_ERR_601 = Integer.parseInt(RESOURCE.getString("COD_ERR_601"));
	public static final int COD_ERR_602 = Integer.parseInt(RESOURCE.getString("COD_ERR_602"));
	public static final int COD_ERR_603 = Integer.parseInt(RESOURCE.getString("COD_ERR_603"));
	public static final int COD_ERR_604 = Integer.parseInt(RESOURCE.getString("COD_ERR_604"));
	public static final int COD_ERR_605 = Integer.parseInt(RESOURCE.getString("COD_ERR_605"));
	public static final int COD_ERR_606 = Integer.parseInt(RESOURCE.getString("COD_ERR_606"));
	public static final int COD_ERR_607 = Integer.parseInt(RESOURCE.getString("COD_ERR_607"));
		
	//Descripción de codigos
	public static final String DES_EXITO = RESOURCE.getString("DESC_EXITO");
	public static final String DES_EXITO_LOG = RESOURCE.getString("DESC_EXITO_LOG");
	public static final String DES_ERROR_LOG = RESOURCE.getString("DESC_ERROR_LOG");
	public static final String DES_ERROR = RESOURCE.getString("DESC_ERROR_TRANS");
	public static final String DES_ERR_DAT_ENT = RESOURCE.getString("DESC_ERROR_PARAM_ENTRADA");
	public static final String DES_SIS_NO_DISP = RESOURCE.getString("DESC_SISTEMA_NO_DISPONIBLE");
	public static final String DESC_ERROR_REG = RESOURCE.getString("DESC_ERROR_NO_REG");
		
	public static final String DES_EXITO_200 = RESOURCE.getString("DESC_EXITO_200");
	public static final String DES_EXITO_202 = RESOURCE.getString("DESC_EXITO_202");
	public static final String DES_EXITO_203 = RESOURCE.getString("DESC_EXITO_203");
	public static final String DES_EXITO_204 = RESOURCE.getString("DESC_EXITO_204");
		
	public static final String DESC_ERR_400 = RESOURCE.getString("DESC_ERR_400");
	public static final String DESC_ERR_401 = RESOURCE.getString("DESC_ERR_401");
	public static final String DESC_ERR_402 = RESOURCE.getString("DESC_ERR_402");
	public static final String DESC_ERR_403 = RESOURCE.getString("DESC_ERR_403");
	public static final String DESC_ERR_404 = RESOURCE.getString("DESC_ERR_404");
	public static final String DESC_ERR_405 = RESOURCE.getString("DESC_ERR_405");
	public static final String DESC_ERR_406 = RESOURCE.getString("DESC_ERR_406");
		
	public static final String DESC_ERR_500 = RESOURCE.getString("DESC_ERR_500");
		
	public static final String DESC_ERR_601 = RESOURCE.getString("DESC_ERR_601");
	public static final String DESC_ERR_602 = RESOURCE.getString("DESC_ERR_602");
	public static final String DESC_ERR_603 = RESOURCE.getString("DESC_ERR_603");
	public static final String DESC_ERR_604 = RESOURCE.getString("DESC_ERR_604");
	public static final String DESC_ERR_605 = RESOURCE.getString("DESC_ERR_605");
	public static final String DESC_ERR_606 = RESOURCE.getString("DESC_ERR_606");
	public static final String DESC_ERR_607 = RESOURCE.getString("DESC_ERR_607");
		
	//Mensajes
	public static final String VACIO = "";
	public static final String EL_OBJETO = RESOURCE.getString("EL_OBJETO");
	public static final String EL_ATRIBUTO = RESOURCE.getString("EL_ATRIBUTO");
	public static final String VACIO_O_NULO = RESOURCE.getString("VACIO_O_NULO");
	public static final String MENOR_A_UNO = RESOURCE.getString("MENOR_A_UNO");
	public static final String MENOR_A_CERO = RESOURCE.getString("MENOR_A_CERO");
	public static final String CAD_JSON_ENT = RESOURCE.getString("CAD_JSON_ENT");
	public static final String CAD_JSON_SAL = RESOURCE.getString("CAD_JSON_SAL");
		
	public static final String CLIENTETDCVO = "ClienteTDCVO";
	public static final String PAGOTDCVO = "PagoTDCVO";
	public static final String TARJETATDCVO = "TarjetaTDCVO";
		
	public static final String CREDENCIALAPP = "credencialApp";
	public static final String CREDENCIAL = "credencial";
	public static final String PRINCIPALAPP = "principalApp";
	public static final String PRINCIPAL = "principal";
		
	//Cadenas encriptadas
	public static final String MVL = RESOURCE.getString("MVL");
	public static final String IOS = RESOURCE.getString("IOS");
	public static final String WPN = RESOURCE.getString("WPN");
	public static final String ATT = RESOURCE.getString("ATT");
	
	private ATTConstants(){
		
	}
	
	public static Map<String, String> getPARAMETERS_WP() {
		return PARAMETERS_WP;
	}

	public static void setPARAMETERS_WP(final Map<String, String> pARAMETERS_WP) {
		PARAMETERS_WP = pARAMETERS_WP;
	}

	public static Map<String, String> getPARAMETERS_FVM() {
		return PARAMETERS_FVM;
	}

	public static void setPARAMETERS_FVM(final Map<String, String> pARAMETERS_FVM) {
		PARAMETERS_FVM = pARAMETERS_FVM;
	}
}
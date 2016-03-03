package mx.com.att.vo.orange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;



public class DeviceVO
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Long coId;
    protected Integer subScriberRef;
    protected Integer part1;
    protected Integer part2;
    protected String dn;
    protected String userPassword;
    protected String estatusPort;
    protected Integer dnId;
    protected String modEstatusPort;
    protected Integer portId;
    protected String portNum;
    protected String imei;
    protected String sim;
    protected String id;
    protected Long equipoId;
    protected String claveMkt;
    protected String modelo;
    protected String cdSmNum;
    protected Long hlcode;
    protected Long hmCode;
    protected Long spIdE;
    protected Long spIdG;
    protected String serialNo;
    protected Long plcode;
    protected String puk;
    protected String puk2;
    protected String smAuth;
    protected transient XMLGregorianCalendar smModDate;
    protected Long smcId;
    protected String estatusImeiBSCS;
    protected String estatusImeiMIBAS;
    protected String estatusImeiVISION;
    protected String estatusImeiOF;
    protected String estatusSimBSCS;
    protected String estatusSimMIBAS;
    protected String estatusSimVISION;
    protected String estatusSimOF;
    protected Boolean relacion;
    protected String lada;
    protected String codigo;
    protected FleetVO fleetVO;
    protected String inventoryItem;
    protected String subInventoryItem;
    protected Integer cantidad;
    protected Float precio;
    protected String oracleCode;
    protected String iva;
    protected String subInvOracle;
    protected String planTarifario;
    protected String alias;
    protected String idPrivado;
    protected String areaOperacion;
    protected String lote;
    protected String usuarioAsignado;
    protected String descEstImeiBSCS;
    protected String descEstImeiMIBAS;
    protected String descEstImeiVISION;
    protected String descEstImeiOF;
    protected String descEstSimBSCS;
    protected String descEstSimMIBAS;
    protected String descEstSimVISION;
    protected String descEstSimOF;
    protected String color;
    protected Integer subMId;
    protected Boolean esRim;
    protected List<RimVO> rimVO;
    protected String subscriberId;
    protected String ki;
    protected Long idTransaccion;
    protected Long channelId;
    protected Long contractType;
    protected String system;//
    protected Long technology;//
    protected Long tmCode;
    protected String descEquipo;
    protected Integer multServ;
    
    
    public Integer getMultServ() {
		return multServ;
	}

	public void setMultServ(final Integer multServ) {
		this.multServ = multServ;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(final Long channelId) {
		this.channelId = channelId;
	}

	public Long getContractType() {
		return contractType;
	}

	public void setContractType(final Long contractType) {
		this.contractType = contractType;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(final String system) {
		this.system = system;
	}

	public Long getTechnology() {
		return technology;
	}

	public void setTechnology(final Long technology) {
		this.technology = technology;
	}

	public Long getTmCode() {
		return tmCode;
	}

	public void setTmCode(final Long tmCode) {
		this.tmCode = tmCode;
	}
    
    /* Para Ecommerce */
    //mlElement(required = false, nillable = false)
    /**
     * Gets the value of the coId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCoId() {
        return coId;
    }

    /**
     * Sets the value of the coId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCoId(final Long value) {
        this.coId = value;
    }

    /**
     * Gets the value of the subScriberRef property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubScriberRef() {
        return subScriberRef;
    }

    /**
     * Sets the value of the subScriberRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubScriberRef(final  Integer value) {
        this.subScriberRef = value;
    }

    /**
     * Gets the value of the part1 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPart1() {
        return part1;
    }

    /**
     * Sets the value of the part1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPart1(final Integer value) {
        this.part1 = value;
    }

    /**
     * Gets the value of the part2 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPart2() {
        return part2;
    }

    /**
     * Sets the value of the part2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPart2(final Integer value) {
        this.part2 = value;
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

    public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
     * Gets the value of the estatusPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusPort() {
        return estatusPort;
    }

    /**
     * Sets the value of the estatusPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusPort(final String value) {
        this.estatusPort = value;
    }

    /**
     * Gets the value of the dnId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDnId() {
        return dnId;
    }

    /**
     * Sets the value of the dnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDnId(final Integer value) {
        this.dnId = value;
    }

    /**
     * Gets the value of the modEstatusPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModEstatusPort() {
        return modEstatusPort;
    }

    /**
     * Sets the value of the modEstatusPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModEstatusPort(final String value) {
        this.modEstatusPort = value;
    }

    /**
     * Gets the value of the portId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortId() {
        return portId;
    }

    /**
     * Sets the value of the portId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortId(final Integer value) {
        this.portId = value;
    }

    /**
     * Gets the value of the portNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortNum() {
        return portNum;
    }

    /**
     * Sets the value of the portNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortNum(final String value) {
        this.portNum = value;
    }

    /**
     * Gets the value of the imei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImei() {
        return imei;
    }

    /**
     * Sets the value of the imei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImei(final String value) {
        this.imei = value;
    }

    /**
     * Gets the value of the sim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSim() {
        return sim;
    }

    /**
     * Sets the value of the sim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSim(final String value) {
        this.sim = value;
    }

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
     * Gets the value of the equipoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEquipoId() {
        return equipoId;
    }

    /**
     * Sets the value of the equipoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEquipoId(final Long value) {
        this.equipoId = value;
    }

    /**
     * Gets the value of the claveMkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveMkt() {
        return claveMkt;
    }

    /**
     * Sets the value of the claveMkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveMkt(final String value) {
        this.claveMkt = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelo(final String value) {
        this.modelo = value;
    }

    /**
     * Gets the value of the cdSmNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdSmNum() {
        return cdSmNum;
    }

    /**
     * Sets the value of the cdSmNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdSmNum(final String value) {
        this.cdSmNum = value;
    }

    /**
     * Gets the value of the hlcode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHlcode() {
        return hlcode;
    }

    /**
     * Sets the value of the hlcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHlcode(final Long value) {
        this.hlcode = value;
    }

    /**
     * Gets the value of the hmCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHmCode() {
        return hmCode;
    }

    /**
     * Sets the value of the hmCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHmCode(final Long value) {
        this.hmCode = value;
    }

    /**
     * Gets the value of the spIdE property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpIdE() {
        return spIdE;
    }

    /**
     * Sets the value of the spIdE property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpIdE(final Long value) {
        this.spIdE = value;
    }

    /**
     * Gets the value of the spIdG property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpIdG() {
        return spIdG;
    }

    /**
     * Sets the value of the spIdG property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpIdG(final Long value) {
        this.spIdG = value;
    }

    /**
     * Gets the value of the serialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Sets the value of the serialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(final String value) {
        this.serialNo = value;
    }

    /**
     * Gets the value of the plcode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPlcode() {
        return plcode;
    }

    /**
     * Sets the value of the plcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPlcode(final Long value) {
        this.plcode = value;
    }

    /**
     * Gets the value of the puk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuk() {
        return puk;
    }

    /**
     * Sets the value of the puk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuk(final String value) {
        this.puk = value;
    }

    /**
     * Gets the value of the puk2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuk2() {
        return puk2;
    }

    /**
     * Sets the value of the puk2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuk2(final String value) {
        this.puk2 = value;
    }

    /**
     * Gets the value of the smAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmAuth() {
        return smAuth;
    }

    /**
     * Sets the value of the smAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmAuth(final String value) {
        this.smAuth = value;
    }

    /**
     * Gets the value of the smModDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSmModDate() {
        return smModDate;
    }

    /**
     * Sets the value of the smModDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSmModDate(final XMLGregorianCalendar value) {
        this.smModDate = value;
    }

    /**
     * Gets the value of the smcId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSmcId() {
        return smcId;
    }

    /**
     * Sets the value of the smcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSmcId(final Long value) {
        this.smcId = value;
    }

    /**
     * Gets the value of the estatusImeiBSCS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusImeiBSCS() {
        return estatusImeiBSCS;
    }

    /**
     * Sets the value of the estatusImeiBSCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusImeiBSCS(final String value) {
        this.estatusImeiBSCS = value;
    }

    /**
     * Gets the value of the estatusImeiMIBAS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusImeiMIBAS() {
        return estatusImeiMIBAS;
    }

    /**
     * Sets the value of the estatusImeiMIBAS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusImeiMIBAS(final String value) {
        this.estatusImeiMIBAS = value;
    }

    /**
     * Gets the value of the estatusImeiVISION property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusImeiVISION() {
        return estatusImeiVISION;
    }

    /**
     * Sets the value of the estatusImeiVISION property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusImeiVISION(final String value) {
        this.estatusImeiVISION = value;
    }

    /**
     * Gets the value of the estatusImeiOF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusImeiOF() {
        return estatusImeiOF;
    }

    /**
     * Sets the value of the estatusImeiOF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusImeiOF(final String value) {
        this.estatusImeiOF = value;
    }

    /**
     * Gets the value of the estatusSimBSCS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusSimBSCS() {
        return estatusSimBSCS;
    }

    /**
     * Sets the value of the estatusSimBSCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusSimBSCS(final String value) {
        this.estatusSimBSCS = value;
    }

    /**
     * Gets the value of the estatusSimMIBAS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusSimMIBAS() {
        return estatusSimMIBAS;
    }

    /**
     * Sets the value of the estatusSimMIBAS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusSimMIBAS(final String value) {
        this.estatusSimMIBAS = value;
    }

    /**
     * Gets the value of the estatusSimVISION property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusSimVISION() {
        return estatusSimVISION;
    }

    /**
     * Sets the value of the estatusSimVISION property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusSimVISION(final String value) {
        this.estatusSimVISION = value;
    }

    /**
     * Gets the value of the estatusSimOF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstatusSimOF() {
        return estatusSimOF;
    }

    /**
     * Sets the value of the estatusSimOF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstatusSimOF(final String value) {
        this.estatusSimOF = value;
    }

    /**
     * Gets the value of the relacion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRelacion() {
        return relacion;
    }

    /**
     * Sets the value of the relacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRelacion(final Boolean value) {
        this.relacion = value;
    }

    /**
     * Gets the value of the lada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLada() {
        return lada;
    }

    /**
     * Sets the value of the lada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLada(final String value) {
        this.lada = value;
    }

    /**
     * Gets the value of the codigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(final String value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the fleetVO property.
     * 
     * @return
     *     possible object is
     *     {@link FleetVO }
     *     
     */
    public FleetVO getFleetVO() {
        return fleetVO;
    }

    /**
     * Sets the value of the fleetVO property.
     * 
     * @param value
     *     allowed object is
     *     {@link FleetVO }
     *     
     */
    public void setFleetVO(final FleetVO value) {
        this.fleetVO = value;
    }

    /**
     * Gets the value of the inventoryItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryItem() {
        return inventoryItem;
    }

    /**
     * Sets the value of the inventoryItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryItem(final String value) {
        this.inventoryItem = value;
    }

    /**
     * Gets the value of the subInventoryItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInventoryItem() {
        return subInventoryItem;
    }

    /**
     * Sets the value of the subInventoryItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInventoryItem(final String value) {
        this.subInventoryItem = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidad(final Integer value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the precio property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Sets the value of the precio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrecio(final Float value) {
        this.precio = value;
    }

    /**
     * Gets the value of the oracleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOracleCode() {
        return oracleCode;
    }

    /**
     * Sets the value of the oracleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOracleCode(final String value) {
        this.oracleCode = value;
    }

    /**
     * Gets the value of the iva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVA() {
        return iva;
    }

    /**
     * Sets the value of the iva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVA(final String value) {
        this.iva = value;
    }

    /**
     * Gets the value of the subInvOracle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubInvOracle() {
        return subInvOracle;
    }

    /**
     * Sets the value of the subInvOracle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubInvOracle(final String value) {
        this.subInvOracle = value;
    }

    /**
     * Gets the value of the planTarifario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanTarifario() {
        return planTarifario;
    }

    /**
     * Sets the value of the planTarifario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanTarifario(final String value) {
        this.planTarifario = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(final String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the idPrivado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPrivado() {
        return idPrivado;
    }

    /**
     * Sets the value of the idPrivado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPrivado(final String value) {
        this.idPrivado = value;
    }

    /**
     * Gets the value of the areaOperacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaOperacion() {
        return areaOperacion;
    }

    /**
     * Sets the value of the areaOperacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaOperacion(final String value) {
        this.areaOperacion = value;
    }

    /**
     * Gets the value of the lote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLote() {
        return lote;
    }

    /**
     * Sets the value of the lote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLote(final String value) {
        this.lote = value;
    }

    /**
     * Gets the value of the usuarioAsignado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioAsignado() {
        return usuarioAsignado;
    }

    /**
     * Sets the value of the usuarioAsignado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioAsignado(final String value) {
        this.usuarioAsignado = value;
    }

    /**
     * Gets the value of the descEstImeiBSCS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstImeiBSCS() {
        return descEstImeiBSCS;
    }

    /**
     * Sets the value of the descEstImeiBSCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstImeiBSCS(final String value) {
        this.descEstImeiBSCS = value;
    }

    /**
     * Gets the value of the descEstImeiMIBAS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstImeiMIBAS() {
        return descEstImeiMIBAS;
    }

    /**
     * Sets the value of the descEstImeiMIBAS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstImeiMIBAS(final String value) {
        this.descEstImeiMIBAS = value;
    }

    /**
     * Gets the value of the descEstImeiVISION property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstImeiVISION() {
        return descEstImeiVISION;
    }

    /**
     * Sets the value of the descEstImeiVISION property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstImeiVISION(final String value) {
        this.descEstImeiVISION = value;
    }

    /**
     * Gets the value of the descEstImeiOF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstImeiOF() {
        return descEstImeiOF;
    }

    /**
     * Sets the value of the descEstImeiOF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstImeiOF(final String value) {
        this.descEstImeiOF = value;
    }

    /**
     * Gets the value of the descEstSimBSCS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstSimBSCS() {
        return descEstSimBSCS;
    }

    /**
     * Sets the value of the descEstSimBSCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstSimBSCS(final  String value) {
        this.descEstSimBSCS = value;
    }

    /**
     * Gets the value of the descEstSimMIBAS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstSimMIBAS() {
        return descEstSimMIBAS;
    }

    /**
     * Sets the value of the descEstSimMIBAS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstSimMIBAS(final String value) {
        this.descEstSimMIBAS = value;
    }

    /**
     * Gets the value of the descEstSimVISION property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstSimVISION() {
        return descEstSimVISION;
    }

    /**
     * Sets the value of the descEstSimVISION property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstSimVISION(final String value) {
        this.descEstSimVISION = value;
    }

    /**
     * Gets the value of the descEstSimOF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstSimOF() {
        return descEstSimOF;
    }

    /**
     * Sets the value of the descEstSimOF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstSimOF(final String value) {
        this.descEstSimOF = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(final String value) {
        this.color = value;
    }

    /**
     * Gets the value of the subMId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubMId() {
        return subMId;
    }

    /**
     * Sets the value of the subMId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubMId(final Integer value) {
        this.subMId = value;
    }

    /**
     * Gets the value of the esRim property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEsRim() {
        return esRim;
    }

    /**
     * Sets the value of the esRim property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEsRim(final Boolean value) {
        this.esRim = value;
    }

    /**
     * Gets the value of the rimVO property.
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the
     * rimVO property.
     * For example, to add a new item, do as follows:
     *    getRimVO().add(newItem);
     * Objects of the following type(s) are allowed in the list
     * {@link RimVO }
     */
    public List<RimVO> getRimVO() {
        if (rimVO == null) {
            rimVO = new ArrayList<RimVO>();
        }
        return this.rimVO;
    }

    /**
     * Gets the value of the subscriberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the value of the subscriberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriberId(final String value) {
        this.subscriberId = value;
    }

    /**
     * Gets the value of the ki property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKi() {
        return ki;
    }

    /**
     * Sets the value of the ki property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKi(final String value) {
        this.ki = value;
    }

    /**
     * Gets the value of the idTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Sets the value of the idTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdTransaccion(final Long value) {
        this.idTransaccion = value;
    }

	public String getDescEquipo() {
		return descEquipo;
	}

	public void setDescEquipo(final String descEquipo) {
		this.descEquipo = descEquipo;
	}
    
    
    
}

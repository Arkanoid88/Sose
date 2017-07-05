
package it.univaq.disim.sose.hes.client_patient_device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per MeasurementType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="MeasurementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idPatient" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="measurementInfo" type="{http://it.univaq.disim.sose.hes/measurement}measurementInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementType", propOrder = {
    "idPatient",
    "measurementInfo"
})
public class MeasurementType {

    protected int idPatient;
    @XmlElement(required = true)
    protected MeasurementInfoType measurementInfo;

    /**
     * Recupera il valore della proprietà idPatient.
     * 
     */
    public int getIdPatient() {
        return idPatient;
    }

    /**
     * Imposta il valore della proprietà idPatient.
     * 
     */
    public void setIdPatient(int value) {
        this.idPatient = value;
    }

    /**
     * Recupera il valore della proprietà measurementInfo.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementInfoType }
     *     
     */
    public MeasurementInfoType getMeasurementInfo() {
        return measurementInfo;
    }

    /**
     * Imposta il valore della proprietà measurementInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementInfoType }
     *     
     */
    public void setMeasurementInfo(MeasurementInfoType value) {
        this.measurementInfo = value;
    }

}

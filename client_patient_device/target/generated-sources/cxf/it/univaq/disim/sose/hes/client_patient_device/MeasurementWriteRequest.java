
package it.univaq.disim.sose.hes.client_patient_device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per measurementWriteRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="measurementWriteRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="measurements" type="{http://it.univaq.disim.sose.hes/measurement}MeasurementType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measurementWriteRequest", propOrder = {
    "measurements"
})
public class MeasurementWriteRequest {

    @XmlElement(required = true)
    protected MeasurementType measurements;

    /**
     * Recupera il valore della proprietà measurements.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *     
     */
    public MeasurementType getMeasurements() {
        return measurements;
    }

    /**
     * Imposta il valore della proprietà measurements.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *     
     */
    public void setMeasurements(MeasurementType value) {
        this.measurements = value;
    }

}

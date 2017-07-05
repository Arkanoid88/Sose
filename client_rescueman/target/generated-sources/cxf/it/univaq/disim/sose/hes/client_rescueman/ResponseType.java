
package it.univaq.disim.sose.hes.client_rescueman;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MapsUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="responseInfoType" type="{http://it.univaq.disim.sose.hes/emergency}responseInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseType", propOrder = {
    "mapsUrl",
    "responseInfoType"
})
public class ResponseType {

    @XmlElement(name = "MapsUrl", required = true)
    protected String mapsUrl;
    @XmlElement(required = true)
    protected ResponseInfoType responseInfoType;

    /**
     * Recupera il valore della proprietà mapsUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapsUrl() {
        return mapsUrl;
    }

    /**
     * Imposta il valore della proprietà mapsUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapsUrl(String value) {
        this.mapsUrl = value;
    }

    /**
     * Recupera il valore della proprietà responseInfoType.
     * 
     * @return
     *     possible object is
     *     {@link ResponseInfoType }
     *     
     */
    public ResponseInfoType getResponseInfoType() {
        return responseInfoType;
    }

    /**
     * Imposta il valore della proprietà responseInfoType.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseInfoType }
     *     
     */
    public void setResponseInfoType(ResponseInfoType value) {
        this.responseInfoType = value;
    }

}


package it.univaq.disim.sose.hes.maps;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per mapsResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="mapsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="mapsurl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mapsResponse", propOrder = {

})
public class MapsResponse {

    @XmlElement(required = true)
    protected String mapsurl;

    /**
     * Recupera il valore della proprietà mapsurl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapsurl() {
        return mapsurl;
    }

    /**
     * Imposta il valore della proprietà mapsurl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapsurl(String value) {
        this.mapsurl = value;
    }

}

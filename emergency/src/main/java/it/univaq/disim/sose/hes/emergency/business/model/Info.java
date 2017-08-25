package it.univaq.disim.sose.hes.emergency.business.model;


public class Info {

	//TUTTO QUELLO CHE SI TROVA IN measurement.java
	private static int idPatient;
    private String name;
    private String lastUpdate;
    private String description;
    private String mapsurl;
    
    public static int getIdPatient() {
        return idPatient;
    }
    
    public void setIdPatient(int id) {
        Info.idPatient = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String update) {
        this.lastUpdate = update;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setUrl(String mapsurl) {
        this.mapsurl = mapsurl;
    }
    public String getUrl() {
        return mapsurl;
    }


}

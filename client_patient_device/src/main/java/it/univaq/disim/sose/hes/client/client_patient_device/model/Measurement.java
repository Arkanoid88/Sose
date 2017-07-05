package it.univaq.disim.sose.hes.client.client_patient_device.model;

public class Measurement {
	private int idPatient;
    private String name;
    private String lastUpdate;
    private String description;
    
    public int getIdPatient() {
        return idPatient;
    }
    
    public void setIdPatient(int id) {
        this.idPatient = id;
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
}

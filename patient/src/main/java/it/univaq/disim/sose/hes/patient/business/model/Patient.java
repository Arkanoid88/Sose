package it.univaq.disim.sose.hes.patient.business.model;

import it.univaq.disim.sose.hes.patient.business.model.Address;

public class Patient {
	
    private int id;
    private String name;
    private String description;
    private String pathologies;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathologies() {
        return pathologies;
    }

    public void setPathologies(String pathologies) {
        this.pathologies = pathologies;
    }
    
    public Address getAddress(){
    	return address;
    }
    
    public void setAddress(Address address){
    	this.address = address;
    	}
    }
    

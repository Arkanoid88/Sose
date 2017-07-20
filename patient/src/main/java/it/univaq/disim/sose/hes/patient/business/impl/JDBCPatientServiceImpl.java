package it.univaq.disim.sose.hes.patient.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.hes.patient.business.BusinessException;
import it.univaq.disim.sose.hes.patient.business.PatientService;
import it.univaq.disim.sose.hes.patient.business.model.Address;
import it.univaq.disim.sose.hes.patient.business.model.Patient;



@Service
public class JDBCPatientServiceImpl implements PatientService  {
	
	@Autowired
	private DataSource dataSource; 
	  
	public Patient getPatient(int id) throws BusinessException{
		
		// preparing the query
		String sql = "SELECT * FROM hospital.patients WHERE ID="+id;

		Patient result = new Patient();
		Address result_a = new Address();
		
		// db connection setup
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
	    try {
	    	// db connection and query
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery(sql);

		    while (rs.next()) {
		    	// retrieving the information
		    	  String name = rs.getString("Name");
		          String description = rs.getString("Description");
		          String pathology = rs.getString("Pathology");
		    	  String country = rs.getString("Country");
		          String city = rs.getString("City");
		          String street = rs.getString("Street");	
		          result.setName(name);
		          result.setDescription(description);
		          result.setPathologies(pathology);
		          result_a.setCountry(country);
		          result_a.setCity(city);
		          result_a.setStreet(street);
		          result.setAddress(result_a);
			      
			    }
	        
	    
	    	} catch (SQLException e) {
				e.printStackTrace();
				throw new BusinessException(e);
			} finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
					}
				}

			}
			
			return result;
	  }
}
package it.univaq.disim.sose.hes.measurement.business.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.hes.measurement.MeasurementWriteResponse;
import it.univaq.disim.sose.hes.measurement.business.BusinessException;
import it.univaq.disim.sose.hes.measurement.business.MeasurementService;
import it.univaq.disim.sose.hes.measurement.business.model.Measurement;

@Service
public class JDBCMeasurementServiceImpl implements MeasurementService {
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCMeasurementServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Measurement> getMeasurements(int ID) throws BusinessException {
		// from the DB all the measurements related to a specified patient are retrieved
		// preparing the sql query 
		String sql = "SELECT * FROM measurement.measurement WHERE idPatient="+ID+" ORDER BY lastUpdate DESC";
		LOGGER.info(sql);
		
		List<Measurement> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		// executing the query
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// filling the fields that will be returned
				Measurement measurement = new Measurement();
				measurement.setIdPatient( rs.getInt("idPatient") );
				measurement.setName( rs.getString("name") );
				measurement.setLastUpdate (rs.getString("lastUpdate"));
				measurement.setDescription( rs.getString("description") );
				result.add(measurement);
			}
			
			// query exceptions
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

	@Override
	public MeasurementWriteResponse getResponse(Measurement parameters) throws BusinessException {
		
		// getting the information to be injected in the DB
		MeasurementWriteResponse response = new MeasurementWriteResponse();
		int ID = parameters.getIdPatient();
		String Name = parameters.getName();
		String Desc = parameters.getDescription();
		String Update = parameters.getLastUpdate();
		String sql = "INSERT INTO measurement.measurement "+"VALUES ("+ID+", '"+Name+"', '"+Update+"', "+Desc+") ";
		
		LOGGER.info(sql);
		Connection con = null;
		PreparedStatement st = null;
		int rs;
		// executing the query
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);

			rs = st.executeUpdate(sql);		
		
			// query excpetions
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
		response.setAck(true);
		return response;
	}
}

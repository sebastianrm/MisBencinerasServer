package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Region;

public class RegionDao extends ConnectionDAO{

	private static final String SQL_INSERT = "INSERT INTO regiones (nombre) values (?)";
	
	
	public void insert (Region region){
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

		ps.setString(1, region.getNombre());
		
		ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(ps,conn);
		}
		
	}
	
	
}

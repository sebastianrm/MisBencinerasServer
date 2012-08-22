package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;

public class UserTrx extends ConnectionDAO {

	private String SQL_INSERT = "INSERT INTO trxuser (bencina,empresa,latBencinera,longBencinera,[key],latUser,longUser,fecha_hora_consulta,precio,distancia) VALUES (?,?,?,?,?,?,?,?,?,?)";

	public void insert(Double latitud, Double longitud, String ultanaje,
			String empresa, Double latempresa, Double longempresa,Double precio, Double distancia, String key) {

		Connection conn = null;
		
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(1, ultanaje);
			ps.setString(2, empresa);
			ps.setDouble(3, latempresa);
			ps.setDouble(4, longempresa);

			ps.setString(5, key);
			ps.setDouble(6, latitud);
			ps.setDouble(7, longitud);
			
			ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			
			ps.setDouble(9, precio);
			ps.setDouble(10, distancia);
			
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}

	}

}

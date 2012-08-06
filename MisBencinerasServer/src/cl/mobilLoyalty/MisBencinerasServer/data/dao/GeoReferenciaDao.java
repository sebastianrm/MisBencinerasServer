package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.ServiCentro;

public class GeoReferenciaDao extends ConnectionDAO {

	private static final String SQL_INSERT = "INSERT INTO direcciones_google (fkempresa,fkdireccion,fkregion,dirGooogle) values (?,?,?,?)";

	public void insert(ServiCentro sc) {

		Connection conn =null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(1, sc.getEmpresa());
			ps.setString(2, sc.getDireccion());
			ps.setString(3, sc.getRegion().getNombre());
			Iterator<String> iterator = sc.getGeoRef().getDireccionGoogle()
					.iterator();

			while (iterator.hasNext()) {
				String next = iterator.next();
				ps.setString(4, next);
				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}

	}

}

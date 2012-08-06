package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Bencinas;

public class PreciosDao extends ConnectionDAO {

	private static final String SQL_INSERT = "INSERT INTO precios (precio,fkbencina,fkempresa,fkdireccion,fkregion,fecha_actualizacion) values (?,?,?,?,?,?)";

	public void insert(Bencinas precios) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setFloat(1, precios.getPrecios());
			ps.setString(2, precios.getDescripcion());
			ps.setString(3, precios.getServiCentro().getEmpresa());
			ps.setString(4, precios.getServiCentro().getDireccion());
			ps.setString(5, precios.getServiCentro().getRegion().getNombre());
			ps.setTimestamp(6, precios.getFechaUlmtimaModificacion());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(ps,conn);
		}

	}

}

package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Locales;
import cl.mobilLoyalty.MisBencinerasServer.logic.SuperLocales;



public class LocalesDao  extends ConnectionDAO {
	private static Logger log = Logger.getLogger(LocalesDao.class);

	private static final String SQL_INSERT = "INSERT INTO [Bencineras].[dbo].[locales] ([nombre],[direccion],[latitud],[longitud],[fk_cadena],[fk_region]) VALUES (?,?,?,?,?,?)";
	private String SQL_EMPRESAS_MAXIMA_DISTANCIA = "select dist.distancia,dist.fk_cadena,dist.direccion,dist.latitud,dist.longitud from ( select 	SQRT(POWER((ABS(latitud)-(ABS(?)))*1852*60,2) + POWER((ABS(longitud)-(ABS(?)))*1852*60,2)) as distancia,fk_cadena,direccion,latitud,longitud from locales ) dist where dist.distancia <= 7000 order by dist.distancia asc";

	public void insert(Locales local) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(1, local.getNombre());
			ps.setString(2, local.getDireccion());
			ps.setDouble(3, local.getLatitud());
			ps.setDouble(4, local.getLongitud());
			ps.setString(5, local.getFk_cadena().getNombre());
			ps.setString(6, local.getFk_region().getNombre());

			ps.execute();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			close(ps,conn);
		}
		
	}

	public HashSet<SuperLocales> selectSuperCercanas(Double lat,
			Double lng) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_EMPRESAS_MAXIMA_DISTANCIA);
			ps.setDouble(1, lat);
			ps.setDouble(2,lng);
			// dist.distancia,dist.fk_cadena,dist.direccion,dist.latitud,dist.longitud
			rs = ps.executeQuery();

			HashSet<SuperLocales> hs = new HashSet<SuperLocales>();
			while (rs.next()) {

				SuperLocales bs = new SuperLocales();

				bs.setDistancia(rs.getLong("distancia"));
				bs.setCadena(rs.getString("fk_cadena"));
				bs.setDireccion(rs.getString("direccion"));
				bs.setLatitud(rs.getDouble("latitud"));
				bs.setLongitud(rs.getDouble("longitud"));
				

				hs.add(bs);

			}
			return hs;

		} catch (SQLException e) {
			
			log.error(e);
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}
}

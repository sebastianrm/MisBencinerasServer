package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.GeoReferencia;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Region;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.ServiCentro;

public class ServiCentroDao extends ConnectionDAO {

	private static final String SQL_INSERT = "INSERT INTO servicentros (empresa,direccion,latitud,longitud,fkregion) values (?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT empresa,direccion,latitud,longitud,fkregion FROM servicentros";
	private static final String SQL_UPDATE = "UPDATE bencineras.servicentros SET latitud = ?, longitud = ? WHERE empresa = ? AND direccion = ? AND fkregion = ?";
	private static final String SQL_SELECT_BY_LAT_LONG = "SELECT empresa,direccion,latitud,longitud,fkregion FROM servicentros where latitud <> ? and longitud <> ?";
	public void insert(ServiCentro sc) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(1, sc.getEmpresa());
			ps.setString(2, sc.getDireccion());

			if (sc.getGeoRef() != null) {
				ps.setFloat(3, sc.getGeoRef().getLatitud());
				ps.setFloat(4, sc.getGeoRef().getLongitud());
			} else {
				ps.setFloat(3, 0);
				ps.setFloat(4, 0);
			}

			ps.setString(5, sc.getRegion().getNombre());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}

	}

	public void update(ServiCentro sc) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_UPDATE);

			if (Float.valueOf(sc.getGeoRef().getLatitud()).isNaN()) {
				ps.setFloat(1,0);
			}else{
				ps.setFloat(1, sc.getGeoRef().getLatitud());
			}
			
			if (Float.valueOf(sc.getGeoRef().getLongitud()).isNaN()) {
				ps.setFloat(2,0);
				
			}else{
				ps.setFloat(2, sc.getGeoRef().getLongitud());
			}
			

			ps.setString(3, sc.getEmpresa());
			ps.setString(4, sc.getDireccion());
			ps.setString(5, sc.getRegion().getNombre());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}

	}

	public ArrayList<ServiCentro> selectAll() {

		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.createStatement();
			rs = ps.executeQuery(SQL_SELECT_ALL);

			ArrayList<ServiCentro> rsArray = new ArrayList<ServiCentro>();
			while (rs.next()) {

				ServiCentro serviCentro = new ServiCentro();
				serviCentro.setEmpresa(rs.getString("empresa"));
				serviCentro.setDireccion(rs.getString("direccion"));

				GeoReferencia geoReferencia = new GeoReferencia();

				geoReferencia.setLatitud(rs.getFloat("latitud"));
				geoReferencia.setLongitud(rs.getFloat("longitud"));

				Region region = new Region();
				region.setNombre(rs.getString("fkregion"));

				serviCentro.setRegion(region);
				serviCentro.setGeoRef(geoReferencia);
				rsArray.add(serviCentro);

			}
			return rsArray;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;

	}

	public ArrayList<ServiCentro> selectLatLogCero() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_SELECT_BY_LAT_LONG);
			ps.setFloat(1, 0);
			ps.setFloat(2, 0);
			
			rs = ps.executeQuery();

			ArrayList<ServiCentro> rsArray = new ArrayList<ServiCentro>();
			while (rs.next()) {

				ServiCentro serviCentro = new ServiCentro();
				serviCentro.setEmpresa(rs.getString("empresa"));
				serviCentro.setDireccion(rs.getString("direccion"));

				GeoReferencia geoReferencia = new GeoReferencia();

				geoReferencia.setLatitud(rs.getFloat("latitud"));
				geoReferencia.setLongitud(rs.getFloat("longitud"));

				Region region = new Region();
				region.setNombre(rs.getString("fkregion"));

				serviCentro.setRegion(region);
				serviCentro.setGeoRef(geoReferencia);
				rsArray.add(serviCentro);

			}
			return rsArray;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;

	}
	
	
	public HashSet<ServiCentro> selectLatLogCeroHash() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_SELECT_BY_LAT_LONG);
			ps.setFloat(1, 0);
			ps.setFloat(2, 0);
			
			rs = ps.executeQuery();

			HashSet<ServiCentro> hs = new HashSet<ServiCentro>();
			while (rs.next()) {

				ServiCentro serviCentro = new ServiCentro();
				serviCentro.setEmpresa(rs.getString("empresa"));
				serviCentro.setDireccion(rs.getString("direccion"));

				GeoReferencia geoReferencia = new GeoReferencia();

				geoReferencia.setLatitud(rs.getFloat("latitud"));
				geoReferencia.setLongitud(rs.getFloat("longitud"));

				Region region = new Region();
				region.setNombre(rs.getString("fkregion"));

				serviCentro.setRegion(region);
				serviCentro.setGeoRef(geoReferencia);
				hs.add(serviCentro);

			}
			return hs;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;

	}
	
}

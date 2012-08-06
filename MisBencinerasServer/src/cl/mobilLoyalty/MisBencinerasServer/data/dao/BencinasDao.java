package cl.mobilLoyalty.MisBencinerasServer.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import cl.mobilLoyalty.MisBencinerasServer.data.ConnectionDAO;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Bencinas;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.GeoReferencia;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Region;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.ServiCentro;

public class BencinasDao extends ConnectionDAO {

	private static final String SQL_INSERT = "INSERT INTO bencinas (nombre) values (?)";
	
	private static final String SQL_CRUZE_PRECIO_SERV =	"SELECT s.empresa,s.direccion,s.latitud,s.longitud,s.fkregion,p.fkbencina,p.precio,p.fecha_actualizacion FROM servicentros s inner join precios p on (p.fkempresa = s.empresa and p.fkdireccion = s.direccion and p.fkregion = s.fkregion)  where s.latitud <> ? and s.longitud <> ?";
	
	public void insert (Bencinas bencinas){
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_INSERT);

		ps.setString(1, bencinas.getDescripcion());
		
		ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(ps,conn);
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public HashSet<Bencinas> selectLatLogCeroHash() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_CRUZE_PRECIO_SERV);
			ps.setFloat(1, 0);
			ps.setFloat(2, 0);
//			s.empresa,s.direccion,s.latitud,s.longitud,s.fkregion,p.fkbencina,p.precio,p.fechaUlmtimaModificacion
			rs = ps.executeQuery();

			HashSet<Bencinas> hs = new HashSet<Bencinas>();
			while (rs.next()) {
				
				Bencinas bs = new Bencinas();

				
				bs.setDescripcion(rs.getString("fkbencina"));
				bs.setFechaUlmtimaModificacion(rs.getTimestamp("fecha_actualizacion"));
				bs.setPrecios(rs.getFloat("precio"));
				
				
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
				
				
				bs.setServiCentro(serviCentro);
				
				
				hs.add(bs);

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

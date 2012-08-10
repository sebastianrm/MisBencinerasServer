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

	private static final String SQL_CRUZE_PRECIO_SERV = "SELECT s.empresa,s.direccion,s.latitud,s.longitud,s.fkregion,p.fkbencina,p.precio,p.fecha_actualizacion FROM servicentros s inner join precios p on (p.fkempresa = s.empresa and p.fkdireccion = s.direccion and p.fkregion = s.fkregion)  where s.latitud <> ? and s.longitud <> ?";

	private String SQL_EMPRESAS_MAXIMA_DISTANCIA = "select `dist`.distancia,`dist`.precio,`dist`.fkbencina,`dist`.fkempresa,`dist`.fkdireccion,`dist`.fkregion,`dist`.fecha_actualizacion,`dist`.fklatitud,`dist`.fklongitud from 	(	select 	SQRT(POW((ABS(fklatitud)-(ABS(?)))*1852*60,2) + POW((ABS(fklongitud)-(ABS(?)))*1852*60,2)) as distancia,`precios`.`precio`,	`precios`.`fkbencina`, `precios`.`fkempresa`, `precios`.`fkdireccion`,	`precios`.`fkregion`,	`precios`.`fecha_actualizacion`,	`precios`.`fklatitud`,	`precios`.`fklongitud` from bencineras.precios ) dist where dist.distancia <= 7000 order by `dist`.precio asc";

	public void insert(Bencinas bencinas) {

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
		} finally {
			close(ps, conn);
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
			// s.empresa,s.direccion,s.latitud,s.longitud,s.fkregion,p.fkbencina,p.precio,p.fechaUlmtimaModificacion
			rs = ps.executeQuery();

			HashSet<Bencinas> hs = new HashSet<Bencinas>();
			while (rs.next()) {

				Bencinas bs = new Bencinas();

				bs.setDescripcion(rs.getString("fkbencina"));
				bs.setFechaUlmtimaModificacion(rs
						.getTimestamp("fecha_actualizacion"));
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

	/**
	 * 
	 * @param lat
	 * @param lng
	 * @return
	 */
	public HashSet<Bencinas> selectServicentrosCercanas(Double lat,
			Double lng) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = super.getConnectionMySql();
			ps = conn.prepareStatement(SQL_EMPRESAS_MAXIMA_DISTANCIA);
			ps.setDouble(1, lat);
			ps.setDouble(2, lng);
			// s.empresa,s.direccion,s.latitud,s.longitud,s.fkregion,p.fkbencina,p.precio,p.fechaUlmtimaModificacion
			rs = ps.executeQuery();

			HashSet<Bencinas> hs = new HashSet<Bencinas>();
			while (rs.next()) {

				Bencinas bs = new Bencinas();

				bs.setDescripcion(rs.getString("fkbencina"));
				bs.setFechaUlmtimaModificacion(rs
						.getTimestamp("fecha_actualizacion"));
				bs.setPrecios(rs.getFloat("precio"));

				ServiCentro serviCentro = new ServiCentro();
				serviCentro.setEmpresa(rs.getString("empresa"));
				serviCentro.setDireccion(rs.getString("direccion"));
				serviCentro.setDistancia(rs.getFloat("distancia"));

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

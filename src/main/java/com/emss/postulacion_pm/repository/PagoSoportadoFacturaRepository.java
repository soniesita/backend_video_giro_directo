package com.emss.postulacion_pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emss.postulacion_pm.entity.PagoSoportadoFactura;

public interface PagoSoportadoFacturaRepository  extends JpaRepository<PagoSoportadoFactura, Long>{

	@Query("select ps from PagoSoportadoFactura ps where upper(ps.razonSocial) like upper(concat('%', ?1, '%')) or nit like upper(concat('%', ?1, '%'))")
	public List<PagoSoportadoFactura> findByRazonSocial(String term);
}

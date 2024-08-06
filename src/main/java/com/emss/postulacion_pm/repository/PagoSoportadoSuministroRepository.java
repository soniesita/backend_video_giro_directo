package com.emss.postulacion_pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emss.postulacion_pm.entity.PagoSoportadoSuministro;

public interface PagoSoportadoSuministroRepository extends JpaRepository<PagoSoportadoSuministro, Long> {
	
	@Query("select ps from PagoSoportadoSuministro ps where upper(ps.razonSocial) like upper(concat('%', ?1, '%')) or nit like upper(concat('%', ?1, '%'))")
	public List<PagoSoportadoSuministro> findByRazonSocial(String term);

}

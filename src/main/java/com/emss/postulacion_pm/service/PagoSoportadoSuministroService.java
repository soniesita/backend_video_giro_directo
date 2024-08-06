package com.emss.postulacion_pm.service;

import java.util.List;
import java.util.Optional;

import com.emss.postulacion_pm.entity.PagoSoportadoSuministro;

public interface PagoSoportadoSuministroService {
	
	public List<PagoSoportadoSuministro> findAll();
	public Optional<PagoSoportadoSuministro> findById(Long id);
	public PagoSoportadoSuministro save(PagoSoportadoSuministro pagoSoportadoSuministro);
	public List<PagoSoportadoSuministro> findByRazonSocial(String term);
}

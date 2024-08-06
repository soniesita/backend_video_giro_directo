package com.emss.postulacion_pm.service;

import java.util.List;
import java.util.Optional;

import com.emss.postulacion_pm.entity.PagoSoportadoFactura;
import com.emss.postulacion_pm.entity.Plantilla;

public interface PagoSoportadoFacturaService {
	
	public List<PagoSoportadoFactura> findAll();
	public List<PagoSoportadoFactura> findByRazonSocial(String term);
	public PagoSoportadoFactura save(PagoSoportadoFactura pagoSoportadoFactura);	
	public void deleteById(Long id);
	public Optional<PagoSoportadoFactura> findById(Long id);

	
}

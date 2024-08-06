package com.emss.postulacion_pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emss.postulacion_pm.entity.PagoSoportadoFactura;
import com.emss.postulacion_pm.entity.Plantilla;
import com.emss.postulacion_pm.repository.PagoSoportadoFacturaRepository;

import jakarta.transaction.Transactional;

@Service
public class PagoSoportadoFacturaServiceImpl implements PagoSoportadoFacturaService {

	@Autowired
	private PagoSoportadoFacturaRepository pagoSoportadoFacturaRepository;
	
	@Override
	public List<PagoSoportadoFactura> findAll() {
		return pagoSoportadoFacturaRepository.findAll() ;
	}

	@Override
	public List<PagoSoportadoFactura> findByRazonSocial(String term) {
		return pagoSoportadoFacturaRepository.findByRazonSocial(term);
	}

	@Override
	public PagoSoportadoFactura save(PagoSoportadoFactura pagoSoportadoFactura) {
		// TODO Auto-generated method stub
		return pagoSoportadoFacturaRepository.save(pagoSoportadoFactura);
	}

	@Override
	public void deleteById(Long id) {
		pagoSoportadoFacturaRepository.deleteById(id);
		
	}

	@Override
	public Optional<PagoSoportadoFactura> findById(Long id) {
		// TODO Auto-generated method stub
		return pagoSoportadoFacturaRepository.findById(id);
	}



}

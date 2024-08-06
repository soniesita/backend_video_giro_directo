package com.emss.postulacion_pm.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emss.postulacion_pm.entity.PagoSoportadoSuministro;
import com.emss.postulacion_pm.repository.PagoSoportadoSuministroRepository;

import jakarta.transaction.Transactional;

@Service
public class PagoSoportadoSuministroServiceImpl implements PagoSoportadoSuministroService {

	@Autowired
	private PagoSoportadoSuministroRepository pagoSoportadoSuministroRepository;
	
	@Override
	public List<PagoSoportadoSuministro> findAll() {
		return pagoSoportadoSuministroRepository.findAll() ;
	}

	@Override
	public Optional<PagoSoportadoSuministro> findById(Long id) {
		return pagoSoportadoSuministroRepository.findById(id);
	}
	
	@Override
	@Transactional
	public PagoSoportadoSuministro save(PagoSoportadoSuministro pagoSoportadoSuministro) {
		BigDecimal minValue = new BigDecimal("1000000");
		
		if (pagoSoportadoSuministro.getValorPagarFactura().compareTo(minValue) < 0 && pagoSoportadoSuministro.getValorPagarFactura().compareTo(BigDecimal.ZERO) != 0) {
	        throw new IllegalArgumentException("El valor a pagar no puede ser inferior a 1'000,000");
	    }
		
		if (pagoSoportadoSuministro.getValorPagarSuministro().compareTo(minValue) < 0 && pagoSoportadoSuministro.getValorPagarSuministro().compareTo(BigDecimal.ZERO) != 0) {
	        throw new IllegalArgumentException("El valor a pagar no puede ser inferior a 1'000,000");
	    }
		
		if (pagoSoportadoSuministro.getValorPagarFactura().compareTo(pagoSoportadoSuministro.getValorPosiblePagoFactura()) > 0) {
	        throw new IllegalArgumentException("El valor a pagar nivel factura no puede ser mayor que el valor probable de pago nivel factura");
	    }
		
		if (pagoSoportadoSuministro.getValorPagarSuministro().compareTo(pagoSoportadoSuministro.getValorPosiblePagoSuministro()) > 0) {
	        throw new IllegalArgumentException("El valor a pagar nivel suministro no puede ser mayor que el valor probable de pago nivel suministro");
	    }
		
		return pagoSoportadoSuministroRepository.save(pagoSoportadoSuministro);
	}
	
	@Override
	public List<PagoSoportadoSuministro> findByRazonSocial(String term) {
		return pagoSoportadoSuministroRepository.findByRazonSocial(term);
	}

	

	

}

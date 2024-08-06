 package com.emss.postulacion_pm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emss.postulacion_pm.entity.PagoSoportadoSuministro;
import com.emss.postulacion_pm.service.PagoSoportadoSuministroService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/pago-soportado-suministro")
public class PagoSoportadoSuministroController {

	@Autowired
	private PagoSoportadoSuministroService pagoSoportadoSuministroService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(pagoSoportadoSuministroService.findAll());
	}
	
	@GetMapping("/search-razon-social/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(pagoSoportadoSuministroService.findByRazonSocial(term));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PagoSoportadoSuministro pagoSoportadoSuministro){
		return  ResponseEntity.status(HttpStatus.CREATED).body(pagoSoportadoSuministroService.save(pagoSoportadoSuministro));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody PagoSoportadoSuministro pagoSoportadoSuministro, @PathVariable(name = "id") Long id){
		
		Optional<PagoSoportadoSuministro> objeto = pagoSoportadoSuministroService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		PagoSoportadoSuministro pssDb = objeto.get();
		pssDb.setNit(pagoSoportadoSuministro.getNit());
		pssDb.setHabilitado(pagoSoportadoSuministro.getHabilitado());
		pssDb.setRazonSocial(pagoSoportadoSuministro.getRazonSocial());
		pssDb.setValorPosiblePagoFactura(pagoSoportadoSuministro.getValorPosiblePagoFactura());
		pssDb.setValorPosiblePagoSuministro(pagoSoportadoSuministro.getValorPosiblePagoSuministro());
		pssDb.setValorPagarFactura(pagoSoportadoSuministro.getValorPagarFactura());
		pssDb.setValorPagarSuministro(pagoSoportadoSuministro.getValorPagarSuministro());
		
		try {
	        return ResponseEntity.status(HttpStatus.CREATED).body(pagoSoportadoSuministroService.save(pssDb));
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}
}

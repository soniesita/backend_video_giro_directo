package com.emss.postulacion_pm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emss.postulacion_pm.entity.PagoSoportadoFactura;
import com.emss.postulacion_pm.service.PagoSoportadoFacturaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/pago-soportado-factura")
public class PagoSoportadoFacturaController {

	@Autowired
	private PagoSoportadoFacturaService pagoSoportadoFacturaService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(pagoSoportadoFacturaService.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PagoSoportadoFactura pagoSoportadoFactura){
		return  ResponseEntity.status(HttpStatus.CREATED).body(pagoSoportadoFacturaService.save(pagoSoportadoFactura));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody PagoSoportadoFactura pagoSoportadoFactura, @PathVariable(name = "id") Long id){
		
		Optional<PagoSoportadoFactura> objeto = pagoSoportadoFacturaService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		PagoSoportadoFactura pagoSoportadoFacturaDb = objeto.get();
		pagoSoportadoFacturaDb.setNit(pagoSoportadoFactura.getNit());
		pagoSoportadoFacturaDb.setRazonSocial(pagoSoportadoFactura.getRazonSocial());
		pagoSoportadoFacturaDb.setValorPosiblePago(pagoSoportadoFactura.getValorPosiblePago());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(pagoSoportadoFacturaService.save(pagoSoportadoFacturaDb));
	}
	
	
	@DeleteMapping(path="/{id}")
    public String delete(@PathVariable("id") Long id){
        pagoSoportadoFacturaService.deleteById(id);
         return "Se elimino el pago con id " + id;
                
    }
	
	@GetMapping("/search-razon-social/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(pagoSoportadoFacturaService.findByRazonSocial(term));
	}
}

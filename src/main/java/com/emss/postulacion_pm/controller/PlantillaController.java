package com.emss.postulacion_pm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emss.postulacion_pm.entity.Plantilla;
import com.emss.postulacion_pm.service.PlantillaService;

@RestController
@RequestMapping(value="/api/v1/plantilla")
public class PlantillaController {
	
	@Autowired
	private PlantillaService plantillaService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(plantillaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
		Optional<Plantilla> plantilla = plantillaService.findById(id);

		if (plantilla.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(plantilla.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Plantilla plantilla){
		return  ResponseEntity.status(HttpStatus.CREATED).body(plantillaService.save(plantilla));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Plantilla plantilla, @PathVariable(name = "id") Long id){
		
		Optional<Plantilla> objeto = plantillaService.findById(id);
		
		if(objeto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Plantilla plantillaDb = objeto.get();
		plantillaDb.setCuentaCobro(plantilla.getCuentaCobro());
		plantillaDb.setNit(plantilla.getNit());
		plantillaDb.setNotas(plantilla.getNotas());
		plantillaDb.setNumeroDocto(plantilla.getNumeroDocto());
		plantillaDb.setNumeroRadicado(plantilla.getNumeroRadicado());
		plantillaDb.setRazonSocial(plantilla.getRazonSocial());
		plantillaDb.setTotalCOP(plantilla.getTotalCOP());
		plantillaDb.setValorPagar(plantilla.getValorPagar());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(plantillaService.save(plantillaDb));
	}
}
package com.emss.postulacion_pm.service;

import java.util.List;
import java.util.Optional;

import com.emss.postulacion_pm.entity.Plantilla;

public interface PlantillaService {
	public List<Plantilla> findAll();
	
	public Optional<Plantilla> findById(Long id);
	
	public Plantilla save(Plantilla plantilla);
	
	public void deleteById(Long id);
}
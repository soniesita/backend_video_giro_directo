package com.emss.postulacion_pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emss.postulacion_pm.entity.Plantilla;
import com.emss.postulacion_pm.repository.PlantillaRepository;

import jakarta.transaction.Transactional;

@Service
public class PlantillaServiceImpl implements PlantillaService {

	@Autowired
	private PlantillaRepository plantillaRepository;
	
	@Override
	public List<Plantilla> findAll() {
		return plantillaRepository.findAll();
	}

	@Override
	public Optional<Plantilla> findById(Long id) {
		return plantillaRepository.findById(id);
	}

	@Override
	@Transactional
	public Plantilla save(Plantilla plantilla) {
		return plantillaRepository.save(plantilla);
	}

	@Override
	public void deleteById(Long id) {
		plantillaRepository.deleteById(id);		
	}
}
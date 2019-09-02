package br.com.danilosales.healthcare.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.danilosales.healthcare.model.HealthcareInstitution;
import br.com.danilosales.healthcare.repository.HealthcareInstitutionRepository;
import br.com.danilosales.healthcare.service.exception.HealthcareInstitutionAlreadyExistException;

@Service
public class HealthcareInstitutionService {

	@Autowired
	private HealthcareInstitutionRepository institutionRepository;
	
	
	@Transactional
	public void save(HealthcareInstitution institution) {
		
		Optional<HealthcareInstitution> institutionExist = institutionRepository.findByCnpj(institution.getCnpj());
		
		if(institutionExist.isPresent()) {
			throw new HealthcareInstitutionAlreadyExistException("Instituion with CNPJ is already exist.");
		}
		
		institutionRepository.save(institution);
	}


	public Optional<HealthcareInstitution> getById(Long id) {
		return institutionRepository.findById(id);
	}
}

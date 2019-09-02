package br.com.danilosales.healthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danilosales.healthcare.model.Exam;
import br.com.danilosales.healthcare.model.HealthcareInstitution;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{

	public Optional<Exam> findByPatientNameAndProcedureNameAndInstitution(
			String patientName, 
			String procedureName,
			HealthcareInstitution institution);
	
}

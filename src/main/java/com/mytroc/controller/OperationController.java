package com.mytroc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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

import com.mytroc.exception.ResourceNotFoundException;
import com.mytroc.model.Operation;
import com.mytroc.repository.OperationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class OperationController {
	@Autowired
	OperationRepository operationRepository;

	@GetMapping(value = "/operations")
	public List<Operation> getAllOperations() {
		System.out.println("Get all operations...");
		List<Operation> operations = new ArrayList<>();
		operationRepository.findAll().forEach(operations::add);
		return operations;
	}

	@GetMapping(value = "/operations/{id}")
	public ResponseEntity<Operation> getOperationById(@PathVariable(value = "id") Long operationId)
			throws ResourceNotFoundException {
		Operation operation = operationRepository.findById(operationId)
				.orElseThrow(() -> new ResourceNotFoundException("Opération non trouvée"));
		return ResponseEntity.ok().body(operation);
	}

	@PostMapping("/operations")
	public Operation createOperation(@Valid @RequestBody Operation operation) {
		return operationRepository.save(operation);
	}

	@DeleteMapping("/operations/{id}")
	public Map<String, Boolean> deleteOperation(@PathVariable(value = "id") Long operationId)
			throws ResourceNotFoundException {
		Operation operation = operationRepository.findById(operationId)
				.orElseThrow(() -> new ResourceNotFoundException("Opération non trouvé id :" + operationId));
		operationRepository.delete(operation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/operations/delete")
	public ResponseEntity<String> deleteAllOperations() {
		System.out.println("Supprimer toutes les opérations...");
		operationRepository.deleteAll();
		return new ResponseEntity<>("Toutes les opératoions ont été supprimées", HttpStatus.OK);
	}

	@PutMapping(value = "/operations/{id}")
	public ResponseEntity<Operation> updateOperation(@PathVariable("id") long id, @RequestBody Operation operation) {
		System.out.println("Mise à jour de l'opération ID = " + id);
		Optional<Operation> operationInfo = operationRepository.findById(id);

		if (operationInfo.isPresent()) {
			Operation o = operationInfo.get();
			o.setCodeUtilEmeteur(operation.getCodeUtilEmeteur());
			o.setCodeUtilRecepteur(operation.getCodeUtilRecepteur());
			o.setDateOperation(operation.getDateOperation());
			o.setTypeOperation(operation.getTypeOperation());
			o.setValeurOperation(operation.getValeurOperation());
			return new ResponseEntity<>(operationRepository.save(o), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

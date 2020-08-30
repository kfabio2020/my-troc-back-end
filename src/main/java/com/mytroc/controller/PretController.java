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
import com.mytroc.model.Pret;
import com.mytroc.repository.PretRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class PretController {

	@Autowired
	PretRepository pretRepository;

	@GetMapping(value = "/prets")
	public List<Pret> getAllPrets() {
		System.out.println("Get all pret...");
		List<Pret> prets = new ArrayList<>();
		pretRepository.findAll().forEach(prets::add);
		return prets;
	}
	
	@GetMapping(value = "/prets/{id}")
	public ResponseEntity<Pret> getPretById(@PathVariable(value = "id") Long pretId)
			throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(pretId)
				.orElseThrow(() -> new ResourceNotFoundException("Prêt non trouvé"));
		return ResponseEntity.ok().body(pret);
	}
	
	@PostMapping("/prets")
	public Pret createPret(@Valid @RequestBody Pret pret) {
		return pretRepository.save(pret);
	}

	@DeleteMapping("/prets/{id}")
	public Map<String, Boolean> deletePret(@PathVariable(value = "id") Long pretId)
			throws ResourceNotFoundException {
		Pret pret = pretRepository.findById(pretId)
				.orElseThrow(() -> new ResourceNotFoundException("Prêt non trouvé id :" + pretId));
		pretRepository.delete(pret);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/prets/delete")
	public ResponseEntity<String> deleteAllPrets() {
		System.out.println("Supprimer tous les prets...");
		pretRepository.deleteAll();
		return new ResponseEntity<>("Tous les prets ont été supprimés", HttpStatus.OK);
	}
	
	@PutMapping(value = "/prets/{id}")
	public ResponseEntity<Pret> updatePret(@PathVariable("id") long id, @RequestBody Pret pret) {
		System.out.println("Mise à jour du pret  ID = " + id);
		Optional<Pret> pretInfo = pretRepository.findById(id);

		if (pretInfo.isPresent()) {
			Pret p = pretInfo.get();
			p.setCodeArticle(pret.getCodeArticle());
			p.setCodeUtilPret(pret.getCodeUtilPret());
			p.setDatePret(pret.getDatePret());
			p.setDateRetour(pret.getDateRetour());
			return new ResponseEntity<>(pretRepository.save(p), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

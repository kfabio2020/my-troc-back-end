package com.mytroc.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.mytroc.model.Utilisateur;
import com.mytroc.repository.UtilisateurRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class UtilisateurController {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@GetMapping(value = "/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		System.out.println("Get all Utilisateurs...");
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurRepository.findAll().forEach(utilisateurs::add);
		return utilisateurs;
	}

	@GetMapping(value = "/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") Long utilisateurId)
			throws ResourceNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé"));
		return ResponseEntity.ok().body(utilisateur);
	}
	
	@GetMapping("/users/5/{login}")
	  public   ResponseEntity<Utilisateur> getUtilisateurByLogin(@PathVariable String login) 
		  throws ResourceNotFoundException {
		  Utilisateur utilisateur = utilisateurRepository.findByLogin(login)
				  .orElseThrow(() -> new ResourceNotFoundException("Usernot found for this id : "));
		   return ResponseEntity.ok().body(utilisateur);
	  } 

	@PostMapping("/utilisateurs")
	public Utilisateur createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
		utilisateur.setDateCreation(new Date());
		return utilisateurRepository.save(utilisateur);
	}

	@DeleteMapping("/utilisateurs/{id}")
	public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId)
			throws ResourceNotFoundException {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé id :" + utilisateurId));
		utilisateurRepository.delete(utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/utilisateurs/delete")
	public ResponseEntity<String> deleteAllUtilisateurs() {
		System.out.println("Supprimer tous les Utilisateurs...");
		utilisateurRepository.deleteAll();
		return new ResponseEntity<>("Tous les utilisateurs ont été supprimés", HttpStatus.OK);
	}

	@PutMapping(value = "/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") long id,
			@RequestBody Utilisateur utilisateur) {
		System.out.println("Mise à jour de l'article ID = " + id);
		Optional<Utilisateur> utilisateurInfo = utilisateurRepository.findById(id);

		if (utilisateurInfo.isPresent()) {
			Utilisateur u = utilisateurInfo.get();
			u.setCodeUtil(utilisateur.getCodeUtil());
			u.setNomUtil(utilisateur.getNomUtil());
			u.setPrenomUtil(utilisateur.getPrenomUtil());
			u.setLogin(utilisateur.getLogin());
			u.setMotPass(utilisateur.getMotPass());
			u.setTelephone(utilisateur.getTelephone());
			u.setSoldePoint(utilisateur.getSoldePoint());
			u.setEtatCompte(utilisateur.getEtatCompte());
			u.setEmail(utilisateur.getEmail());
			u.setDateCreation(utilisateur.getDateCreation());
			u.setAdresse(utilisateur.getAdresse());
			return new ResponseEntity<>(utilisateurRepository.save(u), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

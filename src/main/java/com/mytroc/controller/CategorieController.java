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
import com.mytroc.model.CategorieArticle;
import com.mytroc.repository.CategorieRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class CategorieController {
	@Autowired
	CategorieRepository categoriesRepository;
	
	@GetMapping(value = "/categories")
	public List<CategorieArticle> getAllCategorieArticles() {
		System.out.println("Get all categorie article...");
		List<CategorieArticle> categorieArticles = new ArrayList<>();
		categoriesRepository.findAll().forEach(categorieArticles::add);
		return categorieArticles;
	}
	@GetMapping(value = "/categories/{id}")
	public ResponseEntity<CategorieArticle> getCategorieArticleById(@PathVariable(value = "id") Long categorieId)
			throws ResourceNotFoundException {
		CategorieArticle categorieArticle = categoriesRepository.findById(categorieId)
				.orElseThrow(() -> new ResourceNotFoundException("Catégorie non trouvée"));
		return ResponseEntity.ok().body(categorieArticle);
	}
	
	@PostMapping("/categories")
	public CategorieArticle createCategorieArticle(@Valid @RequestBody CategorieArticle categorieArticle) {
		return categoriesRepository.save(categorieArticle);
	}
	
	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategorieArticle(@PathVariable(value = "id") Long categorieArticleId)
			throws ResourceNotFoundException {
		CategorieArticle categorieArticle = categoriesRepository.findById(categorieArticleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article non trouvé id :" + categorieArticleId));
		categoriesRepository.delete(categorieArticle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/categories/delete")
	public ResponseEntity<String> deleteAllCategorieArticle() {
		System.out.println("Supprimer toutes les catégories articles...");
		categoriesRepository.deleteAll();
		return new ResponseEntity<>("Toutes les catégories articles ont été supprimés", HttpStatus.OK);
	}
	
	@PutMapping(value = "/categories/{id}")
	public ResponseEntity<CategorieArticle> updateArticle(@PathVariable("id") long id, @RequestBody CategorieArticle categorieArticle) {
		System.out.println("Mise à jour de l'article ID = " + id);
		Optional<CategorieArticle> cateArticleInfo = categoriesRepository.findById(id);

		if (cateArticleInfo.isPresent()) {
			CategorieArticle cat = cateArticleInfo.get();
			cat.setCodeCategorie(categorieArticle.getCodeCategorie());
			cat.setLibelleCategorie(categorieArticle.getLibelleCategorie());
			return new ResponseEntity<>(categoriesRepository.save(cat), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

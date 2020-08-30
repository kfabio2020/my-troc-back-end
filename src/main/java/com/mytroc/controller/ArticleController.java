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
import com.mytroc.model.Article;
import com.mytroc.repository.ArticleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@GetMapping(value = "/articles")
	public List<Article> getAllArticles() {
		System.out.println("Get all article...");
		List<Article> articles = new ArrayList<>();
		articleRepository.findAll().forEach(articles::add);
		return articles;
	}

	@GetMapping(value = "/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long articleId)
			throws ResourceNotFoundException {
		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article non trouvé"));
		return ResponseEntity.ok().body(article);
	}

	@PostMapping("/articles")
	public Article createArticle(@Valid @RequestBody Article article) {
		return articleRepository.save(article);
	}

	@DeleteMapping("/articles/{id}")
	public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long articleId)
			throws ResourceNotFoundException {
		Article article = articleRepository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article non trouvé id :" + articleId));
		articleRepository.delete(article);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/articles/delete")
	public ResponseEntity<String> deleteAllArticles() {
		System.out.println("Supprimer tous les articles...");
		articleRepository.deleteAll();
		return new ResponseEntity<>("Tous les articles ont été supprimés", HttpStatus.OK);
	}

	@PutMapping(value = "/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) {
		System.out.println("Mise à jour de l'article ID = " + id);
		Optional<Article> articleInfo = articleRepository.findById(id);

		if (articleInfo.isPresent()) {
			Article a = articleInfo.get();
			a.setCodeArticle(article.getCodeArticle());
			a.setLibelleArticle(article.getLibelleArticle());
			a.setCodeCategorie(article.getCodeCategorie());
			a.setCodeUtil(article.getCodeUtil());
			a.setPointArticle(article.getPointArticle());
			a.setPhoto(article.getPhoto());
			a.setDateCreation(article.getDateCreation());
			a.setEtatArticle(article.getEtatArticle());
			return new ResponseEntity<>(articleRepository.save(a), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

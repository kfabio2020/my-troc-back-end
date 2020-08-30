package com.mytroc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytroc.model.CategorieArticle;

@Repository
public interface CategorieRepository extends JpaRepository<CategorieArticle, Long> {

}

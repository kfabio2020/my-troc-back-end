package com.mytroc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytroc.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}

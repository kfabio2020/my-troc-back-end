package com.mytroc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytroc.model.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Long> {

}
package com.mytroc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytroc.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}

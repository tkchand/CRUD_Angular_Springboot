package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.api.entity.Employees;

@Repository
public interface BaseRepository extends JpaRepository<Employees, Long>, EmpTransactionMgmtRepository {

}

package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
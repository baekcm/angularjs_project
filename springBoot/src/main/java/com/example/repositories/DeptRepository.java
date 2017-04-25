package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

}
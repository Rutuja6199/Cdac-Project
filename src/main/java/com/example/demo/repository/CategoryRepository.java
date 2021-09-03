package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}

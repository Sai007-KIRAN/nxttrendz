package com.example.nxttrendz1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.nxttrendz1.model.Review;

// Write your code here

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Integer> {

}
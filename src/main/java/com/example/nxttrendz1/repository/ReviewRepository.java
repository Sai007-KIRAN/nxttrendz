package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {
    ArrayList<Review> allReview();

    Review each(int reviewId);

    Review addReview(Review view);

    Review updateReview(int reviewId, Review view);

    void deleteReview(int reviewId);

    Product getProductReview(int reviewId);
}
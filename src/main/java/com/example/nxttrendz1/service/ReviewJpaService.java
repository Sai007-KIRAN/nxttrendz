package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.repository.ReviewRepository;

// Write your code here
@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository rjr;

    @Autowired
    private ProductJpaRepository pjr;

    @Override
    public ArrayList<Review> allReview() {
        List<Review> reviewList = rjr.findAll();
        ArrayList<Review> reviews = new ArrayList<>(reviewList);
        return reviews;
    }

    @Override
    public Review each(int reviewId) {
        try {
            Review review = rjr.findById(reviewId).get();
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review addReview(Review view) {
        Product reviewProduct = view.getProduct();
        int pId = reviewProduct.getProductId();
        try {
            Product complete = pjr.findById(pId).get();
            view.setProduct(complete);
            rjr.save(view);
            return view;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Review updateReview(int reviewId, Review view) {
        try {
            Review newReview = rjr.findById(reviewId).get();
            if (view.getReviewContent() != null) {
                newReview.setReviewContent(view.getReviewContent());
            }
            if (view.getRating() >= 0) {
                newReview.setRating(view.getRating());
            }
            if (view.getProduct() != null) {
                Product reviewProduct = view.getProduct();
                int pId = reviewProduct.getProductId();
                Product complete = pjr.findById(pId).get();
                view.setProduct(complete);
            }
            rjr.save(view);
            return newReview;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        try {
            rjr.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Product getProductReview(int reviewId) {
        try {
            Review view = rjr.findById(reviewId).get();
            return view.getProduct();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
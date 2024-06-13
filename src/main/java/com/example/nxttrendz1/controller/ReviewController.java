
package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.service.ReviewJpaService;
// Write your code here

@RestController
public class ReviewController {

    @Autowired
    private ReviewJpaService RJS;

    @GetMapping("/products/reviews")
    public ArrayList<Review> allReview() {
        return RJS.allReview();
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review each(@PathVariable("reviewId") int reviewId) {
        return RJS.each(reviewId);
    }

    @PostMapping("/products/reviews")
    public Review addReview(@RequestBody Review view) {
        return RJS.addReview(view);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review view) {
        return RJS.updateReview(reviewId, view);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId) {
        RJS.deleteReview(reviewId);
    }

    @GetMapping("/reviews/{reviewId}/product")
    public Product getProductReview(@PathVariable("reviewId") int reviewId) {
        return RJS.getProductReview(reviewId);
    }
}

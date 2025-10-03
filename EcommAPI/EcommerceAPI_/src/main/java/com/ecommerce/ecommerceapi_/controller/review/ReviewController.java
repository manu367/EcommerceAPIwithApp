package com.ecommerce.ecommerceapi_.controller.review;

import com.ecommerce.ecommerceapi_.constants.ApiEndpoints;
import com.ecommerce.ecommerceapi_.mapper.request.ReviewRequest;
import com.ecommerce.ecommerceapi_.mapper.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiEndpoints.REVIEWS)
@RequiredArgsConstructor
public class ReviewController {

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> getAllReviews() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(new ReviewResponse());
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest request) {
        //ReviewResponse response = reviewService.addReview(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ReviewResponse());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable Long id,
                                                       @RequestBody ReviewRequest request) {
        return ResponseEntity.ok(new ReviewResponse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
       // reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}

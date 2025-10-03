package com.ecommerce.ecommerceapi_.controller.product;

import com.ecommerce.ecommerceapi_.constants.ApiEndpoints;
import com.ecommerce.ecommerceapi_.mapper.request.ProductRequest;
import com.ecommerce.ecommerceapi_.mapper.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiEndpoints.PRODUCTS)
@RequiredArgsConstructor
public class ProductController {


    @GetMapping
    public ResponseEntity<List<ProductResponse>> products() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }


    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
//        ProductResponse response = productService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductResponse());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody ProductRequest request) {
        return ResponseEntity.ok(new ProductResponse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
       // productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

package com.ecommerce.ecommerceapi_.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {
    private String status;   // e.g. "SENT", "FAILED"
    private String message;
}

package com.ecommerce.ecommerceapi_.controller.email;

import com.ecommerce.ecommerceapi_.constants.ApiEndpoints;
import com.ecommerce.ecommerceapi_.mapper.request.EmailRequest;
import com.ecommerce.ecommerceapi_.mapper.response.EmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(ApiEndpoints.EMAIL)
@RequiredArgsConstructor
public class EmailController {
    @PostMapping("/send")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest request) {
        //EmailResponse response = emailService.sendEmail(request);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/send/attachment")
    public ResponseEntity<EmailResponse> sendEmailWithAttachment(
            @RequestPart("request") EmailRequest request,
            @RequestPart("file") MultipartFile file) {

       // EmailResponse response = emailService.sendEmailWithAttachment(request, file);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}

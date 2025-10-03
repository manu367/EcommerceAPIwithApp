package com.ecommerce.ecommerceapi_.controller.bot;

import com.ecommerce.ecommerceapi_.constants.ApiEndpoints;
import com.ecommerce.ecommerceapi_.mapper.request.BotRequest;
import com.ecommerce.ecommerceapi_.mapper.response.BotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndpoints.BOT)
@RequiredArgsConstructor
public class BotController {
    @PostMapping("/message")
    public ResponseEntity<BotResponse> sendMessage(@RequestBody BotRequest request) {
        //BotResponse response = botService.processUserMessage(request);
        return ResponseEntity.status(HttpStatus.OK).body(new BotResponse());
    }
}

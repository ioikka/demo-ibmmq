package com.example.demoibmmq.controller;

import com.example.demoibmmq.publisher.JmsPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jms/publisher")
public class JmsPublisherController {
    private final JmsPublisherService jmsPublisherService;

    @GetMapping("/{message}")
    public ResponseEntity<Boolean> publish(@PathVariable("message") String message) {
        jmsPublisherService.publish(message);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}

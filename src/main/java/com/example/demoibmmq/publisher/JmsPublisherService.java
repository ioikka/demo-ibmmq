package com.example.demoibmmq.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JmsPublisherService {
    private final JmsTemplate jmsTemplate;

    @Value("${q.checkiia.req}")
    private String qName;

    public void publish(String body) {
        jmsTemplate.send(qName, session -> session.createTextMessage(body));
    }
}

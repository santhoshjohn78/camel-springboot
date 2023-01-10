package com.example.camelspringboot.routes;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("entered processiung...");
        String body = exchange.getIn().getBody(String.class);
        body+="---"+ LocalDateTime.now();
        exchange.getIn().setBody(body);
        log.info("exited processing....");
    }
}

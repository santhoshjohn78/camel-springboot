package com.example.camelspringboot.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MyRoute extends RouteBuilder {

    @Autowired
    MyProcessor myProcessor;

    @Override
    public void configure() throws Exception {
        from("timer:first-timer")
            .transform().constant("My body  "+ LocalDateTime.now())
                .log("${body}")
                .process(myProcessor)
            .to("log:mylog");
    }
}

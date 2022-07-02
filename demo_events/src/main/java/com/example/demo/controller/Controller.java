package com.example.demo.controller;

import com.example.demo.event.DemoEvent;
import com.example.demo.event.DemoEventType;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ApplicationEventPublisher publisher;

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        // Async Event
        publisher.publishEvent("I'm Async");

        publisher.publishEvent(DemoEvent.builder().data("Event demo data").build());
        publisher.publishEvent(DemoEvent.builder().data("Data to be deleted").eventName("deleteRecordEvent").build());
        publisher.publishEvent(DemoEvent.builder().data("Data for enum ").eventType(DemoEventType.CREATED).build());
        return ResponseEntity.ok("");
    }

}

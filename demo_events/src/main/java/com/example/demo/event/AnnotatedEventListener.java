package com.example.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AnnotatedEventListener {

    @EventListener
    public <T> CustomReturnedEvent handleAllDemoEvents(DemoEvent<T> event){
        log.info("Event triggered {}", event);
        return new CustomReturnedEvent(true);
    }

    @Async
    @EventListener
    public void handleAsyncEvent(String event) {
        log.info("Async event received: {}", event);
    }

    @EventListener(condition = "#event.eventName eq 'deleteRecordEvent'")
    public <T> void handleOnlyDeleteRecordEvents(DemoEvent<T> event){
        log.info("Event triggered no-returned {}", event);
    }

    @EventListener(condition = "#event.eventType == T(com.example.demo.event.DemoEventType).CREATED")
    public <T> void handleOnlyDeleteRecordEventss(DemoEvent<T> event){
        log.info("Event type no-returned {}", event);
    }

    @EventListener
    public void handleReturnedEvent(CustomReturnedEvent event) {
        log.info("ReturnedEvent received {}", event);
    }

}

package com.example.demo.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoEvent<T> {
    private String eventName;
    private T data;
    private DemoEventType eventType;
}

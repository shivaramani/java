package com.codeandtech.appcoreengine.core;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class Bootstrap{
    public String HelloWorld(){
      return "Test message from com.codeandtech.appcoreengine.core.bootstrap - " + LocalDateTime.now();
    }
}
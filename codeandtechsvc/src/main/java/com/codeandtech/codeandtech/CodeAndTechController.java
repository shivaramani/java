package com.codeandtech.codeandtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeAndTechController {

    private static final String HELLOWORLD = "/codeandtech/helloworld";

    @RequestMapping(method=RequestMethod.GET, value=HELLOWORLD)
    public String helloworld() {
        return "Hello World!!!";
    }
}
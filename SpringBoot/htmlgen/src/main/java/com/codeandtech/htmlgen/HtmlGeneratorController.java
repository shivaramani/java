package com.codeandtech.htmlgen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlGeneratorController {

    private static final String HTMLGEN_GETHTML = "/htmlgen/gethtml";

	@RequestMapping(method=RequestMethod.GET, value=HTMLGEN_GETHTML)
    public String htmlgen() {
        return "sample html text";
    }
}
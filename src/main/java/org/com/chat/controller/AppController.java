package org.com.chat.controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class AppController {

    @GetMapping(value = "/hi")
    public String getHi() {
        return "Hi";
    }


}

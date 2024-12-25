package org.example.log.log;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LogController {

    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @PostMapping("/result")
    public ResponseEntity<Void> printShuffledArray(@RequestBody Object object) {
        service.printObject(object);
        return ResponseEntity.ok().build();
    }

}


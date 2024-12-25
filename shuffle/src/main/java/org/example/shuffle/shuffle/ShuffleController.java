package org.example.shuffle.shuffle;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ShuffleController {

    private final ShuffleService service;

    public ShuffleController(ShuffleService service) {
        this.service = service;
    }

    @PostMapping("/test")
    public ResponseEntity<Void> createShuffledArray(@RequestBody InputDto number) {
        return service.createShuffledArray(number);
    }

}


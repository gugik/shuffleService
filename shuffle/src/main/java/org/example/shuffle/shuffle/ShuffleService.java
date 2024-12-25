package org.example.shuffle.shuffle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShuffleService {

    @Value("${log.service.url}")
    private String url;

    public ResponseEntity<Void> createShuffledArray(InputDto inputDto) {
        if (inputDto.getNumber() < 1 || inputDto.getNumber() > 1000) {
            return ResponseEntity.badRequest().build();
        }
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 1; i <= inputDto.getNumber(); i++) {
            listOfNumbers.add(i);
        }
        Collections.shuffle(listOfNumbers);
        var result = listOfNumbers.toArray(new Integer[0]);
        logShuffledArray(result);
        return ResponseEntity.ok().build();
    }

    private void logShuffledArray(Object result) {
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .build();
        client.post().uri("/result")
                .bodyValue(result).retrieve()
                .toBodilessEntity()
                .block();
    }

}


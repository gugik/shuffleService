package org.example.log.log;

import org.springframework.stereotype.Service;

@Service
public class LogService {

    public void printObject(Object inputDto) {
        System.out.println("Logged object: ");
        System.out.println(inputDto);
    }

}


package com.gos.gos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GosController {
    private final GosService gosService;

    public GosController(
            GosService gosService
    ) {
        this.gosService = gosService;
    }

    @GetMapping("/scores/{sbd}")
    public ResponseEntity<Object> scores(
            @PathVariable("sbd") String sbd
    ) {
        try {
            ScoreDto response = this.gosService.getScore(sbd);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

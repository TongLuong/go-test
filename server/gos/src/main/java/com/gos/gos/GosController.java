package com.gos.gos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class GosController {
    private final GosService gosService;

    @Autowired
    public GosController(
            GosService gosService
    ) {
        this.gosService = gosService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
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

    @GetMapping("/scores/all")
    public ResponseEntity<Object> getAllScores() {
        try {
            List<StatisticDto> response = this.gosService.getAllScores();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/scores/top")
    public ResponseEntity<Object> listTop(
            @RequestParam("top") Integer top
    ) {
        try {
            List<ScoreDto> response = this.gosService.listTop(top);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

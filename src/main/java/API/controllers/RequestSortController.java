package API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import API.services.ResultService;

@RestController
@RequestMapping("/requestSort")
public class RequestSortController {
    @Autowired
    public RequestSortController(ResultService resultService) {
        this.resultService = resultService;
    }
    private final ResultService resultService;

    @DeleteMapping
    public ResponseEntity<String> deleteAllResults(){
        return new ResponseEntity<>("All results deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> getAllResults() throws InterruptedException {
        Thread.sleep(5000);
        return new ResponseEntity<>("Prueba", HttpStatus.OK);
    }

}

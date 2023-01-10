package API.controllers;

import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.RequestData;
import API.model.RequestResult;
import API.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import API.services.ResultService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/requestSort")
public class RequestSortController {
    @Autowired
    public RequestSortController(ResultService resultService) {

        this.resultService = resultService;
        this.executor = CPUExecutor.getInstance().getExecutor();
    }
    private final ResultService resultService;
    private final ExecutorService executor;

    @PostMapping ()
    public ResponseEntity<RequestResult> sort(@RequestBody RequestData request) throws ExecutionException, InterruptedException {
        RequestResult r = new RequestResult(request);
        HandleRequest handleRequest = new HandleRequest(request);
        r.setResults(CompletableFuture.supplyAsync(handleRequest::call,executor).get());
        resultService.saveResult(r);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResult> getResult(@PathVariable Long id){
        return new ResponseEntity<>(resultService.getResult(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteResult(@PathVariable Long id){
        resultService.deleteResult(id);
        return HttpStatus.OK;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestResult>> getAllResults(){
        return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
    }

}

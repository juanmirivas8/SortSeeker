package API.controllers;

import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.RequestData;
import API.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
    private ExecutorService executor;

    @GetMapping()
    public List<Result> sort(@RequestBody RequestData request) throws ExecutionException, InterruptedException {
        System.out.println("Request received");
        HandleRequest handleRequest = new HandleRequest(request);
        List<Result> results = CompletableFuture.supplyAsync(handleRequest::call,executor).get();
        return results;
    }

}

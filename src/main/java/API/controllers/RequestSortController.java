package API.controllers;

import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.RequestData;
import API.model.RequestResult;
import API.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import API.services.ResultService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

@RestController
@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT}, origins = "*")
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
    public RequestResult sort(@RequestBody RequestData request) throws ExecutionException, InterruptedException {
        RequestResult r = new RequestResult(request);
        HandleRequest handleRequest = new HandleRequest(request);
        r.setResults(CompletableFuture.supplyAsync(handleRequest::call,executor).get());
        resultService.saveResult(r);
        return r;
    }

    @GetMapping("/{id}")
    public RequestResult getResult(@PathVariable Long id){
        return resultService.getResult(id);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteResult(@PathVariable Long id){
        resultService.deleteResult(id);
        return HttpStatus.OK;
    }

    @GetMapping("/all")
    public List<RequestResult> getAllResults(){
        return resultService.getAllResults();
    }

}

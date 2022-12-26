package API.services;

import API.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import API.repositories.ResultRepository;

@Service
public class ResultService {
    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }
    private final ResultRepository resultRepository;


    public void saveResult(Result r) {
        resultRepository.save(r);
    }
}

package API.services;

import API.model.RequestResult;
import API.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import API.repositories.ResultRepository;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }
    private final ResultRepository resultRepository;
    public void saveResult(RequestResult r) {
        resultRepository.save(r);
    }

    public RequestResult getResult(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

    public List<RequestResult> getAllResults() {
        return resultRepository.findAll();
    }
}

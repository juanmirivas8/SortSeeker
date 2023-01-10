package API.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class RequestResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "requestResult")
    private List<Result> results;
    @Embedded
    private RequestData requestData;

    public RequestResult() {
    }

    public RequestResult(RequestData requestData) {
        this.requestData = requestData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        results.forEach(r->r.setRequestResult(this));
        this.results = results;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}

package API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private RequestResult requestResult;
    @Column
    private Integer nElements;
    @Column
    private Long computedTime;
    @Enumerated(EnumType.ORDINAL)
    private Algorithm algorithm;

    public Result(Integer nElements, Long computedTime, Algorithm algorithm) {
        this.nElements = nElements;
        this.computedTime = computedTime;
        this.algorithm = algorithm;
    }

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getnElements() {
        return nElements;
    }

    public void setnElements(Integer nElements) {
        this.nElements = nElements;
    }

    public Long getComputedTime() {
        return computedTime;
    }

    public void setComputedTime(Long computedTime) {
        this.computedTime = computedTime;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResult requestResult) {
        this.requestResult = requestResult;
    }

    @Override
    public String toString() {
        return "["+nElements+","+computedTime+"]";
    }
}

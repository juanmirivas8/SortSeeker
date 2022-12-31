package API.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column
    private Integer nElements;
    @Column
    private Long computedTime;
    @Enumerated(EnumType.ORDINAL)
    private Algorithm algorithm;

    @Column
    private Boolean multiThreaded;

    public Result(Integer nElements, Long computedTime, Algorithm algorithm, Boolean multiThreaded) {
        this.nElements = nElements;
        this.computedTime = computedTime;
        this.algorithm = algorithm;
        this.multiThreaded = multiThreaded;
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

    public Boolean getMultiThreaded() {
        return multiThreaded;
    }

    public void setMultiThreaded(Boolean multiThreaded) {
        this.multiThreaded = multiThreaded;
    }

    @Override
    public String toString() {
        return "["+nElements+","+computedTime+"]";
    }
}

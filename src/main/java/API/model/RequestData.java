package API.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
@Embeddable

public class RequestData implements Serializable {
    private Integer minElements;
    private Integer maxElements;
    private Integer step;
    private Algorithm algorithm;

    private LocalDateTime date;

    public RequestData() {
    }

    public RequestData(Integer minElements, Integer maxElements, Integer step, Algorithm algorithm, LocalDateTime date) {
        this.minElements = minElements;
        this.maxElements = maxElements;
        this.step = step;
        this.algorithm = algorithm;
        this.date = date;
    }

    public Integer getMinElements() {
        return minElements;
    }

    public void setMinElements(Integer minElements) {
        this.minElements = minElements;
    }

    public Integer getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(Integer maxElements) {
        this.maxElements = maxElements;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}


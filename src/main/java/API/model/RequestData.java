package API.model;

public class RequestData {
    private Long minElements;
    private Long maxElements;
    private Long step;
    private Long computingTime;
    private Algorithm algorithm;

    public RequestData() {}

    public RequestData(Long minElements, Long maxElements, Long step, Long computingTime, Algorithm algorithm) {
        this.minElements = minElements;
        this.maxElements = maxElements;
        this.step = step;
        this.computingTime = computingTime;
        this.algorithm = algorithm;
    }

    public Long getMinElements() {
        return minElements;
    }

    public void setMinElements(Long minElements) {
        this.minElements = minElements;
    }

    public Long getMaxElements() {
        return maxElements;
    }

    public void setMaxElements(Long maxElements) {
        this.maxElements = maxElements;
    }

    public Long getStep() {
        return step;
    }

    public void setStep(Long step) {
        this.step = step;
    }

    public Long getComputingTime() {
        return computingTime;
    }

    public void setComputingTime(Long computingTime) {
        this.computingTime = computingTime;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}


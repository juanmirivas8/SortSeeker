package API.model;

import java.io.Serializable;

public class RequestData implements Serializable {
    private Integer minElements;
    private Integer maxElements;
    private Integer step;
    private Long computingTime;
    private Algorithm algorithm;

    private Boolean multiThreaded;

    public RequestData() {
    }

    public RequestData(Integer minElements, Integer maxElements, Integer step, Long computingTime, Algorithm algorithm, Boolean multiThread) {
        this.minElements = minElements;
        this.maxElements = maxElements;
        this.step = step;
        this.computingTime = computingTime;
        this.algorithm = algorithm;
        this.multiThreaded = multiThread;
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

    public Boolean getMultiThreaded() {
        return multiThreaded;
    }

    public void setMultiThreaded(Boolean multiThreaded) {
        this.multiThreaded = multiThreaded;
    }
}


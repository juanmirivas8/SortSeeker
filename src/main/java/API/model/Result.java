package API.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Column
    private Long nElements;
    @Column
    private Long computedTime;
    @Enumerated(EnumType.ORDINAL)
    private Algorithm algorithm;

    public Result(){}
}

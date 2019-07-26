package ir.maktab25.quizmaker.base.domain;

import java.io.Serializable;

public class BaseEntity<PK extends Serializable> implements Serializable {

    public PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}

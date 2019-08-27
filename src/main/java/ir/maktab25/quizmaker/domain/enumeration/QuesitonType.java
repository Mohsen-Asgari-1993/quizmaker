package ir.maktab25.quizmaker.domain.enumeration;

public enum QuesitonType {
    MULTIPLE_CHOICE,
    DESCRIPTIVE;

    @Override
    public String toString() {
        return this.name();
    }
}

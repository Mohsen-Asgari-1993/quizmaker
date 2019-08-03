package ir.maktab25.quizmaker.base.seurity.domian.enumeration;

public enum RoleName {
    SUPER,
    ADMIN,
    TEACHER,
    STUDENT;

    @Override
    public String toString() {
        return this.name();
    }
}

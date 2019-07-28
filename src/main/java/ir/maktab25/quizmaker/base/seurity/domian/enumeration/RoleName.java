package ir.maktab25.quizmaker.base.seurity.domian.enumeration;

public enum RoleName {
    ROLE_ADMIN,
    ROLE_TEACHER,
    ROLE_STUDENT;

    @Override
    public String toString() {
        return this.name();
    }
}

package epam.jpa.model;


public enum EmployeeStatus {
    LOOKING_FOR_JOB, BUSY;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

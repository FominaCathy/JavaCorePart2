package gb.homework.Company;

public enum Staff {
    DEV("developer"),
    TEST("tester"),
    LEAD("Tec lead");
    private String staff;

    Staff(String staff) {
        this.staff = staff;
    }

    public String getStaff() {
        return staff;
    }
}


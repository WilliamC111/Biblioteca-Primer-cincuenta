package model;

public class Campus {
    private String campusName;

    public Campus(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusName() {
        return campusName;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusName='" + campusName + '\'' +
                '}';
    }
}

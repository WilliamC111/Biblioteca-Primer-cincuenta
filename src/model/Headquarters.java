package model;
import java.util.ArrayList;
import java.util.List;

public class Headquarters {
    private String headquartersName;
    private List<Campus> campuses; 

    public Headquarters(String headquartersName) {
        this.headquartersName = headquartersName;
        this.campuses = new ArrayList<>(); 
    }

    public void addCampus(Campus campus) {
        campuses.add(campus);
    }

    public String getHeadquartersName() {
        return headquartersName;
    }

    public List<Campus> getCampuses() {
        return campuses;
    }

    @Override
    public String toString() {
        return "Headquarters{" +
                "headquartersName='" + headquartersName + '\'' +
                ", campuses=" + campuses +
                '}';
    }
}

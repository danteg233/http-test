package rest.model;

public class GroupWithSeparateLevel {
    private String name;
    private String startTime;

    public GroupWithSeparateLevel(String name, String startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}

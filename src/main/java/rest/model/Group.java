package rest.model;

public class Group {
    private String name;
    private Level[] levels;

    public Group(String name) {
        this.name = name;
        this.levels = new Level[0];
    }

    public Group(String name, Level[] levels) {
        this.name = name;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }
}

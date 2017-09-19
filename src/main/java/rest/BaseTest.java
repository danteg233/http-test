package rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static final String TEMPLATE_URL = "http://epkzkarw0472:9005/templates";
    protected String groupName;
    protected String templateName;
    protected int capacity;
    protected int companyBusinessId;
    protected int locationBusinessId;
    protected String status;
    protected String name;
    protected String startTime;
    protected String levelName;

    @BeforeClass
    @Parameters({"groupName", "templateName", "capacity", "companyBusinessId", "locationBusinessId", "name", "startTime", "levelName"})
    public void setUp(String groupName, String templateName, int capacity, int companyBusinessId, int locationBusinessId, String name, String startTime, String levelName){
        this.groupName = groupName;
        this.templateName = templateName;
        this.capacity = capacity;
        this.companyBusinessId = companyBusinessId;
        this.locationBusinessId = locationBusinessId;
        this.name = name;
        this.startTime = startTime;
        this.levelName = levelName;
    }
}

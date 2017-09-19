package rest.model;

public class Template {
        private String templateName;
        private int capacity;
        private int companyBusinessId;
        private int locationBusinessId;
        private String status;
        private String name;
        private Group[] groups;
        private GroupWithSeparateLevel[] draftSeparateLevels;

    public Template() {
    }

    public Template(String templateName, int capacity, int companyBusinessId, int locationBusinessId, String status, String name, Group[] groups) {
        this.templateName = templateName;
        this.capacity = capacity;
        this.companyBusinessId = companyBusinessId;
        this.locationBusinessId = locationBusinessId;
        this.status = status;
        this.name = name;
        this.groups = groups;
        this.draftSeparateLevels = new GroupWithSeparateLevel[0];
    }

    public Template(String templateName, int capacity, int companyBusinessId, int locationBusinessId, String status, String name, GroupWithSeparateLevel[] draftSeparateLevels) {
        this.templateName = templateName;
        this.capacity = capacity;
        this.companyBusinessId = companyBusinessId;
        this.locationBusinessId = locationBusinessId;
        this.status = status;
        this.name = name;
        this.draftSeparateLevels = draftSeparateLevels;
        this.groups = new Group[0];
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCompanyBusinessId() {
        return companyBusinessId;
    }

    public void setCompanyBusinessId(int companyBusinessId) {
        this.companyBusinessId = companyBusinessId;
    }

    public int getLocationBusinessId() {
        return locationBusinessId;
    }

    public void setLocationBusinessId(int locationBusinessId) {
        this.locationBusinessId = locationBusinessId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public GroupWithSeparateLevel[] getDraftSeparateLevels() {
        return draftSeparateLevels;
    }

    public void setDraftSeparateLevels(GroupWithSeparateLevel[] draftSeparateLevels) {
        this.draftSeparateLevels = draftSeparateLevels;
    }
}

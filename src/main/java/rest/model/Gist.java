package rest.model;

import java.util.Arrays;

public class Gist {
    private String description;
    private boolean isPublic;
    private File[] files;

    public Gist(){
    }

    public Gist(String description, boolean isPublic, File[] files) {
        this.description = description;
        this.isPublic = isPublic;
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "{" +
                "description='" + description + '\'' +
                ", public=" + isPublic +
                ", files={" + Arrays.toString(files) + '}'+
                '}';
    }
}

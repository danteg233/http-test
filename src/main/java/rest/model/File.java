package rest.model;

public class File {
    private String fileName;
    private String content;

    public File(){
    }

    public File(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return fileName + '{' +
                "content=" + content +
                '}';
    }
}

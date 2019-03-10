package billow.fun.serve4j.model;

import billow.fun.serve4j.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Post extends BaseEntity {
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String category;
    private String[] fileList;

    public Post() {
    }

    public Post(String title, String content, String category, String[] fileList) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.fileList = fileList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getFileList() {
        return fileList;
    }

    public void setFileList(String[] fileList) {
        this.fileList = fileList;
    }
}

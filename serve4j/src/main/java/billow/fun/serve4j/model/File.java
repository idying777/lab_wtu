package billow.fun.serve4j.model;

import org.springframework.stereotype.Component;

@Component
public class File {
    private String username;
    private String url;

    public File() {
    }

    public File(String username, String url) {
        this.username = username;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

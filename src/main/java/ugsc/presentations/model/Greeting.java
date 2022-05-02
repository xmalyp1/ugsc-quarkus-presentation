package ugsc.presentations.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Greeting extends PanacheEntity {

    private String message;
    private LocalDateTime timestamp;
    private String user;

    public Greeting(String message,String user){
        this(message,LocalDateTime.now(),user);
    }

    public Greeting(String message, LocalDateTime timestamp, String user) {
        this.message = message;
        this.timestamp = timestamp;
        this.user = user;
    }

    public Greeting() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

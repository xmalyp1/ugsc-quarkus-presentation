package ugsc.presentations.model;

public class GreetingDTO {
    private String message;
    private String user;

    public GreetingDTO(){}

    public GreetingDTO(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

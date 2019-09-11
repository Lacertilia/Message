import java.sql.SQLOutput;
import java.util.*;

public class Message {
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String author;

    public Message(String message){
        if(message.length() <= 140){
            this.message = message;
        }else{
            System.out.println("Your message is too long! Max. 140 characters");
            System.exit(2);
        }
        this.createdAt = new Date();
        this.author = System.getProperty("user.name");
    }


    public String toString(){
        return this.message + " - " + this.author + ", at " + this.createdAt;
    }

    public void update(String message){
        if(message.length() <= 140){
            this.message = message;
        }else{
            System.out.println("Your message is too long! Max. 140 characters");
        }
        this.updatedAt = new Date();
    }
}

import java.sql.SQLOutput;
import java.util.*;

public class Message implements java.io.Serializable{
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String author;

    /**
     * Constructor for message, max-length is 140 characters and the Constructor automatically gets the author and time that the message was written.
     * @param message
     */
    public Message(String message){
        if(message.length() <= 140){
            this.message = message;
            this.createdAt = new Date();
            this.author = System.getProperty("user.name");
        }else{
            System.out.println("Your message is too long! Max. 140 characters");
            System.exit(2);
        }
    }

    /**
     *  A function to return a wiewable message
     * @return the message, however it is different if the message is updated.
     */
    public String toString(){
        if(this.updatedAt == null){
            return this.message + " - " + this.author + ", at " + this.createdAt;
        }else{
            return this.message + " - " + this.author + ", updated at " + this.updatedAt;
        }
    }

    /**
     * A function to update messages.
     * @param message
     */

    public void update(String message){
        if(message.length() <= 140){
            this.message = message;
            this.updatedAt = new Date();
            this.author = System.getProperty("user.name");
        }else{
            System.out.println("Your message is too long! Max. 140 characters");
        }
    }
}

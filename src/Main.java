import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean filesRead = false;

    /**
     * Starts the program
     * @param args
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in;
        ArrayList<Message> messages = new ArrayList<Message>();
        while (true) {
            menu();
            in = scan.next();
            switch (in) {
                case "1":
                    messages.forEach((n) -> System.out.println(n.toString()));
                    break;
                case "2":
                    System.out.println("Skriv ditt meddelande.");
                    messages.add(new Message(getMessage()));
                    break;
                case "3":
                    messages.addAll(readMessages());
                    System.out.println("Vilket meddelande vill du uppdatera?");
                    int update = scan.nextInt();
                    System.out.println("Skriv ditt nya meddelande.");
                    messages.get((update - 1)).update(getMessage());
                    System.out.println("Uppdateraderingen gick som den skulle");
                    break;
                case "4":
                    saveMessages(messages);
                    System.out.println("Meddelanden sparades till fil.");
                    break;
                case "5":
                    messages.addAll(readMessages());
                    System.out.println("Meddelanden inlästa från fil.");
                    break;
                case "6":
                    System.out.println("See you next time.");
                    System.exit(3);
                    break;
                case "Delete":
                    messages.addAll(readMessages());
                    messages.clear();
                    saveMessages(messages);
                default:
                    System.out.println("Vänligen skriv en siffra mellan 1-6");
            }
        }
    }

    /**
     * Prints out the menu for options.
     */

    private static void menu() {
        System.out.println("1.Visa meddelanden \n" +
                "2.Lägg till meddelande \n" +
                "3.Uppdatera meddelande \n" +
                "4.Spara meddelanden till fil \n" +
                "5.Läs in meddelande från fil \n" +
                "6.Avsluta ");
    }

    /**
     * A function to save messages to a file in order to read them later
     * @param messages The messages that will be saved
     */

    private static void saveMessages(ArrayList<Message> messages) {
        try {

            messages.addAll(readMessages());
            FileOutputStream fo = new FileOutputStream(new File("messages.txt"));
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            oo.writeObject(messages);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * A function to read messages from a file
     * @return the messages from a txt file.
     */

    private static ArrayList<Message> readMessages() {
        if(!filesRead){
            ArrayList<Message> messages = new ArrayList<Message>();

            try {
                FileInputStream fi = new FileInputStream("messages.txt");
                ObjectInputStream oi = new ObjectInputStream(fi);

                messages = (ArrayList<Message>) oi.readObject();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            filesRead = true;

            return messages;
        }else{
            return new ArrayList<Message>();
        }
    }

    /**
     * Scanner for input message, needed to read whole line.
     * @return the message written
     */

    private static String getMessage(){
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        return msg;
    }
}

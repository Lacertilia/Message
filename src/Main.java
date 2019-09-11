import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int in;
        ArrayList<Message> messages = new ArrayList<Message>();
        while(true) {
            menu();
            in = scan.nextInt();
            switch (in) {
                case 1:
                    messages.forEach((n) -> System.out.println(n.toString()));
                    break;
                case 2:
                    System.out.println("Skriv ditt meddelande.");
                    messages.add(new Message(scan.next()));
                    break;
                case 3:
                    System.out.println("Vilket meddelande vill du uppdatera?");
                    int update = scan.nextInt();
                    System.out.println("Skriv ditt nya meddelande.");
                    messages.get((update-1)).update(scan.next());
                    System.out.println("Uppdateraderingen gick som den skulle");
                    break;
                case 4:
                    saveMessages();
                    System.out.println("Meddelanden sparades.");
                    break;
                case 5:
                    readMessages();
                    System.out.println("Meddelanden inlästa");
                    break;
                case 6:
                    System.out.println("See you next time.");
                    System.exit(3);
            }
        }
    }

    private static void menu(){
        System.out.println("1.Visa meddelanden \n" +
                "2.Lägg till meddelande \n" +
                "3.Uppdatera meddelande \n" +
                "4.Spara meddelanden till fil \n" +
                "5.Läs in meddelande från fil \n" +
                "6.Avsluta ");
    }

    private static void saveMessages(){

    }

    private static void readMessages(){

    }
}

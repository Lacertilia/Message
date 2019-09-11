import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            menu();
            int in = scan.nextInt();
            ArrayList messages = new ArrayList();
            switch (in) {
                case 1:
                    messages.forEach((n) -> System.out.println(n.toString()));
                case 2:
                    System.out.println("Skriv ditt meddelande.");
                    messages.add(new Message(scan.next()));
                case 3:

                case 4:

                case 5:

                case 6:
                    System.out.println("See you next time.");
                    System.exit(3);

            }
        }
    }

    public static void menu(){
        System.out.println("1.Visa meddelanden \n" +
                "2.Lägg till meddelande \n" +
                "3.Uppdatera meddelande \n" +
                "4.Spara meddelanden till fil \n" +
                "5.Läs in meddelande från fil \n" +
                "6.Avsluta ");
    }
}

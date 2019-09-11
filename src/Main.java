import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Visa meddelanden \n2.Lägg till meddelande \n3.Uppdatera meddelande \n4.Spara meddelanden till fil \n5.Läs in meddelande från fil \n6.Avsluta ");
        int in = scan.nextInt();
        switch(in){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:
                System.exit(3);

        }
    }
}

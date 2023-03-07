import java.util.Random;
import java.util.Scanner;

public class SafeBox {
    public static void main(String[] args) {
//        if(args.length < 2)
//            return;
        String option;
        String userText;
        Safe safe = new Safe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Option. What Should I do?");
        System.out.println("1.Encrypt: -e\n2.Decrypt: -d");
        option = scanner.nextLine();

        System.out.println("Enter your text:");
        userText = scanner.nextLine();
        switch (option){
            case "-e":
                safe.encrypt(userText);
                System.out.println("This is your key: " + safe.getKey());
                System.out.println("This is your enctypted text:" + safe.getOutput());
                System.out.println("\nPLEASE COPY YOUR KEY AND TEXT. YOU WONT BE ABLE TO GET THEM AGAIN!");
                break;
            case "-d":
                System.out.println("Set Key to decrypt:");
                safe.setOutput(userText);
                safe.setKey(scanner.nextLine());
                System.out.println("The Encrypted Text is: \n" + safe.decrypt());
                break;
        }

    }
}
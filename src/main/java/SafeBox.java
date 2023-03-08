import Color.ConsoleColor;
import JcommanderClasses.Args;
import com.beust.jcommander.JCommander;
import java.util.Scanner;

public class SafeBox {
    public static void main(String[] args) throws Exception {

        Args arguments = new Args();
        JCommander safeBoxCmd = JCommander
                .newBuilder()
                .addObject(arguments)
                .build();
        safeBoxCmd.parse(args);

        String userPathToFile;
        Safe safe = new Safe();
        Scanner scanner = new Scanner(System.in);

        userPathToFile = arguments.getOriginalFile();

        switch (arguments.getType()){
            case "encrypt":
                safe.readFile(userPathToFile);
//                System.out.println(safe.getInput());
                safe.encrypt(arguments.getOutputName());
                System.out.println(ConsoleColor.GREEN +
                        "\nSUCCESSFULLY ENCRYPTED"+
                        "\nAll Files will be save in ~/user/Documents/Kinko"
                        + ConsoleColor.RESET+"\n");
                System.out.println("This is your key:\n" + safe.getKey());
                System.out.println("This is your enctypted text:" + safe.getOutput());
                System.out.println(ConsoleColor.RED +
                        "\nPLEASE COPY YOUR KEY AND TEXT. YOU WONT BE ABLE TO GET THEM AGAIN!!"
                        + ConsoleColor.RESET);
                break;
            case "decrypt":
                System.out.println("Set Key to decrypt:");
                safe.setOutput(userPathToFile);
                safe.setKey(scanner.nextLine());
                System.out.println("The Encrypted Text is: \n" + safe.decrypt());
                break;
            default:
                System.out.println("Please set valid options");
                break;
        }

    }
}
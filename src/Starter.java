import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Robot robot = new Robot();
        CommandInterpreter interpreter = new CommandInterpreter(robot);

        Scanner scanner = new Scanner(System.in);
        String commandString;
        while (true) {
            System.out.print("Enter command: ");
            commandString = scanner.nextLine();
            if (commandString.equalsIgnoreCase("QUIT")) {
                break;
            }
            interpreter.interpret(commandString);
        }

        System.out.println("Exiting...");
    }
}

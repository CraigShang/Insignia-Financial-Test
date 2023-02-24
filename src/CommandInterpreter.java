public class CommandInterpreter {
    private Robot robot;

    public CommandInterpreter(Robot robot) {
        this.robot = robot;
    }

    public void interpret(String commandString) {
        String[] tokens = commandString.trim().split("\\s+");
        if (tokens.length == 0) {
            return; // ignore empty lines
        }
        Command command = Command.valueOf(tokens[0].toUpperCase());
        switch (command) {
            case PLACE:
                if (tokens.length == 4) {
                    int x = Integer.parseInt(tokens[1]);
                    int y = Integer.parseInt(tokens[2]);
                    Direction direction = Direction.valueOf(tokens[3].toUpperCase());
                    robot.place(x, y, direction);
                }else{
                    showUnknownCommandErrorMessage(commandString);;
                }
                break;
            case MOVE:
                robot.move();
                break;
            case LEFT:
                robot.rotateLeft();
                break;
            case RIGHT:
                robot.rotateRight();
                break;
            case REPORT:
                robot.report();
                break;
            default:
                showUnknownCommandErrorMessage(commandString);
                break;
        }
    }
    
    private void showUnknownCommandErrorMessage(String command){
        System.err.println("Unknown command: " + command);
    }
}

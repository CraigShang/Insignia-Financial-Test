import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    private Robot robot;
    private CommandInterpreter interpreter;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
        interpreter = new CommandInterpreter(robot);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPlaceCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        robot.move();
        robot.move();
        robot.rotateRight();
        robot.move();
        interpreter.interpret("REPORT");
        assertEquals("3,3,NORTH\n", outputStream.toString());
    }

    @Test
    public void testInvalidPlaceCommand() {
        interpreter.interpret("PLACE 6,0,EAST");
        robot.move();
        robot.rotateRight();
        robot.move();
        interpreter.interpret("REPORT");
        assertEquals("0,0,SOUTH\n", outputStream.toString());
    }

    @Test
    public void testMultiplePlaceCommands() {
        interpreter.interpret("PLACE 0,0,EAST");
        interpreter.interpret("PLACE 3,4,NORTH");
        interpreter.interpret("MOVE");
        interpreter.interpret("MOVE");
        interpreter.interpret("LEFT");
        interpreter.interpret("MOVE");
        interpreter.interpret("REPORT");
        assertEquals("2,5,WEST\n", outputStream.toString());
    }

    @Test
    public void testIgnoreCommandsBeforePlaceCommand() {
        robot.move();
        robot.rotateRight();
        robot.move();
        interpreter.interpret("REPORT");
        assertEquals("0,0,SOUTH\n", outputStream.toString());
    }

    @Test
    public void testUnknownCommand() {
        interpreter.interpret("JUMP");
        assertEquals("Unknown command: JUMP\n", outputStream.toString());
    }
}

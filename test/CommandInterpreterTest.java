import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandInterpreterTest {
    private Robot robot;
    private CommandInterpreter interpreter;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
        interpreter = new CommandInterpreter(robot);
    }

    @Test
    public void testPlaceCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testMoveCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        interpreter.interpret("MOVE");
        assertEquals(2, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testLeftCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        interpreter.interpret("LEFT");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testRightCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        interpreter.interpret("RIGHT");
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }

    @Test
    public void testReportCommand() {
        interpreter.interpret("PLACE 1,2,EAST");
        interpreter.interpret("REPORT");
        assertEquals("1,2,EAST\n", interpreter.getOutput());
    }

    @Test
    public void testInvalidCommand() {
        interpreter.interpret("JUMP");
        assertEquals("Unknown command: JUMP\n", interpreter.getOutput());
    }

    @Test
    public void testInvalidPlaceCommand() {
        interpreter.interpret("PLACE 6,0,EAST");
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testIgnoreCommandsBeforePlaceCommand() {
        interpreter.interpret("MOVE");
        interpreter.interpret("LEFT");
        interpreter.interpret("RIGHT");
        interpreter.interpret("REPORT");
        assertEquals("", interpreter.getOutput());
    }
}

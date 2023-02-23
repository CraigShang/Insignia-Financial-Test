public class Robot {
    private int x;
    private int y;
    private Direction direction;
    private Table table;

    public Robot(Table table) {
        this.table = table;
    }

    public void place(int x, int y, Direction direction) {
        if (table.isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public void move() {
        int nextX = x;
        int nextY = y;

        switch (direction) {
            case NORTH:
                nextY++;
                break;
            case SOUTH:
                nextY--;
                break;
            case EAST:
                nextX++;
                break;
            case WEST:
                nextX--;
                break;
        }

        if (table.isValidPosition(nextX, nextY) && !table.willFall(x, y, direction)) {
            x = nextX;
            y = nextY;
        }
    }

    public void rotateLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    public void rotateRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    public void report() {
        System.out.println(x + "," + y + "," + direction);
    }
}

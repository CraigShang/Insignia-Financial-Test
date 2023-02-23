public class ToyRobot {
    private int x = -1;
    private int y = -1;
    private Direction direction;

    public void place(int x, int y, Direction direction) {
        if (isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public void move() {
        if (isValidMove()) {
            switch (direction) {
                case NORTH:
                    y++;
                    break;
                case EAST:
                    x++;
                    break;
                case SOUTH:
                    y--;
                    break;
                case WEST:
                    x--;
                    break;
            }
        }
    }

    public void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    public void report() {
        System.out.println(x + "," + y + "," + direction.toString());
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= 4 && y >= 0 && y <= 4;
    }

    public boolean isValidMove() {
        switch (direction) {
            case NORTH:
                return y < 4;
            case EAST:
                return x < 4;
            case SOUTH:
                return y > 0;
            case WEST:
                return x > 0;
            default:
                return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}

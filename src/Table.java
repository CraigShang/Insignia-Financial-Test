public class Table {
    private final int width = 5;
    private final int height = 5;

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean willFall(int x, int y, Direction direction) {
        switch (direction) {
            case NORTH:
                return y == height - 1;
            case SOUTH:
                return y == 0;
            case EAST:
                return x == width - 1;
            case WEST:
                return x == 0;
            default:
                return true;
        }
    }
}

public class Table {
    private final int width = 5;
    private final int height = 5;

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}

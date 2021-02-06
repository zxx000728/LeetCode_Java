public class _1232_CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length == 2) {
            return true;
        }

        for (int i = 0; i < length - 2; i++) {
            int dY1 = coordinates[i + 1][1] - coordinates[i][1];
            int dX1 = coordinates[i + 1][0] - coordinates[i][0];
            int dY2 = coordinates[i + 2][1] - coordinates[i + 1][1];
            int dX2 = coordinates[i + 2][0] - coordinates[i + 1][0];
            if (dY1 * dX2 != dY2 * dX1) {
                return false;
            }
        }
        return true;
    }
}

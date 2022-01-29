public class _1109_corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference df = new Difference(res);
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int inc = booking[2];
            df.increment(i, j, inc);
        }
        return df.result();
    }
}

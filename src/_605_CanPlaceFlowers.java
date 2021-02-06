public class _605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return n == 0;
        }
        int countOfZero = 1; // assume left with 0
        int count = 0; // can place
        for (int i1 : flowerbed) {
            if (i1 == 0) {
                countOfZero++;
            } else {
                count += (countOfZero - 1) / 2;
                if (count >= n) {
                    return true;
                }
                countOfZero = 0;
            }
        }
        countOfZero++;
        count += (countOfZero - 1) / 2;
        return count >= n;
    }
}

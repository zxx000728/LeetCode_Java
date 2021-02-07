public class LargestMerge {
    public String largestMerge(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] > chars2[j]) {
                result.append(chars1[i]);
                i++;
            } else if (chars1[i] < chars2[j]) {
                result.append(chars2[j]);
                j++;
            } else {
                String temp1 = word1.substring(i, i+Math.min(word1.length() - i, word2.length() - j));
                String temp2 = word2.substring(j, j+Math.min(word1.length() - i, word2.length() - j));
                if (temp1.compareTo(temp2) >= 0) {
                    result.append(chars1[i]);
                    i++;
                } else {
                    result.append(chars2[j]);
                    j++;
                }
            }
        }
        if (i <chars1.length){
            result.append(word1, i, chars1.length);
        }
        if (j<chars1.length){
            result.append(word2, j, chars2.length);
        }
        return result.toString();
    }
}

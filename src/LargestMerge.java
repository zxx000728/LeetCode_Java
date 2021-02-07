public class LargestMerge {
    public String largestMerge(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                result.append(chars1[i++]);
            } else {
                result.append(chars2[j++]);
            }
        }
        System.out.println("len1: " + len1);
        System.out.println("len2: " + len2);
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        if (i < chars1.length) {
            result.append(word1, i, chars1.length);
        }
        if (j < chars2.length) {
            result.append(word2, j, chars2.length);
            System.out.println("aaa");
        }
        return result.toString();
    }

}

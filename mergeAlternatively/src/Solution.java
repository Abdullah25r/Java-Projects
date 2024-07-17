class Solution {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        int i = 0, j = 0;

        while (i < length1 && j < length2) {
            mergedString.append(word1.charAt(i++));
            mergedString.append(word2.charAt(j++));
        }
        while (i < length1) {
            mergedString.append(word1.charAt(i++));
        }


        while (j < length2) {
            mergedString.append(word2.charAt(j++));
        }

        return mergedString.toString();
    }

    public static void main(String[] args) {


        System.out.println(mergeAlternately("ab", "pqrs"));
          }
}
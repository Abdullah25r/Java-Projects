import java.lang.reflect.Array;

public class StringSearch {
    public static void main(String[] args) {
        String str = "Abdullah bhatti";
        char target= 'h';
        boolean found = search(str,target);
        System.out.println(found);
    }
    public static boolean search(String str, char target) {
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index)==target)
                return true;
        }

        return false;
    }


}

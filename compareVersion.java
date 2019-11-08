import java.util.*;
public class compareVersion {
    public static void main(String[] args) {
        String version1 = "1";
        String version2 = "01";
        int res = 123 / 10;
        System.out.println(res);
    }

    private static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int length = Math.max(arr1.length, arr2.length);
        for (int i = 0; i < length; i++) {
            Integer l1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            Integer l2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;
            int compare = l1.compareTo(l2);

            if (compare != 0) {
                return compare;
            }

        }

        return 0;
    }

}
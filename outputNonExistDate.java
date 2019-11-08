import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class outputNonExistDate {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int y = sc.nextInt(); // year
//        int m = sc.nextInt(); // month
//        int d = sc.nextInt(); // day

        int y = 2004;
        int m = 6;
        int d = 45;

        // determine if year is leap or not
        boolean flag = false;
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            flag = true;
        }

        int[] monthDays = {31, flag ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean isExceed = false;
        if (monthDays[m - 1] < d) {
            isExceed = true;
            d = d - monthDays[m - 1];
            m++;
        }
        String monthRes = m >= 10 ? String.valueOf(m) : "0" + String.valueOf(m);
        String DayRes = d >= 10 ? String.valueOf(d) : "0" + String.valueOf(d);
        System.out.println(String.valueOf(y) + "-" + monthRes + "-" + DayRes);
    }
}

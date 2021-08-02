import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class nartvt {

    public static void main(String[] args) {
        int n = 10;
        String[] s = new String[n + 2];
        s[0] = "123";
        s[1] = "45";
        s[2] = "766";
        s[3] = "324324";
        s[4] = ".324";
        s[5] = "0.325";
        s[6] = "-234";
        s[7] = "4546";
        s[8] = "100";
        s[9] = "0";
        s = Arrays.copyOfRange(s, 0, n);
        Arrays.sort(s, Collections.reverseOrder(
                new Comparator<String>() {
                    @Override
                    public int compare(String a1, String a2) {
                        BigDecimal a = new BigDecimal(a1);
                        BigDecimal b = new BigDecimal(a2);
                        return a.compareTo(b);
                    }
                }));

        for (String va : s) {
            System.out.println(va);
        }
    }
}

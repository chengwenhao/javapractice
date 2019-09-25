package localdate;

import java.time.Clock;
import java.time.LocalDate;

public class LocaldateTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate birthday = LocalDate.of(2019, 12, 17);
        System.out.println(birthday.getDayOfYear());
        System.out.println(birthday);
    }
}

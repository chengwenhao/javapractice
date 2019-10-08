package localdate;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

public class LocalDateTest {

    public static void main(String[] args) {

        //1.获取年月日：LocalDate
        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(2019, 12, 17);
        int dayOfYear = birthday.getDayOfYear();//一年中的第多少天
        int dayOfMonth = birthday.getDayOfMonth();//一月中的第多少天
        DayOfWeek dayOfWeek = birthday.getDayOfWeek();//周几（Tuesday）
            int value = dayOfWeek.getValue();//一周的第几天
            int value1 = dayOfWeek.plus(1).getValue();//这天的后一天
            int value2 = dayOfWeek.minus(1).getValue();//这天的前一天
        Month month = birthday.getMonth();
            Month minus = month.minus(1);
            Month plus = month.plus(1);
        int monthValue = birthday.getMonthValue();
        int year = birthday.getYear();

        int i = birthday.get(ChronoField.DAY_OF_MONTH);


        //2.获取时间：LocalTime
        LocalTime localTime1 = LocalTime.now();
        LocalTime time = LocalTime.of(11, 11, 11);
        //获取小时
        int hour = localTime1.get(ChronoField.HOUR_OF_DAY);
        int hour1 = localTime1.getHour();
        //获取分钟
        int minute = localTime1.get(ChronoField.MINUTE_OF_HOUR);
        int minute1 = localTime1.getMinute();
        //获取秒
        int second = localTime1.get(ChronoField.SECOND_OF_MINUTE);
        int second1 = localTime1.getSecond();


        //3.获取日期时间：LocalDate + LocalTime
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime dateTime1 = LocalDateTime.of(2018, 12, 12, 12, 12, 12);
        LocalDate localDate = dateTime1.toLocalDate();
        LocalTime time1 = dateTime1.toLocalTime();


        //4.LocalDate、LocalTime、LocalDateTime、Instant为不可变对象，修改这些对象对象会返回一个副本
        LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 17, 12, 20, 20);
        LocalDateTime dateTime2 = localDateTime.plusYears(1);
        LocalDateTime plus1 = localDateTime.plus(1, ChronoUnit.YEARS);

        //通过with修改值
        LocalDateTime dateTime3 = localDateTime.withYear(2021);
        LocalDateTime with = localDateTime.with(ChronoField.YEAR, 2022);


        //5.格式化时间
        LocalDateTime now2 = LocalDateTime.now();
        String format = now2.format(DateTimeFormatter.BASIC_ISO_DATE);
        String format1 = now2.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String format2 = now2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String format3 = now2.format(DateTimeFormatter.ISO_LOCAL_TIME);
        String format4 = now2.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        LocalDateTime parse = LocalDateTime.parse("20191008 13:50:09.073",DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSS"));
        LocalDate parse1 = LocalDate.parse("20190121", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
        System.out.println(parse1);


    }
}

package time;

import java.time.*;

public class JavaTime {
    public static void main(String[] args) {

        LocalDate     localDate     = LocalDate.now();
        LocalTime     localTime     = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);     // 2023-07-17
        System.out.println(localTime);     // 14:40:25.088115900
        System.out.println(localDateTime); // 2023-07-17T14:40:25.088115900

        Instant  instant  = Instant.now();
        Period   period   = Period.between(
                Year.now().atMonth(Month.JULY).atDay(1),
                Year.now().atMonthDay(MonthDay.of(7,17)));
        Duration duration = Duration.between(
                LocalTime.of(12,0) ,
                LocalTime.now());

        System.out.println(instant); // 2023-07-17T12:55:09.086005900Z
        System.out.println(period);  // P16D (pour 16 jours)
        System.out.println(duration);// PT2H55M9.0910012S

        Year      year      = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay  monthDay  = MonthDay.now();

        System.out.println(year);      // 2023
        System.out.println(yearMonth); // 2023-07
        System.out.println(monthDay);  // --07-17

        Clock clock = Clock.fixed(
                Year.of(2023).atMonth(Month.JANUARY).atDay(1)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        System.out.println(LocalDate.now(clock)); // 2023-01-01
    }
}

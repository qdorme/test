package time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class JavaTime {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);     // 2023-07-17
        System.out.println(localTime);     // 14:40:25.088115900
        System.out.println(localDateTime); // 2023-07-17T14:40:25.088115900

        Instant instant = Instant.now();
        Period period = Period.between(
                Year.now().atMonth(Month.JULY).atDay(1),
                Year.now().atMonthDay(MonthDay.of(7, 17)));
        Duration duration = Duration.between(
                LocalTime.of(12, 0),
                LocalTime.now());

        System.out.println(instant); // 2023-07-17T12:55:09.086005900Z
        System.out.println(period);  // P16D (pour 16 jours)
        System.out.println(duration);// PT2H55M9.0910012S

        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println(year);      // 2023
        System.out.println(yearMonth); // 2023-07
        System.out.println(monthDay);  // --07-17

        Clock clock = Clock.fixed(
                Year.of(2023).atMonth(Month.JANUARY).atDay(1)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        System.out.println(LocalDate.now(clock)); // 2023-01-01

        Instant instant1 =
                YearMonth.of(1970, Month.JANUARY)
                        .atDay(1)
                        .atStartOfDay()
                        .toInstant(ZoneOffset.UTC);

        System.out.println(instant1); // 1970-01-01T00:00:00Z

        Instant losAngelesInstant = Instant.now(Clock.system(ZoneId.of("America/Los_Angeles"))).truncatedTo(ChronoUnit.SECONDS);

        System.out.println(losAngelesInstant); // en UTC -> un Instant n'a pas de zone

        LocalDate localParis = LocalDate.now(ZoneId.of("Europe/Paris"));
        ZonedDateTime fixedDateTime = ZonedDateTime.of(localParis, LocalTime.of(8, 0), ZoneId.of("Europe/Paris"));
        Instant fixedInstant = fixedDateTime.toInstant();

        System.out.println(fixedInstant);

        LocalDateTime fixedLocalDateTime = LocalDateTime.of(2024, 1, 1, 14, 30, 22);
        ZonedDateTime canadaZonedDateTime = fixedLocalDateTime.atZone(ZoneId.of("Canada/Atlantic"));

        System.out.println(fixedLocalDateTime); // 2024-01-01T14:30:22
        System.out.println(canadaZonedDateTime);// 2024-01-01T14:30:22-04:00[Canada/Atlantic]
        System.out.println(canadaZonedDateTime.toLocalDateTime());// 2024-01-01T14:30:22

        System.out.println(instant);                                                               // 2024-01-02T17:15:42.203487900Z
        System.out.println(instant.atZone(ZoneId.of("Europe/Paris")));                     // 2024-01-02T17:15:42.203487900+01:00[Europe/Paris]
        System.out.println(instant.atZone(ZoneId.of("Europe/Paris")).toLocalDateTime());   // 2024-01-02T17:15:42.203487900
        System.out.println(instant.atZone(ZoneId.of("Canada/Atlantic")));                  // 2024-01-02T12:15:42.203487900-04:00[Canada/Atlantic]
        System.out.println(instant.atZone(ZoneId.of("Canada/Atlantic")).toLocalDateTime());// 2024-01-02T12:15:42.203487900

    }
}

public class Lab03 {
    public static void main(String[] args) {
        System.out.println("Wykorzystanie konstruktorów i statycznych metod fabrycznych:");
        Time t1 = new Time();
        System.out.println(t1); // 0:00:00:00
        Time t2 = new Time(0, 13, 55, 49);
        System.out.println(t2); // 0:13:55:49
        Time t3 = Time.timeOf("2:01:51:34");
        System.out.println(t3); // 2:01:51:34
        t1 = Time.copyOf(t3);
        System.out.println(t1); // 2:01:51:34
        System.out.println();

        System.out.println("Stałe pola typu int:");
        System.out.println("Time.SECONDS_PER_MINUTE = " + Time.SECONDS_PER_MINUTE); // Time.SECONDS_PER_MINUTE = 60
        System.out.println("Time.MINUTES_PER_HOUR = " + Time.MINUTES_PER_HOUR); // Time.MINUTES_PER_HOUR = 60
        System.out.println("Time.HOURS_PER_DAY = " + Time.HOURS_PER_DAY); // Time.HOURS_PER_DAY = 24
        System.out.println();

        System.out.println("Stałe pola typu Time:");
        System.out.println("Time.ZERO = " + Time.ZERO); // Time.ZERO = 0:00:00:00
        System.out.println("Time.ONE_SECOND = " + Time.ONE_SECOND); // Time.ONE_SECOND = 0:00:00:01
        System.out.println("Time.ONE_MINUTE = " + Time.ONE_MINUTE); // Time.ONE_MINUTE = 0:00:01:00
        System.out.println("Time.ONE_HOUR = " + Time.ONE_HOUR); // Time.ONE_HOUR = 0:01:00:00
        System.out.println("Time.ONE_DAY = " + Time.ONE_DAY); // Time.ONE_DAY = 1:00:00:00
        System.out.println("Time.ONE_YEAR = " + Time.ONE_YEAR); // Time.ONE_YEAR = 365:00:00:00
        System.out.println();

        System.out.println("Wykorzystanie metod-mutatorów:");
        t3.addSeconds(79706);
        System.out.println(t3); // 3:00:00:00
        t3.addMinutes(3022);
        System.out.println(t3); // 5:02:22:00
        t3.addHours(24);
        System.out.println(t3); // 6:02:22:00
        t3.addDays(183);
        System.out.println(t3); // 189:02:22:00
        t3.setDays(1);
        t3.setHours(23);
        t3.setMinutes(59);
        t3.setSeconds(58);
        System.out.println(t3); // 1:23:59:58
        t3.setDays(-2); // Błędna liczba dni do ustawienia: -2
        t3.setHours(-1); // Błędna liczba godzin do ustawienia: -1
        t3.setHours(24); // Błędna liczba godzin do ustawienia: 24
        t3.setMinutes(-15); // Błędna liczba minut do ustawienia: -15
        t3.setMinutes(60); // Błędna liczba minut do ustawienia: 60
        t3.setSeconds(-152); // Błędna liczba sekund do ustawienia: -152
        t3.setSeconds(152); // Błędna liczba sekund do ustawienia: 152
        System.out.println(t3); // 1:23:59:58
        System.out.println();

        System.out.println("Wykorzystanie metod-akcesorów:");
        System.out.println("t3.getDays() = " + t3.getDays()); // t3.getDays() = 1
        System.out.println("t3.getHours() = " + t3.getHours()); // t3.getHours() = 23
        System.out.println("t3.getMinutes() = " + t3.getMinutes()); // t3.getMinutes() = 59
        System.out.println("t3.getSeconds() = " + t3.getSeconds()); // t3.getSeconds() = 59
        System.out.println("t1 + t2 = " + Time.plusTime(t1, t2)); // t1 + t2 = 2:15:47:23
        System.out.println("t1 * 2 = " + Time.times(t1, 2)); // t1 * 2 = 4:03:43:08
        System.out.println("t1 * 60 = " + Time.times(t1, 60)); // t1 * 60 = 124:15:34:00
        System.out.println();

        System.out.println("Metoda equals:");
        System.out.println("t1.equals(t1) = " + t1.equals(t1)); // t1.equals(t1) = true
        System.out.println("t1.equals(null) = " + t1.equals(null)); // t1.equals(null) = false
        System.out.println("t1.equals(\"błędny obiekt\") = " + t1.equals("błędny obiekt")); // t1.equals("błędny obiekt") = false
        System.out.println("t1.equals(t2) = " + t1.equals(t2)); // t1.equals(t2) = false
        t3 = new Time(2, 01, 51, 34);
        System.out.println("t1.equals(t3) = " + t1.equals(t3)); // t1.equals(t3) = true
        t3.addDays(1);
        System.out.println("t1.equals(t3) = " + t1.equals(t3)); // t1.equals(t3) = false
        System.out.println();
    }
}
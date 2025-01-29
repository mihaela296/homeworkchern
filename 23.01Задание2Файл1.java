import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

class DateTimeTasks {

    public static void main(String[] args) {
        // 1. Основы LocalDate и LocalTime
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущая дата и время: " + currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " " + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        // 2. Сравнение дат
        System.out.println(compareDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));

        // 3. Сколько дней до Нового года?
        System.out.println("Дней до Нового года: " + daysUntilNewYear());

        // 4. Проверка високосного года
        System.out.println("2025 год високосный? " + isLeapYear(2025));

        // 5. Подсчет выходных за месяц
        System.out.println("Выходные в январе 2025: " + countWeekends(1, 2025));

        // 6. Расчет времени выполнения метода
        measureExecutionTime(() -> {
            for (int i = 0; i < 1_000_000; i++);
        });

        // 7. Форматирование и парсинг даты
        System.out.println("Дата через 10 дней: " + formatDateString("01-01-2025"));

        // 8. Конвертация между часовыми поясами
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("Время в Москве: " + convertTimeZone(utcTime, "Europe/Moscow"));

        // 9. Вычисление возраста по дате рождения
        System.out.println("Возраст: " + calculateAge(LocalDate.of(2006, 7, 29)));

        // 10. Создание календаря на месяц
        printMonthCalendar(1, 2025);

        // 11. Генерация случайной даты в диапазоне
        System.out.println("Случайная дата: " + generateRandomDate(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31)));

        // 12. Расчет времени до заданной даты
        System.out.println("Время до события: " + timeUntilEvent(LocalDateTime.of(2025, 12, 31, 23, 59)));

        // 13. Вычисление количества рабочих часов
        System.out.println("Рабочие часы: " + calculateWorkingHours(LocalDateTime.of(2024, 1, 1, 9, 0), LocalDateTime.of(2024, 1, 1, 17, 0)));

        // 14. Конвертация даты в строку с учетом локали
        System.out.println("Дата с учетом локали: " + formatDateWithLocale(LocalDate.now(), Locale.forLanguageTag("ru")));

        // 15. Определение дня недели по дате
        System.out.println("День недели: " + getDayOfWeekInRussian(LocalDate.now()));
    }

    // Метод для сравнения дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isEqual(date2)) return "Даты равны.";
        return date1.isBefore(date2) ? "Первая дата меньше." : "Первая дата больше.";
    }

    // Метод для определения количества дней до Нового года
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

    // Метод для проверки високосного года
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    // Метод для подсчета выходных за месяц
    public static int countWeekends(int month, int year) {
        int weekends = 0;
        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getMonthValue() == month) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends++;
            }
            date = date.plusDays(1);
        }
        return weekends;
    }

    // Метод для измерения времени выполнения другого метода
    public static void measureExecutionTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) / 1_000_000 + " мс");
    }

    // Метод для форматирования и парсинга даты
    public static String formatDateString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        date = date.plusDays(10);
        return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    // Метод для конвертации между часовыми поясами
    public static ZonedDateTime convertTimeZone(ZonedDateTime dateTime, String zoneId) {
        return dateTime.withZoneSameInstant(ZoneId.of(zoneId));
    }

    // Метод для вычисления возраста по дате рождения
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Метод для создания календаря на месяц
    public static void printMonthCalendar(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getMonthValue() == month) {
            String dayType = (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) ? "Выходной" : "Рабочий";
            System.out.println(date + " - " + dayType);
            date = date.plusDays(1);
        }
    }

    // Метод для генерации случайной даты в диапазоне
    public static LocalDate generateRandomDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    // Метод для расчета времени до заданной даты
    public static String timeUntilEvent(LocalDateTime eventDateTime) {
        Duration duration = Duration.between(LocalDateTime.now(), eventDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return hours + " часов, " + minutes + " минут и " + seconds + " секунд";
    }

    // Метод для вычисления количества рабочих часов
    public static double calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) return 0;

        double workingHours = 0;

        while (start.isBefore(end)) {
            if (start.getDayOfWeek() != DayOfWeek.SATURDAY && start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingHours += Math.min(8 - start.getHour(), end.getHour() - start.getHour());
            }
            start = start.plusDays(1).withHour(0).withMinute(0);
        }

        return workingHours;
    }

    // Метод для конвертации даты в строку с учетом локали
    public static String formatDateWithLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        return date.format(formatter);
    }

    // Метод для определения дня недели по дате
    public static String getDayOfWeekInRussian(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case MONDAY: return "Понедельник";
            case TUESDAY: return "Вторник";
            case WEDNESDAY: return "Среда";
            case THURSDAY: return "Четверг";
            case FRIDAY: return "Пятница";
            case SATURDAY: return "Суббота";
            case SUNDAY: return "Воскресенье";
            default: return "";
        }
    }
}
import java.util.ArrayList;
import java.util.List;

// Задача 1: Класс базы данных (Singleton)
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Приватный конструктор
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            System.out.println("Создано подключение к базе данных.");
        }
        return instance;
    }
}

// Задача 2: Класс логирования (Singleton)
class Logger {
    private static Logger instance;
    private List<String> logMessages;

    private Logger() {
        logMessages = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logMessages.add(message);
    }

    public void printLogs() {
        System.out.println("Логи:");
        for (String message : logMessages) {
            System.out.println(message);
        }
    }
}

// Задача 3: Enum для статусов заказа
enum OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, CANCELLED
}

// Класс заказа
class Order {
    private OrderStatus status;

    public Order() {
        this.status = OrderStatus.NEW;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus newStatus) {
        if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
            System.out.println("Нельзя отменить доставленный заказ.");
            return;
        }
        this.status = newStatus;
        Logger.getInstance().log("Статус заказа изменен на: " + newStatus);
    }
}

// Задача 4: Enum для времен года
enum Season {
    WINTER, SPRING, SUMMER, AUTUMN
}

// Класс для работы с сезонами
class SeasonUtil {
    public static String getSeasonName(Season season) {
        switch (season) {
            case WINTER:
                return "Зима";
            case SPRING:
                return "Весна";
            case SUMMER:
                return "Лето";
            case AUTUMN:
                return "Осень";
            default:
                return "Неизвестный сезон";
        }
    }
}

// Основной класс
class Main {
    public static void main(String[] args) {
        // Задача 1: Проверка Singleton для базы данных
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("db1 и db2 ссылаются на один и тот же объект: " + (db1 == db2));

        // Задача 2: Логирование
        Logger logger = Logger.getInstance();
        logger.log("Первое сообщение лога.");
        logger.log("Второе сообщение лога.");
        logger.printLogs();

        // Задача 3: Работа со статусами заказа
        Order order = new Order();
        System.out.println("Текущий статус заказа: " + order.getStatus());
        order.setStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Текущий статус заказа: " + order.getStatus());
        order.setStatus(OrderStatus.DELIVERED);
        System.out.println("Текущий статус заказа: " + order.getStatus());
        order.setStatus(OrderStatus.CANCELLED); // Попытка отмены доставленного заказа
        System.out.println("Текущий статус заказа: " + order.getStatus());

        // Задача 4: Работа с сезонами
        Season season = Season.WINTER;
        System.out.println("Название сезона: " + SeasonUtil.getSeasonName(season));
    }
}
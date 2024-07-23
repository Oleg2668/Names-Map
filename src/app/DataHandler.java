package app;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

  /*  Створення об'єкта за допомогою new DataRepository()
  і присвоєння його змінній типу Map<Integer, String> неможливе
   через те, що DataRepository не є класом, який реалізує
    інтерфейс Map. DataRepository - це клас, який містить метод getData(),
     що повертає об'єкт типу Map<Integer, String>.
   */

    private final Map<Integer, String> map;

    // Конструктор, який ініціалізує карту
    public DataHandler() {
        DataRepository repository = new DataRepository();
        this.map = repository.getData();
    }

    // Метод формує виведення нумерованого переліку імен
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(0);
        map.forEach((id, name) ->
                sb.append(String.format("%d) %d, %s%n",
                        count.incrementAndGet(),id, name)
        ));
        return "All NAMES:\n" + sb;
    }

    // Метод формує виведення імені за певним id
    public String getById(int id ) {
        if (map.containsKey(id)) {
            return "NAME: id " + id + ", " +
                    map.containsKey(id);
        } else return "No data!";
    }
}
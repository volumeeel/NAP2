import java.util.Scanner;

public class Main {

    private static final String ADMIN_PASSWORD = "admin123";
    private static final Scanner scanner = new Scanner(System.in);
    private static final MusicManager manager = new MusicManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== МУЗЫКАЛЬНАЯ КОЛЛЕКЦИЯ ===");
            System.out.println("1. Добавить песню");
            System.out.println("2. Добавить альбом");
            System.out.println("3. Добавить подкаст");
            System.out.println("4. Просмотреть коллекцию");
            System.out.println("5. Поиск по названию");
            System.out.println("6. Поиск по исполнителю");
            System.out.println("7. Фильтр по типу");
            System.out.println("8. Фильтр по длительности");
            System.out.println("9. Сортировка по названию");
            System.out.println("10. Сортировка по исполнителю");
            System.out.println("11. Статистика");
            System.out.println("12. Сохранить");
            System.out.println("13. Загрузить");
            System.out.println("14. Меню администратора");
            System.out.println("0. Выход");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addSong();
                case "2" -> addAlbum();
                case "3" -> addPodcast();
                case "4" -> manager.printAll();
                case "5" -> {
                    System.out.print("Название: ");
                    manager.searchByTitle(scanner.nextLine());
                }
                case "6" -> {
                    System.out.print("Исполнитель: ");
                    manager.searchByArtist(scanner.nextLine());
                }
                case "7" -> {
                    System.out.print("Тип (Song/Album/Podcast): ");
                    manager.filterByType(scanner.nextLine());
                }
                case "8" -> {
                    System.out.print("Максимальная длительность (сек): ");
                    manager.filterByDuration(Integer.parseInt(scanner.nextLine()));
                }
                case "9"  -> manager.sortByTitle();
                case "10" -> manager.sortByArtist();
                case "11" -> manager.statistics();
                case "12" -> manager.save();
                case "13" -> manager.load();
                case "14" -> adminMenu();
                case "0"  -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void addSong() {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Исполнитель: ");
        String artist = scanner.nextLine();
        System.out.print("Длительность (сек): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Жанр: ");
        String genre = scanner.nextLine();
        manager.add(new Song(title, artist, duration, genre));
    }

    private static void addAlbum() {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Исполнитель: ");
        String artist = scanner.nextLine();
        System.out.print("Длительность (сек): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Количество треков: ");
        int count = Integer.parseInt(scanner.nextLine());
        manager.add(new Album(title, artist, duration, count));
    }

    private static void addPodcast() {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Канал: ");
        String artist = scanner.nextLine();
        System.out.print("Длительность (сек): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Ведущий: ");
        String host = scanner.nextLine();
        manager.add(new Podcast(title, artist, duration, host));
    }

    private static void adminMenu() {
        System.out.print("Пароль: ");
        String pass = scanner.nextLine();
        if (!pass.equals(ADMIN_PASSWORD)) {
            System.out.println("Неверный пароль.");
            return;
        }

        System.out.println("--- Меню администратора ---");
        System.out.println("1. Удалить запись");
        System.out.println("2. Редактировать запись");
        System.out.print("> ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                manager.printAll();
                System.out.print("Индекс для удаления: ");
                manager.remove(Integer.parseInt(scanner.nextLine()));
            }
            case "2" -> {
                manager.printAll();
                System.out.print("Индекс для редактирования: ");
                int idx = Integer.parseInt(scanner.nextLine());
                System.out.print("Новый исполнитель: ");
                String artist = scanner.nextLine();
                System.out.print("Новое название: ");
                String title = scanner.nextLine();
                manager.edit(idx, artist, title);
            }
            default -> System.out.println("Неверный выбор.");
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MusicManager {
    private List<Track> tracks = new ArrayList<>();
    private static final String FILE = "music.dat";

    // 1
    public void add(Track track) {
        tracks.add(track);
        System.out.println("Добавлено: " + track);
    }

    // 2
    public void remove(int index) {
        if (index < 0 || index >= tracks.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        System.out.println("Удалено: " + tracks.remove(index));
    }

    // 3
    public void edit(int index, String newArtist, String newTitle) {
        if (index < 0 || index >= tracks.size()) {
            System.out.println("Неверный индекс.");
            return;
        }
        Track t = tracks.get(index);
        t.setArtist(newArtist);
        t.setTitle(newTitle);
        System.out.println("Обновлено: " + t);
    }

    // 4
    public void printAll() {
        if (tracks.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println(i + ". " + tracks.get(i));
        }
    }

    // 5
    public void searchByTitle(String query) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.getTitle().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("Ничего не найдено.");
    }

    // 6
    public void searchByArtist(String query) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.getArtist().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("Ничего не найдено.");
    }

    // 7
    public void filterByType(String type) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.getType().equalsIgnoreCase(type)) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("Ничего не найдено.");
    }

    // 8
    public void filterByDuration(int maxSeconds) {
        boolean found = false;
        for (Track t : tracks) {
            if (t.getDuration() <= maxSeconds) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) System.out.println("Ничего не найдено.");
    }

    // 9
    public void sortByTitle() {
        tracks.sort(Comparator.comparing(Track::getTitle));
        System.out.println("Отсортировано по названию.");
        printAll();
    }

    // 10
    public void sortByArtist() {
        tracks.sort(Comparator.comparing(Track::getArtist));
        System.out.println("Отсортировано по исполнителю.");
        printAll();
    }

    // 11
    public void statistics() {
        int songs = 0, albums = 0, podcasts = 0;
        for (Track t : tracks) {
            switch (t.getType()) {
                case "Song"    -> songs++;
                case "Album"   -> albums++;
                case "Podcast" -> podcasts++;
            }
        }
        System.out.println("Всего: " + tracks.size());
        System.out.println("Песни: " + songs);
        System.out.println("Альбомы: " + albums);
        System.out.println("Подкасты: " + podcasts);
    }

    // 12
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(tracks);
            System.out.println("Данные сохранены в " + FILE);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    // 13
    @SuppressWarnings("unchecked")
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            tracks = (List<Track>) ois.readObject();
            System.out.println("Данные загружены. Записей: " + tracks.size());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
        }
    }

    public int size() { return tracks.size(); }
}
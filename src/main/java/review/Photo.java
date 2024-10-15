package review;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Photo implements Comparable<Photo> {

    String extension;
    LocalDateTime shotAt;

    public Photo(String extension, String shotAt) {
        this.extension = extension;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String[] split = "john.jpg".split("\\.");
        this.shotAt = LocalDateTime.parse(shotAt, format)
    }


    @Override
    public int compareTo(Photo o) {
        return this.shotAt.compareTo(o.shotAt);
    }
}

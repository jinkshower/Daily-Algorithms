package review;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class leetcode2215 {

    public static void main(String[] args) {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("A", "jpg",
                LocalDateTime.parse("2021-07-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 1));
        photos.add(new Photo("B", "jpg",
                LocalDateTime.parse("2021-07-01 00:00:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 2));
        photos.add(new Photo("C", "jpg",
                LocalDateTime.parse("2021-07-01 00:00:02", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 3));

        Map<String, List<Photo>> grouped = photos.stream().collect(Collectors.groupingBy(p -> p.city));

        for (List<Photo> value : grouped.values()) {
            value.sort(Photo::compareTo);
            int size = value.size();
            int digits = String.valueOf(size).length();
            String format = "%0" + digits + "d";

            for (int i = 0; i < size; i++) {
                Photo photo = value.get(i);
                photo.newName = photo.city + String.format(format, i + 1) + "." + photo.extension;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Photo photo : photos) {
            answer.append(photo.newName).append("\n");
        }
        System.out.println(answer.toString());
        answer.deleteCharAt(answer.length() - 1);
    }

    static class Photo implements Comparable<Photo> {
        String city;
        String extension;
        String newName;
        LocalDateTime shotAt;
        int originalIndex;

        public Photo(String city, String extension, LocalDateTime shotAt, int originalIndex) {
            this.city = city;
            this.extension = extension;
            this.shotAt = shotAt;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Photo o) {
            return this.shotAt.compareTo(o.shotAt);
        }

        @Override
        public String toString() {
            return "Photo{" +
                    "city='" + city + '\'' +
                    ", extension='" + extension + '\'' +
                    ", newName='" + newName + '\'' +
                    ", shotAt=" + shotAt +
                    ", originalIndex=" + originalIndex +
                    '}';
        }
    }
}

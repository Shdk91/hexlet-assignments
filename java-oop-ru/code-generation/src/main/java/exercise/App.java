package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) {
        Path fullPath = path.toAbsolutePath().normalize();
        String content = car.serialize();
        try {
            Files.writeString(fullPath, content, StandardOpenOption.WRITE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) {
        Path fullPath = path.toAbsolutePath().normalize();
        String content = "";
        try {
            content = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Car car = Car.unserialize(content);
        return car;
    }


}
// END

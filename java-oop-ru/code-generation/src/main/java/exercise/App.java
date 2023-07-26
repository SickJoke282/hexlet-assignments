package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        String jsonRepresentation = car.serialize();
        try {
            Files.writeString(path, jsonRepresentation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Car extract(Path path) {
        try {
            return Car.unserialize(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END

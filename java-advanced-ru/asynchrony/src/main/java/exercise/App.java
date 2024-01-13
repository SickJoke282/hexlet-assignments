package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

class App {

    // BEGIN
    public static CompletableFuture<Long> getDirectorySize(String directoryPath) {
        return CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(directoryPath);
            try {
                return Files.walk(path, 1)
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (IOException e) {
                                throw new RuntimeException();
                            }
                        }).sum();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static CompletableFuture<String> unionFiles(String sourceFilename1, String sourceFilename2, String resultFilename) {
        CompletableFuture<String> futureSource1 = CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(sourceFilename1);
            try {
                return Files.readString(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            throw new IllegalStateException();
        });
        CompletableFuture<String> futureSource2 = CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(sourceFilename2);
            try {
                return Files.readString(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(Throwable::getMessage);
        return futureSource1.thenCombine(futureSource2, (content1, content2) -> {
            Path path = Paths.get(resultFilename);
            String fullContent = content1 + content2;
            try {
                Files.write(path, fullContent.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return fullContent;
        }).exceptionally(Throwable::getMessage);
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        System.out.println(unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/Hello.txt").get());
        // END
    }
}


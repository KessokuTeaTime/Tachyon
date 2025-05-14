package band.kessoku.tachyon.common.utils;

import club.someoneice.json.node.JsonNode;
import club.someoneice.json.processor.JsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonWriter {

    public static void writeToPath(Path path, JsonNode<?> content) {
        try {
            tryWriteToPath(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void tryWriteToPath(Path path, JsonNode<?> content) throws IOException {
        File target = path.toFile().getParentFile();
        if ((!target.exists() || !target.isDirectory()) && !target.getParentFile().mkdirs()) {
            throw new IOException("Can't be create the path %s!".formatted(target.getPath()));
        }

        String result = JsonBuilder.prettyPrint(content);
        Files.write(path, result.getBytes());
    }
}

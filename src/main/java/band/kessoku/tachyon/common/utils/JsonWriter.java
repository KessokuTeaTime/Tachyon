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
        File target = path.toFile();
        if (!target.exists() || !target.isFile()) target.getParentFile().mkdirs();
        String result = JsonBuilder.prettyPrint(content);
        OutputStream outputStream = Files.newOutputStream(path);
        outputStream.write(result.getBytes());
        outputStream.close();
    }

}

package band.kessoku.tachyon.common;

import band.kessoku.tachyon.api.export.Data;
import band.kessoku.tachyon.api.export.Exportable;
import band.kessoku.tachyon.common.utils.JsonWriter;
import club.someoneice.json.node.ArrayNode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class BaseExporter<T extends Data> implements Exportable<T> {

    private final String type;
    private final Collection<T> exportedData;

    public BaseExporter(String type) {
        this.type = type;
        this.exportedData = new ArrayList<>();
    }

    public void addExportedData(T data) {
        if (data != null) {
            exportedData.add(data);
        }
    }

    public void addExportedData(Collection<T> data) {
        if (data != null) {
            exportedData.addAll(data);
        }
    }

    // Fixme 堆污染可能不是一个好的主意，即便这很难发生问题。
    public void addExportedData(T... data) {
        if (data != null) {
            exportedData.addAll(Arrays.stream(data).toList());
        }
    }

    public void serialize(Path filePath) {
        ArrayNode array = new ArrayNode();
        exportedData.forEach(data -> {
            if (data != null) {
                data.serialize(array);
            }
        });
        JsonWriter.writeToPath(filePath.resolve(type + ".json"), array);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Collection<T> getExportedData() {
        return exportedData;
    }
}

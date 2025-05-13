package band.kessoku.tachyon;

import band.kessoku.tachyon.common.ModHolder;
import band.kessoku.tachyon.common.data.EffectData;
import band.kessoku.tachyon.common.data.EntityData;
import band.kessoku.tachyon.common.data.ItemData;

import java.nio.file.Path;
import java.util.List;

public class Tachyon {

    public static void main(String[] args) {
        ModHolder modHolder = new ModHolder("example_mod");
        modHolder.items.addExportedData(new ItemData(
                "example_item",
                "示例",
                "Example Item",
                1, 1, List.of("#minecraft:example_tag"),
                "Test", "TEST_LARGE", "TEST_SMALL"
        ));
        modHolder.effects.addExportedData(new EffectData(
                "example_effect",
                "示例",
                "Example Effect",
                "TEST_LARGE", "TEST_SMALL"
        ));
        modHolder.entities.addExportedData(new EntityData(
                "example_entity",
                "示例",
                "Example Entity",
                "TEST_LARGE", "TEST_SMALL"
        ));
        modHolder.export(Path.of("run/exported"));
    }

}

package band.kessoku.tachyon.common;

import band.kessoku.tachyon.common.data.EffectData;
import band.kessoku.tachyon.common.data.EntityData;
import band.kessoku.tachyon.common.data.ItemData;

import java.nio.file.Path;

public class ModHolder {
    private final String modId;

    public final BaseExporter<ItemData> items;
    public final BaseExporter<EntityData> entities;
    public final BaseExporter<EffectData> effects;

    public ModHolder(String modId) {
        this.modId = modId;
        this.items = new BaseExporter<>("items");
        this.entities = new BaseExporter<>("entities");
        this.effects = new BaseExporter<>("effects");
    }

    public void export(Path path) {
        path = path.resolve(modId);

        items.serialize(path);
        entities.serialize(path);
        effects.serialize(path);
    }

    public String getModId() {
        return modId;
    }
}

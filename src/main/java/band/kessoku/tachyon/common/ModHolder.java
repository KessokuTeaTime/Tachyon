package band.kessoku.tachyon.common;

import band.kessoku.tachyon.common.data.EffectData;
import band.kessoku.tachyon.common.data.EntityData;
import band.kessoku.tachyon.common.data.ItemData;

public class ModHolder {

    private final String modId;

    public BaseExporter<ItemData> items;
    public BaseExporter<EntityData> entities;
    public BaseExporter<EffectData> effects;

    public ModHolder(String modId) {
        this.modId = modId;
        this.items = new BaseExporter<>("items");
        this.entities = new BaseExporter<>("entities");
        this.effects = new BaseExporter<>("effects");
    }

    public String getModId() {
        return modId;
    }
}

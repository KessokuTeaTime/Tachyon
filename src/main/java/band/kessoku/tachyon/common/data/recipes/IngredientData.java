package band.kessoku.tachyon.common.data.recipes;

import club.someoneice.json.node.MapNode;
import org.jetbrains.annotations.Nullable;

public record IngredientData(
        Type type,
        String id,
        int count,
        @Nullable String nbt
) {
    public MapNode serialize() {
        MapNode itself = new MapNode();
        itself.put(type.getName(), id);
        itself.put("count", count);
        return itself;
    }

    public enum Type {
        ITEM,
        TAG;

        public String getName() {
            return this.name().toLowerCase();
        }
    }
}

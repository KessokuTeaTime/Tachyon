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
        switch (type) {
            case ITEM -> itself.put("item", id);
            case TAG -> itself.put("tag", id);
        }
        itself.put("count", count);
        return itself;
    }

    public enum Type {
        ITEM("item"),
        TAG("tag");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

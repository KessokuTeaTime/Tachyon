package band.kessoku.tachyon.common.data.recipes;

import band.kessoku.tachyon.api.export.Data;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.MapNode;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public record RecipeData(
        String type,
        String id,
        Map<String, IngredientData> ingredients,
        Map<String, IngredientData> results
) implements Data {
    @Override
    public void serialize(ArrayNode arrayNode) {
        // TODO
    }
}

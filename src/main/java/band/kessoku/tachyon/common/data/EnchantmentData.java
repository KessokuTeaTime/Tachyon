package band.kessoku.tachyon.common.data;

import band.kessoku.tachyon.api.export.Data;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.MapNode;
import club.someoneice.json.node.StringNode;

import java.util.List;

public record EnchantmentData(
        String id,
        String name,
        String subName,
        String description,
        int maxLevel,
        int weight,
        List<String> slots
) implements Data {

    private ArrayNode toSlotsArray() {
        ArrayNode arrayNode = new ArrayNode();
        slots.stream().map(StringNode::new).forEach(arrayNode::add);
        return arrayNode;
    }

    @Override
    public void serialize(ArrayNode arrayNode) {
        MapNode itself = new MapNode();
        itself.put("registerName", id);
        itself.put("name", name);
        itself.put("englishName", subName);
        itself.put("desc", description);
        itself.put("maxLevel", maxLevel);
        itself.put("weight", weight);
        itself.put("slots", toSlotsArray());
        arrayNode.add(itself);
    }
}

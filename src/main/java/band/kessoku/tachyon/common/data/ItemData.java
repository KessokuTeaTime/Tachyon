package band.kessoku.tachyon.common.data;

import band.kessoku.tachyon.api.export.Data;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.MapNode;
import club.someoneice.json.node.StringNode;

import java.util.List;

/**
 * 物品数据，格式来自 IRR
 * @param id 注册名
 * @param name 中文名称（主要名称）
 * @param subName 英文名称（副名称）
 * @param maxCount 堆叠上限
 * @param maxDamage 耐久上限
 * @param tagList 物品标签列表
 * @param itemGroupName 物品组名称
 * @param largeIcon 大图标
 * @param smallIcon 小图标
 */

public record ItemData(
        String id,
        String name,
        String subName,
        int maxCount,
        int maxDamage,
        List<String> tagList,
        String itemGroupName,
        String largeIcon,
        String smallIcon
) implements Data {

    private ArrayNode toTagArray() {
        ArrayNode arrayNode = new ArrayNode();
        tagList.stream().map(StringNode::new).forEach(arrayNode::add);
        return arrayNode;
    }

    @Override
    public void serialize(ArrayNode arrayNode) {
        MapNode itself = new MapNode();
        itself.put("registerName", id);
        itself.put("name", name);
        itself.put("englishName", subName);
        itself.put("maxStackSize", maxCount);
        itself.put("maxDurability", maxDamage);
        itself.put("TagList", toTagArray());
        itself.put("CreativeTabName", itemGroupName);
        itself.put("largeIcon", largeIcon);
        itself.put("smallIcon", smallIcon);
        arrayNode.add(itself);
    }

}

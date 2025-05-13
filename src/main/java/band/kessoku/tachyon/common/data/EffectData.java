package band.kessoku.tachyon.common.data;

import band.kessoku.tachyon.api.export.Data;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.MapNode;

/**
 * 药水效果，格式来自Effect Export
 * @param id 注册名
 * @param name 中文名（主名称）
 * @param subName 英文名（副名称）
 * @param largeIcon 大图标
 * @param smallIcon 小图标
 */
public record EffectData(
        String id,
        String name,
        String subName,
        String largeIcon,
        String smallIcon
) implements Data {
    @Override
    public void serialize(ArrayNode arrayNode) {
        MapNode itself = new MapNode();
        itself.put("registerName", id);
        itself.put("name", name);
        itself.put("englishname", subName);
        itself.put("largeIcon", largeIcon);
        itself.put("smallIcon", smallIcon);
        arrayNode.add(itself);
    }
}

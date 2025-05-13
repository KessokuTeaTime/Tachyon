package band.kessoku.tachyon.common.data;

import band.kessoku.tachyon.api.export.Data;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.MapNode;

/**
 * 实体数据，格式来自IRR
 * @param id 注册名
 * @param name 实体名称
 * @param subName 实体英文名称
 * @param largeIcon 大图标
 * @param smallIcon 小图标 <p/>
 * TODO: animationIcon 动图标
 */
public record EntityData(
        String id,
        String name,
        String subName,
        String largeIcon,
        String smallIcon
        //String animationIcon
) implements Data {
    @Override
    public void serialize(ArrayNode arrayNode) {
        MapNode itself = new MapNode();
        itself.put("registerName", id);
        itself.put("name", name);
        itself.put("englishName", subName);
        itself.put("largeIcon", largeIcon);
        itself.put("smallIcon", smallIcon);
        // TODO itself.put("animationIcon", animationIcon);
        arrayNode.add(itself);
    }
}

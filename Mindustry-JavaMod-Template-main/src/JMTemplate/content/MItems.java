package JMTemplate.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class MItems implements ContentList {
    public static Item stone;
    @Override
    public void load() {
        stone = new Item("stone", Color.valueOf("888c8d")){{
            cost = 50;
        }};
    }
}
package JMTemplate.content;

import mindustry.ctype.*;
import JMTemplate.content.*;

public class TestMod implements ContentList {
    private final ContentList[] contents = {new MItems()};
    public void load() {
        for(ContentList list : contents){
            list.load();
        }
    }

    }

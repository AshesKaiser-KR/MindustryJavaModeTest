package JMTemplate.io;

import arc.Core;
import arc.Net;
import arc.util.serialization.Jval;

import static JMTemplate.Vars.*;

public class Updater {
    private static volatile String tempString;

    public int versionCheck(){
        Core.net.httpGet("https://raw.githubusercontent.com/" + repositoryPath + "/main/mod.json", res -> {
            if (res.getStatus() == Net.HttpStatus.OK) {
                tempString = res.getResultAsString();
            }} , error -> {});

        while (tempString == null){}
        Jval jval = Jval.read(tempString);
        int version = jval.getInt("version", 1);
        tempString = null;

        return version;
    }
}

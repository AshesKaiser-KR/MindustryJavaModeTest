package JMTemplate.core;

import java.io.IOException;
import JMTemplate.io.*;

import arc.Events;
import arc.util.Log;
import arc.util.serialization.Jval;
import mindustry.game.EventType.*;
import mindustry.mod.Mod;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static JMTemplate.Vars.*;
import JMTemplate.content.*;

@SuppressWarnings("unused")
public class Main extends Mod {
    public Main(){
        Events.on(ClientLoadEvent.class, e -> {
            new TestMod().load();
            onlineMode = new SocketManager().connectionCheck("www.google.com",80);
            if(onlineMode) {
                this.updateCheck();
            }
        });

        Events.on(WorldLoadEvent.class, e -> {

        });
    }

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
    }

    private void updateCheck() {
        InputStream is = getClass().getResourceAsStream("/mod.json");
        Jval jval = Jval.read(new InputStreamReader(is, StandardCharsets.UTF_8));

        int currentVersion = jval.getInt("version",1);
        Log.info(currentVersion);

        if(onlineMode) {
            int repoVersion = new Updater().versionCheck();
            if(currentVersion < repoVersion) {
                Log.info("@updater.newversion");
            } else {
                Log.info("latest");
            }
        } else {
            Log.info("@updater.notonline");
        }
    }
}

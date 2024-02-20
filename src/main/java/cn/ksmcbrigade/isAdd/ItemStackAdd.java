package cn.ksmcbrigade.isAdd;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Mod("isadd")
public class ItemStackAdd {

    public static boolean init = false;
    public static int max = 21474835;

    public ItemStackAdd() throws IOException {
        MinecraftForge.EVENT_BUS.register(this);
        init();
    }

    public static void init() throws IOException {
        if(!init){
            File file = new File("config/isAdd-config.json");
            if(!file.exists()){
                JsonObject json = new JsonObject();
                json.addProperty("max",21474835);
                Files.write(file.toPath(),json.toString().getBytes());
            }
            max = JsonParser.parseString(Files.readString(file.toPath())).getAsJsonObject().get("max").getAsInt();
            init = true;
        }
    }
}

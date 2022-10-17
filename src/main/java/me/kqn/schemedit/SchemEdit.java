package me.kqn.schemedit;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTFile;
import de.tr7zw.nbtapi.NBTListCompound;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class SchemEdit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            main();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {

    }

    public  void main() throws IOException {
        NBTFile nbtFile=new NBTFile(new File("E:\\编辑Schema\\deepdark2.schem"));
     /*   NBTCompound palette=nbtFile.getCompound("Palette");//total676entry
        HashMap<String,Integer> map=new HashMap<>();
        System.out.println(palette.getKeys());

        for(String key:palette.getKeys()){

                map.put(key,palette.getInteger(key));

        }
        for(String key:map.keySet()){
            if(key.contains("twm")){
                palette.removeKey(key);
                Integer val=map.get(key);
                String key1=key.replace("twm","minecraft");
                palette.setInteger(key1,val);
            }
        }*/
        NBTCompoundList blocks=nbtFile.getCompoundList("BlockEntities");
        for(int i=0;i<blocks.size();i++){
           NBTListCompound nbtListCompound= blocks.get(i);
           String val=nbtListCompound.getString("Id");
           if(val.contains("twm")){
               nbtListCompound.setString("Id",val.replace("twm","minecraft"));
           }

        }

        nbtFile.save();




    }
}

package me.xmao.MaoSign;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase{
	@Override
    public void onLoad() {
		getLogger().info("MaoSign Load! Author QQ: 124520547");
    }
    @Override
    public void onEnable() {
		this.getServer().getPluginManager().registerEvents((Listener)new PlayerSignListener(), (Plugin)this);
    	getLogger().info("MaoSign Enable! Author QQ: 124520547");
    }
    @Override
    public void onDisable() {
    	getLogger().info("MaoSign Disable! Author QQ: 124520547");
    }
    
}
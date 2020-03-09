package me.xmao.MaoSign;

import cn.nukkit.block.BlockSignPost;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.SignChangeEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import me.xmao.MaoPoints.Core.PlayerPoint;

public class PlayerSignListener implements Listener{
	public static String signname = "§f[§aMaoSign§f]";
	 @EventHandler
	 public void onSignChangeEvent(SignChangeEvent event) {
		if(event.getPlayer().isOp()) {
			if(event.getLine(0).equals("MaoSign")) {
				event.setLine(0, signname);
			}
		}
	 }
	 @EventHandler
	 public void onPlayerInteractEntityEvent(PlayerInteractEvent event) {
		 if(event.getBlock() instanceof BlockSignPost) {
			 BlockEntitySign sign = (BlockEntitySign) event.getBlock().getLevel().getBlockEntity((Vector3)new Position(event.getBlock().x, event.getBlock().y, event.getBlock().z));
			 if(sign.getText()[0].equals(signname)) {
				 int point = Integer.parseInt(sign.getText()[1]);
				 int itemid = Integer.parseInt(sign.getText()[2]);
				 PlayerPoint mp = new PlayerPoint(event.getPlayer().getName());
				 if(!mp.has(point)) {
					 event.getPlayer().sendMessage(signname + "§a你的点券不足!");
					 return;
				 }
				 mp.take(point);
				 event.getPlayer().sendMessage(signname + "§a已从你的账户扣除" +  point  +"点券");
				 Item item = Item.get(itemid);
				 event.getPlayer().getInventory().addItem(item);
			 }
		 }
	 }
}

package com.boyboy0710.noneedpvp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public final class Main extends JavaPlugin implements Listener  {

    public void onEnable() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("            No_Need_pvp 를러그인을 성공적으로 불러왔습니다");
        System.out.println("               플러그인 제작자ㅣ:booyboy0710");
        System.out.println("----------------------------------------------------------------------");

        getCommand("NoNeedpvp").setExecutor(new Commands()); //Executor을 등록하는 매소드
        getCommand("NoNeedpvp").setTabCompleter(new Commands()); //TabCompleter을 등록하는 매소드
    }
    @Override
    public void onDisable() {
        System.out.println("No_Need_pvp 플러그인이 비활성화 되었습니다");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(p.getName() + "님이 입장하였습니다");
        p.sendMessage("설명은 /NoNeedpvp 로 볼수 있습니다");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta wand_meta = wand.getItemMeta();
        wand.addEnchantment(Enchantment.LUCK, 10000);
        wand_meta.setDisplayName("마법사의 지팡이");
        wand_meta.setLore(Arrays.asList("엄청난 행운과 마법의 기운이 느껴진다"));
        wand.setItemMeta(wand_meta);

        ItemStack king = new ItemStack(Material.BLAZE_ROD);
        ItemMeta king_meta = king.getItemMeta();
        king_meta.setDisplayName("왕의 지팡이");
        king_meta.setLore(Arrays.asList("위엄이 넘쳐나는 사람만이 쓸수 있을것 같다"));
        king.setItemMeta(king_meta);

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() == wand) {
                Random r = new Random();
                switch (r.nextInt(3)) {
                    case 0:
                        p.sendMessage("꽃이 피어납니다");
                        p.getEyeLocation().getBlock().setType(Material.RED_TULIP);
                        break;

                    case 1:
                        p.sendMessage("마력이 부족합니다");
                        break;

                    case 2:
                        p.sendMessage("마법을 잘못걸었습니다");
                        p.getWorld().createExplosion(p.getLocation(), 5);
                        break;
                }
            }
            if (e.getItem() == king){
                p.sendMessage("위엄이 부족합니다");
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (p.getInventory().getChestplate().getType() == Material.NETHERITE_CHESTPLATE) {
            p.sendMessage("허어억 너무 무거워");
            e.setCancelled(true);
        }
    }
}

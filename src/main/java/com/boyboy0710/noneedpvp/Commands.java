package com.boyboy0710.noneedpvp;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Commands  implements TabExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

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

        if (cmd.getName().equalsIgnoreCase("NoNeedpvp")) {

            if (args[0].equalsIgnoreCase("class")) {
                if (args[1].equalsIgnoreCase("Vindicator")) {
                    p.sendMessage("직업:변명자");
                    p.sendMessage("능력:변명을 해 사람들의 시선을 끕니다");
                    p.sendMessage("싸우는 이유:변명하기위해서");
                }
                if (args[1].equalsIgnoreCase("Wizard")) {
                    p.sendMessage("직업:마법사");
                    p.sendMessage("능력:마법을 씁니다");
                    p.sendMessage("싸우는 이유:자신의 마법능력을 자랑하기 위해서");
                }
                if (args[1].equalsIgnoreCase("tanker")) {
                    p.sendMessage("직업:탱커");
                    p.sendMessage("능력:어마어마한 채력으로 상대를 압도합니다");
                    p.sendMessage("싸우는 이유:자신이 얼마나 튼튼한가를 자랑하려고");
                }
                if (args[1].equalsIgnoreCase("king")) {
                    p.sendMessage("직업:왕");
                    p.sendMessage("능력:왕의 기운이 담긴 지팡이로 공격합니다");
                    p.sendMessage("싸우는 이유:왕의 위엄이 어떤것인가를 보여주기 위해");
                }
            }
            if (args[0].equalsIgnoreCase("pick_class")) {
                if (args[1].equalsIgnoreCase("Vindicator")) {
                    p.getInventory().clear();
                    p.sendMessage("변명하세요!");
                }
                if (args[1].equalsIgnoreCase("Wizard")) {
                    p.getInventory().clear();
                    p.getInventory().addItem(wand);
                }
                if (args[1].equalsIgnoreCase("tanker")) {
                    p.getInventory().clear();
                    p.getInventory().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
                    p.getInventory().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
                    p.getInventory().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
                    p.getInventory().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
                    p.sendMessage("너무 무거워");
                }
                if (args[1].equalsIgnoreCase("king")) {
                    p.getInventory().clear();
                    p.getInventory().addItem(king);
                }
            }
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equals("NoNeedpvp")) {
            if (args.length == 1) {
                return Arrays.asList("class", "pick_class");
            }
            else if(args.length == 2) {
                if (args[0].equals("class")){
                    return  Arrays.asList("Vindicator","Wizard","tanker","king");
                }
                else if (args[0].equals("pick_class")){
                    return  Arrays.asList("Vindicator","Wizard","tanker","king");
                }
            }
        }
        return null;
    }
}

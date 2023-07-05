package dev.oglis22.vorzeigeplugin.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material){
    this.itemStack = new ItemStack(material);
    this.itemMeta = this.itemStack.getItemMeta();
    }
    public ItemBuilder setDisplayname(String name){
        this.itemMeta.setDisplayName(name);
        return this;
    }
    public ItemBuilder setLore(List<String> list) {
        this.itemMeta.setLore(list);
        return this;
    }
    public ItemStack build(){
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}

///////////////////////////////
// Class coded by Pandadoxo  //
// on 21.04.2022 at 17:42     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.guiapi.example.howto;

import de.pandadoxo.guiapi.builder.GuiItemBuilder;
import de.pandadoxo.guiapi.enums.GuiColor;
import de.pandadoxo.guiapi.result.GuiItem;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class Example_GuiItem {

    /**
     * Create the simplest GuiItem
     *
     * @param type The material of the item
     * @return A GuiItem with the given type
     */
    public GuiItem createExampleItem(Material type) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setType(type);

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem with a name
     *
     * @param name The name of the item
     * @param type The material of the item
     * @return A GuiItem with the given name and type
     */
    public GuiItem createExampleItem(String name, Material type) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setType(type);

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem with a name and lore
     *
     * @param name The name of the item
     * @param lore The lore of the item
     * @param type The material of the item
     * @return A GuiItem with the given name, type and lore
     */
    public GuiItem createExampleItem(String name, String[] lore, Material type) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setLore(lore);
        itemBuilder.setType(type);

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem with a lore
     *
     * @param type The material of the item
     * @param lore The lore of the item (line by line)
     * @return A GuiItem with the given name and lore
     */
    public GuiItem createExampleItem(Material type, String... lore) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setType(type);
        itemBuilder.setLore(lore);

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem with a name, lore and player skin
     *
     * @param name       The name of the item
     * @param lore       The lore of the item
     * @param playerName The name of the player
     * @return A GuiItem with the given name, lore and skin
     */
    public GuiItem createExamplePlayerHead(String name, String[] lore, String playerName) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setLore(lore);
        itemBuilder.setType(Material.PLAYER_HEAD); // We want a player head, so we don't have to pass the material in the method
        itemBuilder.setSkin(playerName); // Set the skin of the player
        itemBuilder.setSkinIsPlayer(true); // Shows that the skin should be downloaded and actually is just the player's name

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem with a name, lore and skin
     *
     * @param name  The name of the item
     * @param lore  The lore of the item
     * @param value The value of the skin // e.g. https://minecraft-heads.com/custom-heads
     * @return A GuiItem with the given name, lore and skin
     */
    public GuiItem createExampleCustomHead(String name, String[] lore, String value) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setLore(lore);
        itemBuilder.setType(Material.PLAYER_HEAD); // We want a player head, so we don't have to pass the material in the method
        itemBuilder.setSkin(value); // Set the custom skin
        itemBuilder.setSkinIsPlayer(false); // Shows that the skin is not just the player's name and must not be downloaded

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a leather armor piece with invisible enchantments, a name and a lore
     *
     * @param enchantment1 The first enchantment
     * @param level1       The level of the first enchantment
     * @param enchantment2 The second enchantment
     * @param level2       The level of the second enchantment
     * @return A GuiItem of a leather chestplate with the given enchantments
     */
    public GuiItem createExampleArmor(Enchantment enchantment1, int level1, Enchantment enchantment2, int level2) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setName("§bLeather Chestplate");
        itemBuilder.setLore("§5This is a mystical item");
        itemBuilder.setType(Material.LEATHER_CHESTPLATE);
        itemBuilder.setEnchantmentsVisible(false); // Hide the enchantments from the lore
        itemBuilder.setUnbreakable(true); // Make the item unbreakable
        itemBuilder.setShine(false); // This won't do anything, because we add enchantments in the following !!!

        // * Set the enchantments * //
        itemBuilder.addEnchantment(enchantment1, level1); // Add the first enchantment to the chestplate
        itemBuilder.addEnchantment(enchantment2, level2); // Add the second enchantment to the chestplate

        HashMap<Enchantment, Integer> preparedEnchantments = new HashMap<Enchantment, Integer>() {{ // Alternative way if you already have a HashMap with all enchantments
            put(enchantment1, level1);
            put(enchantment2, level2);
        }};
        itemBuilder.addAllEnchantments(preparedEnchantments);

        // * Set color of the leather piece * //
        itemBuilder.setLeatherArmorColor(Color.AQUA); // org.bukkit.Color
        itemBuilder.setLeatherArmorColor(Color.fromBGR(85, 255, 255)); // Color form rgb
        itemBuilder.setLeatherArmorColor(GuiColor.getFromChatColor(ChatColor.AQUA).getColor()); // Color from ChatColor
        itemBuilder.setLeatherArmorColor(GuiColor.AQUA.getColor()); // Color from GuiColor


        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a potion with the given potionEffect and a custom color
     *
     * @param potionEffect The potionEffect of the potion
     * @return A GuiItem of the potion
     */
    public GuiItem createExamplePotion(PotionEffect potionEffect) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setType(Material.POTION);
        itemBuilder.addPotionAffect(potionEffect);
        itemBuilder.addPotionAffect(new PotionEffect(PotionEffectType.GLOWING, 20, 1)); //!!! Important: Duration is in TICKS
        itemBuilder.removePotionEffect(PotionEffectType.GLOWING);
        itemBuilder.setPotionsVisible(false); // Hide the potion effect from the lore

        // * Set color of the potion * //
        itemBuilder.setPotionColor(Color.AQUA); // org.bukkit.Color
        itemBuilder.setPotionColor(Color.fromBGR(85, 255, 255)); // Color form rgb
        itemBuilder.setPotionColor(GuiColor.getFromChatColor(ChatColor.AQUA).getColor()); // Color from ChatColor
        itemBuilder.setPotionColor(GuiColor.AQUA.getColor()); // Color from GuiColor

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a weapon with the given durability
     *
     * @param durability The durability of the weapon
     * @return A GuiItem of the weapon
     */
    public GuiItem createExampleWeapon(int durability) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = new GuiItemBuilder();
        itemBuilder.setType(Material.DIAMOND_AXE);
        itemBuilder.setDurability(10);
        itemBuilder.setShine(true);
        itemBuilder.addLore("I can add", "A lore line");
        itemBuilder.addLore("Anytime I want");
        itemBuilder.addLore(":O");

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Create a GuiItem from an ItemStack
     *
     * @param itemStack The ItemStack
     * @return The GuIItem of the ItemStack
     */
    public GuiItem createExampleItemFromItemStack(ItemStack itemStack) {
        // Create GuiItemBuilder
        GuiItemBuilder itemBuilder = GuiItemBuilder.fromItemStack(itemStack);

        // Create the GuiItem from the itemBuilder and return it
        return itemBuilder.create();
    }

    /**
     * Get the ItemStack from a GuiItem
     *
     * @param guiItem The GuiItem
     * @return The ItemStack of the GuiItem
     */
    public ItemStack getItemStackFromGuiItem(GuiItem guiItem) {
        return guiItem.getItemStack();
    }


}

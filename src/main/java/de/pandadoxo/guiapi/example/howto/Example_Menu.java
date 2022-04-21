///////////////////////////////
// Class coded by Pandadoxo  //
// on 21.04.2022 at 18:27     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.guiapi.example.howto;

import de.pandadoxo.guiapi.builder.GuiButtonBuilder;
import de.pandadoxo.guiapi.builder.GuiItemBuilder;
import de.pandadoxo.guiapi.builder.GuiMenuBuilder;
import de.pandadoxo.guiapi.example.Main;
import de.pandadoxo.guiapi.menu.GuiChest;
import de.pandadoxo.guiapi.result.GuiButton;
import de.pandadoxo.guiapi.result.GuiItem;
import de.pandadoxo.guiapi.result.GuiMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Example_Menu {

    /**
     * Create a GuiMenu
     *
     * @param player The player which should open the menu
     * @return A GuiMenu
     * @see Example_GuiItem on how to create a guiItem
     * @see Example_Button on how to create a button
     * @see de.pandadoxo.guiapi.menu for the different menu types
     */
    public GuiMenu createExampleMenu(Player player) {
        // Create guiMenuBuilder
        GuiMenuBuilder menuBuilder = new GuiMenuBuilder();
        menuBuilder.setMenuType(GuiChest.class); // !!! Set the type of the menu
        menuBuilder.setPlayer(player);
        menuBuilder.setSize(6 * 9); // This is just important if you use GuiChest

        menuBuilder.setCurPage(1); // The values are just for working purposes, you could also just create variables
        menuBuilder.setMaxPage(2);

        GuiMenu menu = menuBuilder.create(Main.getPlugin(Main.class)); // Create the menu !!! requires the plugin

        // fill the menu
        menu.setOnFill(() -> { // this is just needed, if you want to update the menu frequently (if you want to have a static menu, skip this and directly use menu.setItem etc.!!!)
            // add items with no name (for borders for example)
            for (int i = 0; i < 9; i++) {
                menu.setItem(Material.WHITE_STAINED_GLASS_PANE, i);
            }
            for (int i = 1; i < 6; i++) {
                menu.setItem(Material.WHITE_STAINED_GLASS_PANE, 9 * i);
                menu.setItem(Material.WHITE_STAINED_GLASS_PANE, 9 * i + 8);
            }
            for (int i = 0; i < 9; i++) {
                menu.setItem(Material.WHITE_STAINED_GLASS_PANE, i);
            }

            // add button
            GuiItem item = new GuiItemBuilder().setName("§eI'm a button").setType(Material.STONE_BUTTON).setAmount(32).setLore("§cPress me ^^").create();
            GuiButton button = new GuiButtonBuilder().setGuiItem(item).setSlot(22).setPressListener((clickType, guiMenu, guiButton, player1) -> {
                // send message
                player1.sendMessage("You just pressed a button :HYPERS:");
            }).create();

            menu.addButton(button); // don't forget to actually add the button to the menu
        });

        // open the menu
        menu.open();

        return menu;
    }

}

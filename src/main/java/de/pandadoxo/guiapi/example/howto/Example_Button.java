///////////////////////////////
// Class coded by Pandadoxo  //
// on 21.04.2022 at 18:20     //
// Don't remove this section //
///////////////////////////////
package de.pandadoxo.guiapi.example.howto;

import de.pandadoxo.guiapi.builder.GuiButtonBuilder;
import de.pandadoxo.guiapi.interfaces.PressListener;
import de.pandadoxo.guiapi.result.GuiButton;
import de.pandadoxo.guiapi.result.GuiItem;
import de.pandadoxo.guiapi.result.GuiMenu;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public class Example_Button {

    /**
     * @param guiItem The GuiItem of the button
     * @param onPress What should happen if the button gets pressed
     * @return A Button
     * @see Example_GuiItem on how to create a GuiItem
     */
    public GuiButton createExampleButton(GuiItem guiItem, Runnable onPress) {
        // Create GuiButtonBuilder
        GuiButtonBuilder buttonBuilder = new GuiButtonBuilder();
        buttonBuilder.setGuiItem(guiItem);
        buttonBuilder.setSlot(4); // Set the slot of the button (where it should appear in the inventory)
        buttonBuilder.setPressSound(Sound.BLOCK_NOTE_BLOCK_PLING); // Set the sound of the button
        buttonBuilder.setPitch(1); // Set the pitch of the sound
        buttonBuilder.setVolume(1); // Set the volume of the sound
        buttonBuilder.setPressListener(new PressListener() {
            @Override
            public void performAction(ClickType clickType, GuiMenu guiMenu, GuiButton guiButton, Player player) {
                // Write, what should happen if the button gets pressed here
                onPress.run(); // just an example, you can write code normally

                player.sendMessage("YOU PRESSED A BUTTON :O");
                player.sendMessage("USED BUTTON: " + (clickType.isRightClick() ? "RIGHTCLICK" : "LEFTCLICK"));
                player.sendMessage("THE SLOT OF THE BUTTON IS: " + guiButton.getSlot());
                player.sendMessage("THE MENU'S NAME, IN WHICH THE BUTTON IS, IS: " + guiMenu.getTitle());
            }
        });

        // Create the GuiButton from the buttonBuilder and return it
        return buttonBuilder.create();
    }

}

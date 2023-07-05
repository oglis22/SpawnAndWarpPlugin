package dev.oglis22.vorzeigeplugin.gui;

import dev.oglis22.vorzeigeplugin.utils.FileManager;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.CustomForm;
import org.geysermc.cumulus.response.CustomFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public class BedrockGUI {

    public static void createAndOpenGUI(Player player){
        FloodgatePlayer bedrockPlayer = FloodgateApi.getInstance().getPlayer(player.getUniqueId());
        bedrockPlayer.sendForm(
                CustomForm.builder()
                        .title("Warp Teleporter")
                        .dropdown("Wähle deinen Warp", FileManager.getNameofWarps())
                        .validResultHandler(response -> test(player, response))
        );
    }
    public static void test(Player player, CustomFormResponse response) {
        Integer selectedWarp = response.getDropdown(0);
        player.teleport(FileManager.getAllWarps().get(selectedWarp));
        player.sendMessage("Ausgewählter Warp: " + FileManager.getNameofWarps().get(selectedWarp));
    }
}

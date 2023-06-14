package me.loving11ish.playerguiadvanced.updatesystem;

import com.tcoded.folialib.FoliaLib;
import me.loving11ish.playerguiadvanced.PlayerGUIAdvanced;
import me.loving11ish.playerguiadvanced.utils.ColorUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class UpdateChecker {

    private int resourceId;
    private FoliaLib foliaLib = PlayerGUIAdvanced.getFoliaLib();
    Logger logger = PlayerGUIAdvanced.getPlugin().getLogger();

    FileConfiguration messagesConfig = PlayerGUIAdvanced.getPlugin().messagesFileManager.getMessagesConfig();

    public UpdateChecker(int resourceId) {
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        foliaLib.getImpl().runAsync(() -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                logger.warning(ColorUtils.translateColorCodes(messagesConfig.getString("Update-check-failure") + exception.getMessage()));
            }
        });
    }
}
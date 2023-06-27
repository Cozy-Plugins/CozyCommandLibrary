package com.github.cozyplugins.cozylibrary.inventory.action;

import com.github.cozyplugins.cozylibrary.inventory.InventoryInterface;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

/**
 * <h1>Represents an action handler</h1>
 * Provides a handler with the inventory events.
 */
public interface ActionHandler {

    /**
     * <h1>Called when a inventory is clicked on</h1>
     * <li>Defaults to always cancel the event.</li>
     *
     * @param inventory The instance of the inventory.
     * @param user The instance of the user.
     * @param event The instance of the event.
     * @return The Action result.
     */
    @NotNull
    ActionResult onInventoryClick(@NotNull InventoryInterface inventory, @NotNull PlayerUser user, InventoryClickEvent event);
}

package com.github.cozyplugins.cozylibrary.inventory.action.handler;

import com.github.cozyplugins.cozylibrary.inventory.InventoryInterface;
import com.github.cozyplugins.cozylibrary.inventory.action.ActionHandler;
import com.github.cozyplugins.cozylibrary.inventory.action.ActionResult;
import com.github.cozyplugins.cozylibrary.inventory.action.action.ClickActionWithResult;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Represents the click action with result handler.
 * Handles the {@link ClickActionWithResult} actions.
 */
public class ClickActionWithResultHandler implements ActionHandler {

    @Override
    public @NotNull ActionResult onInventoryClick(@NotNull InventoryInterface inventoryInterface, @NotNull PlayerUser user, InventoryClickEvent event) {
        List<ClickActionWithResult> actionList = inventoryInterface.getActionList(event.getSlot(), ClickActionWithResult.class);

        ActionResult actionResult = new ActionResult();

        for (ClickActionWithResult action : actionList) {
            actionResult = action.onClick(user, event.getClick(), event.getInventory(), actionResult, event.getSlot());
        }

        return actionResult;
    }

    @Override
    public void onInventoryClose(@NotNull InventoryInterface inventoryInterface, @NotNull PlayerUser user, InventoryCloseEvent event) {

    }

    @Override
    public void onAnvilText(@NotNull InventoryInterface inventoryInterface, @NotNull String text, @NotNull PlayerUser user) {

    }
}

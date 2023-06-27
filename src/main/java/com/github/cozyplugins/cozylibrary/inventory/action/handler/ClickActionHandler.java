package com.github.cozyplugins.cozylibrary.inventory.action.handler;

import com.github.cozyplugins.cozylibrary.inventory.InventoryInterface;
import com.github.cozyplugins.cozylibrary.inventory.action.ActionHandler;
import com.github.cozyplugins.cozylibrary.inventory.action.ActionResult;
import com.github.cozyplugins.cozylibrary.inventory.action.action.ClickAction;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * <h1>Represents the click action handler.</h1>
 */
public class ClickActionHandler implements ActionHandler {

    @Override
    public @NotNull ActionResult onInventoryClick(@NotNull InventoryInterface inventory, @NotNull PlayerUser user, InventoryClickEvent event) {
        List<ClickAction> actionList = inventory.getActionList(event.getSlot(), ClickAction.class);

        for (ClickAction action : actionList) {
            action.onClick(user, event.getClick());
        }

        return new ActionResult();
    }
}

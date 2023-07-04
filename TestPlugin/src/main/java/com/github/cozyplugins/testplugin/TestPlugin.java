package com.github.cozyplugins.testplugin;

import com.github.cozyplugins.cozylibrary.CozyPlugin;
import com.github.cozyplugins.cozylibrary.command.command.command.ProgrammableCommand;
import com.github.cozyplugins.cozylibrary.command.command.command.programmable.ProgrammableExecutor;
import com.github.cozyplugins.cozylibrary.command.datatype.CommandArguments;
import com.github.cozyplugins.cozylibrary.command.datatype.CommandStatus;
import com.github.cozyplugins.cozylibrary.user.PlayerUser;
import com.github.cozyplugins.testplugin.commands.HelloWorldCommand;
import com.github.cozyplugins.testplugin.commands.TestCommandType;
import com.github.cozyplugins.testplugin.inventorys.InputInventory;
import com.github.cozyplugins.testplugin.inventorys.TestInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <h1>Represents a test plugin</h1>
 */
public final class TestPlugin extends CozyPlugin {

    @Override
    public boolean enableCommandDirectory() {
        return true;
    }

    @Override
    public void onCozyEnable() {
        // Setup commands.
        this.addCommand(new HelloWorldCommand());
        this.addCommand(new ProgrammableCommand("testinventory").setPlayer((user, arguments) -> {
            new TestInventory().open(user.getPlayer());
            return new CommandStatus();
        }));
        this.addCommand(new ProgrammableCommand("inputinventory").setPlayer((user, arguments) -> {
            new InputInventory("test").open(user.getPlayer());
            return new CommandStatus();
        }));

        // Setup command types.
        this.addCommandType(new TestCommandType());
    }
}

package dev.titanlabs.mpt.mc.common;

import dev.titanlabs.mpt.mc.common.commands.CommandController;

public class MptPlatform {
    private final CommandController commandController;

    public MptPlatform() {
        this.commandController = new CommandController();
    }

    public CommandController getCommandController() {
        return this.commandController;
    }
}

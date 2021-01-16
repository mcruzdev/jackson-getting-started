package com.github.mcruzdev.learnjackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CommandRequest {

    @NotBlank
    @JsonProperty("Command_Name")
    private String commandName;

    @NotBlank
    @JsonProperty("Command_Target")
    private String commandTarget;

    public CommandRequest() {}

    public CommandRequest(String commandName, String commandTarget) {
        this.commandName = commandName;
        this.commandTarget = commandTarget;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandTarget() {
        return commandTarget;
    }

    public void setCommandTarget(String commandTarget) {
        this.commandTarget = commandTarget;
    }
}

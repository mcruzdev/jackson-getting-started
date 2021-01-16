package com.github.mcruzdev.learnjackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CommandResponse {

    @JsonProperty(value = "commandName")
    @JsonAlias("Command_Name")
    private String commandName;

    @JsonProperty("commandTarget")
    @JsonAlias("Command_Target")
    private String commandTarget;

    @JsonProperty(value = "commandResultPayload")
    @JsonAlias(value = "Command_Result_Payload")
    private List<String> commandResultPayload;

    public CommandResponse() {}

    public CommandResponse(String commandName, String commandTarget, List<String> commandResultPayload) {
        this.commandName = commandName;
        this.commandTarget = commandTarget;
        this.commandResultPayload = commandResultPayload;
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

    public List<String> getCommandResultPayload() {
        return commandResultPayload;
    }

    public void setCommandResultPayload(List<String> commandResultPayload) {
        this.commandResultPayload = commandResultPayload;
    }

    @Override
    public String toString() {
        return "CommandResponse{" +
                "status='" + commandName + '\'' +
                ", results=" + commandResultPayload +
                '}';
    }
}

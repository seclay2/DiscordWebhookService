package io.github.seclay2.webhookservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscordResponse {

    private int type;
    private String id;
    private String name;
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("guild_id")
    private String guildId;
    private String token;

    public DiscordResponse() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "DiscordResponse{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", channelId='" + channelId + '\'' +
                ", guildId='" + guildId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

package io.github.seclay2.webhookservice.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.seclay2.webhookservice.model.discord.DiscordEmbed;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordRequest {

    @JsonProperty
    private String content;
    @JsonProperty
    private String username;
    @JsonProperty
    private String avatar_url;
    @JsonProperty
    private boolean tts;
    @JsonProperty
    private String file;
    @JsonProperty
    private ArrayList<DiscordEmbed> embeds;

    public DiscordRequest() {
        content = "";
        username = "";
        avatar_url = "";
        tts = false;
        file = "";
        embeds = new ArrayList<>();
    }

    public DiscordRequest(String content) {
        this.content = content;
    }

    public DiscordRequest(String username, ArrayList<DiscordEmbed> embeds) {
        this.username = username;
        this.embeds = embeds;
    }

    public DiscordRequest(String content, String username, String avatar_url, boolean tts, String file, ArrayList<DiscordEmbed> embeds) {
        this.content = content;
        this.username = username;
        this.avatar_url = avatar_url;
        this.tts = tts;
        this.file = file;
        this.embeds = embeds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public boolean isTts() {
        return tts;
    }

    public void setTts(boolean tts) {
        this.tts = tts;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ArrayList<DiscordEmbed> getEmbeds() {
        return embeds;
    }

    public void setEmbeds(ArrayList<DiscordEmbed> embeds) {
        this.embeds = embeds;
    }

    public void addEmbed(DiscordEmbed embed) {
        embeds.add(embed);
    }

    @Override
    public String toString() {
        return "DiscordRequest{" +
                "content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", tts=" + tts +
                ", file='" + file + '\'' +
                ", embeds=" + embeds +
                '}';
    }
}

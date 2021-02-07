package io.github.seclay2.webhookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordRequest {

    private String content;
    private String username;
    private String avatar_url;
    private boolean tts;
    private String file;
    private ArrayList<DiscordEmbed> embeds;

    public DiscordRequest() {
    }

    public DiscordRequest(String content) {
        this.content = content;
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

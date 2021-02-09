package io.github.seclay2.webhookservice.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordThumbnail {

    @JsonProperty
    private String url;
    @JsonProperty
    private int height;
    @JsonProperty
    private int width;

    public DiscordThumbnail() {
    }

    public DiscordThumbnail(String url) {
        this.url = url;
        height = 0;
        width = 0;
    }

    public DiscordThumbnail(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "DiscordThumbnail{" +
                "url='" + url + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}

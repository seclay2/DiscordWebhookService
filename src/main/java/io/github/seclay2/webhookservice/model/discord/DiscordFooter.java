package io.github.seclay2.webhookservice.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordFooter {

    @JsonProperty
    private String text;
    @JsonProperty
    private String icon_url;

    public DiscordFooter() {
    }

    public DiscordFooter(String text) {
        this.text = text;
        this.icon_url = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    @Override
    public String toString() {
        return "DiscordFooter{" +
                "text='" + text + '\'' +
                ", icon_url='" + icon_url + '\'' +
                '}';
    }
}

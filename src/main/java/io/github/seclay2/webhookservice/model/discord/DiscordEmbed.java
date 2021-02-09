package io.github.seclay2.webhookservice.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordEmbed {

    @JsonProperty
    private String title;
    @JsonProperty
    private String type;
    @JsonProperty
    private String description;
    @JsonProperty
    private String url;
    @JsonProperty
    private int color;
    @JsonProperty
    private DiscordFooter footer;
    // private DiscordImage image;
    @JsonProperty
    private DiscordThumbnail thumbnail;
    //private DiscordVideo video;
    //private DiscordProvider provider;
    //private DiscordAuthor author;
    @JsonProperty
    private List<DiscordField> fields;

    public DiscordEmbed() {
    }

    public DiscordEmbed(String title) {
        this.title = title;
    }

    public DiscordEmbed(String title, String type, String description, String url, int color, DiscordFooter footer, DiscordThumbnail thumbnail, List<DiscordField> fields) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.url = url;
        this.color = color;
        this.footer = footer;
        this.thumbnail = thumbnail;
        this.fields = fields;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public DiscordFooter getFooter() {
        return footer;
    }

    public void setFooter(DiscordFooter footer) {
        this.footer = footer;
    }

    public DiscordThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(DiscordThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<DiscordField> getFields() {
        return fields;
    }

    public void setFields(List<DiscordField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "DiscordEmbed{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", color=" + color +
                ", footer=" + footer +
                ", thumbnail=" + thumbnail +
                ", fields=" + fields +
                '}';
    }
}

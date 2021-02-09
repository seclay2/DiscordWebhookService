package io.github.seclay2.webhookservice.model.discord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscordField {

    @JsonProperty
    private String name;
    @JsonProperty
    private String value;
    @JsonProperty
    private boolean inline;

    public DiscordField() {
    }

    public DiscordField(String name, String value, boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isInline() {
        return inline;
    }

    public void setInline(boolean inline) {
        this.inline = inline;
    }

    @Override
    public String toString() {
        return "DiscordField{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", inline=" + inline +
                '}';
    }
}

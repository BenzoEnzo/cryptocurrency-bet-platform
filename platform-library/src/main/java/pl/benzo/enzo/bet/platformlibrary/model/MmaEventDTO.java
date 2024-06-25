package pl.benzo.enzo.bet.platformlibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class MmaEventDTO {

    @JsonProperty("EventId")
    private int eventId;

    @JsonProperty("LeagueId")
    private int leagueId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("ShortName")
    private String shortName;

    @JsonProperty("Season")
    private int season;

    @JsonProperty("Day")
    private LocalDateTime day;

    @JsonProperty("DateTime")
    private LocalDateTime dateTime;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Active")
    private boolean active;

    // Getters and Setters

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

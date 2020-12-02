package com.bchong.sutdeets;

public class Events {
    private String Date;
    private String Location;
    private String Title;
    private String timeStart;
    private String TimeEnd;
    private String purl;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;
    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        TimeEnd = timeEnd;
    }

    public Events() {
    }

    public Events(String date, String location, String title, String timeStart, String timeEnd,String purl,String Description) {
        Date = date;
        Location = location;
        Title = title;
        this.timeStart = timeStart;
        TimeEnd = timeEnd;
        this.purl=purl;
        this.Description=Description;
    }
}

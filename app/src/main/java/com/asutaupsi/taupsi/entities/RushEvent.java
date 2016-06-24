package com.asutaupsi.taupsi.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class RushEvent implements Parcelable {
    private int eventId;
    private String eventName;
    private String eventType;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private double eventLatitude;
    private double eventLongitude;


    public RushEvent(int eventId, String eventName, String eventType, String eventDate, String eventTime, String eventLocation, double eventLatitude, double eventLongitude) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventLatitude = eventLatitude;
        this.eventLongitude = eventLongitude;
    }

    protected RushEvent(Parcel in) {
        eventId = in.readInt();
        eventName = in.readString();
        eventType = in.readString();
        eventDate = in.readString();
        eventTime = in.readString();
        eventLocation = in.readString();
        eventLatitude = in.readDouble();
        eventLongitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeString(eventName);
        dest.writeString(eventType);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(eventLocation);
        dest.writeDouble(eventLatitude);
        dest.writeDouble(eventLongitude);
    }


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public double getEventLatitude() {
        return eventLatitude;
    }

    public void setEventLatitude(double eventLatitude) {
        this.eventLatitude = eventLatitude;
    }

    public double getEventLongitude() {
        return eventLongitude;
    }

    public void setEventLongitude(double eventLongitude) {
        this.eventLongitude = eventLongitude;
    }

    public static final Creator<RushEvent> CREATOR = new Creator<RushEvent>() {
        @Override
        public RushEvent createFromParcel(Parcel in) {
            return new RushEvent(in);
        }

        @Override
        public RushEvent[] newArray(int size) {
            return new RushEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}

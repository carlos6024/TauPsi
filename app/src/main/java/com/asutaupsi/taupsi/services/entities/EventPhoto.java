package com.asutaupsi.taupsi.services.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class EventPhoto implements Parcelable {
    private int EventPhotoId;
    private String EventName;
    private String EventPhotoUrl;


    public EventPhoto(int eventPhotoId, String eventName, String eventPhotoUrl) {
        EventPhotoId = eventPhotoId;
        EventName = eventName;
        EventPhotoUrl = eventPhotoUrl;
    }



    protected EventPhoto(Parcel in) {
        EventPhotoId = in.readInt();
        EventName = in.readString();
        EventPhotoUrl = in.readString();
    }




    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(EventPhotoId);
        dest.writeString(EventName);
        dest.writeString(EventPhotoUrl);
    }


    public int getEventPhotoId() {
        return EventPhotoId;
    }

    public void setEventPhotoId(int eventPhotoId) {
        EventPhotoId = eventPhotoId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventPhotoUrl() {
        return EventPhotoUrl;
    }

    public void setEventPhotoUrl(String eventPhotoUrl) {
        EventPhotoUrl = eventPhotoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<EventPhoto> CREATOR = new Creator<EventPhoto>() {
        @Override
        public EventPhoto createFromParcel(Parcel in) {
            return new EventPhoto(in);
        }

        @Override
        public EventPhoto[] newArray(int size) {
            return new EventPhoto[size];
        }
    };
}

package com.asutaupsi.taupsi.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class EventPhoto implements Parcelable {
    private int EventPhotoId;
    private String EventPhotoUrl;


    public EventPhoto(int eventPhotoId, String eventPhotoUrl) {
        EventPhotoId = eventPhotoId;
        EventPhotoUrl = eventPhotoUrl;
    }



    protected EventPhoto(Parcel in) {
        EventPhotoId = in.readInt();
        EventPhotoUrl = in.readString();
    }




    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(EventPhotoId);
        dest.writeString(EventPhotoUrl);
    }


    public String getEventPhotoUrl() {
        return EventPhotoUrl;
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

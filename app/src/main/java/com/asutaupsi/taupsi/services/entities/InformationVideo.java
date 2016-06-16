package com.asutaupsi.taupsi.services.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class InformationVideo implements Parcelable {
    private int videoId;
    private String videoTitle;
    private String videoDesctiption;
    private String videoType;
    private String videoImage;
    private String videoYoutubeEnding;


    public InformationVideo(int videoId, String videoTitle, String videoDesctiption, String videoType, String videoImage, String videoYoutubeEnding) {
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoDesctiption = videoDesctiption;
        this.videoType = videoType;
        this.videoImage = videoImage;
        this.videoYoutubeEnding = videoYoutubeEnding;
    }


    protected InformationVideo(Parcel in) {
        videoId = in.readInt();
        videoTitle = in.readString();
        videoDesctiption = in.readString();
        videoType = in.readString();
        videoImage = in.readString();
        videoYoutubeEnding = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(videoId);
        dest.writeString(videoTitle);
        dest.writeString(videoDesctiption);
        dest.writeString(videoType);
        dest.writeString(videoImage);
        dest.writeString(videoYoutubeEnding);
    }


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDesctiption() {
        return videoDesctiption;
    }

    public void setVideoDesctiption(String videoDesctiption) {
        this.videoDesctiption = videoDesctiption;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoYoutubeEnding() {
        return videoYoutubeEnding;
    }

    public void setVideoYoutubeEnding(String videoYoutubeEnding) {
        this.videoYoutubeEnding = videoYoutubeEnding;
    }

    public static final Creator<InformationVideo> CREATOR = new Creator<InformationVideo>() {
        @Override
        public InformationVideo createFromParcel(Parcel in) {
            return new InformationVideo(in);
        }

        @Override
        public InformationVideo[] newArray(int size) {
            return new InformationVideo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}

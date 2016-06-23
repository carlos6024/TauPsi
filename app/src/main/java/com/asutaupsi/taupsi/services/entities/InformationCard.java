package com.asutaupsi.taupsi.services.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class InformationCard implements Parcelable {
    private int videoId;
    private String videoTitle;
    private String videoDescription;
    private String videoType;
    private String videoImage;
    private String videoYoutubeEnding;
    private Boolean isVideo;


    public InformationCard(int videoId, String videoTitle, String videoDesctiption, String videoType, String videoImage, String videoYoutubeEnding,Boolean isVideo) {
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDesctiption;
        this.videoType = videoType;
        this.videoImage = videoImage;
        this.videoYoutubeEnding = videoYoutubeEnding;
        this.isVideo = isVideo;
    }


    protected InformationCard(Parcel in) {
        videoId = in.readInt();
        videoTitle = in.readString();
        videoDescription = in.readString();
        videoType = in.readString();
        videoImage = in.readString();
        videoYoutubeEnding = in.readString();
        isVideo = in.readByte() !=0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(videoId);
        dest.writeString(videoTitle);
        dest.writeString(videoDescription);
        dest.writeString(videoType);
        dest.writeString(videoImage);
        dest.writeString(videoYoutubeEnding);
        dest.writeByte((byte) (isVideo ? 1:0));
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

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
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


    public Boolean getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        this.isVideo = isVideo;
    }

    public void setVideoYoutubeEnding(String videoYoutubeEnding) {
        this.videoYoutubeEnding = videoYoutubeEnding;
    }

    public static final Creator<InformationCard> CREATOR = new Creator<InformationCard>() {
        @Override
        public InformationCard createFromParcel(Parcel in) {
            return new InformationCard(in);
        }

        @Override
        public InformationCard[] newArray(int size) {
            return new InformationCard[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

}

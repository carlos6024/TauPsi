package com.asutaupsi.taupsi.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class InformationCard implements Parcelable {
    private int cardId;
    private String cardTitle;
    private String cardDescription;
    private String cardType;
    private String cardImage;
    private String videoYoutubeEnding;
    private Boolean isVideo;


    public InformationCard(int videoId, String videoTitle, String videoDesctiption, String videoType, String videoImage, String videoYoutubeEnding,Boolean isVideo) {
        this.cardId = videoId;
        this.cardTitle = videoTitle;
        this.cardDescription = videoDesctiption;
        this.cardType = videoType;
        this.cardImage = videoImage;
        this.videoYoutubeEnding = videoYoutubeEnding;
        this.isVideo = isVideo;
    }


    protected InformationCard(Parcel in) {
        cardId = in.readInt();
        cardTitle = in.readString();
        cardDescription = in.readString();
        cardType = in.readString();
        cardImage = in.readString();
        videoYoutubeEnding = in.readString();
        isVideo = in.readByte() !=0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cardId);
        dest.writeString(cardTitle);
        dest.writeString(cardDescription);
        dest.writeString(cardType);
        dest.writeString(cardImage);
        dest.writeString(videoYoutubeEnding);
        dest.writeByte((byte) (isVideo ? 1:0));
    }


    public int getCardId() {
        return cardId;
    }


    public String getCardTitle() {
        return cardTitle;
    }


    public String getCardDescription() {
        return cardDescription;
    }


    public String getCardImage() {
        return cardImage;
    }


    public String getVideoYoutubeEnding() {
        return videoYoutubeEnding;
    }


    public Boolean getIsVideo() {
        return isVideo;
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

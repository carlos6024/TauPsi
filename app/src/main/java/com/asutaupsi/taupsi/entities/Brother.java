package com.asutaupsi.taupsi.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Brother implements Parcelable {

    private int BrotherId;
    private String BrotherName;
    private String BrotherWhyJoin;
    private String BrotherPicture;
    private String BrotherMajor;
    private String BrotherCrossSemester;
    private String BrotherFunFact;


    public Brother(int brotherId, String brotherName, String brotherAbout, String brotherPicture, String brotherMajor, String brotherCrossSemester, String brotherFunFact) {
        BrotherId = brotherId;
        BrotherName = brotherName;
        BrotherWhyJoin = brotherAbout;
        BrotherPicture = brotherPicture;
        BrotherMajor = brotherMajor;
        BrotherCrossSemester = brotherCrossSemester;
        BrotherFunFact = brotherFunFact;
    }


    protected Brother(Parcel in) {
        BrotherId = in.readInt();
        BrotherName = in.readString();
        BrotherWhyJoin = in.readString();
        BrotherPicture = in.readString();
        BrotherMajor = in.readString();
        BrotherCrossSemester = in.readString();
        BrotherFunFact = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BrotherId);
        dest.writeString(BrotherName);
        dest.writeString(BrotherWhyJoin);
        dest.writeString(BrotherPicture);
        dest.writeString(BrotherMajor);
        dest.writeString(BrotherCrossSemester);
        dest.writeString(BrotherFunFact);
    }


    public int getBrotherId() {
        return BrotherId;
    }


    public String getBrotherName() {
        return BrotherName;
    }


    public String getBrotherWhyJoin() {
        return BrotherWhyJoin;
    }


    public String getBrotherPicture() {
        return BrotherPicture;
    }


    public String getBrotherMajor() {
        return BrotherMajor;
    }


    public String getBrotherCrossSemester() {
        return BrotherCrossSemester;
    }


    public String getBrotherFunFact() {
        return BrotherFunFact;
    }


    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}

package com.asutaupsi.taupsi.services.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Brother implements Parcelable {

    private int BrotherId;
    private String BrotherName;
    private String BrotherAbout;
    private String BrotherPicture;
    private String BrotherMajor;
    private String BrotherCrossSemester;
    private String BrotherFunFact;


    public Brother(int brotherId, String brotherName, String brotherAbout, String brotherPicture, String brotherMajor, String brotherCrossSemester, String brotherFunFact) {
        BrotherId = brotherId;
        BrotherName = brotherName;
        BrotherAbout = brotherAbout;
        BrotherPicture = brotherPicture;
        BrotherMajor = brotherMajor;
        BrotherCrossSemester = brotherCrossSemester;
        BrotherFunFact = brotherFunFact;
    }

    protected Brother(Parcel in) {
        BrotherId = in.readInt();
        BrotherName = in.readString();
        BrotherAbout = in.readString();
        BrotherPicture = in.readString();
        BrotherMajor = in.readString();
        BrotherCrossSemester = in.readString();
        BrotherFunFact = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BrotherId);
        dest.writeString(BrotherName);
        dest.writeString(BrotherAbout);
        dest.writeString(BrotherPicture);
        dest.writeString(BrotherMajor);
        dest.writeString(BrotherCrossSemester);
        dest.writeString(BrotherFunFact);
    }


    public int getBrotherId() {
        return BrotherId;
    }

    public void setBrotherId(int brotherId) {
        BrotherId = brotherId;
    }

    public String getBrotherName() {
        return BrotherName;
    }

    public void setBrotherName(String brotherName) {
        BrotherName = brotherName;
    }

    public String getBrotherAbout() {
        return BrotherAbout;
    }

    public void setBrotherAbout(String brotherAbout) {
        BrotherAbout = brotherAbout;
    }

    public String getBrotherPicture() {
        return BrotherPicture;
    }

    public void setBrotherPicture(String brotherPicture) {
        BrotherPicture = brotherPicture;
    }

    public String getBrotherMajor() {
        return BrotherMajor;
    }

    public void setBrotherMajor(String brotherMajor) {
        BrotherMajor = brotherMajor;
    }

    public String getBrotherCrossSemester() {
        return BrotherCrossSemester;
    }

    public void setBrotherCrossSemester(String brotherCrossSemester) {
        BrotherCrossSemester = brotherCrossSemester;
    }

    public String getBrotherFunFact() {
        return BrotherFunFact;
    }

    public void setBrotherFunFact(String brotherFunFact) {
        BrotherFunFact = brotherFunFact;
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

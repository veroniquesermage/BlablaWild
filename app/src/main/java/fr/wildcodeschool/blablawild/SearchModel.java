package fr.wildcodeschool.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchModel implements Parcelable {

    private String mDeparture;
    private String mDestination;
    private String mDate;

    // constructeur
    public SearchModel(String pDeparture, String pDestination, String pDate) {
        this.mDeparture = pDeparture;
        this.mDestination = pDestination;
        this.mDate = pDate;
    }

    public String getDeparture() {
        return mDeparture;
    }

    public void setDeparture(String departure) {
        this.mDeparture = departure;
    }

    public String getDestination() {
        return mDestination;
    }

    public void setDestination(String destination) {
        this.mDestination = destination;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mDeparture);
        dest.writeString(mDestination);
        dest.writeString(mDate);
    }

    protected SearchModel(Parcel in) {
        mDeparture = in.readString();
        mDestination = in.readString();
        mDate = in.readString();
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel in) {
            return new SearchModel(in);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };
}

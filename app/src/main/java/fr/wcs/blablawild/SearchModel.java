package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 13/03/18.
 */

public class SearchModel implements Parcelable {

    String departure;
    String destination;
    String date;

    public SearchModel(String departure, String destination, String date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    protected SearchModel(Parcel in) {
        departure = in.readString();
        destination = in.readString();
        date = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(departure);
        parcel.writeString(destination);
        parcel.writeString(date);
    }
}

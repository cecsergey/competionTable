package com.android.sergey.competitiontable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Sergey on 4/12/2016.
 */
public class ParticipantList extends ArrayList<Contact> implements Parcelable {
    private static final long serialVersionUID = 663585476779879096L;



    public ParticipantList(){

    }

    public ParticipantList(Parcel in){
        readFromParcel(in);
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ParticipantList createFromParcel(Parcel in) {
            return new ParticipantList(in);
        }

        public Object[] newArray(int arg0) {
            return null;
        }
    };

    private void readFromParcel(Parcel in) {
        this.clear();
        //First we have to read the list size
        int size = in.readInt();
        //Reading remember that we wrote first the Name and later the Phone Number.
        //Order is fundamental
        for (int i = 0; i < size; i++) {
            Contact c = new Contact();
            c.setName(in.readString());
            c.setWeight(in.readString());
            c.setAge(in.readString());
            this.add(c);
        }
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        int size = this.size();
        //We have to write the list size, we need him recreating the list
        dest.writeInt(size);
        //We decided arbitrarily to write first the Name and later the Phone Number.
        for (int i = 0; i < size; i++) {
            Contact c = this.get(i);
            dest.writeInt(c.getID());
            dest.writeString(c.getName());
            dest.writeString(c.getWeight());
            dest.writeString(c.getAge());
        }
    }
}

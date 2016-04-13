package com.android.sergey.competitiontable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Sergey on 3/22/2016.
 */
public class Contact implements Parcelable{
    //private variables
    int _id;
    String _weight;
    String _age;
    String _name;


    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name, String weight, String age){
        this._id = id;
        this._name = name;
        this._weight = weight;
        this._age = age;
    }

    // constructor
    public Contact(String name, String weight, String age){
        this._name = name;
        this._weight = weight;
        this._age = age;
    }


    protected Contact(Parcel in) {
        _id = in.readInt();
        _name = in.readString();
        _weight = in.readString();
        _age = in.readString();

    }



    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting weight
    public String getWeight(){
        return this._weight;
    }

    // setting name
    public void setWeight(String weight){
        this._weight = weight;
    }

    // getting name
    public String getAge(){
        return this._age;
    }

    // setting name
    public void setAge(String age){
        this._age = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(_name);
        dest.writeString(_weight);
        dest.writeString(_age);

    }

    private void readToParcel(Parcel in){
        _id = in.readInt();
        _name = in.readString();
        _weight = in.readString();
        _age = in.readString();
    }




    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}

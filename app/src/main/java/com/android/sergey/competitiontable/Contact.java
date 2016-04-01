package com.android.sergey.competitiontable;

/**
 * Created by Sergey on 3/22/2016.
 */
public class Contact {
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

}

package com.asutaupsi.taupsi.entities.FirebaseEntites;

public class RushEventFireBase {
    private String name;
    private String date;
    private String time;
    private String location;
    private double latitude;
    private double longitude;
    private boolean asu;
    private boolean downtown;
    private String description;

    public RushEventFireBase(){
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isAsu() {
        return asu;
    }

    public boolean isDowntown() {
        return downtown;
    }

    public String getDescription() {
        return description;
    }
}

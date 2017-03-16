package com.example.quanla.smartschool.networks.jsonModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hieutran on 3/17/17.
 */

public class TeachingScheduleResponJSON {
    @SerializedName("date_start")
    private String dateStart;
    @SerializedName("date_end")
    private String dateEnd;
    @SerializedName("class_room")
    private String classRoom;
    @SerializedName("name")
    String name;
    @SerializedName("time_study")
    private String timeStudy;

    @Override
    public String toString() {
        return "TeachingScheduleResponJSON{" +
                "dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", name='" + name + '\'' +
                ", timeStudy='" + timeStudy + '\'' +
                '}';
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStudy() {
        return timeStudy;
    }

    public void setTimeStudy(String timeStudy) {
        this.timeStudy = timeStudy;
    }

    public TeachingScheduleResponJSON(String dateStart, String dateEnd, String classRoom, String name, String timeStudy) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.classRoom = classRoom;
        this.name = name;
        this.timeStudy = timeStudy;
    }
}

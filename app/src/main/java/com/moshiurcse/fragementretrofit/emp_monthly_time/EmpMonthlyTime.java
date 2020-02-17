
package com.moshiurcse.fragementretrofit.emp_monthly_time;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmpMonthlyTime {

    @SerializedName("EMPCODE")
    @Expose
    private String eMPCODE;
    @SerializedName("YearID")
    @Expose
    private String yearID;
    @SerializedName("MonthID")
    @Expose
    private String monthID;
    @SerializedName("WeekID")
    @Expose
    private String weekID;
    @SerializedName("EMPDATE")
    @Expose
    private String eMPDATE;
    @SerializedName("TimeIn")
    @Expose
    private String timeIn;
    @SerializedName("TimeOffStart")
    @Expose
    private Object timeOffStart;
    @SerializedName("TimeOffEnd")
    @Expose
    private Object timeOffEnd;
    @SerializedName("TimeOut")
    @Expose
    private String timeOut;

    public String getEMPCODE() {
        return eMPCODE;
    }

    public void setEMPCODE(String eMPCODE) {
        this.eMPCODE = eMPCODE;
    }

    public String getYearID() {
        return yearID;
    }

    public void setYearID(String yearID) {
        this.yearID = yearID;
    }

    public String getMonthID() {
        return monthID;
    }

    public void setMonthID(String monthID) {
        this.monthID = monthID;
    }

    public String getWeekID() {
        return weekID;
    }

    public void setWeekID(String weekID) {
        this.weekID = weekID;
    }

    public String getEMPDATE() {
        return eMPDATE;
    }

    public void setEMPDATE(String eMPDATE) {
        this.eMPDATE = eMPDATE;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public Object getTimeOffStart() {
        return timeOffStart;
    }

    public void setTimeOffStart(Object timeOffStart) {
        this.timeOffStart = timeOffStart;
    }

    public Object getTimeOffEnd() {
        return timeOffEnd;
    }

    public void setTimeOffEnd(Object timeOffEnd) {
        this.timeOffEnd = timeOffEnd;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

}

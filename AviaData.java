/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.List;

// Класс для хранения исходных данных - информации о полетах
public class AviaData {

    String DayofMonth;
    String DayOfWeek;
    String FlightDate;
    String UniqueCarrier;
    String TailNum;
    String OriginAirportID;
    String Origin;
    String OriginStateName;
    String DestAirportID;
    String Dest;
    String DestStateName;
    String DepTime;
    String DepDelay;
    String WheelsOff;
    String WheelsOn;
    String ArrTime;
    String ArrDelay;
    String Cancelled;
    String CancellationCode;
    String Diverted;
    String AirTime;
    String Distance;


    AviaData(String[] Data) {
        this.DayofMonth = Data[0];
        this.DayOfWeek = Data[1];
        this.FlightDate = Data[2];
        this.UniqueCarrier = Data[3];
        this.TailNum = Data[4];
        this.OriginAirportID = Data[5];
        this.Origin = Data[6];
        this.OriginStateName = Data[7];
        this.DestAirportID = Data[8];
        this.Dest = Data[9];
        this.DestStateName = Data[10];
        this.DepTime = Data[11];
        this.DepDelay = Data[12];
        this.WheelsOff = Data[13];
        this.WheelsOn = Data[14];
        this.AirTime = Data[15];
        this.ArrDelay = Data[16];
        this.Cancelled = Data[17];
        this.CancellationCode = Data[18];
        this.Diverted = Data[19];
        this.AirTime = Data[20];
        this.Distance = Data[21];
    }

    public String getUniqueCarrier() {
        return this.UniqueCarrier;
    }

    public String getOriginAirportID() {
        return this.OriginAirportID;
    }

    public String getDestAirportID() {
        return this.DestAirportID;
    }

    public boolean getCancelled() {
        return this.Cancelled.equals("1");
    }

    public String getCancellationCode() {
        return this.CancellationCode;
    }

    public String getDayofMonth() {
        return this.DayofMonth;
    }

    public String getTailNum() {
        return this.TailNum;
    }

    public Integer getDepDelay() {
        Integer a = 0;
        a = Integer.valueOf(this.DepDelay);
        return a;

    }

    public Integer getArrDelay() {
        Integer a = 0;
        a = Integer.valueOf(this.ArrDelay);
        return a;

    }

    public Integer getAirTime() {
        Integer a = 0;
        a = Integer.valueOf(this.AirTime);
        return a;
    }

    public Integer getDistance() {
        Integer a = 0;
        a = Integer.valueOf(this.Distance);
        return a;
    }

    public Integer getDelay() {
        Integer a = 0;
        a = Integer.valueOf(this.DepDelay) < Integer.valueOf(this.ArrDelay)
                ? Integer.valueOf(this.ArrDelay)
                : Integer.valueOf(this.DepDelay);

        return a;
    }

}

package com.coolweather.myweather.db;



import org.litepal.crud.LitePalSupport;



public class County extends LitePalSupport {

    private int id;

    private String countyName;

    private String weatherId;

    private int CityId;

    private boolean flag;



    public void setFlag(boolean flag) {

        this.flag = flag;

    }

    public boolean getFlag(){

        return flag;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getCountyName() {

        return countyName;

    }

    public void setCountyName(String countyName) {

        this.countyName = countyName;

    }

    public String getWeatherId() {

        return weatherId;

    }

    public void setWeatherId(String weatherId) {

        this.weatherId = weatherId;

    }

    public int getCityId() {

        return CityId;

    }

    public void setCityId(int cityId) {

        CityId = cityId;

    }

}


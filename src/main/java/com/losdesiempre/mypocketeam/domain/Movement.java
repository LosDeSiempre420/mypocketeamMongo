package com.losdesiempre.mypocketeam.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movimientos")
public class Movement {
    public void setId(int i) {
    }

    public void setName(String absorb) {
    }

    public void setType(String grass) {
    }

    public void setCategory(String special) {
    }

    public void setPower(Integer i) {
    }

    public void setAccuracy(Integer i) {
    }

    public void setPp(int i) {
    }

    public void setEffect(String s) {
    }

    public int getId() {
        return 0;
    }

    public String getName() {
        return "";
    }

    public String getType() {
        return "";
    }

    public String getCategory() {
        return "";
    }

    public Integer getPower() {
        return -1;

    }

    public Integer getAccuracy() {
        return -1;
    }

    public int getPp() {
        return 0;
    }

    public String getEffect() {
        return "";
    }
}

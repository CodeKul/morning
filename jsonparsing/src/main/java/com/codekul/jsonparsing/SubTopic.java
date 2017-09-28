
package com.codekul.jsonparsing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubTopic {

    @SerializedName("http")
    @Expose
    private String http;
    @SerializedName("weight")
    @Expose
    private Double weight;

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}

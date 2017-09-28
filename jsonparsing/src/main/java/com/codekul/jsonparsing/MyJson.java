
package com.codekul.jsonparsing;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyJson {

    @SerializedName("nm")
    @Expose
    private String nm;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("topicNum")
    @Expose
    private Integer topicNum;
    @SerializedName("isGood")
    @Expose
    private Boolean isGood;
    @SerializedName("subTopic")
    @Expose
    private SubTopic subTopic;
    @SerializedName("topics")
    @Expose
    private List<String> topics = null;

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }

    public Boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(Boolean isGood) {
        this.isGood = isGood;
    }

    public SubTopic getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(SubTopic subTopic) {
        this.subTopic = subTopic;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

}

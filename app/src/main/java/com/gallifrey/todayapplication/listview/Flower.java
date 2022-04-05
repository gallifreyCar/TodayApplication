package com.gallifrey.todayapplication.listview;

public class Flower {
    private int imageId;
    private String name;
    private String content;
    private  Boolean checkStatus;
    public Flower(int imageId,String name,String content){
        this.imageId=imageId;
        this.name=name;
        this.content=content;
        checkStatus=false;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Boolean checkStatus) {
        this.checkStatus=checkStatus;
    }
}

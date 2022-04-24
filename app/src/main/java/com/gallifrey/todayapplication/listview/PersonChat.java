package com.gallifrey.todayapplication.listview;

public class PersonChat {
    private int imageId;
    private String words;
    private Boolean status;
    public PersonChat(int imageId,String words,Boolean status){
        this.imageId=imageId;
        this.words=words;
        this.status=status;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

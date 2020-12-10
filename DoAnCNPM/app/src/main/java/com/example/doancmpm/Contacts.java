package com.example.doancmpm;

public class Contacts {
    String Title;
    int Image;

    public Contacts()
    {

    }
    public Contacts(String Title) {
        this.Title = Title;
    }

    public Contacts(String Title, int Image)
    {
        this.Title = Title;
        this.Image = Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int Image) {
        this.Image = Image;
    }
}

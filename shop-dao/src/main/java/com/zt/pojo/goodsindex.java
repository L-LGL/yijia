package com.zt.pojo;

public class goodsindex {
    private String id;
    private String title;
    private String info;
    private String img;
    private String type;
    public goodsindex(){}

    public goodsindex(String id, String title, String info, String img, String type) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.img = img;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "goodsindex{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", img='" + img + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

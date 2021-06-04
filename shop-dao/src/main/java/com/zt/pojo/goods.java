package com.zt.pojo;

public class goods {

    private String id;
    private int sid;
    private String img;
    private String title;
    private String info;
    private String name;
    private int price;
    private int stock;
    private String para;
    private String type;
    private int weight;
    private int priority;
    private String store;

    public goods(){}

    public goods(String id, String img, String title, String info, String name, int price, int stock, String para, String type, int weight, int priority) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.info = info;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.para = para;
        this.type = type;
        this.weight = weight;
        this.priority = priority;
    }

    public goods(String id, int s_id, String img, String title, String info, String name, int price, int stock, String para, String type, int weight, int priority) {
        this.id = id;
        this.sid = s_id;
        this.img = img;
        this.title = title;
        this.info = info;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.para = para;
        this.type = type;
        this.weight = weight;
        this.priority = priority;
    }

    public goods(String id, int s_id, String img, String title, String info, String name, int price, int stock, String para, String type, int weight, int priority, String store) {
        this.id = id;
        this.sid = s_id;
        this.img = img;
        this.title = title;
        this.info = info;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.para = para;
        this.type = type;
        this.weight = weight;
        this.priority = priority;
        this.store = store;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getS_id() {
        return sid;
    }

    public void setS_id(int s_id) {
        this.sid = s_id;
    }

    @Override
    public String toString() {
        return "goods{" +
                "id='" + id + '\'' +
                ", s_id=" + sid +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", para='" + para + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", priority=" + priority +
                ", store='" + store + '\'' +
                '}';
    }
}

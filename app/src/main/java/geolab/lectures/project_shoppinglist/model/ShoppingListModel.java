package geolab.lectures.project_shoppinglist.model;

/**
 * Created by Jay on 6/26/2015.
 */
public class ShoppingListModel {
    private long id;
    private String title;
    private String date;
    private int type;

    public ShoppingListModel(int type, String date) {
        this.date = date;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShoppingListModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", type=" + type +
                '}';
    }
}

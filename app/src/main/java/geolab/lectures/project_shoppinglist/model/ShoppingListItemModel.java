package geolab.lectures.project_shoppinglist.model;

/**
 * Created by Jay on 6/26/2015.
 */
public class ShoppingListItemModel {
    public enum ShoppingListItemState {Unchecked, Checked};
    private long id, parentId;
    private String value;
    private int isChecked = ShoppingListItemState.Unchecked.ordinal();

    public ShoppingListItemModel(long parentId, String value, int isChecked) {
        this.parentId = parentId;
        this.value = value;
        this.isChecked = isChecked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "ShoppingListItemModel{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", value='" + value + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}

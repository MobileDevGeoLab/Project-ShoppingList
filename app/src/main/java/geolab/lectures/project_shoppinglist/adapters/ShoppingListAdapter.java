package geolab.lectures.project_shoppinglist.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import geolab.lectures.project_shoppinglist.R;
import geolab.lectures.project_shoppinglist.model.ShoppingListModel;

/**
 * Created by Jay on 6/26/2015.
 */
public class ShoppingListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ShoppingListModel> shoppingList;

    public ShoppingListAdapter(Context context, ArrayList<ShoppingListModel> shoppingList){
        this.context = context;
        this.shoppingList = shoppingList;
    }

    @Override
    public int getCount() {
        return shoppingList.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = View.inflate(context, R.layout.shopping_list_item_layout, null);
        TextView textView = (TextView) itemView.findViewById(R.id.shopping_list_title);
        textView.setText(String.valueOf(getItem(position)));

        return itemView;
    }
}

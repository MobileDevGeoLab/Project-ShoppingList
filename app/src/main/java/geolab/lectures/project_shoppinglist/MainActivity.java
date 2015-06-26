package geolab.lectures.project_shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import geolab.lectures.project_shoppinglist.adapters.ShoppingListAdapter;
import geolab.lectures.project_shoppinglist.model.ShoppingListModel;


public class MainActivity extends ActionBarActivity {
    private Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        ArrayList<ShoppingListModel> listItems = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            listItems.add(new ShoppingListModel(1, "26-06-2015", "Drakula Untoldis Recepti", 5));
        }

        ListView shoppingListView = (ListView) findViewById(R.id.shoppingListView);
        ShoppingListAdapter adapter = new ShoppingListAdapter(this, listItems);
        shoppingListView.setAdapter(adapter);

        Button newList = (Button) findViewById(R.id.newListButton);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingListDetailsIntent = new Intent(mainActivity, ShoppingListDetailsActivity.class);
                startActivity(shoppingListDetailsIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

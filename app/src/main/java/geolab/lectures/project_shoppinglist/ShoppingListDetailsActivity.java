package geolab.lectures.project_shoppinglist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import geolab.lectures.project_shoppinglist.custom_views.CheckBoxView;


public class ShoppingListDetailsActivity extends ActionBarActivity {
    private EditText titleView;
    private LinearLayout uncheckedContainer, checkedContainer;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_details);

        activity = this;

        titleView = (EditText) findViewById(R.id.listTitle);
        uncheckedContainer = (LinearLayout) findViewById(R.id.unchecked_container);
        checkedContainer = (LinearLayout) findViewById(R.id.checked_container);


        final EditText newItemValue = (EditText) findViewById(R.id.newItem);
        Button addNewItem = (Button) findViewById(R.id.addItem);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBoxView item = new CheckBoxView(activity, String.valueOf(newItemValue.getText()), false, checkedContainer, uncheckedContainer);
                uncheckedContainer.addView(item);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_list_details, menu);
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

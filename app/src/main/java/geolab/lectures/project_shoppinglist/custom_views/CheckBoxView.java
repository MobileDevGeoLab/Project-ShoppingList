package geolab.lectures.project_shoppinglist.custom_views;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import geolab.lectures.project_shoppinglist.R;

/**
 * Created by Jay on 6/26/2015.
 */
public class CheckBoxView extends LinearLayout {
    private Context context;
    private LinearLayout parentView;
    private CheckBox checkBox;
    private EditText editText;
    private Button removeBtn;

    private LinearLayout checkedContainer, uncheckedContainer;

    private String value;
    private boolean isChecked;

    public CheckBoxView(Context context, String value, boolean isChecked, LinearLayout checkedContainer, LinearLayout uncheckedContainer) {
        super(context);
        this.context = context;
        this.checkedContainer = checkedContainer;
        this.uncheckedContainer = uncheckedContainer;
        this.value = value;
        this.isChecked = isChecked;
        initViews();
    }

    private void initViews(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parentView = (LinearLayout) inflater.inflate(R.layout.checkbox_custom_view, this, true);
        checkBox = (CheckBox) parentView.findViewById(R.id.checkBox);
        editText = (EditText) parentView.findViewById(R.id.text);
        removeBtn = (Button) parentView.findViewById(R.id.removeBtn);

        editText.setText(value);
        setValue(isChecked);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editText.setPaintFlags(editText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    uncheckedContainer.removeView(getView());
                    CheckBoxView copy = new CheckBoxView(context, String.valueOf(editText.getText()), true, checkedContainer, uncheckedContainer);
                    checkedContainer.addView(copy);
                } else {
                    editText.setPaintFlags(editText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    checkedContainer.removeView(getView());
                    CheckBoxView copy = new CheckBoxView(context, String.valueOf(editText.getText()), false, checkedContainer, uncheckedContainer);
                    uncheckedContainer.addView(copy);
                }
            }
        });

        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    removeBtn.setVisibility(VISIBLE);
                } else {
                    removeBtn.setVisibility(INVISIBLE);
                }
            }
        });

        removeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    checkedContainer.removeView(getView());
                } else {
                    uncheckedContainer.removeView(getView());
                }
            }
        });
    }

    public View getView(){
        return this;
    }

    public void setValue(boolean isChecked){
        if(isChecked){
            checkBox.setChecked(true);
            editText.setPaintFlags(editText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else{
            checkBox.setChecked(false);
            editText.setPaintFlags(editText.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
    }
}

package ntu.ce2006.swensens.hdbdesirabilityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;

import ntu.ce2006.swensens.hdbdesirabilityapp.R;

public class Search_Price_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__price_);
        String s = "Set Price";
        setTitle(s);
    }

    @Override
    public void onPause() {
        super.onPause();

        // item = text field
        String minPriceString = ((EditText) findViewById(R.id.MinPriceInput)).getText().toString();
        minPriceString = sanitizePrice(minPriceString);

        // item = text field
        String maxPriceString = ((EditText) findViewById(R.id.MaxPriceInput)).getText().toString();
        maxPriceString = sanitizePrice(maxPriceString);

        if(Integer.parseInt(maxPriceString) > Integer.parseInt(minPriceString)) {
            save("MinPriceInput", minPriceString);
            save("MaxPriceInput", maxPriceString);
        }
        else if (Integer.parseInt(maxPriceString) < Integer.parseInt(minPriceString)){
            save("MinPriceInput", maxPriceString);
            save("MaxPriceInput", minPriceString);
        }
        else{
            save("MinPriceInput", Integer.toString(Integer.parseInt(minPriceString)-1));
            save("MaxPriceInput", minPriceString);
        }
    }

    private String sanitizePrice(String inputString){

        // remove non-numeric characters
        inputString.replaceAll("[^0-9.]", "");

        // convert to number
        int price = Integer.parseInt(inputString);

        // limit max number
        if(price > 2000000)
            return "2000000";

        return Integer.toString(price);
    }

    @Override
    public void onResume() {
        super.onResume();

        EditText tempEditText;
        String savedString;

        // item = text field with number input
        tempEditText = (EditText) findViewById(R.id.MinPriceInput);
        savedString = load("MinPriceInput");
        tempEditText.setText(savedString);

        // item = text field with number input
        tempEditText = (EditText) findViewById(R.id.MaxPriceInput);
        savedString = load("MaxPriceInput");
        tempEditText.setText(savedString);
    }

    private void save(String itemName, String itemString) {
        // item = int
        SharedPreferences sharedPreferences = getSharedPreferences("x",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(itemName,itemString);
        editor.commit();
    }

    private String load(String itemName) {
        SharedPreferences sharedPreferences = getSharedPreferences("x",Context.MODE_PRIVATE);
        return sharedPreferences.getString(itemName,"0");
    }
}

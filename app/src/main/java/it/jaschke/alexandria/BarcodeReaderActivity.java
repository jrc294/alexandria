package it.jaschke.alexandria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by jonathan.cook on 11/4/2015.
 */
public class BarcodeReaderActivity extends ActionBarActivity implements BarcodeReader.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_reader);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.


            BarcodeReader fragment = new BarcodeReader();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.bar_code_reader_container, fragment)
                    .commit();
        }
    }
    @Override
    public void onItemSelected(String barCode) {
        Intent i = new Intent();
        i.putExtra("barcode",barCode);
        setResult(RESULT_OK,i);
        finish();
    }
}

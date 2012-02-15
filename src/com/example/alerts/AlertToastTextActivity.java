package com.example.alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AlertToastTextActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Dialog box setup and selection handling:
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case DialogInterface.BUTTON_POSITIVE: // Yes button action (display check mark)
					ImageView cMarkDisplay = (ImageView) findViewById(R.id.cMark);
					cMarkDisplay.setImageResource(R.drawable.c_mark);
					break;
					
				case DialogInterface.BUTTON_NEGATIVE: // No button action (display x mark)
					ImageView xMarkDisplay = (ImageView) findViewById(R.id.xMark);
					xMarkDisplay.setImageResource(R.drawable.x_mark);
					break;
				}
			}
		}; // end of Dialog
		
		// Add the text and show the box:
		AlertDialog.Builder alertMessage = new AlertDialog.Builder(this);
		alertMessage.setMessage("Did you see this?").setPositiveButton("Yes", dialogClickListener)
				    .setNegativeButton("No", dialogClickListener).show();
		
		// Long press of the button:
        final Button theButton = (Button) findViewById(R.id.theButton);
        theButton.setOnLongClickListener(new View.OnLongClickListener() {
        	@Override
        	public boolean onLongClick(View view) {
        		Context context = getApplicationContext();
        		Toast.makeText(context, "Loooong click", Toast.LENGTH_SHORT).show();
        		return true;
        	}
        });

    } // end of onCreate
    
    // Short click method:
	public void shortClick(View view) {
		Toast.makeText(this, "Tap tap", Toast.LENGTH_SHORT).show();
	}     
}
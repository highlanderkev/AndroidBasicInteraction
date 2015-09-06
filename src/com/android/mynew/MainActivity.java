package com.android.mynew;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.KeyEvent;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Button button1 = new Button(this);
	button1.setText("Press Me!");
	
	final EditText et = new EditText(this);
	et.setText("Edit this text!");
	
	Button button2 = new Button(this);
	button2.setText("Get Text!");

	final TextView console = new TextView(this);


	/*
	TextView tv1 = new TextView(this);
	String longText = "";
	for(int i=1; i< 100; i++){
	    longText += "Line_" + i + "\n";
	}
	tv1.setText(longText);
	
	TextView tv2 = new TextView(this);
	tv2.setText("Another_TextView!");
	*/

	
	LinearLayout ll = new LinearLayout(this);
	ll.setOrientation(LinearLayout.VERTICAL);
	ll.addView(button1);
	ll.addView(et);
	ll.addView(button2);
	ll.addView(console);
	

	ScrollView sv = new ScrollView(this);
	sv.addView(ll);
	sv.setFillViewport(true);

	button1.setOnClickListener(new View.OnClickListener(){
		int numPresses = 0;
		public void onClick(View v){
		    console.setText(console.getText() + "\nButton Press " + numPresses++);
		}
	    });
	et.setOnKeyListener(new View.OnKeyListener(){
		int numPresses = 0;
		public boolean onKey(View v, int keyCode, KeyEvent event){
		    if(event.getAction() == KeyEvent.ACTION_DOWN){
			if(numPresses % 10 == 0)
			    console.setText(console.getText() + "\nKey Press " + numPresses);
			numPresses++;
		    }
		    return false;
		}
	    });
	button2.setOnClickListener(new View.OnClickListener(){
		public void onClick(View v){
		    console.setText(console.getText() + "\nCurrent Text = \"" + et.getText() + "\"");
		}
	    });

	setContentView(sv);
    }
}

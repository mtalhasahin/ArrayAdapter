package com.example.arrayadapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ArrayAdapterActivity extends Activity {

	List<CharSequence> getcities;
	ArrayAdapter<CharSequence> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_adapter);
		getcities();
	}
	private void getcities() {
	getcities=new ArrayList<CharSequence>();
	getcities.add("Ankara");
	getcities.add("Ýstanbul");
	getcities.add("izmir");
	getcities.add("Ýzmit");
	getcities.add("Bursa");
	getcities.add("Bolu");
	
	adapter=new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_dropdown_item,getcities);
	Spinner spinner=(Spinner) findViewById(R.id.spinner);
	spinner.setAdapter(adapter);
	
	Button button=(Button) findViewById(R.id.button);
	final EditText sehirEditText=(EditText) findViewById(R.id.editText);
	final TextView durumTextView=(TextView) findViewById(R.id.textView1);
	button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String sehiradi=sehirEditText.getText().toString();
			getcities.add(sehiradi);
			adapter.notifyDataSetChanged();
			sehirEditText.setText("");
			durumTextView.setText(sehiradi+" baþarýyla eklendi");
		
			
			
		}
	});
	
		
	}
}

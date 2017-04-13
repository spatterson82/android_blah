package org.disasterproject4a;

import java.util.HashMap;

import org.disasterproject4a.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ReportFilterActivity extends Activity {
	private Spinner mDisasterSpinner;
	private Spinner mReportSpinner;
	private LinearLayout mResourceOrDamageLaylout;
	private TextView mResourceOrDamageLabel;
	private Spinner mResourceOrDamageSpinner;
	
	@Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_report_filter);
    
    mDisasterSpinner = (Spinner) findViewById(R.id.disaster_type_spinner);
    setSpinnerResource(mDisasterSpinner,R.array.disaster_type_spinner);
    
    mReportSpinner = (Spinner) findViewById(R.id.report_type_spinner);
    setSpinnerResource(mReportSpinner,R.array.report_type_spinner);
    
    mResourceOrDamageLaylout = (LinearLayout) findViewById(R.id.resource_or_damage_type_layout);
    mResourceOrDamageLabel = (TextView) findViewById(R.id.resource_or_damage_type_text_view);
    mResourceOrDamageSpinner = (Spinner) findViewById(R.id.resource_or_damage_type_spinner);
      
  }
	
	private void setSpinnerResource(Spinner spinner, int srcId) {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        srcId, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	public void submitQuery(View view) {
		int p1 = mDisasterSpinner.getSelectedItemPosition();
		int p2 = mReportSpinner.getSelectedItemPosition();
		
		Intent returnIntent = new Intent();
		HashMap<String, String> data = new HashMap<String,String>();
		data.put("tab_id","1");
		if (p1!=0){
			String text = mDisasterSpinner.getSelectedItem().toString();
			data.put("disaster_type",text);
		}
		if (p2!=0) {
			String text = mReportSpinner.getSelectedItem().toString();
			data.put("report_type",text);
		}
		
		returnIntent.putExtra("data", data);
    setResult(Activity.RESULT_OK,returnIntent);
		finish();
  }

}

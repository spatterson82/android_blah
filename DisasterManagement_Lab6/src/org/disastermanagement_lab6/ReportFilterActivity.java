package org.disastermanagement_lab6;

import org.disastermanagement_lab6.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
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
	
	public class SpinnerActivity extends Activity implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			mResourceOrDamageSpinner.setVisibility(View.VISIBLE);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			mResourceOrDamageSpinner.setVisibility(View.GONE);
			
		}
	}

}

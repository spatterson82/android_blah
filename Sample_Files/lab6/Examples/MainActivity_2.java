package org.disasterproject4a;

import java.util.HashMap;

import org.disasterproject4a.AsyncHttpPost;
import org.disasterproject4a.R;
import org.disasterproject4a.ReportFilterActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	private GoogleMap map;
	private static final int QUERY_REPORT_REQUEST = 1;
	public static String servletURL = "http://10.0.3.2:8080/WebProject/HttpServlet";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("tab_id", "1");
		AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data,map);
    asyncHttpPost.execute(servletURL);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.report_filter) {
			Intent intent = new Intent(this, ReportFilterActivity.class);
			startActivityForResult(intent,QUERY_REPORT_REQUEST);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	    if (requestCode == QUERY_REPORT_REQUEST) {
	        if(resultCode == Activity.RESULT_OK){
	        	HashMap<String, String> postData = null;
	      		postData = (HashMap<String, String>)data.getSerializableExtra("data");

	      		AsyncHttpPost asyncHttpPost = new AsyncHttpPost(postData,map);
	      	  asyncHttpPost.execute(servletURL);
	        }
	    }
	}

}

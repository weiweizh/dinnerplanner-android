package se.kth.csc.iprog.dinnerplanner.android;


import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuView;
import se.kth.csc.iprog.dinnerplanner.android.view.SummaryView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;

public class SummaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);

		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		SummaryView mainView = new SummaryView(findViewById(R.id.activity_summary_id), model);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summary, menu);
		return true;
	}
	
	public void backToChooseMenu(View view) {
		   
		  Intent intent;
		  
		  intent = new Intent(this, ChooseMenuActivity.class);
		  startActivity(intent);
	  } 
	

}

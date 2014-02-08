package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChooseMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_menu);
		
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		ChooseMenuView mainView = new ChooseMenuView(findViewById(R.id.activity_choose_menu_id), model);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_menu, menu);
		return true;
	}

}

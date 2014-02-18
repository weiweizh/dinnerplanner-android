package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuViewController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ChooseMenuActivity extends Activity {

	ChooseMenuView mainView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_menu);
		
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		mainView = new ChooseMenuView(findViewById(R.id.activity_choose_menu_id), model);
		
		ChooseMenuViewController viewController = new ChooseMenuViewController(model, mainView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_menu, menu);
		return true;
	}



    //create function to jump to the next page
       public void createMenu(View view) {
    	   
    	   
	   
	   Intent intent;
	  
	   intent = new Intent(this,SummaryActivity.class);
	   startActivity(intent);
} 
      
      public void closeWindow(View view){
    	  mainView.pressedDishWindow.dismiss();
      } 
       

}
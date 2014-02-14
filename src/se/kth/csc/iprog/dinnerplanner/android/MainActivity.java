package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.WelcomeView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        
    	// Creating the view class instance
    	WelcomeView mainView = new WelcomeView(findViewById(R.id.activity_main_id));

    }
    
    public void startChoose(View view) {
		   
			  Intent intent;
			  
			  intent = new Intent(this,ChooseMenuActivity.class);
			  startActivity(intent);
		  } 
    
    

}

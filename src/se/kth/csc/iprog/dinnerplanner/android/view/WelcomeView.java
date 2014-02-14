package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import android.content.Context;
import android.view.View;
import android.widget.Button;


public class WelcomeView {

	View view;
	public Button startButton;

	public WelcomeView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

//		TextView example = (TextView) view.findViewById(R.id.example_text);
//		example.setText("[gg]Welcome to Dinner Planner!Here you will be able to easily plan your dinner.On the next page start by selecting number of participants.Then select your courses.Watch Magic Happen!");

		// Setup the rest of the view layout
		startButton = (Button) view.findViewById(R.id.start_button);
	}

	public Context getContext() {
		// TODO Auto-generated method stub
	    return view.getContext();
		
	}

}

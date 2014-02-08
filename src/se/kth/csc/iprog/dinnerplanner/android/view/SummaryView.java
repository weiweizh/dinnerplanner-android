package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.TextView;

public class SummaryView {

	View view;
	DinnerModel model;

	public SummaryView(View view, DinnerModel dinnerModel) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = dinnerModel;

		//TODO: get right text label
//		TextView example = (TextView) view.findViewById(R.id.example_text);	
//		example.setText(String.valueOf(this.model.getTotalMenuPrice()));

		// Setup the rest of the view layout
	}

}

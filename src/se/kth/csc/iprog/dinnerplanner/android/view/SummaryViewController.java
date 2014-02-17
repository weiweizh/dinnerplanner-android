package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.util.Log;

public class SummaryViewController implements OnClickListener{
	SummaryView view;
	DinnerModel model;
	
	public SummaryViewController(DinnerModel model, SummaryView view) {
		this.model = model;
		this.view = view;

		// Here we setup the listeners
		this.view.ingredientBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == this.view.ingredientBtn){

			Log.d("SummaryViewController", "ing btn is clicked");
			this.view.ingredientView.setVisibility(View.VISIBLE);

			this.view.instructionView.setVisibility(View.GONE);	
		}
		
		
	}

}

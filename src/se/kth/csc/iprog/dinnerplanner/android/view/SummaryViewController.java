package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.annotation.SuppressLint;
import android.util.Log;

public class SummaryViewController implements OnClickListener{
	SummaryView view;
	DinnerModel model;
	
	public SummaryViewController(DinnerModel model, SummaryView view) {
		this.model = model;
		this.view = view;

		// Here we setup the listeners
		this.view.ingredientBtn.setOnClickListener(this);
		this.view.dish1Btn.setOnClickListener(this);
		this.view.dish2Btn.setOnClickListener(this);
		this.view.dish3Btn.setOnClickListener(this);
	}

//	@SuppressLint("NewApi")
	@Override
	public void onClick(View clickedView) {
		if(clickedView == this.view.ingredientBtn){
			Log.d("SummaryViewController", "ingre btn is clicked");
			this.uncheckAllBtn();
			this.view.ingredientBtn.setChecked(true);
			
			this.view.ingredientView.setVisibility(View.VISIBLE);
			this.view.instructionView.setVisibility(View.GONE);	
		}else if(clickedView == this.view.dish1Btn){
			Log.d("SummaryViewController", "starter btn is clicked");
			this.uncheckAllBtn();
			this.view.dish1Btn.setChecked(true);
			
			this.view.ingredientView.setVisibility(View.GONE);
			this.view.instructionView.setVisibility(View.VISIBLE);	
			this.view.showDishByType(1);
		}else if(clickedView == this.view.dish2Btn){
			Log.d("SummaryViewController", "main btn is clicked");
			this.uncheckAllBtn();
			this.view.dish2Btn.setChecked(true);
			
			this.view.ingredientView.setVisibility(View.GONE);
			this.view.instructionView.setVisibility(View.VISIBLE);	
			this.view.showDishByType(2);
		}else if(clickedView == this.view.dish3Btn){
			Log.d("SummaryViewController", "desert btn is clicked");
			this.uncheckAllBtn();
			this.view.dish3Btn.setChecked(true);
			
			this.view.ingredientView.setVisibility(View.GONE);
			this.view.instructionView.setVisibility(View.VISIBLE);	
			this.view.showDishByType(3);
		}
	}
	
	protected void uncheckAllBtn(){
		this.view.ingredientBtn.setChecked(false);
		this.view.dish1Btn.setChecked(false);
		this.view.dish2Btn.setChecked(false);
		this.view.dish3Btn.setChecked(false);
		
	}
}

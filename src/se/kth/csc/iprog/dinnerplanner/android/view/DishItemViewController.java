package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.view.DishItemView; 
import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuView; 

public class DishItemViewController implements OnClickListener, OnLongClickListener{
	DinnerModel model = null;
	DishItemView view = null;
	ChooseMenuView parentView = null;
	
	public DishItemViewController(DinnerModel dinnerModel, DishItemView dishItemView, ChooseMenuView pageView) {
		this.model = dinnerModel;
		this.view = dishItemView;
		this.parentView = pageView;
		
		//Set up listeners here
		this.view.setOnClickListener(this);
		this.view.setOnLongClickListener(this);
		
	}


	@Override
	public void onClick(View clickedView) {
		// TODO Auto-generated method stub
		Log.d("DishItemViewController", "onClick");	
		if(clickedView instanceof DishItemView){
			//Highlight selected dish
			((DishItemView) clickedView).setHighlight(true);

			//Update DinnerModel
			this.model.selectDish(((DishItemView) clickedView).dish);	
		}
		
	}


	@Override
	public boolean onLongClick(View clickedView) {
		// TODO Auto-generated method stub
		Log.d("DishItemViewController", "onLongClick");
		
		if(clickedView instanceof DishItemView){
			if(this.parentView != null){
				this.parentView.showPopup();
			}
			
		}
		
		//return true so it wont trigger onClick
		return true;
	}

}

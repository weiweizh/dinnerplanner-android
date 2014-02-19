package se.kth.csc.iprog.dinnerplanner.android.view;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.android.view.DishItemView; 

public class DishItemViewController implements OnClickListener, OnLongClickListener{
	DinnerModel model;
	DishItemView view;
	
	
	public DishItemViewController(DinnerModel dinnerModel, DishItemView dishItemView) {
		this.model = dinnerModel;
		this.view = dishItemView;
		
		//Set up listeners here
		this.view.setOnClickListener(this);
		this.view.setOnLongClickListener(this);
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.d("DishItemViewController", "onClick");
		
	}


	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Log.d("DishItemViewController", "onLongClick");
		return false;
	}

}

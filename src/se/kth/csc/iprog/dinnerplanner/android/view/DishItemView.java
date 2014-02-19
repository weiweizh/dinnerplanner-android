package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.net.Uri;


public class DishItemView extends LinearLayout{

	Dish dish;

	public DishItemView(Context context, Dish dishItem) {
		super(context);

		// store in the class the reference to the Android View
		this.dish = dishItem;
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.dish_item_view, this, true);
		
		//Set image
		ImageView dishImage = (ImageView) this.findViewById(R.id.dish_item_image);
//		Uri uri = Uri.parse("android.resource://se.kth.csc.iprog.dinnerplanner.android/drawable/" + this.dish.getImage());
//		dishImage.setImageURI(uri);
		dishImage.setImageResource(DinnerPlannerApplication.getImageResId(context, this.dish.getImage()));

		
		//Set text
		TextView dishCaption = (TextView) this.findViewById(R.id.dish_item_caption);	
		dishCaption.setText(String.valueOf(this.dish.getName()));

	}
	
	public void setHighlight(boolean enableHighlight){
		if(enableHighlight){
			this.setBackgroundColor(Color.GRAY);
		}else{
			this.setBackgroundColor(Color.TRANSPARENT);
		}
	}


}

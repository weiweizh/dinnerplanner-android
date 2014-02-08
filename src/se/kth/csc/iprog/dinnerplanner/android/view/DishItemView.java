package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

public class DishItemView extends LinearLayout{

	Dish dish;
//	ViewGroup view;

	public DishItemView(Context context, Dish dishItem) {
		super(context);

		// store in the class the reference to the Android View
		this.dish = dishItem;
//		this.view = new ViewGroup();
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService
			      (Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.dish_item_view, this, true);
		

		//Set image
		ImageView dishImage = (ImageView) this.findViewById(R.id.dish_item_image);
		
		//TOFIX: read image from filepath!!
		String filePath = context.getFileStreamPath(this.dish.getImage()).getAbsolutePath();
		Log.d("Image FilePath", filePath);
//		Bitmap bmImg = BitmapFactory.decodeFile(filePath);
//		dishImage.setImageBitmap(bmImg);
		
//		Drawable dishDrawable = Drawable.createFromPath(this.dish.getImage());
//		dishImage.setImageDrawable(dishDrawable);	
	
		
		//Set text
		TextView dishCaption = (TextView) this.findViewById(R.id.dish_item_caption);	
		dishCaption.setText(String.valueOf(this.dish.getName()));

	}


}

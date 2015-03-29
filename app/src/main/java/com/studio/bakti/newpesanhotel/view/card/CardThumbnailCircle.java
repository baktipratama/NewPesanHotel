package com.studio.bakti.newpesanhotel.view.card;

import it.gmariotti.cardslib.library.internal.CardThumbnail;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;

public class CardThumbnailCircle extends CardThumbnail{

    public CardThumbnailCircle(Context context) {
		super(context);
	}

	@Override
    public boolean applyBitmap(View imageView, Bitmap bitmap) {

       //Put your code here
       //Return true if your callback attaches the bitmap to the ImageView, false otherwise

       // Example:
       CircleDrawable circle = new CircleDrawable(bitmap,true);
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
           imageView.setBackground(circle);
       else
           imageView.setBackgroundDrawable(circle);
       return true;

    }

}

/**
 *  Copyright 2010 Bartl Dominic

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package at.bartinger.example;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import at.bartinger.candroid.CandroidActivity;
import at.bartinger.example.androidhunt.AndroidHuntView;


public class ExampleActivity extends CandroidActivity{

	public static int exampleNr = 0;
	private String startLabel = "This is an example about: \n\n";
	private String[] messages;
	AlertDialog.Builder dialog;
	private Context context;

	private Example01View view01;
	private Example02View view02;
	private Example03View view03;
	private Example04View view04;
	private Example05View view05;
	private Example06View view06;
	private Example07View view07;
	private Example08View view08;
	private Example09View view09;
	private Example10View view10;

	private AndroidHuntView andhuntview;

	private DisplayMetrics dm;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.context = this;
		setFullscreen(true);

		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		super.onCreate(savedInstanceState);
		switch(exampleNr){

		case 1:

			view01 = new Example01View(context);
			setContentView(view01);
			break;

		case 2:
			view02 = new Example02View(context);
			setContentView(view02);
			break;

		case 3:
			view03 = new Example03View(context, getDisplayMetrics());
			setContentView(view03);
			break;

		case 4:
			view04 = new Example04View(context);
			setContentView(view04);
			break;

		case 5:
			view05 = new Example05View(context);
			setContentView(view05);
			break;

		case 6:
			view06 = new Example06View(context);
			setContentView(view06);
			break;

		case 7:
			view07 = new Example07View(context);
			setContentView(view07);
			break;

		case 8:
			view08 = new Example08View(context);
			setContentView(view08);
			break;

		case 9:
			view09 = new Example09View(context,dm);
			setContentView(view09);
			break;

		case 10:
			view10 = new Example10View(context);
			setContentView(view10);
			break;

		case 11:
			andhuntview = new AndroidHuntView(this, dm);
			setContentView(andhuntview);
			break;

		}
		dialog = new AlertDialog.Builder(this);
		messages = new String[] {
				"Basics, Textures and Sprites",
				"Animations",
				"Backgrounds Part 1",
				"Backgrounds Part 2",
				"SFX and Backgroundmusic",
				"Text and Fonts",
				"Touch-, Trackball- and D-Pad Event",
				"Accelerometer",
				"CellView and CellRenderer",
				"Shapes"
		};

		dialog.setIcon(R.drawable.icon);
		dialog.setTitle("Candroid Game Engine");  
		
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.dismiss();
			}  
		});
		if(exampleNr != 11){
			dialog.setMessage(startLabel + messages[exampleNr-1]);
		}else{
			dialog.setMessage("This is a very very small dummy-game based on Candroid");
		}

		dialog.create().show();


	}

}

package com.tssf.ghooker.tssfprayers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;
import java.util.Date;

import com.tssf.ghooker.tssfprayers.utils.TssfUtils;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;

public class CommunityObedienceActivity extends Activity implements
		TssfPrayerConstants {
	ScrollView scroll;
	LinearLayout linear;
	LinearLayout buttons;
	Date _date = null;
	final public int ABOUT = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getDate() == null) {
			Date date = new Date();
			setDate(date);
		}
		scroll = new ScrollView(this);
		linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		linear.setPadding(10, 0, 10, 0);
		linear.addView(getDateTextView());
		linear.addView(getInstructionTextView());
		linear.addView(getGloriaTextView());
		linear.addView(getOpeningTextView());
		linear.addView(getPrincpleRubricTextView());
		linear.addView(getPrinciple());
		linear.addView(getIntercessionRubricTextView());
		this.getIntercessions();
		this.getPrivatePrayer();
		linear.addView(getCommunityPrayer());
		linear.addView(getCollectRubricTextView());
		linear.addView(getDayString());
		linear.addView(getCollectForDay());
		linear.addView(getBlessingRubric1());
		linear.addView(getBlessing1());
		linear.addView(getBlessingRubric2());
		linear.addView(getBlessing2());
		scroll.addView(linear);
		setContentView(scroll);
		// setContentView(R.layout.activity_test_it_screen);
	}

	// @Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		// menu.addSubMenu("Gordon Menu");
		return true;
	} */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0,ABOUT,0,getString(R.string.TSSFAboutTitle)).setIcon(R.drawable.info_icon);
    	return true;
    }
	
	@Override
	public boolean onOptionsItemSelected (MenuItem item){
    	switch (item.getItemId()){
    		case ABOUT:
    			AboutDialog about = new AboutDialog(this);
    			about.setTitle(getString(R.string.TSSFAboutDialog));
    			about.show();
    			break;
    	}
    	return true;
    }

	private TextView getDateTextView() {
		TextView dateView = new TextView(this);
		dateView.setText(TssfUtils.getDateString(getDate()));
		dateView.setTextSize(SMALL);
		dateView.setTextColor(Color.BLACK);
		dateView.setTypeface(null, Typeface.ITALIC);
		return dateView;
	}

	private TextView getInstructionTextView() {
		TextView instruction = new TextView(this);
		instruction.setText(getString(R.string.TSSFDailyObedienceExplain));
		instruction.setTextSize(SMALL);
		instruction.setTextColor(Color.RED);
		instruction.setTypeface(null, Typeface.ITALIC);
		return instruction;
	}

	private TextView getGloriaTextView() {
		TextView gloria = new TextView(this);
		gloria.setText(getString(R.string.TSSFGloriaPatra));
		gloria.setTextSize(NORMAL);
		gloria.setTextColor(Color.BLACK);
		return gloria;
	}

	private TextView getOpeningTextView() {
		TextView opening = new TextView(this);
		opening.setText(getString(R.string.TSSFOpeningPrayer));
		opening.setTextSize(NORMAL);
		opening.setTextColor(Color.BLACK);
		return opening;
	}

	private TextView getPrincpleRubricTextView() {
		TextView principleRubric = new TextView(this);
		String pString = getString(R.string.TSSFPrincipleRubric) + " "
				+ TssfUtils.getDayOfMonth(getDate()) + "\n";
		principleRubric.setText(pString);
		principleRubric.setTextSize(SMALL);
		principleRubric.setTextColor(Color.RED);
		principleRubric.setTypeface(null, Typeface.ITALIC);
		return principleRubric;
	}

	private TextView getPrinciple() {
		TextView principle = new TextView(this);
		int day = TssfUtils.getDayOfMonth(getDate());
		if (day == 31) {
			day = TssfUtils.getRandomDayOfMonth();
		}
		switch (day) {
		case 1:
			principle.setText(R.string.TSSFPrinciple1);
			break;
		case 2:
			principle.setText(R.string.TSSFPrinciple2);
			break;
		case 3:
			principle.setText(R.string.TSSFPrinciple3);
			break;
		case 4:
			principle.setText(R.string.TSSFPrinciple4);
			break;
		case 5:
			principle.setText(R.string.TSSFPrinciple5);
			break;
		case 6:
			principle.setText(R.string.TSSFPrinciple6);
			break;
		case 7:
			principle.setText(R.string.TSSFPrinciple7);
			break;
		case 8:
			principle.setText(R.string.TSSFPrinciple8);
			break;
		case 9:
			principle.setText(R.string.TSSFPrinciple9);
			break;
		case 10:
			principle.setText(R.string.TSSFPrinciple10);
			break;
		case 11:
			principle.setText(R.string.TSSFPrinciple11);
			break;
		case 12:
			principle.setText(R.string.TSSFPrinciple12);
			break;
		case 13:
			principle.setText(R.string.TSSFPrinciple13);
			break;
		case 14:
			principle.setText(R.string.TSSFPrinciple14);
			break;
		case 15:
			principle.setText(R.string.TSSFPrinciple15);
			break;
		case 16:
			principle.setText(R.string.TSSFPrinciple16);
			break;
		case 17:
			principle.setText(R.string.TSSFPrinciple17);
			break;
		case 18:
			principle.setText(R.string.TSSFPrinciple18);
			break;
		case 19:
			principle.setText(R.string.TSSFPrinciple19);
			break;
		case 20:
			principle.setText(R.string.TSSFPrinciple20);
			break;
		case 21:
			principle.setText(R.string.TSSFPrinciple21);
			break;
		case 22:
			principle.setText(R.string.TSSFPrinciple22);
			break;
		case 23:
			principle.setText(R.string.TSSFPrinciple23);
			break;
		case 24:
			principle.setText(R.string.TSSFPrinciple24);
			break;
		case 25:
			principle.setText(R.string.TSSFPrinciple25);
			break;
		case 26:
			principle.setText(R.string.TSSFPrinciple26);
			break;
		case 27:
			principle.setText(R.string.TSSFPrinciple27);
			break;
		case 28:
			principle.setText(R.string.TSSFPrinciple28);
			break;
		case 29:
			principle.setText(R.string.TSSFPrinciple29);
			break;
		case 30:
			principle.setText(R.string.TSSFPrinciple30);
			break;
		default:
			principle.setText(R.string.TSSFPrinciple30);
		}

		principle.setTextSize(NORMAL);
		principle.setTextColor(Color.BLACK);
		return principle;
	}

	private TextView getIntercessionRubricTextView() {
		TextView intercessionRubric = new TextView(this);
		String pString = getString(R.string.TSSFIntercessionRubric) + " "
				+ TssfUtils.getDayOfMonth(getDate()) + "\n";
		intercessionRubric.setText(pString);
		intercessionRubric.setTextSize(SMALL);
		intercessionRubric.setTextColor(Color.RED);
		intercessionRubric.setTypeface(null, Typeface.ITALIC);
		return intercessionRubric;
	}

	private TextView getPrivatePrayerRubricTextView() {
		TextView intercessionRubric = new TextView(this);
		String pString = getString(R.string.TSSFIntercessionRubric) + " "
		+ TssfUtils.getDayOfMonth(getDate()) + "\n";
		intercessionRubric.setText(pString);
		intercessionRubric.setTextSize(SMALL);
		intercessionRubric.setTextColor(Color.RED);
		intercessionRubric.setTypeface(null, Typeface.ITALIC);
		return intercessionRubric;
	}

	private TextView getCommunityPrayer() {
		TextView comprayer = new TextView(this);
		comprayer.setText(R.string.TSSFCommunityPrayer);
		comprayer.setTextSize(NORMAL);
		comprayer.setTextColor(Color.BLACK);
		return comprayer;
	}

	private TextView getCollectRubricTextView() {
		TextView collectRubric = new TextView(this);
		collectRubric.setText(getString(R.string.TSSFCollectRubric));
		collectRubric.setTextSize(SMALL);
		collectRubric.setTextColor(Color.RED);
		collectRubric.setTypeface(null, Typeface.ITALIC);
		return collectRubric;
	}

	private TextView getCollectForDay() {
		TextView comprayer = new TextView(this);
		int day = TssfUtils.getDayOfWeek(getDate());
		switch (day) {
		case 1:
			comprayer.setText(R.string.TSSFCollect1);
			break;
		case 2:
			comprayer.setText(R.string.TSSFCollect2);
			break;
		case 3:
			comprayer.setText(R.string.TSSFCollect3);
			break;
		case 4:
			comprayer.setText(R.string.TSSFCollect4);
			break;
		case 5:
			comprayer.setText(R.string.TSSFCollect5);
			break;
		case 6:
			comprayer.setText(R.string.TSSFCollect6);
			break;
		case 7:
			comprayer.setText(R.string.TSSFCollect7);
			break;
		default:
			comprayer.setText("Error setting collect for day");
		}

		comprayer.setTextSize(NORMAL);
		comprayer.setTextColor(Color.BLACK);
		return comprayer;
	}

	private TextView getBlessingRubric1() {
		TextView blessing = new TextView(this);
		blessing.setText(R.string.TSSFBlessingRubric1);
		blessing.setTextSize(SMALL);
		blessing.setTextColor(Color.RED);
		blessing.setTypeface(null, Typeface.ITALIC);
		return blessing;
	}

	private TextView getBlessingRubric2() {
		TextView blessing = new TextView(this);
		blessing.setText(R.string.TSSFBlessingRubric2);
		blessing.setTextSize(SMALL);
		blessing.setTextColor(Color.RED);
		blessing.setTypeface(null, Typeface.ITALIC);
		return blessing;
	}

	private TextView getBlessing1() {
		TextView blessing = new TextView(this);
		blessing.setText(R.string.TSSFBlessing1);
		blessing.setTextSize(NORMAL);
		blessing.setTextColor(Color.BLACK);
		return blessing;
	}

	private TextView getBlessing2() {
		TextView blessing = new TextView(this);
		blessing.setText(R.string.TSSFBlessing2);
		blessing.setTextSize(NORMAL);
		blessing.setTextColor(Color.BLACK);
		return blessing;
	}

	private TextView getDayString() {
		TextView dayString = new TextView(this);
		int day = TssfUtils.getDayOfWeek(getDate());
		switch (day) {
		case 1:
			dayString.setText(R.string.TSSFSunday);
			break;
		case 2:
			dayString.setText(R.string.TSSFMonday);
			break;
		case 3:
			dayString.setText(R.string.TSSFTuesday);
			break;
		case 4:
			dayString.setText(R.string.TSSFWednesday);
			break;
		case 5:
			dayString.setText(R.string.TSSFThursday);
			break;
		case 6:
			dayString.setText(R.string.TSSFFriday);
			break;
		case 7:
			dayString.setText(R.string.TSSFSaturday);
			break;
		}

		dayString.setTextSize(NORMAL);
		dayString.setTextColor(Color.BLACK);
		return dayString;
	}

	public void getIntercessions() {
		InputStream is = null;
		String fileName = getFileName();
		AssetManager am = getAssets();
		try {
			// is = getDownloadIntercessionStream(fileName);
			// if (is == null)
			// {
			is = am.open(fileName);				
			// }
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			String strLine;
			while ((strLine = bfr.readLine()) != null) {
				TextView tv = new TextView(this);
				tv.setText(strLine);
				tv.setTextSize(NORMAL);
				tv.setTextColor(Color.BLACK);
				linear.addView(tv);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// yummo let it fall through...
		}
	}

	private InputStream getDownloadIntercessionStream(String fileName)
	{   
		File[] paths;
		File downloadDir = null;
		InputStream is = null;
		
		downloadDir = (File) Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		paths = downloadDir.listFiles();
		for (int i = 0; i < paths.length; i++) {
			File tmpFile = paths[i];
			if (fileName.equals(tmpFile.getName())) {
				try {
					is = new FileInputStream(tmpFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		
		return is;
	}
	
	private String getFileName() {
		int day = TssfUtils.getDayOfMonth(getDate());

		String fileName;

		switch (day) {
		case 1:
			fileName = "day1.txt";
			break;
		case 2:
			fileName = "day2.txt";
			break;
		case 3:
			fileName = "day3.txt";
			break;
		case 4:
			fileName = "day4.txt";
			break;
		case 5:
			fileName = "day5.txt";
			break;
		case 6:
			fileName = "day6.txt";
			break;
		case 7:
			fileName = "day7.txt";
			break;
		case 8:
			fileName = "day8.txt";
			break;
		case 9:
			fileName = "day9.txt";
			break;
		case 10:
			fileName = "day10.txt";
			break;
		case 11:
			fileName = "day11.txt";
			break;
		case 12:
			fileName = "day12.txt";
			break;
		case 13:
			fileName = "day13.txt";
			break;
		case 14:
			fileName = "day14.txt";
			break;
		case 15:
			fileName = "day15.txt";
			break;
		case 16:
			fileName = "day16.txt";
			break;
		case 17:
			fileName = "day17.txt";
			break;
		case 18:
			fileName = "day18.txt";
			break;
		case 19:
			fileName = "day19.txt";
			break;
		case 20:
			fileName = "day20.txt";
			break;
		case 21:
			fileName = "day21.txt";
			break;
		case 22:
			fileName = "day22.txt";
			break;
		case 23:
			fileName = "day23.txt";
			break;
		case 24:
			fileName = "day24.txt";
			break;
		case 25:
			fileName = "day25.txt";
			break;
		case 26:
			fileName = "day26.txt";
			break;
		case 27:
			fileName = "day27.txt";
			break;
		case 28:
			fileName = "day28.txt";
			break;
		case 29:
			fileName = "day29.txt";
			break;
		case 30:
			fileName = "day30.txt";
			break;
		case 31:
			fileName = "day31.txt";
			break;
		default:
			fileName = "day1.txt";
		}

		return fileName;
	}

	/* ghooker code added for my personal prayer. */
    public void getPrivatePrayer()
    {
    	AssetManager am = getAssets();

		// add my daily prayers...
		try {
			// InputStream isDaily = getDownloadIntercessionStream("daily.txt"); for download directory

			InputStream isDaily = am.open("daily.txt");
			BufferedReader bfrDaily = new BufferedReader(new InputStreamReader(isDaily));
			String strLineDaily;
			TextView spacerDaily = new TextView(this);
			spacerDaily.setText("");
			linear.addView(spacerDaily);
			while ((strLineDaily = bfrDaily.readLine()) != null) {
				TextView tvDaily = new TextView(this);
				tvDaily.setText(strLineDaily);
				tvDaily.setTextSize(NORMAL);
				tvDaily.setTextColor(Color.BLACK);
				linear.addView(tvDaily);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// yummo let it fall through...
		}

    	String fileName = getPrivateFileName();
    	try {
    		// InputStream is = this.getDownloadIntercessionStream(fileName); for download directory

			InputStream is = am.open(fileName);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
			String strLine;
			TextView spacer = new TextView(this);
			spacer.setText("");
			linear.addView(spacer);
			while ((strLine = bfr.readLine()) != null)
			{
				TextView tv = new TextView(this);
		    	tv.setText(strLine);
		    	tv.setTextSize(NORMAL);
		    	tv.setTextColor(Color.BLACK);
		    	linear.addView(tv);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// yummo let it fall through...
		}
    }

	private String getPrivateFileName() {
		int day = TssfUtils.getDayOfWeek(getDate());

		String fileName;

		switch (day) {
		case 1:
			fileName = "sunday.txt";
			break;
		case 2:
			fileName = "monday.txt";
			break;
		case 3:
			fileName = "tuesday.txt";
			break;
		case 4:
			fileName = "wednesday.txt";
			break;
		case 5:
			fileName = "thursday.txt";
			break;
		case 6:
			fileName = "friday.txt";
			break;
		case 7:
			fileName = "saturday.txt";
			break;
		default:
			fileName = null;
		}

		return fileName;
	}

	/* end of code for my private prayer. */

	public void setDate(Date date) {
		_date = date;
	}

	public Date getDate() {
		return _date;
	}
}

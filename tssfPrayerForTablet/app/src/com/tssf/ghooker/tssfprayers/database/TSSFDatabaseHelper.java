package com.tssf.ghooker.tssfprayers.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TSSFDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "intercession.db";

	// TOGGLE THIS NUMBER FOR UPDATING TABLES AND DATABASE
	private static final int DATABASE_VERSION = 1;

	// SOME SAMPLE FIELDS
	public static final String UID = "_id";
	public static final String DAY = "day";
	public static final String TYPE = "type";
	public static final String REGION = "region";
	public static final String DETAIL = "detail";

	TSSFDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + IntercessionTable.TABLE_NAME + " ("
				+ IntercessionTable.UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ IntercessionTable.DAY + " INTEGER, " + IntercessionTable.TYPE
				+ " INTEGER, " + IntercessionTable.REGION + " TEXT, "
				+ IntercessionTable.DETAIL + " TEXT);");
		db.execSQL("CREATE TABLE " + IntercessionTable.TABLE_NAME + " (" + UID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + DAY + " INTEGER, "
				+ DETAIL + " TEXT);");
		
	    /* BufferedReader in = new BufferedReader(new FileReader("a file"));
        String reader = "";
        while ((reader = in.readLine()) != null){
            String[] RowData = reader.split("|");
            String day = RowData[0];
            String type = RowData[1];
            String region = RowData[2];
            String detail = RowData[3];
            ContentValues values = new ContentValues();
            values.put(CsvProvider.DAY, day);
            values.put(CsvProvider.TYPE, type);
            values.put(CsvProvider.REGION, region);
            values.put(CsvProvider.DETAIL, detail);
            getContentResolver().insert(CsvProvider.CONTENT_URI, values); */

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w("LOG_TAG", "Upgrading database from version " + oldVersion
				+ " to " + newVersion + ", which will destroy all old data");

		// KILL PREVIOUS TABLE IF UPGRADED
		db.execSQL("DROP TABLE IF EXISTS " + IntercessionTable.TABLE_NAME);

		// CREATE NEW INSTANCE OF TABLE
		onCreate(db);
	}

	public boolean addIntersession(int day, int type, String region, String detail) {
		// CREATE A CONTENTVALUE OBJECT
		ContentValues cv = new ContentValues();
		cv.put(IntercessionTable.DAY, day);
		cv.put(IntercessionTable.TYPE, type);
		cv.put(IntercessionTable.REGION, region);
		cv.put(IntercessionTable.DETAIL, detail);

		// RETRIEVE WRITEABLE DATABASE AND INSERT
		SQLiteDatabase sd = getWritableDatabase();
		long result = sd.insert(IntercessionTable.TABLE_NAME, IntercessionTable.REGION, cv);
		return (result >= 0);
	}

	/*
	    BufferedReader in = new BufferedReader(res/raw/intercession.txt);
        String reader = "";
        while ((reader = in.readLine()) != null){
            String[] RowData = reader.split("|");
            day = RowData[0];
            type = RowData[1];
            region = RowData[2];
            detail = RowData[3];
            ContentValues values = new ContentValues();
            values.put(CsvProvider.DAY, day);
            values.put(CsvProvider.TYPE, type);
            values.put(CsvProvider.REGION, region);
            values.put(CsvProvider.DETAIL, detail);
            getContentResolver().insert(CsvProvider.CONTENT_URI, values);
        }
        in.close(); 
	 */
}

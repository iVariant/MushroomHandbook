package com.example.ixvar.mushroomhandbook.BD;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ixvar.mushroomhandbook.R;

/**
 * Created by ixvar on 10/3/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mushroom_handbook.db";
    private static final int DATABASE_VERSION = 1;

    //----------TABLES---------------------------
    public static final String TABLE_SEASONS = "seasons";
    public static final String TABLE_BERRIE_OTHER_NAMES = "berrie_other_names";
    public static final String TABLE_BERRIE_PICTURES = "berrie_pictures";

    public static final String TABLE_ID_BERRIE__ID_SEASON = "id_berrie__id_season";



    public static final String TABLE_BERRIES = "berries";
    public static final String TABLE_BERRIES_SIZE = "berries_size";
    public static final String TABLE_BERRIES_TYPE = "berries_type";
    public static final String TABLE_BERRIES_COLOR = "berries_color";

    public static final String TABLE_HERBS = "herbs";
    public static final String TABLE_HERBS_TYPE = "herbs_type";
    public static final String TABLE_HERBS_STEM_HEIGHT = "herbs_stem_height";
    public static final String TABLE_HERBS_FLOWERS_SIZE = "herbs_flowers_size";
    public static final String TABLE_HERBS_COLOR = "herbs_color";

    public static final String TABLE_MUSHROOMS = "mushrooms";
    public static final String TABLE_MUSHROOMS_TYPE = "mushrooms_type";
    public static final String TABLE_MUSHROOMS_CAP_SIZE = "mushrooms_cap_size";
    public static final String TABLE_MUSHROOMS_CAP_COLOR = "mushrooms_cap_color";
    public static final String TABLE_MUSHROOMS_STIPE_THICKNESS = "mushrooms_stipe_thickness";
    public static final String TABLE_MUSHROOMS_STIPE_HIGHT = "mushrooms_stipe_hight";
    public static final String TABLE_MUSHROOMS_STIPE_COLOR = "mushrooms_stipe_color";
    public static final String TABLE_MUSHROOMS_FLESH_COLOR = "mushrooms_flesh_color";


    //----------COLUMNS---------------------------
    public static final String COLUMN_ID_BERRIE = "id_berrie";
    public static final String COLUMN_ID_SEASON = "_id_season";




    public static final String COLUMN_PICTURES_ID = "_id";
    public static final String COLUMN_PICTURES_RES = "pictureRes";

    public static final String COLUMN_SEASONS_ID = "_id";
    public static final String COLUMN_SEASONS_NAME = "name";

    public static final String COLUMN_OTHER_NAMES_ID = "_id";
    public static final String COLUMN_OTHER_NAMES_NAME = "name";

    public static final String COLUMN_BERRIES_COLOR_ID = "_id";
    public static final String COLUMN_BERRIES_COLOR_NAME = "name";

    public static final String COLUMN_BERRIES_SIZE_ID = "_id";
    public static final String COLUMN_BERRIES_SIZE_NAME = "name";

    public static final String COLUMN_BERRIES_TYPE_ID = "_id";
    public static final String COLUMN_BERRIES_TYPE_NAME = "name";

    public static final String COLUMN_BERRIE_PICTURES_ID = "_id";
    public static final String COLUMN_BERRIE_PICTURES_ID_BERRIE = "id_berrie";
    public static final String COLUMN_BERRIE_PICTURES_RES = "res";

    public static final String COLUMN_BERRIE_OTHER_NAMES_ID = "_id";
    public static final String COLUMN_BERRIE_OTHER_NAMES_ID_BERRIE = "id_berrie";
    public static final String COLUMN_BERRIE_OTHER_NAMES_NAME = "name";

    public static final String COLUMN_BERRIES_ID = "_id";
    public static final String COLUMN_BERRIES_NAME = "name";
    public static final String COLUMN_BERRIES_DESCRIPTION = "description";
    public static final String COLUMN_BERRIES_FAVORITE = "favorite";
    public static final String COLUMN_BERRIES_PLACE = "berries_place";

    private Resources res;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_BERRIES_SIZE + " ("
                + COLUMN_BERRIES_SIZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_SIZE_NAME + " TEXT NOT NULL);");

        insertBerriesSize(db,1, res.getString(R.string.berries_size_small));
        insertBerriesSize(db,2, res.getString(R.string.berries_size_mid));
        insertBerriesSize(db,3, res.getString(R.string.berries_size_big));


        db.execSQL("CREATE TABLE " + TABLE_BERRIES_TYPE + " ("
                + COLUMN_BERRIES_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_TYPE_NAME + " TEXT NOT NULL);");

        insertBerriesType(db,1, res.getString(R.string.berries_type_edible));
        insertBerriesType(db,2, res.getString(R.string.berries_type_inedible));


        db.execSQL("CREATE TABLE " + TABLE_BERRIES_COLOR + " ("
                + COLUMN_BERRIES_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_COLOR_NAME + " TEXT NOT NULL);");

        insertBerriesColor(db,1, res.getString(R.string.berries_color_white));
        insertBerriesColor(db,2, res.getString(R.string.berries_color_green));
        insertBerriesColor(db,3, res.getString(R.string.berries_color_red));
        insertBerriesColor(db,4, res.getString(R.string.berries_color_orange));
        insertBerriesColor(db,5, res.getString(R.string.berries_color_pink));
        insertBerriesColor(db,6, res.getString(R.string.berries_color_blue));
        insertBerriesColor(db,7, res.getString(R.string.berries_color_black));

        db.execSQL("CREATE TABLE " + TABLE_SEASONS + " ("
                + COLUMN_SEASONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SEASONS_NAME + " TEXT NOT NULL);");

        insertSeason(db,1, res.getString(R.string.season_January));
        insertSeason(db,2, res.getString(R.string.season_February));
        insertSeason(db,3, res.getString(R.string.season_March));
        insertSeason(db,4, res.getString(R.string.season_April));
        insertSeason(db,5, res.getString(R.string.season_May));
        insertSeason(db,6, res.getString(R.string.season_June));
        insertSeason(db,7, res.getString(R.string.season_July));
        insertSeason(db,8, res.getString(R.string.season_August));
        insertSeason(db,9, res.getString(R.string.season_September));
        insertSeason(db,10, res.getString(R.string.season_October));
        insertSeason(db,11, res.getString(R.string.season_November));
        insertSeason(db,12, res.getString(R.string.season_December));

        db.execSQL("CREATE TABLE " + TABLE_BERRIE_OTHER_NAMES + " ("
                + COLUMN_BERRIE_OTHER_NAMES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIE_OTHER_NAMES_NAME + " TEXT NOT NULL), "
                + COLUMN_BERRIE_OTHER_NAMES_ID_BERRIE + " INTEGER NOT NULL, "
                +" FOREIGN KEY("+ COLUMN_BERRIE_OTHER_NAMES_ID_BERRIE +") REFERENCES " + TABLE_BERRIES + "("+ COLUMN_BERRIES_ID +"));");

        db.execSQL("CREATE TABLE " + TABLE_BERRIE_PICTURES + " ("
                + COLUMN_BERRIE_PICTURES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIE_PICTURES_ID_BERRIE + " INTEGER NOT NULL, "
                + COLUMN_BERRIE_PICTURES_RES + " INTEGER NOT NULL), "
                +" FOREIGN KEY("+ COLUMN_BERRIE_PICTURES_ID_BERRIE +") REFERENCES " + TABLE_BERRIES + "("+ COLUMN_BERRIES_ID +"));");

        db.execSQL("CREATE TABLE " + TABLE_ID_BERRIE__ID_SEASON + " ("
                + COLUMN_ID_BERRIE + " INTEGER NOT NULL, "
                + COLUMN_ID_SEASON + " INTEGER NOT NULL);");


        db.execSQL("CREATE TABLE " + TABLE_BERRIES + " ("
                + COLUMN_BERRIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_NAME + " TEXT NOT NULL, "
                + COLUMN_BERRIES_DESCRIPTION + " TEXT NOT NULL, "
                + COLUMN_BERRIES_PLACE + " TEXT NOT NULL, "
                + COLUMN_BERRIES_FAVORITE + " NUMERIC NOT NULL;");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIES);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_SEASONS);


        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIES_SIZE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIES_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIES_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ID_BERRIE__ID_SEASON);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIE_OTHER_NAMES);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIE_PICTURES);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_STEM_HEIGHT);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_FLOWERS_SIZE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_COLOR);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_CAP_SIZE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_CAP_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_THICKNESS);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_HIGHT);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_FLESH_COLOR);


        onCreate(db);
    }

    private static void insertBerriesSize(SQLiteDatabase db,int id, String size) {
        ContentValues berriesSizeValues = new ContentValues();
        berriesSizeValues.put(COLUMN_BERRIES_SIZE_ID, id);
        berriesSizeValues.put(COLUMN_BERRIES_SIZE_NAME, size);

        db.insert(TABLE_BERRIES_SIZE, null, berriesSizeValues);
        }

    private static void insertBerriesType(SQLiteDatabase db,int id, String type) {
        ContentValues berriesTypeValues = new ContentValues();
        berriesTypeValues.put(COLUMN_BERRIES_TYPE_ID, id);
        berriesTypeValues.put(COLUMN_BERRIES_TYPE_NAME, type);

        db.insert(TABLE_BERRIES_TYPE, null, berriesTypeValues);
    }

    private static void insertBerriesColor(SQLiteDatabase db,int id, String color) {
        ContentValues berriesColorValues = new ContentValues();
        berriesColorValues.put(COLUMN_BERRIES_COLOR_ID, id);
        berriesColorValues.put(COLUMN_BERRIES_COLOR_NAME, color);

        db.insert(TABLE_BERRIES_COLOR, null, berriesColorValues);
    }

    private static void insertSeason(SQLiteDatabase db,int id, String season) {
        ContentValues seasonValues = new ContentValues();
        seasonValues.put(COLUMN_SEASONS_ID, id);
        seasonValues.put(COLUMN_SEASONS_NAME, season);

        db.insert(TABLE_SEASONS, null, seasonValues);
    }


    private static void insertBerrieOtherName(SQLiteDatabase db,int id, String name,int idBerrie) {
        ContentValues otherNameValues = new ContentValues();
        otherNameValues.put(COLUMN_BERRIE_OTHER_NAMES_ID, id);
        otherNameValues.put(COLUMN_BERRIE_OTHER_NAMES_NAME, name);
        otherNameValues.put(COLUMN_BERRIE_OTHER_NAMES_ID_BERRIE, idBerrie);

        db.insert(TABLE_BERRIE_OTHER_NAMES, null, otherNameValues);
    }

    private static void insertBerriePicture(SQLiteDatabase db,int id, int res, int idBerrie) {
        ContentValues pictureValues = new ContentValues();
        pictureValues.put(COLUMN_BERRIE_PICTURES_ID, id);
        pictureValues.put(COLUMN_BERRIE_PICTURES_RES, res);
        pictureValues.put(COLUMN_BERRIE_PICTURES_ID_BERRIE, idBerrie);

        db.insert(TABLE_BERRIE_PICTURES, null, pictureValues);
    }

    private static void insertIDberrieIDSeason(SQLiteDatabase db,int idBerrie, int idSeason) {
        ContentValues pictureValues = new ContentValues();
        pictureValues.put(COLUMN_ID_BERRIE, idBerrie);
        pictureValues.put(COLUMN_ID_SEASON, idSeason);

        db.insert(TABLE_ID_BERRIE__ID_SEASON, null, pictureValues);
    }



}
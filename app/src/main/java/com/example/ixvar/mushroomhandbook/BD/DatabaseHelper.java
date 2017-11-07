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
    private static final int DATABASE_VERSION = 62;

    //----------TABLES---------------------------
    public static final String TABLE_SEASONS = "seasons";


    public static final String TABLE_ID_BERRIE__ID_SEASON = "id_berrie__id_season";
    public static final String TABLE_ID_HERB__ID_SEASON = "id_herb__id_season";
    public static final String TABLE_ID_MUSHROOM__ID_SEASON = "id_mushroom__id_season";


    public static final String TABLE_BERRIES = "berries";
    public static final String TABLE_BERRIES_SIZE = "berries_size";
    public static final String TABLE_BERRIES_TYPE = "berries_type";
    public static final String TABLE_BERRIES_COLOR = "berries_color";
    public static final String TABLE_BERRIE_PICTURES = "berrie_pictures";

    public static final String TABLE_HERBS = "herbs";
    public static final String TABLE_HERBS_TYPE = "herbs_type";
    public static final String TABLE_HERBS_STEM_HEIGHT = "herbs_stem_height";
    public static final String TABLE_HERBS_FLOWERS_SIZE = "herbs_flowers_size";
    public static final String TABLE_HERBS_COLOR = "herbs_color";
    public static final String TABLE_HERBS_PICTURES = "herbs_pictures";


    public static final String TABLE_MUSHROOMS = "mushrooms";
    public static final String TABLE_MUSHROOMS_TYPE = "mushrooms_type";
    public static final String TABLE_MUSHROOMS_CAP_SIZE = "mushrooms_cap_size";
    public static final String TABLE_MUSHROOMS_CAP_COLOR = "mushrooms_cap_color";
    public static final String TABLE_MUSHROOMS_STIPE_THICKNESS = "mushrooms_stipe_thickness";
    public static final String TABLE_MUSHROOMS_STIPE_HIGHT = "mushrooms_stipe_hight";
    public static final String TABLE_MUSHROOMS_STIPE_COLOR = "mushrooms_stipe_color";
    public static final String TABLE_MUSHROOMS_FLESH_COLOR = "mushrooms_flesh_color";
    public static final String TABLE_MUSHROOMS_PICTURES = "mushrooms_pictures";


    //----------COLUMNS---------------------------
    public static final String COLUMN_ID_HERB = "id_herb";
    public static final String COLUMN_ID_MUSHROOM = "id_mushroom";
    public static final String COLUMN_ID_BERRIE = "id_berrie";

    public static final String COLUMN_ID_SEASON = "_id_season";


    public static final String COLUMN_SEASONS_ID = "_id";
    public static final String COLUMN_SEASONS_NAME = "name";


    public static final String COLUMN_BERRIES_COLOR_ID = "_id";
    public static final String COLUMN_BERRIES_COLOR_NAME = "name";

    public static final String COLUMN_BERRIES_SIZE_ID = "_id";
    public static final String COLUMN_BERRIES_SIZE_NAME = "name";

    public static final String COLUMN_BERRIES_TYPE_ID = "_id";
    public static final String COLUMN_BERRIES_TYPE_NAME = "name";

    public static final String COLUMN_BERRIE_PICTURES_ID = "_id";
    public static final String COLUMN_BERRIE_PICTURES_ID_BERRIE = "id_berrie";
    public static final String COLUMN_BERRIE_PICTURES_URL = "url";


    public static final String COLUMN_BERRIES_ID = "_id";
    public static final String COLUMN_BERRIES_NAME = "name";
    public static final String COLUMN_BERRIES_OTHERNAMES = "other_names";
    public static final String COLUMN_BERRIES_COLOR = "color";
    public static final String COLUMN_BERRIES_SIZE = "size";
    public static final String COLUMN_BERRIES_TYPE = "type";
    public static final String COLUMN_BERRIES_DESCRIPTION = "description";
    public static final String COLUMN_BERRIES_FAVORITE = "favorite";
    public static final String COLUMN_BERRIES_PLACE = "berries_place";

      //---- HERBS-----

    public static final String COLUMN_HERBS_TYPE_ID = "_id";
    public static final String COLUMN_HERBS_TYPE_NAME = "name";

    public static final String COLUMN_HERBS_PICTURES_ID = "_id";
    public static final String COLUMN_HERBS_PICTURES_ID_HERB = "id_herb";
    public static final String COLUMN_HERBS_PICTURES_URL = "url";


    public static final String COLUMN_HERBS_FLOWERS_SIZE_ID = "_id";
    public static final String COLUMN_HERBS_FLOWERS_SIZE_NAME = "size";


    public static final String COLUMN_HERBS_COLOR_ID = "_id";
    public static final String COLUMN_HERBS_COLOR_NAME = "color";

    public static final String COLUMN_HERBS_STEM_HEIGHT_ID = "_id";
    public static final String COLUMN_HERBS_STEM_HEIGHT_NAME = "stem_height";

    public static final String COLUMN_HERBS_ID = "_id";
    public static final String COLUMN_HERBS_NAME = "name";
    public static final String COLUMN_HERBS_OTHERNAMES = "other_names";
    public static final String COLUMN_HERBS_DESCRIPTION = "description";
    public static final String COLUMN_HERBS_PLACE = "place";
    public static final String COLUMN_HERBS_TYPE = "type";
    public static final String COLUMN_HERBS_STEM_HEIGHT = "stem_height";
    public static final String COLUMN_HERBS_FLOWERS_SIZE = "size";
    public static final String COLUMN_HERBS_COLOR = "color";
    public static final String COLUMN_HERBS_FAVORITE = "favorite";

    //---- MUSHROOMS-----
    public static final String COLUMN_MUSHROOMS_TYPE_ID = "_id";
    public static final String COLUMN_MUSHROOMS_TYPE_NAME = "name";


    public static final String COLUMN_MUSHROOMS_CAP_SIZE_ID = "_id";
    public static final String COLUMN_MUSHROOMS_CAP_SIZE_NAME = "size";

    public static final String COLUMN_MUSHROOMS_CAP_COLOR_ID = "_id";
    public static final String COLUMN_MUSHROOMS_CAP_COLOR_NAME = "color";

    public static final String COLUMN_MUSHROOMS_STIPE_THICKNESS_ID = "_id";
    public static final String COLUMN_MUSHROOMS_STIPE_THICKNESS_NAME = "name";


    public static final String COLUMN_MUSHROOMS_STIPE_HIGHT_ID = "_id";
    public static final String COLUMN_MUSHROOMS_STIPE_HIGHT_NAME = "name";

    public static final String COLUMN_MUSHROOMS_STIPE_COLOR_ID = "_id";
    public static final String COLUMN_MUSHROOMS_STIPE_COLOR_NAME = "name";


    public static final String COLUMN_MUSHROOMS_FLESH_COLOR_ID = "_id";
    public static final String COLUMN_MUSHROOMS_FLESH_COLOR_NAME = "name";


    public static final String COLUMN_MUSHROOMS_ID = "_id";
    public static final String COLUMN_MUSHROOMS_NAME = "name";
    public static final String COLUMN_MUSHROOMS_OTHERNAMES = "other_names";
    public static final String COLUMN_MUSHROOMS_DESCRIPTION = "description";
    public static final String COLUMN_MUSHROOMS_PLACE = "place";
    public static final String COLUMN_MUSHROOMS_TYPE = "type";
    public static final String COLUMN_MUSHROOMS_FAVORITE = "favorite";
    public static final String COLUMN_MUSHROOMS_CAP_SIZE = "cap_size";
    public static final String COLUMN_MUSHROOMS_CAP_COLOR = "cap_color";
    public static final String COLUMN_MUSHROOMS_STIPE_THICKNESS = "stipe_thickness";
    public static final String COLUMN_MUSHROOMS_STIPE_HIGHT = "stipe_height";
    public static final String COLUMN_MUSHROOMS_STIPE_COLOR = "stipe_color";
    public static final String COLUMN_MUSHROOMS_FLESH_COLOR = "fresh_color";

    public static final String COLUMN_MUSHROOMS_PICTURES_ID = "_id";
    public static final String COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM = "id_mushroom";
    public static final String COLUMN_MUSHROOMS_PICTURES_URL = "url";



    private Resources res;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_BERRIES_TYPE + " ("
                + COLUMN_BERRIES_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_TYPE_NAME + " TEXT NOT NULL);");

        insertBerriesType(db,1, res.getString(R.string.edible));
        insertBerriesType(db,2, res.getString(R.string.inedible));

        db.execSQL("CREATE TABLE " + TABLE_BERRIES_SIZE + " ("
                + COLUMN_BERRIES_SIZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_SIZE_NAME + " TEXT NOT NULL);");

        insertBerriesSize(db,1, res.getString(R.string.size_small));
        insertBerriesSize(db,2, res.getString(R.string.size_mid));
        insertBerriesSize(db,3, res.getString(R.string.size_big));


        db.execSQL("CREATE TABLE " + TABLE_BERRIES_COLOR + " ("
                + COLUMN_BERRIES_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_COLOR_NAME + " TEXT NOT NULL);");

        insertBerriesColor(db,1, res.getString(R.string.color_white));
        insertBerriesColor(db,2, res.getString(R.string.color_green));
        insertBerriesColor(db,3, res.getString(R.string.color_red));
        insertBerriesColor(db,4, res.getString(R.string.color_orange));
        insertBerriesColor(db,5, res.getString(R.string.color_pink));
        insertBerriesColor(db,6, res.getString(R.string.color_blue));
        insertBerriesColor(db,7, res.getString(R.string.color_black));

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

        db.execSQL("CREATE TABLE " + TABLE_BERRIES + " ("
                + COLUMN_BERRIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIES_NAME + " TEXT NOT NULL, "
                + COLUMN_BERRIES_OTHERNAMES + " TEXT NOT NULL, "
                + COLUMN_BERRIES_DESCRIPTION + " TEXT NOT NULL, "
                + COLUMN_BERRIES_PLACE + " TEXT NOT NULL, "
                + COLUMN_BERRIES_FAVORITE + " NUMERIC NOT NULL, "
                + COLUMN_BERRIES_TYPE + " INTEGER NOT NULL, "
                + COLUMN_BERRIES_SIZE + " INTEGER NOT NULL, "
                + COLUMN_BERRIES_COLOR + " INTEGER NOT NULL, "
                +"FOREIGN KEY("+ COLUMN_BERRIES_SIZE +") REFERENCES " + TABLE_BERRIES_SIZE + "("+ COLUMN_BERRIES_SIZE_ID +"), "
                +"FOREIGN KEY("+ COLUMN_BERRIES_COLOR +") REFERENCES " + TABLE_BERRIES_COLOR + "("+ COLUMN_BERRIES_COLOR_ID +"), "
                +"FOREIGN KEY("+ COLUMN_BERRIES_TYPE +") REFERENCES " + TABLE_BERRIES_TYPE + "("+ COLUMN_BERRIES_TYPE_ID +"));");



        db.execSQL("CREATE TABLE " + TABLE_BERRIE_PICTURES + " ("
                + COLUMN_BERRIE_PICTURES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BERRIE_PICTURES_ID_BERRIE + " INTEGER NOT NULL, "
                + COLUMN_BERRIE_PICTURES_URL + " TEXT NOT NULL, "
                +"FOREIGN KEY("+ COLUMN_BERRIE_PICTURES_ID_BERRIE +") REFERENCES " + TABLE_BERRIES + "("+ COLUMN_BERRIES_ID +"));");

        db.execSQL("CREATE TABLE " + TABLE_ID_BERRIE__ID_SEASON + " ("
                + COLUMN_ID_BERRIE + " INTEGER NOT NULL, "
                + COLUMN_ID_SEASON + " INTEGER NOT NULL);");




        insertBerrie(db,1,res.getString(R.string.berrie_name_wild_cherry),res.getString(R.string.berrie_name_wild_cherry_other_names),
                1,3,3,
                res.getString(R.string.berrie_name_wild_cherry_description), res.getString(R.string.berrie_name_wild_cherry_place),false);

        insertBerriePicture(db,"berries/cherry1.jpg",1);
        insertBerriePicture(db, "berries/cherry2.jpg",1);
        insertBerriePicture(db, "berries/cherry3.jpg",1);
        insertBerriePicture(db, "berries/cherry4.jpg",1);


        insertIDberrieIDSeason(db,1,6);
        insertIDberrieIDSeason(db,1,7);

        //----------------------------

        insertBerrie(db,2,res.getString(R.string.berrie_name_raspberries),res.getString(R.string.berrie_name_raspberries_other_names),
                1,2,3,
                res.getString(R.string.berrie_name_raspberries_description), res.getString(R.string.berrie_name_raspberries_place),false);

        insertBerriePicture(db,"berries/raspberries1.jpg",2);
        insertBerriePicture(db, "berries/raspberries2.jpg",2);
        insertBerriePicture(db, "berries/raspberries3.jpg",2);
        insertBerriePicture(db, "berries/raspberries4.jpg",2);

        insertIDberrieIDSeason(db,2,6);
        insertIDberrieIDSeason(db,2,7);
        insertIDberrieIDSeason(db,2,8);

        //----------------------------

        insertBerrie(db,3,res.getString(R.string.berrie_name_wolf_bast),res.getString(R.string.berrie_name_wolf_bast_other_names),
                2,1,1,
                res.getString(R.string.berrie_name_wolf_bast_description),  res.getString(R.string.berrie_name_wolf_bast_place),false);

        insertBerriePicture(db,"berries/wolf1.jpg",3);
        insertBerriePicture(db,"berries/wolf2.jpg",3);
        insertBerriePicture(db,"berries/wolf3.jpg",3);
        insertBerriePicture(db,"berries/wolf4.jpg",3);

        insertIDberrieIDSeason(db,3,7);
        insertIDberrieIDSeason(db,3,8);

        //----------------------------

        insertBerrie(db,4,res.getString(R.string.berrie_name_raven_eye),res.getString(R.string.berrie_name_raven_eye_other_names),
                2,3,4,
                res.getString(R.string.berrie_name_raven_eye_description) , res.getString(R.string.berrie_name_raven_eye_place),false);

        insertBerriePicture(db,"berries/raven_eye1.jpg",4);
        insertBerriePicture(db,"berries/raven_eye2.jpg",4);
        insertBerriePicture(db,"berries/raven_eye3.jpg",4);
        insertBerriePicture(db,"berries/raven_eye4.jpg",4);

        insertIDberrieIDSeason(db,4,7);
        insertIDberrieIDSeason(db,4,8);


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~HERBS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        db.execSQL("CREATE TABLE " + TABLE_HERBS_TYPE + " ("
                + COLUMN_HERBS_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_TYPE_NAME + " TEXT NOT NULL);");

        insertHerbsType(db,1, res.getString(R.string.useful));
        insertHerbsType(db,2, res.getString(R.string.poison));


        db.execSQL("CREATE TABLE " + TABLE_HERBS_STEM_HEIGHT + " ("
                + COLUMN_HERBS_STEM_HEIGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_STEM_HEIGHT_NAME + " TEXT NOT NULL);");

        insertHerbsStemHeight(db,1, res.getString(R.string.size_small));
        insertHerbsStemHeight(db,2, res.getString(R.string.size_mid));
        insertHerbsStemHeight(db,3, res.getString(R.string.size_big));


        db.execSQL("CREATE TABLE " + TABLE_HERBS_FLOWERS_SIZE + " ("
                + COLUMN_HERBS_FLOWERS_SIZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_FLOWERS_SIZE_NAME + " TEXT NOT NULL);");


        insertFlowersSize(db,1, res.getString(R.string.size_none));
        insertFlowersSize(db,2, res.getString(R.string.size_small));
        insertFlowersSize(db,3, res.getString(R.string.size_mid));
        insertFlowersSize(db,4, res.getString(R.string.size_big));

        db.execSQL("CREATE TABLE " + TABLE_HERBS_COLOR + " ("
                + COLUMN_HERBS_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_COLOR_NAME + " TEXT NOT NULL);");


        insertHerbsColor(db,1, res.getString(R.string.color_white));
        insertHerbsColor(db,2, res.getString(R.string.color_yellow));
        insertHerbsColor(db,3, res.getString(R.string.color_green));
        insertHerbsColor(db,4, res.getString(R.string.color_red));
        insertHerbsColor(db,5, res.getString(R.string.color_orange));
        insertHerbsColor(db,6, res.getString(R.string.color_pink));
        insertHerbsColor(db,7, res.getString(R.string.color_gray));
        insertHerbsColor(db,8, res.getString(R.string.color_blue));
        insertHerbsColor(db,9, res.getString(R.string.color_purple));

        db.execSQL("CREATE TABLE " + TABLE_HERBS + " ("
                + COLUMN_HERBS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_NAME + " TEXT NOT NULL, "
                + COLUMN_HERBS_OTHERNAMES + " TEXT NOT NULL, "
                + COLUMN_HERBS_DESCRIPTION + " TEXT NOT NULL, "
                + COLUMN_HERBS_PLACE + " TEXT NOT NULL, "
                + COLUMN_HERBS_FAVORITE + " NUMERIC NOT NULL, "
                + COLUMN_HERBS_TYPE + " INTEGER NOT NULL, "
                + COLUMN_HERBS_FLOWERS_SIZE + " INTEGER NOT NULL, "
                + COLUMN_HERBS_COLOR + " INTEGER NOT NULL, "
                + COLUMN_HERBS_STEM_HEIGHT + " INTEGER NOT NULL, "
                + "FOREIGN KEY("+ COLUMN_HERBS_FLOWERS_SIZE +") REFERENCES " + TABLE_HERBS_FLOWERS_SIZE + "("+ COLUMN_HERBS_FLOWERS_SIZE_ID +"), "
                + "FOREIGN KEY("+ COLUMN_HERBS_COLOR +") REFERENCES " + TABLE_HERBS_COLOR+ "("+ COLUMN_HERBS_COLOR_ID +"), "
                + "FOREIGN KEY("+ COLUMN_HERBS_STEM_HEIGHT +") REFERENCES " + TABLE_HERBS_STEM_HEIGHT + "("+ COLUMN_HERBS_STEM_HEIGHT_ID +"), "
                + "FOREIGN KEY("+ COLUMN_HERBS_TYPE +") REFERENCES " + TABLE_HERBS_TYPE + "("+ COLUMN_HERBS_TYPE_ID +"));");


        db.execSQL("CREATE TABLE " + TABLE_HERBS_PICTURES + " ("
                + COLUMN_HERBS_PICTURES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HERBS_PICTURES_ID_HERB + " INTEGER NOT NULL, "
                + COLUMN_HERBS_PICTURES_URL + " TEXT NOT NULL, "
                + "FOREIGN KEY("+ COLUMN_HERBS_PICTURES_ID_HERB +") REFERENCES " + TABLE_HERBS + "("+ COLUMN_HERBS_ID +"));");



        db.execSQL("CREATE TABLE " + TABLE_ID_HERB__ID_SEASON + " ("
                + COLUMN_ID_HERB + " INTEGER NOT NULL, "
                + COLUMN_ID_SEASON + " INTEGER NOT NULL);");





        insertHerb(db,1,res.getString(R.string.herbs_name_aloe),res.getString(R.string.herbs_name_aloe_other_names),
                1,2,5,3,
                res.getString(R.string.herbs_name_aloe_description) , res.getString(R.string.herbs_name_aloe_place),false);

        insertIDherbIDSeason(db,1,1);
        insertIDherbIDSeason(db,1,2);
        insertIDherbIDSeason(db,1,3);
        insertIDherbIDSeason(db,1,4);
        insertIDherbIDSeason(db,1,5);
        insertIDherbIDSeason(db,1,6);
        insertIDherbIDSeason(db,1,7);
        insertIDherbIDSeason(db,1,8);
        insertIDherbIDSeason(db,1,9);
        insertIDherbIDSeason(db,1,10);
        insertIDherbIDSeason(db,1,11);
        insertIDherbIDSeason(db,1,12);

        insertHerbPicture(db,"herbs/aloe1.jpg",1);
        insertHerbPicture(db,"herbs/aloe2.jpg",1);
        insertHerbPicture(db,"herbs/aloe3.jpg",1);
        insertHerbPicture(db,"herbs/aloe4.jpg",1);



        insertHerb(db,2,res.getString(R.string.herbs_name_heracleum),res.getString(R.string.herbs_name_heracleum_other_names),
                2,4,1,3,
                res.getString(R.string.herbs_name_heracleum_description) , res.getString(R.string.herbs_name_heracleum_place),false);

        insertIDherbIDSeason(db,2,6);
        insertIDherbIDSeason(db,2,7);
        insertIDherbIDSeason(db,2,8);
        insertIDherbIDSeason(db,2,9);

        insertHerbPicture(db,"herbs/heracleum1.jpg",2);
        insertHerbPicture(db,"herbs/heracleum2.jpg",2);
        insertHerbPicture(db,"herbs/heracleum3.jpg",2);
        insertHerbPicture(db,"herbs/heracleum4.jpg",2);

        // int sizeFlower, int color
        insertHerb(db,3,res.getString(R.string.herbs_name_ambrosia),res.getString(R.string.herbs_name_ambrosia_other_names),
                2,1,2,2,
                res.getString(R.string.herbs_name_ambrosia_description) , res.getString(R.string.herbs_name_ambrosia_place),false);

        insertIDherbIDSeason(db,3,6);
        insertIDherbIDSeason(db,3,7);
        insertIDherbIDSeason(db,3,8);
        insertIDherbIDSeason(db,3,9);
        insertIDherbIDSeason(db,3,10);

        insertHerbPicture(db,"herbs/ambrosia1.jpg",3);
        insertHerbPicture(db,"herbs/ambrosia2.jpg",3);
        insertHerbPicture(db,"herbs/ambrosia3.jpg",3);
        insertHerbPicture(db,"herbs/ambrosia4.jpg",3);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~MUSHROOMS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_TYPE + " ("
                + COLUMN_MUSHROOMS_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_TYPE_NAME + " TEXT NOT NULL);");

        insertMushroomsType(db,1,res.getString(R.string.edible));
        insertMushroomsType(db,2,res.getString(R.string.edible));
        insertMushroomsType(db,3,res.getString(R.string.conditionally));


        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_CAP_SIZE + " ("
                + COLUMN_MUSHROOMS_CAP_SIZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_CAP_SIZE_NAME + " TEXT NOT NULL);");

        insertCapSize(db,1,res.getString(R.string.size_none));
        insertCapSize(db,2,res.getString(R.string.size_small));
        insertCapSize(db,3,res.getString(R.string.size_mid));
        insertCapSize(db,4,res.getString(R.string.size_big));


        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_CAP_COLOR + " ("
                + COLUMN_MUSHROOMS_CAP_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_CAP_COLOR_NAME + " TEXT NOT NULL);");


        insertCapColor(db,1,res.getString(R.string.color_white));
        insertCapColor(db,2,res.getString(R.string.color_brown_light));
        insertCapColor(db,3,res.getString(R.string.color_brown_dark));
        insertCapColor(db,4,res.getString(R.string.color_yellow));
        insertCapColor(db,5,res.getString(R.string.color_brown));
        insertCapColor(db,6,res.getString(R.string.color_red));
        insertCapColor(db,7,res.getString(R.string.color_cream));
        insertCapColor(db,8,res.getString(R.string.color_orange));
        insertCapColor(db,9,res.getString(R.string.color_pink));
        insertCapColor(db,10,res.getString(R.string.color_gray));
        insertCapColor(db,11,res.getString(R.string.color_blue));
        insertCapColor(db,12,res.getString(R.string.color_purple));
        insertCapColor(db,13,res.getString(R.string.color_black));



        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_STIPE_THICKNESS + " ("
                + COLUMN_MUSHROOMS_STIPE_THICKNESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_STIPE_THICKNESS_NAME + " TEXT NOT NULL);");

        insertStipeThickness(db,1,res.getString(R.string.size_none));
        insertStipeThickness(db,2,res.getString(R.string.size_small));
        insertStipeThickness(db,3,res.getString(R.string.size_mid));
        insertStipeThickness(db,4,res.getString(R.string.size_big));

        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_STIPE_HIGHT + " ("
                + COLUMN_MUSHROOMS_STIPE_HIGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_STIPE_HIGHT_NAME + " TEXT NOT NULL);");

        insertStipeHeight(db,1,res.getString(R.string.size_none));
        insertStipeHeight(db,2,res.getString(R.string.size_small));
        insertStipeHeight(db,3,res.getString(R.string.size_mid));
        insertStipeHeight(db,4,res.getString(R.string.size_big));


        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_STIPE_COLOR + " ("
                + COLUMN_MUSHROOMS_STIPE_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_STIPE_COLOR_NAME + " TEXT NOT NULL);");

        insertStipeColor(db,1,res.getString(R.string.color_white));
        insertStipeColor(db,2,res.getString(R.string.color_brown_light));
        insertStipeColor(db,3,res.getString(R.string.color_brown_dark));
        insertStipeColor(db,4,res.getString(R.string.color_yellow));
        insertStipeColor(db,5,res.getString(R.string.color_brown));
        insertStipeColor(db,6,res.getString(R.string.color_red));
        insertStipeColor(db,7,res.getString(R.string.color_cream));
        insertStipeColor(db,8,res.getString(R.string.color_orange));
        insertStipeColor(db,9,res.getString(R.string.color_pink));
        insertStipeColor(db,10,res.getString(R.string.color_gray));
        insertStipeColor(db,11,res.getString(R.string.color_blue));
        insertStipeColor(db,12,res.getString(R.string.color_purple));
        insertStipeColor(db,13,res.getString(R.string.color_black));

        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_FLESH_COLOR + " ("
                + COLUMN_MUSHROOMS_FLESH_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_FLESH_COLOR_NAME + " TEXT NOT NULL);");

        insertFleshColor(db,1,res.getString(R.string.color_white));
        insertFleshColor(db,2,res.getString(R.string.color_brown_dark));
        insertFleshColor(db,3,res.getString(R.string.color_yellow));
        insertFleshColor(db,4,res.getString(R.string.color_brown));
        insertFleshColor(db,5,res.getString(R.string.color_red));
        insertFleshColor(db,6,res.getString(R.string.color_cream));
        insertFleshColor(db,7,res.getString(R.string.color_orange));
        insertFleshColor(db,8,res.getString(R.string.color_pink));
        insertFleshColor(db,9,res.getString(R.string.color_gray));
        insertFleshColor(db,10,res.getString(R.string.color_blue));
        insertFleshColor(db,11,res.getString(R.string.color_purple));
        insertFleshColor(db,12,res.getString(R.string.color_black));



        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS + " ("
                + COLUMN_MUSHROOMS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_NAME + " TEXT NOT NULL, "
                + COLUMN_MUSHROOMS_OTHERNAMES + " TEXT NOT NULL, "
                + COLUMN_MUSHROOMS_DESCRIPTION + " TEXT NOT NULL, "
                + COLUMN_MUSHROOMS_PLACE + " TEXT NOT NULL, "
                + COLUMN_MUSHROOMS_FAVORITE + " NUMERIC NOT NULL, "
                + COLUMN_MUSHROOMS_TYPE + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_CAP_SIZE + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_CAP_COLOR + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_STIPE_THICKNESS + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_STIPE_HIGHT + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_STIPE_COLOR + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_FLESH_COLOR + " INTEGER NOT NULL, "

                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_FLESH_COLOR +") REFERENCES " + TABLE_MUSHROOMS_FLESH_COLOR + "("+ COLUMN_MUSHROOMS_FLESH_COLOR_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_STIPE_COLOR +") REFERENCES " + TABLE_MUSHROOMS_STIPE_COLOR + "("+ COLUMN_MUSHROOMS_STIPE_COLOR_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_STIPE_HIGHT +") REFERENCES " + TABLE_MUSHROOMS_STIPE_HIGHT + "("+ COLUMN_MUSHROOMS_STIPE_HIGHT_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_STIPE_THICKNESS +") REFERENCES " + TABLE_MUSHROOMS_STIPE_THICKNESS+ "("+ COLUMN_MUSHROOMS_STIPE_THICKNESS_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_CAP_COLOR +") REFERENCES " + TABLE_MUSHROOMS_CAP_COLOR + "("+ COLUMN_MUSHROOMS_CAP_COLOR_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_CAP_SIZE +") REFERENCES " + TABLE_MUSHROOMS_CAP_SIZE + "("+ COLUMN_MUSHROOMS_CAP_SIZE_ID +"), "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_TYPE +") REFERENCES " + TABLE_MUSHROOMS_TYPE + "("+ COLUMN_MUSHROOMS_TYPE_ID +"));");


        db.execSQL("CREATE TABLE " + TABLE_MUSHROOMS_PICTURES + " ("
                + COLUMN_MUSHROOMS_PICTURES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM + " INTEGER NOT NULL, "
                + COLUMN_MUSHROOMS_PICTURES_URL + " TEXT NOT NULL, "
                + "FOREIGN KEY("+ COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM +") REFERENCES " + TABLE_MUSHROOMS + "("+ COLUMN_MUSHROOMS_ID +"));");


        db.execSQL("CREATE TABLE " + TABLE_ID_MUSHROOM__ID_SEASON + " ("
                + COLUMN_ID_MUSHROOM + " INTEGER NOT NULL, "
                + COLUMN_ID_SEASON + " INTEGER NOT NULL);");



        insertMushroom(db,1,res.getString(R.string.mushroom_name_chanterelle),res.getString(R.string.mushroom_name_chanterelle_other_names),
                1,2,5,3,1,1,1,
                res.getString(R.string.herbs_name_aloe_description) , res.getString(R.string.mushroom_name_chanterelle_place),false);


        insertIDmushroomIDSeason(db,1,7);
        insertIDmushroomIDSeason(db,1,8);
        insertIDmushroomIDSeason(db,1,9);


        insertMushroomsPicture(db,"mushrooms/chanterelle1.jpg",1);
        insertMushroomsPicture(db,"mushrooms/chanterelle2.jpg",1);
        insertMushroomsPicture(db,"mushrooms/chanterelle3.jpg",1);
        insertMushroomsPicture(db,"mushrooms/chanterelle4.jpg",1);



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

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BERRIE_PICTURES);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_STEM_HEIGHT);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_FLOWERS_SIZE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_COLOR);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_HERBS_PICTURES);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_CAP_SIZE);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_CAP_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_THICKNESS);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_HIGHT);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_STIPE_COLOR);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_FLESH_COLOR);

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_MUSHROOMS_PICTURES);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ID_HERB__ID_SEASON);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ID_MUSHROOM__ID_SEASON);


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

    private static void insertBerriePicture(SQLiteDatabase db, String url, int idBerrie) {
        ContentValues pictureValues = new ContentValues();

        pictureValues.put(COLUMN_BERRIE_PICTURES_URL, url);
        pictureValues.put(COLUMN_BERRIE_PICTURES_ID_BERRIE, idBerrie);

        db.insert(TABLE_BERRIE_PICTURES, null, pictureValues);
    }

    private static void insertIDberrieIDSeason(SQLiteDatabase db,int idBerrie, int idSeason) {
        ContentValues idValues = new ContentValues();
        idValues.put(COLUMN_ID_BERRIE, idBerrie);
        idValues.put(COLUMN_ID_SEASON, idSeason);

        db.insert(TABLE_ID_BERRIE__ID_SEASON, null, idValues);
    }

    private static void insertBerrie(SQLiteDatabase db,int id, String name,String otherNames,int type,int size, int color, String description, String place, boolean favorite) {
        ContentValues berrieValues = new ContentValues();
        berrieValues.put(COLUMN_BERRIES_ID, id);
        berrieValues.put(COLUMN_BERRIES_NAME, name);
        berrieValues.put(COLUMN_BERRIES_OTHERNAMES, otherNames);
        berrieValues.put(COLUMN_BERRIES_TYPE, type);
        berrieValues.put(COLUMN_BERRIES_SIZE, size);
        berrieValues.put(COLUMN_BERRIES_COLOR, color);
        berrieValues.put(COLUMN_BERRIES_DESCRIPTION, description);
        berrieValues.put(COLUMN_BERRIES_PLACE, place);
        berrieValues.put(COLUMN_BERRIES_FAVORITE, favorite);

        db.insert(TABLE_BERRIES, null, berrieValues);
    }

    //-------------

    private static void insertHerbsType(SQLiteDatabase db,int id, String type) {
        ContentValues herbsTypeValues = new ContentValues();
        herbsTypeValues.put(COLUMN_HERBS_TYPE_ID, id);
        herbsTypeValues.put(COLUMN_HERBS_TYPE_NAME, type);

        db.insert(TABLE_HERBS_TYPE, null, herbsTypeValues);
    }

    private static void insertHerbsStemHeight(SQLiteDatabase db,int id, String height) {
        ContentValues herbsStemHeightValues = new ContentValues();
        herbsStemHeightValues.put(COLUMN_HERBS_STEM_HEIGHT_ID, id);
        herbsStemHeightValues.put(COLUMN_HERBS_STEM_HEIGHT_NAME, height);

        db.insert(TABLE_HERBS_STEM_HEIGHT, null, herbsStemHeightValues);
    }

    private static void insertFlowersSize(SQLiteDatabase db,int id, String size) {
        ContentValues flowersSizeValues = new ContentValues();
        flowersSizeValues.put(COLUMN_HERBS_FLOWERS_SIZE_ID, id);
        flowersSizeValues.put(COLUMN_HERBS_FLOWERS_SIZE_NAME, size);

        db.insert(TABLE_HERBS_FLOWERS_SIZE, null, flowersSizeValues);
    }

    private static void insertHerbsColor(SQLiteDatabase db,int id, String color) {
        ContentValues herbsColorValues = new ContentValues();
        herbsColorValues.put(COLUMN_HERBS_COLOR_ID, id);
        herbsColorValues.put(COLUMN_HERBS_COLOR_NAME, color);

        db.insert(TABLE_HERBS_COLOR, null, herbsColorValues);
    }


    private static void insertHerbPicture(SQLiteDatabase db, String url, int idHerb) {
        ContentValues pictureValues = new ContentValues();

        pictureValues.put(COLUMN_HERBS_PICTURES_URL, url);
        pictureValues.put(COLUMN_HERBS_PICTURES_ID_HERB, idHerb);

        db.insert(TABLE_HERBS_PICTURES, null, pictureValues);
    }

    private static void insertIDherbIDSeason(SQLiteDatabase db,int idHerb, int idSeason) {
        ContentValues idValues = new ContentValues();
        idValues.put(COLUMN_ID_HERB, idHerb);
        idValues.put(COLUMN_ID_SEASON, idSeason);

        db.insert(TABLE_ID_HERB__ID_SEASON, null, idValues);
    }

    private static void insertHerb(SQLiteDatabase db,int id, String name,String otherNames,int type,int sizeFlower, int color, int steamHeight , String description, String place, boolean favorite) {
        ContentValues berrieValues = new ContentValues();
        berrieValues.put(COLUMN_HERBS_ID, id);
        berrieValues.put(COLUMN_HERBS_NAME, name);
        berrieValues.put(COLUMN_HERBS_OTHERNAMES, otherNames);
        berrieValues.put(COLUMN_HERBS_TYPE, type);
        berrieValues.put(COLUMN_HERBS_FLOWERS_SIZE, sizeFlower);
        berrieValues.put(COLUMN_HERBS_COLOR, color);
        berrieValues.put(COLUMN_HERBS_STEM_HEIGHT, steamHeight);
        berrieValues.put(COLUMN_HERBS_DESCRIPTION, description);
        berrieValues.put(COLUMN_HERBS_PLACE, place);
        berrieValues.put(COLUMN_HERBS_FAVORITE, favorite);

        db.insert(TABLE_HERBS, null, berrieValues);
    }

    //-------------

    private static void insertMushroomsType(SQLiteDatabase db,int id, String type) {
        ContentValues mushroomsTypeValues = new ContentValues();
        mushroomsTypeValues.put(COLUMN_MUSHROOMS_TYPE_ID, id);
        mushroomsTypeValues.put(COLUMN_MUSHROOMS_TYPE_NAME, type);

        db.insert(TABLE_MUSHROOMS_TYPE, null, mushroomsTypeValues);
    }

    private static void insertCapSize(SQLiteDatabase db,int id, String size) {
        ContentValues capSizeValues = new ContentValues();
        capSizeValues.put(COLUMN_MUSHROOMS_CAP_SIZE_ID, id);
        capSizeValues.put(COLUMN_MUSHROOMS_CAP_SIZE_NAME, size);

        db.insert(TABLE_MUSHROOMS_CAP_SIZE, null, capSizeValues);
    }

    private static void insertCapColor(SQLiteDatabase db,int id, String color) {
        ContentValues capColorValues = new ContentValues();
        capColorValues.put(COLUMN_MUSHROOMS_CAP_COLOR_ID, id);
        capColorValues.put(COLUMN_MUSHROOMS_CAP_COLOR_NAME, color);

        db.insert(TABLE_MUSHROOMS_CAP_COLOR, null, capColorValues);
    }

    private static void insertStipeThickness(SQLiteDatabase db,int id, String thickness) {
        ContentValues stipeThicknessValues = new ContentValues();
        stipeThicknessValues.put(COLUMN_MUSHROOMS_STIPE_THICKNESS_ID, id);
        stipeThicknessValues.put(COLUMN_MUSHROOMS_STIPE_THICKNESS_NAME, thickness);

        db.insert(TABLE_MUSHROOMS_STIPE_THICKNESS, null, stipeThicknessValues);
    }


    private static void insertStipeHeight(SQLiteDatabase db,int id, String height) {
        ContentValues stipeHeightValues = new ContentValues();
        stipeHeightValues.put(COLUMN_MUSHROOMS_STIPE_HIGHT_ID, id);
        stipeHeightValues.put(COLUMN_MUSHROOMS_STIPE_HIGHT_NAME, height);

        db.insert(TABLE_MUSHROOMS_STIPE_HIGHT, null, stipeHeightValues);
    }

    private static void insertStipeColor(SQLiteDatabase db,int id, String color) {
        ContentValues stipeColorValues = new ContentValues();
        stipeColorValues.put(COLUMN_MUSHROOMS_STIPE_COLOR_ID, id);
        stipeColorValues.put(COLUMN_MUSHROOMS_STIPE_COLOR_NAME, color);

        db.insert(TABLE_MUSHROOMS_STIPE_COLOR, null, stipeColorValues);
    }

    private static void insertFleshColor(SQLiteDatabase db,int id, String color) {
        ContentValues fleshColorValues = new ContentValues();
        fleshColorValues.put(COLUMN_MUSHROOMS_FLESH_COLOR_ID, id);
        fleshColorValues.put(COLUMN_MUSHROOMS_FLESH_COLOR_NAME, color);

        db.insert(TABLE_MUSHROOMS_FLESH_COLOR, null, fleshColorValues);
    }

    private static void insertIDmushroomIDSeason(SQLiteDatabase db,int idMushroom, int idSeason) {
        ContentValues idValues = new ContentValues();
        idValues.put(COLUMN_ID_MUSHROOM, idMushroom);
        idValues.put(COLUMN_ID_SEASON, idSeason);

        db.insert(TABLE_ID_MUSHROOM__ID_SEASON, null, idValues);
    }

    private static void insertMushroom(SQLiteDatabase db,int id, String name,String otherNames,int type,int capSize, int capColor, int stipeThickness, int  stipeHeight, int stipeColor,int fleshColor, String description, String place, boolean favorite) {
        ContentValues berrieValues = new ContentValues();
        berrieValues.put(COLUMN_MUSHROOMS_ID, id);
        berrieValues.put(COLUMN_MUSHROOMS_NAME, name);
        berrieValues.put(COLUMN_MUSHROOMS_OTHERNAMES, otherNames);
        berrieValues.put(COLUMN_MUSHROOMS_TYPE, type);

        berrieValues.put(COLUMN_MUSHROOMS_CAP_SIZE, capSize);
        berrieValues.put(COLUMN_MUSHROOMS_CAP_COLOR, capColor);
        berrieValues.put(COLUMN_MUSHROOMS_STIPE_THICKNESS, stipeThickness);
        berrieValues.put(COLUMN_MUSHROOMS_STIPE_HIGHT, stipeHeight);
        berrieValues.put(COLUMN_MUSHROOMS_STIPE_COLOR, stipeColor);
        berrieValues.put(COLUMN_MUSHROOMS_FLESH_COLOR, fleshColor);

        berrieValues.put(COLUMN_MUSHROOMS_DESCRIPTION, description);
        berrieValues.put(COLUMN_MUSHROOMS_PLACE, place);
        berrieValues.put(COLUMN_MUSHROOMS_FAVORITE, favorite);

        db.insert(TABLE_MUSHROOMS, null, berrieValues);

    }

    private static void insertMushroomsPicture(SQLiteDatabase db, String url, int idMushroom) {
        ContentValues pictureValues = new ContentValues();

        pictureValues.put(COLUMN_MUSHROOMS_PICTURES_URL, url);
        pictureValues.put(COLUMN_MUSHROOMS_PICTURES_ID_MUSHROOM, idMushroom);

        db.insert(TABLE_MUSHROOMS_PICTURES, null, pictureValues);
    }


}
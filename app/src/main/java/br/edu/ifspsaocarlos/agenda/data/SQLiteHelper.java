package br.edu.ifspsaocarlos.agenda.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "agenda.db";
    static final String DATABASE_TABLE = "contatos";
    static final String KEY_ID = "id";
    static final String KEY_NAME = "nome";
    static final String KEY_FONE = "fone";
    static final String KEY_FONE2 = "fone2";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    static final String KEY_NASCIMENTO = "nascimento";


    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_CREATE = "CREATE TABLE "+ DATABASE_TABLE +" (" +
            KEY_ID  +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT NOT NULL, " +
            KEY_FONE + " TEXT, "  +
            KEY_EMAIL + " TEXT);";

    SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);

        database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_FAVORITO + " INTEGER;");
        database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_FONE2 + " TEXT;");
        database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_NASCIMENTO + " DATE;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int    newVersion) {

        Log.e("INFO", "Atualizando tabela da versão " + oldVersion + " para a versão " + newVersion);

        if(oldVersion < 2){
            database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_FAVORITO + " INTEGER;");
        }

        if(oldVersion < 3){
            database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_FONE2 + " TEXT;");
        }

        if(oldVersion < 4){
            database.execSQL("ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN "  + KEY_NASCIMENTO + " DATE;");
        }

    }
}


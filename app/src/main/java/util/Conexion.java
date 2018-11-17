package util;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.support.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {


    public Conexion(Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_NACIONAL);
        db.execSQL(Utilidades.CREAR_TABLA_LOTEKA);
        db.execSQL(Utilidades.CREAR_TABLA_REAL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_NACIONAL);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_LOTEKA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REAL);

    }
}

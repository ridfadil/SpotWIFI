package id.wifispotri.com.wifispot.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.wifispotri.com.wifispot.model.Spot;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Spot.db";
    public static final String TABLE_NAME = "DataStudent";

    public static final String ID_DB = "id_db";
    public static final String ID_API = "id_api";
    public static final String NAMA_SPOT = "nama_spot";
    public static final String JUMLAH_SPOT = "jumlah_spot";
    public static final String LOKASI_SPOT = "lokasi";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " " +
                "(id_db INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " id_api TEXT," +
                " nama_spot TEXT ," +
                " jumlah_spot TEXT," +
                " lokasi TEXT," +
                " longitude TEXT," +
                " latitude TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public List<Spot> tampilData() {
        List<Spot> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String qr = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(qr, null);
        if (cursor.moveToFirst()) {
            do {

                Spot spot = new Spot(
                        (cursor).getString((cursor).getColumnIndex(ID_DB)),
                        (cursor).getString((cursor).getColumnIndex(ID_API)),
                        (cursor).getString((cursor).getColumnIndex(NAMA_SPOT)),
                        (cursor).getString((cursor).getColumnIndex(JUMLAH_SPOT)),
                        (cursor).getString((cursor).getColumnIndex(LOKASI_SPOT)),
                        (cursor).getString((cursor).getColumnIndex(LONGITUDE)),
                        (cursor).getString((cursor).getColumnIndex(LATITUDE))
                );
                list.add(spot);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean MasukanData(String idApi, String nama, String jumlahSpot, String lokasi, String longitude, String latitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(ID_API, idApi);
        konten.put(NAMA_SPOT, nama);
        konten.put(JUMLAH_SPOT, jumlahSpot);
        konten.put(LOKASI_SPOT, lokasi);
        konten.put(LATITUDE, latitude);
        konten.put(LONGITUDE, longitude);

        long hasil = db.insert(TABLE_NAME, null, konten);
        db.close();

        if (hasil == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean cekData(String idApi) {
        boolean data = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        String qr = "select * from " + TABLE_NAME + " where " + ID_API + " = " + idApi;
        Cursor cursor = db.rawQuery(qr, null);
        if (cursor.moveToFirst()) {
            do {
                Spot spot = new Spot(
                        (cursor).getString((cursor).getColumnIndex(ID_DB))
                );
                data = true;
            } while (cursor.moveToNext());
        }
        return data;
    }

    public String getIdDb(String idApi) {
        String id = "";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        String qr = "select * from " + TABLE_NAME + " where " + ID_API + " = " + idApi;
        Cursor cursor = db.rawQuery(qr, null);
        if (cursor.moveToFirst()) {
            do {
                Spot spot = new Spot(
                        id = (cursor).getString((cursor).getColumnIndex(ID_DB))
                );
            } while (cursor.moveToNext());
        }
        return id;
    }

    public boolean EditData(String idDb, String idApi, String nama, String jumlahSpot, String lokasi, String longitude, String latitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues konten = new ContentValues();
        konten.put(ID_DB, idDb);
        konten.put(ID_API, idApi);
        konten.put(NAMA_SPOT, nama);
        konten.put(JUMLAH_SPOT, jumlahSpot);
        konten.put(LOKASI_SPOT, lokasi);
        konten.put(LATITUDE, latitude);
        konten.put(LONGITUDE, longitude);

        int hasil = db.update(TABLE_NAME, konten, "id_db = ? ", new String[]{idDb});
        if (hasil > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean DeleteData(String idDb) {
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, "id_db = ? ", new String[]{idDb});
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
}
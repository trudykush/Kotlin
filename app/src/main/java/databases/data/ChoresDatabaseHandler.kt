package databases.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import databases.model.ChoreModel
import databases.model.DATABASE_NAME
import databases.model.DATABASE_VERSION
import databases.model.KEY_CHORE_ASSIGNED_BY
import databases.model.KEY_CHORE_ASSIGNED_TIME
import databases.model.KEY_CHORE_ASSIGNED_TO
import databases.model.KEY_CHORE_NAME
import databases.model.KEY_ID
import databases.model.TABLE_NAME

class ChoresDatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        var CREATE_CHORE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY,"+
                KEY_CHORE_NAME + " TEXT," +
                KEY_CHORE_ASSIGNED_BY + " TEXT," +
                KEY_CHORE_ASSIGNED_TO + " TEXT," +
                KEY_CHORE_ASSIGNED_TIME + " LONG" +");"

        db?.execSQL(CREATE_CHORE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    /*
    *   CRUD - CREATE, READ, UPDATE, DELETE
    * */

    fun createChore(choreModel: ChoreModel) {

        var db: SQLiteDatabase = writableDatabase

        var values: ContentValues = ContentValues()
        values.put(KEY_CHORE_NAME, choreModel.choreName)
        values.put(KEY_CHORE_ASSIGNED_BY, choreModel.assignBy)
        values.put(KEY_CHORE_ASSIGNED_TO, choreModel.assignTo)
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readChore(): ArrayList<ChoreModel> {

        var db: SQLiteDatabase = writableDatabase
        var list: ArrayList<ChoreModel> = ArrayList()

        var selectAllQuery = "SELECT * FROM $TABLE_NAME"

        var cursor: Cursor = db.rawQuery(selectAllQuery, null)

        if (cursor.moveToFirst()) {
            do {
                var chore = ChoreModel()
                chore.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                chore.choreName = cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME))
                chore.assignBy = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY))
                chore.assignTo = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO))
                chore.timeAssigned = cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))

                list.add(chore)
            } while(cursor.moveToNext())
        }
        return list
    }

    fun readAChore(id: Int): ChoreModel {
        var db: SQLiteDatabase = writableDatabase
        var cursor: Cursor = db.query(TABLE_NAME, arrayOf(KEY_ID,
            KEY_CHORE_NAME, KEY_CHORE_ASSIGNED_BY,
            KEY_CHORE_ASSIGNED_TIME,
            KEY_CHORE_ASSIGNED_TO), KEY_ID + "=?", arrayOf(id.toString()),
            null, null, null, null)


        if (cursor != null)
            cursor.moveToFirst()

        var chore = ChoreModel()
        chore.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
        chore.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
        chore.choreName = cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME))
        chore.assignTo = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO))
        chore.timeAssigned = cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))
        chore.assignBy = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY))

        return chore

    }

    fun updateChore(choreModel: ChoreModel) : Int {
        var db: SQLiteDatabase = writableDatabase

        var values: ContentValues = ContentValues()
        values.put(KEY_CHORE_NAME, choreModel.choreName)
        values.put(KEY_CHORE_ASSIGNED_BY, choreModel.assignBy)
        values.put(KEY_CHORE_ASSIGNED_TO, choreModel.assignTo)
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        return db.update(TABLE_NAME, values, "$KEY_ID=?", arrayOf(choreModel.id.toString()))
    }

    fun deleteChore(id: Int) {
        var db: SQLiteDatabase = writableDatabase
        db.delete(TABLE_NAME,  KEY_ID + "=?", arrayOf(id.toString()))

        db.close()
    }

    fun choreCount(): Int {
        var db: SQLiteDatabase = readableDatabase
        var countQuery = "SELECT * FROM " + TABLE_NAME
        var cursor: Cursor = db.rawQuery(countQuery, null)

        return cursor.count
    }
}
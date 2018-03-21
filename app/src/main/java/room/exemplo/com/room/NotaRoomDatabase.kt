package room.exemplo.com.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Andre on 20/03/2018.
 */

@Database(entities = [(Nota::class)],version = 1)
abstract class NotaRoomDatabase : RoomDatabase(){

    abstract fun notaDAO() : NotaDao

    companion object {
        private var INSTANCE: NotaRoomDatabase? = null
        internal fun getDatabase(context: Context): NotaRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(NotaRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                NotaRoomDatabase::class.java, "nota_database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
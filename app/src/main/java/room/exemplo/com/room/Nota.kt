package room.exemplo.com.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Andre on 20/03/2018.
 */

@Entity(tableName = "tb_nota")
data class Nota(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "descricao")
    var descricao: String ){
    constructor():this(null,"")
}
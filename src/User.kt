import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class User(
    firstName: String,
    lastName: String,
    middleName: String
) {
    var counter = 0
        private set

    var firstName by FormatDelegate(firstName)

    var lastName by FormatDelegate(lastName)

    var middleName by FormatDelegate(middleName)

    class FormatDelegate(initial: String): ReadWriteProperty<User, String> {

        private var name = initial

        override fun getValue(
            thisRef: User,
            property: KProperty<*>
        ): String {
            return name
        }

        override fun setValue(
            thisRef: User,
            property: KProperty<*>,
            value: String
        ) {
            name = value.lowercase()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            thisRef.counter++
        }

    }
}


class DatabaseManager {
    val database: ArrayList<String> by lazy {
        ArrayList()
    }
}

object Database {
    private var INSTANCE: ArrayList<String>? = null

    fun getInstance(): ArrayList<String> {
        if (INSTANCE == null) {
            INSTANCE = ArrayList()
        }
        return INSTANCE!!
    }
}
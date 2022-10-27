import java.util.LinkedList
import kotlin.system.measureNanoTime

fun main() {
    val list = ListWithTrash<Int>(LinkedList()).apply {
        add(1)
        add(2)
        add(3)
    }

    list.remove(2)

    println(list.lastDeleted)
}
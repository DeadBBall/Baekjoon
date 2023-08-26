import java.lang.StringBuilder
import java.util.Scanner

var bit = 0L
val ansMaker = StringBuilder()

fun main(args: Array<String>) = with(Scanner(System.`in`)){
    var m: Int = nextInt()
    while(m-- > 0) {
        val command = next()
        when (command) {
            "all" -> all()
            "empty" -> empty()
            "add" -> add(nextInt())
            "remove" -> remove(nextInt())
            "check" -> ansMaker.append(check(nextInt())).append("\n")
            else -> toggle(nextInt())
        }
    }
    print(ansMaker)
}

fun all() {
    bit = bit or 0L.inv()
}

fun add(num: Int) {
    bit = bit or (1L shl num - 1)
}

fun remove(num: Int) {
    bit = bit and (1L shl num - 1).inv()
}

fun check(num: Int): Int {
    if(bit and (1L shl num - 1) >= 1L) return 1
    return 0
}

fun toggle(num: Int) {
    bit = bit xor (1L shl num - 1)
}

fun empty() {
    bit = 0
}
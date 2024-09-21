import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("Hello, World!")
    }
    print("Hello! ====")

}
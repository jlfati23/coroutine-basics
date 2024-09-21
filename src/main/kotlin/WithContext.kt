import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("First Coroutine Context $coroutineContext")
            withContext(Dispatchers.IO){
                println("Second Coroutine Context: $coroutineContext")
            }
            println("Third Coroutine Context $coroutineContext")
        }
    }
}
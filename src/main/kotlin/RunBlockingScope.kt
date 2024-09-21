
import kotlinx.coroutines.*

fun main() {
    runBlocking {
        // This coroutine will run on the main thread
        println("Running on thread: ${Thread.currentThread().name}")
        delay(1000L) // This suspends, but does not block the main thread
        println("Finished after delay on thread: ${Thread.currentThread().name}")
    }
    runBlocking(Dispatchers.Default) {
        // This coroutine will run on another thread
        println("Running on thread: ${Thread.currentThread().name}")
        delay(1000L)
        println("Finished after delay on thread: ${Thread.currentThread().name}")
    }
    println("This will run after the runBlocking block completes.")
}

import kotlinx.coroutines.*

suspend fun getData(): String {
    delay(3000L) // Suspends for 1 second
    return "Data fetched"
}

fun main() {
    runBlocking {
        println("This is running on thread ${Thread.currentThread().name}")

        // This will suspend the whole coroutine for 3 seconds
        val result = getData()
        println(result)
        println("Hello world")

        launch {
            println("This is running on thread ${Thread.currentThread().name}")
            println(getData())
        }
        println("Hello world")

    }
}

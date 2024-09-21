import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("This scope is running on ${Thread.currentThread().name}")
        val job1 = launch {
            println("Task from job1")
            val job2 = launch {
                delay(1000L)
                println("job2 is finishing")
            }
            job2.invokeOnCompletion {
                println("job2 is completed")

            }
            val job3 = launch {
                delay(1000L)
                println("job3 is finishing")
            }
            job3.invokeOnCompletion {
                println("job3 is completed")
            }
        }

        job1.invokeOnCompletion {
            println("job1 is completed")
        }
        delay(500L)
        println("Cancelling job1")
        job1.cancel()
    }
    print("Main program is finished")
}
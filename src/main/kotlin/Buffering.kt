import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

    runBlocking {
        val timeWithoutBuffering = measureTimeMillis {
            generate().collect {
                delay(300L)
                println(it)
            }
        }
        println("Collected in $timeWithoutBuffering ms")

        val timeWithBuffering = measureTimeMillis {
            generate().buffer().collect {
                delay(300L)
                println(it)
            }
        }
        println("Collected in $timeWithBuffering ms")
    }

}


fun generate() = flow {
    for (i in 1..3) {
        delay(100L)
        emit(i)
    }
}
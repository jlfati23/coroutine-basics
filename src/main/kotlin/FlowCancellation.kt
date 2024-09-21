import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbersFlow = sendNewNumbers()
        println("Flow hasn't started yet")
        println("Starting flow now")
        //flow will be cancelled by external timeout, not by itself
        withTimeoutOrNull(1000L) {
            numbersFlow.collect { println(it) }
        }
    }
}

fun sendNewNumbers() = flow {
    listOf(1, 2, 3).forEach {
        delay(400L)
        emit(it)
    }
}

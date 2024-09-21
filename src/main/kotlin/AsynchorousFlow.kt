import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        flowExample().collect { value ->
            println("Received $value")
        }
        asFlowExample().collect { value ->
            println("Received $value")
        }
        flowOfExample().collect { value ->
            println("Received $value")
        }
    }

}

fun flowExample()  = flow{
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun asFlowExample() = listOf(1, 2,3).asFlow()

fun flowOfExample() = flowOf(1, 2, 3)


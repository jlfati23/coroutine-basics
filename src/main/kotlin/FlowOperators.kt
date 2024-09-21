import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        mapOperator()
        filterOperator()
    }
}


suspend fun mapOperator() {
    (1..3).asFlow().map { number -> number * 2 }
        .collect { number -> println(number) }
}

suspend fun filterOperator() {
    (1..10).asFlow().filter { number -> number % 2 == 0 }
        .collect { number -> println(number) }
}

suspend fun takeOperator() {
    (1..10).asFlow().take(3)
        .collect { number -> println(number) }
}

suspend fun reduceOperator() {
    val sum = (1..5).asFlow().reduce { a, b -> a + b }
    println(sum)
}

suspend fun transformOperator() {
    (1..3).asFlow().transform { request ->
        emit("Making request $request")
        emit("Response for request $request")
    }.collect { response -> println(response) }
}
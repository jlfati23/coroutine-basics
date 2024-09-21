import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var timesCalled = 0

fun main() {
    GlobalScope.launch { doSomething() }
    GlobalScope.launch { doSomethingElse() }
    println("Hello! ====")
    Thread.sleep(2000L)
    println("Times called: $timesCalled")
}

suspend fun  doSomething() {
    delay(500L)
    println("Doing something")
    println("Doing something on ${Thread.currentThread().name}")
    timesCalled ++
}

suspend fun doSomethingElse() {
    delay(1000L)
    println("Doing something else")
    println("Doing something else on ${Thread.currentThread().name}")
    timesCalled ++
}

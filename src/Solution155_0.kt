import java.util.*
import kotlin.math.min

//实现栈，并且支持常数时间内获取栈内最小元素
//假设pop，top，getMin总是在非空栈调用

class MinStack() {

    private val numList = LinkedList<Int>()

    private var minValue = LinkedList<Int>()

    fun push(x: Int) {
        numList.add(x)
        minValue.add(if (numList.size == 1) x else min(minValue.last, x))
    }

    fun pop() {
        numList.removeLast()
        minValue.removeLast()
    }

    fun top(): Int {
        return numList.last
    }

    fun getMin(): Int {
        return minValue.last
    }
}
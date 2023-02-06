fun main() {
    //print(maxProfit(intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0)))
    print(maxProfit(intArrayOf(7, 5, 4, 3, 2, 1)))
}

fun maxProfit(prices: IntArray): Int {
    var buy = Integer.MAX_VALUE
    var sell = 0
    val map = HashMap<Int, Int>()
    for (i in 0 until prices.size) {
        if (prices[i] < buy) {
            buy = prices[i]
            sell = 0
        }

        if (buy >= 0 && prices[i] > sell) {
            sell = prices[i]
            map[buy] = sell
        }
    }

    val result: Int


    var difference = Integer.MIN_VALUE
    map.forEach {
        if (it.value - it.key > difference)
            difference = it.value - it.key
    }
    result = difference

    return result
}
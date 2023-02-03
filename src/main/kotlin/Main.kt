import java.lang.Exception
import javax.print.attribute.IntegerSyntax

fun main() {
    print(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

fun maxProfit(prices: IntArray): Int {
    val pricesTemp = prices.toMutableList()
    var tempList = mutableListOf<Int>()
    var min = -1
    while (tempList.size < 2) {
        tempList.clear()
        if (min != -1) {
            pricesTemp.remove(min)
        }
        for (i in pricesTemp.indices) {
            if (tempList.contains(pricesTemp[i])) {
                tempList.removeAt(tempList.indexOf(pricesTemp[i]))
            }
            tempList.add(pricesTemp[i])
        }

        try {
            min = (tempList.min() ?: 0)
        } catch (e: Exception) {
            return 0
        }

        if (min >= 0)
            tempList = tempList.subList(tempList.indexOf(min), tempList.size)
        return 0
    }
    return (tempList.max() ?: 0) - min
}
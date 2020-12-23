import model.Model
import kotlin.math.log

object Exercise2 {

    fun computeCardinalities(list: List<String>, n: Int): List<Model> {

        val groupedList: ArrayList<ArrayList<String>> = mutableListOf<ArrayList<String>>() as ArrayList<ArrayList<String>>
        val helper = ArrayList<String>()
        for(i in 0..list.size-1 step 1) {
            helper.clear()
            for(j in 0..n-1 step 1) {
                if (i+j < list.size )
                    helper.add(list[i+j])
            }
            groupedList.add(helper.clone() as java.util.ArrayList<String>)
        }


        val map = groupedList.groupingBy { it }.eachCount()

        return map.map{ Model(it.key, it.value)}

    }

    private fun computeSumOfCardinalities(list: List<Model>): Double {
        var result: Double = 0.0

        list.forEach {
            result += it.cardinality
        }
        return result
    }

    private fun entropy(list: List<Model>): Double {
        val sumOfCardinalities = computeSumOfCardinalities(list)

        var entropy = 0.0
        list.forEach {
            entropy += -1 * (it.cardinality / sumOfCardinalities) * log(it.cardinality / sumOfCardinalities, 2.0)
        }
        return entropy
    }

    fun doCalculations(ngrams: List<Model>, nextGrams: List<Model>): Double {
        return entropy(nextGrams) - entropy(ngrams)
    }


    fun entropy(text: String, words: Boolean) {

        val stringArray: List<String>
        if (words) {
            stringArray = text.trim().split(' ')
        } else {
            stringArray = text.chunked(1)
        }

        val oneGrams = computeCardinalities(stringArray, 1)

        println("Entropy: " + entropy(oneGrams))
    }

    fun conditionalEntropy(text: String, n: Int, words: Boolean) {
        val stringArray: List<String>
        if (words) {
            stringArray = text.trim().split(' ')
        } else {
            stringArray = text.chunked(1)
        }

        val ngrams = computeCardinalities(stringArray, n)

        val nextGrams = computeCardinalities(stringArray, n+1)

        println("Condidtional Entropy: " + doCalculations(ngrams, nextGrams))
    }
}
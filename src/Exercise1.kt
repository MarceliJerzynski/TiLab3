import kotlin.math.log

object Exercise1 {


    fun Exercise1App() {
        var entriopy: Double = 0.0
        val prob: Double = 1/37.0

        for(i in 1..37) {
            entriopy -= prob * log(prob,2.0)
        }

        print("Entriopy: ${entriopy}")
    }
}
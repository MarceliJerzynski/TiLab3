package model

class Model(
    var values: List<String>,
    var cardinality: Int
    ) {

    override fun toString(): String {
        return "[" + values.toString() + " | " + cardinality.toString() + "]"
    }


}
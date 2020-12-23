



fun main(args: Array<String>) {

    Exercise1.Exercise1App()

    val files = mutableListOf(
   //   "norm_wiki_en.txt",
   //   "norm_wiki_eo.txt",
      "norm_wiki_et.txt",
      "norm_wiki_ht.txt",
      "norm_wiki_la.txt",
      "norm_wiki_nv.txt",
      "norm_wiki_so.txt",
      "sample0.txt",
      "sample1.txt",
      "sample2.txt",
      "sample3.txt",
      "sample4.txt",
      "sample5.txt",

    )
    val path = "C:\\Users\\Marceli\\Documents\\Ti\\"
    for(file in files) {

        val text = FileReader.readFileAsLinesUsingUseLines(path + file)[0]

        println("File: " + file)

        Exercise2.entropy(text, true)
        println("Chars: ")
        Exercise2.entropy(text, false)

        for(n in 1..3) {
            println("N: " + n)
            println("Words: ")
            Exercise2.conditionalEntropy(text, n, true)
            println("Chars: ")
            Exercise2.conditionalEntropy(text, n, false)
        }

    }

}
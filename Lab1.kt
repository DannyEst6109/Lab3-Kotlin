import java.lang.NullPointerException

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    val lista =  ArrayList<ItemData>()
    var i = 0
    if (inputList != null) {
        for (x in inputList) {
            if (x != null) {
                val new = ItemData(originalPos = i, originalValue = x)
                i += 1
                when (x) {
                    is Int -> { new.type = "entero"
                        new.info = (if (x % 10 == 0) "m10" else if (x % 5 == 0)"m5" else if (x % 2 == 0) "m2" else null)
                    }is String -> { new.type = "cadena"
                        new.info = "l${x.length}"
                    }is Boolean -> { new.type = "booleano"
                        new.info = (if (x == true) "verdadero" else "falso").toString()
                    }
                }
                lista.add(new)
            }else { i += 1 }
        }
        return lista
    }else { return null }
}

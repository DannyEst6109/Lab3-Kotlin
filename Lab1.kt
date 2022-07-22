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
                    is Int -> {
                        new.type = "entero"
                        if (x % 10 == 0) {
                            new.info = "m10"
                        } else if (x % 5 == 0) {
                            new.info = "m5"
                        } else if (x % 2 == 0) {
                            new.info = "m2"
                        } else {
                            new.info = null
                        }
                    }is String -> {
                        new.type = "cadena"
                        new.info = "l${x.length}"
                    }is Boolean -> {
                        new.type = "booleano"
                        if (x == true) {
                            new.info = "verdadero"
                        } else {
                            new.info = "falso"
                        }
                    }else -> {
                        new.type = null
                        new.info = null
                    }
                }
                lista.add(new)
            }else{
                i += 1
            }
        }
        return lista
    }else {
        return null
    }
}

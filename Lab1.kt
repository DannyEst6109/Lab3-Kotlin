import java.lang.NullPointerException

//No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    //val result = processList(listOf(false,false,false,true,true,false))
    //val result = processList(listOf(2,4,5,8,10,12,11))
    //val result = processList(listOf("hola","casa","a","ab","supercalifragilisticoespialidoso"))
    //val result = processList(listOf(10, "Enero", null, true))
    //val result = processList(listOf(null, null, null, null, null))
    //val result = processList(listOf())
    //val result = processList(null)

    /*
    val result = processList(
        listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0)
    )
    */
    println(result)

}

fun processList(inputList: List<Any?>?): List<ItemData>? {

    //Crear variable lista y un contador
    val lista =  ArrayList<ItemData>()
    var i = 0

    //verificar si la entrada es o no null
    if (inputList != null) {
        //si inputList no es null..

        //for para recorrer cada elemento de InputList

        for (x in inputList){

            /**originalPos y originalValue:**/
            //crear una variable ItemData y asignar valores iniciales
            //val new = ItemData(originalPos = i, originalValue = x)
            //Aumentar el num del contador
            val posAnterior = i
            i += 1

            /**type*/
            //verificar el tipo de dato/objeto
            val tipo = when(x){
                is Int -> "entero"
                is String -> "cadena"
                is Boolean -> "booleano"
                else -> null
            }


            //comprobar si el elemento es o no null:
            if (x != null){
                //Si el elemento no es null...
                val new = ItemData(originalPos = posAnterior, originalValue = x, type = tipo)

                /**info:*/
                //Corroborar el tipo del elemento
                if (new.type == "entero"){
                    //si es de tipo entero...
                    //convertir x a tipo Int para poder realizar operaciones mat. con ella
                    x as Int//            when {
//                i == 0 -> {
//
//                }
//                i == 1 -> {
//
//                }
//                else -> {
//
//                }
//            }


                    //ver si x es multiplo de 10,5,2 o ninguno
                    if(x%10 == 0){
                        //si al dividir x entre 10, el residuo es cero...
                        new.info = "m10"
                    }else if(x%5 == 0){
                        //si al dividir x entre 5, el residuo es cero...
                        new.info = "m5"
                    }else if(x%2 == 0) {
                        //si al dividir x entre 2, el residuo es cero...
                        new.info = "m2"
                    }else{
                        //si no es divisible entre 10, 5 o 2...
                        new.info = null
                    }

                }else if(new.type == "cadena"){
                    //si es de tipo string...
                    //pasar x a tipo String para poder contar el tamaño de la palabra
                    x as String

                    //asignar la info según la cantidad de letras que tiene
                    new.info = "l${x.length }"

                }else if(new.type == "booleano"){
                    //si es de tipo booleano...

                    //comprobar si x es true o false
                    if(x == true){
                        //si es true...
                        //asignar valor verdadero a info
                        new.info = "verdadero"
                    }else{
                        //si es false...
                        //asignar valor falso a info
                        new.info = "falso"
                    }
                }else{
                    //si es de cualquier otro tipo
                    //asignar valor null a info
                    new.info = null

                }
                //añadir la variable new a la lista
                lista.add(new)
            }
        }
        //retornar el valor de lista
        return lista
    }else{
        //Si inputList es null, retornar null
        return null
    }
    //FIN
}

/**
 * Cómo verificar el tipo de objeto?
 * when (myAnyTypeElement) {
 * 	is String -> TODO()
 *  is Int -> TODO()
 *  is Boolean -> TODO()
 * 	else -> TODO()
 * }
 */

/**
 * Cómo declarar una función en una variable?
 * val myFuncVar = { x: Any -> TODO() }
 */

/**
 * Cómo crear un objeto de nuestra clase?
 * val newItem = ItemData(
 * 	originalPos = 0,
 * 	originalValue = "hola"
 * 	type = "cadena"
 * 	info = "L4"
 * )
 */
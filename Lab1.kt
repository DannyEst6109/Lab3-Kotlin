import java.lang.NullPointerException

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any?,  //Se cambió el tipo de Any a Any? para ejecutar el programa 
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
	//Crear variable lista y un contador
    var lista =  ArrayList<ItemData>()
    var i: Int = 0

    //verificar si la entrada es o no null
    if (inputList != null) {
        //si inputList no es null..

        //for para recorrer cada elemento de InputList
        for (x in inputList){

            /**originalPos y originalValue:**/
            //crear una variable ItemData y asignar valores iniciales
            var new = ItemData(originalPos = i, originalValue = x)
            //Aumentar el num del contador
            i = i+1

            /**type*/
            //verificar el tipo de dato/objeto
            when(x){
                is Int -> new.type = "entero"
                is String -> new.type = "cadena"
                is Boolean -> new.type = "booleano"
                else -> new.type = null
            }

            //comprobar si el elemento es o no null:
            if (x != null){
                //Si el elemento no es null...

                /**info:*/
                //Corroborar el tipo del elemento
                if (new.type == "entero"){
                    //si es de tipo entero...
                    //convertir x a tipo Int para poder realizar operaciones mat. con ella
                    x as Int

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
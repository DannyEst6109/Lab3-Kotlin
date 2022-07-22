package com.example.miprimeraapp

import org.junit.Test
import kotlin.test.*

class LabTest {
    @Test
    fun `Given a list, whem it has multiple elements, then result list should be correct`() {
        val result = processList(
            listOf(10, "Enero", null, true)
        )
        assertNotNull(result)
        assertTrue(result.size == 3)
        assertTrue(
            result.get(0).originalPos == 0
                    && result.get(0).originalValue == 10
                    && result.get(0).type?.lowercase() == "entero"
                    && result.get(0).info?.lowercase() == "m10"
        )

        assertTrue(
            result.get(1).originalPos == 1
                    && result.get(1).originalValue == "Enero"
                    && result.get(1).type?.lowercase() == "cadena"
                    && result.get(1).info?.lowercase() == "l5"
        )
        assertTrue(
            result.get(2).originalPos == 3
                    && result.get(2).originalValue == true
                    && result.get(2).type?.lowercase() == "booleano"
                    && result.get(2).info?.lowercase() == "verdadero"
        )
    }

    @Test
    fun `Given a null list, whem processList is called, then it returns null`() {
        val result = processList(null)
        assertNull(result)
    }

    @Test
    fun `Given a list, whem it has only null items, then it returns an empty list`() {
        // Case 1: multiple null items
        val result = processList(listOf(null, null, null, null, null))
        assertNotNull(result)
        assertTrue(result.size == 0)

        // Case 2: empty list
        val result2 = processList(emptyList())
        assertNotNull(result)
        assertTrue(result.size == 0)
    }

    @Test
    fun `Given a list, whem it has multiple elements, then result list should be correct in all values`() {
        val result = processList(
            listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0)
        )
        assertNotNull(result)
        assertTrue(result.size == 9)

        assertTrue(
            result.get(0).originalPos == 0
                    && result.get(0).originalValue == 20
                    && result.get(0).type?.lowercase() == "entero"
                    && result.get(0).info?.lowercase() == "m10"
        )

        assertTrue(
            result.get(1).originalPos == 1
                    && result.get(1).originalValue == 25
                    && result.get(1).type?.lowercase() == "entero"
                    && result.get(1).info?.lowercase() == "m5"
        )

        assertTrue(
            result.get(2).originalPos == 2
                    && result.get(2).originalValue == 2
                    && result.get(2).type?.lowercase() == "entero"
                    && result.get(2).info?.lowercase() == "m2"
        )

        assertTrue(
            result.get(3).originalPos == 3
                    && result.get(3).originalValue == 7
                    && result.get(3).type?.lowercase() == "entero"
                    && result.get(3).info == null
        )

        assertTrue(
            result.get(4).originalPos == 4
                    && result.get(4).originalValue == "hola"
                    && result.get(4).type?.lowercase() == "cadena"
                    && result.get(4).info?.lowercase() == "l4"
        )

        assertTrue(
            result.get(5).originalPos == 5
                    && result.get(5).originalValue == ""
                    && result.get(5).type?.lowercase() == "cadena"
                    && result.get(5).info?.lowercase() == "l0"
        )

        assertTrue(
            result.get(6).originalPos == 6
                    && result.get(6).originalValue == true
                    && result.get(6).type?.lowercase() == "booleano"
                    && result.get(6).info?.lowercase() == "verdadero"
        )

        assertTrue(
            result.get(7).originalPos == 7
                    && result.get(7).originalValue == false
                    && result.get(7).type?.lowercase() == "booleano"
                    && result.get(7).info?.lowercase() == "falso"
        )

        assertTrue(
            result.get(8).originalPos == 9
                    && result.get(8).originalValue == 2.0
                    && result.get(8).type == null
                    && result.get(8).info == null
        )
    }
}

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any?,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

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
    //FIN)
}
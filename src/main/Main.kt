package main
import modelo.Usuario
import java.io.EOFException
import java.util.Scanner

val sc=  Scanner(System.`in`)
private val Usuario = Usuario("", 500.0)

//Colores mensaje Errores:
val ROJO="0xfff44336" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores


fun main() {
    println("CAJERO AUTOMÁTICO")
}


fun menuCajero(){
var salir=false

    do {
        try {
            print("Ingrese su nombre ")
          var nombre =  sc.nextLine()

            if (nombre.isEmpty()){
                 print("El nombre no debe de estar vacio")
                continue
            }
                Usuario.setNombre(nombre)


        }catch (e:EOFException){
                print(ROJO+"ERROR!: Has salido fuera del fichero")
                salir=false
        }catch (e: IllegalAccessError){
                print(ROJO+"ERROR! Valor introducido no válido")
        }

        try {
            println("<=====CAJERO AUTOMÁTICO========>")
            println("<=======BIENVENIDO: ${Usuario.getNombre()} ----===========>")
            println("<======= 1.Consultar saldo========>")
            println("<=======2. Ingresar dinero====>")
            println("<=======3. Retirar dinero========>")
            println("<=======4. Salir==>")
            println("<=======Seleccione una opción==========>")
            if(!sc.hasNextInt()) {
                sc.next()
                println("Error: La opción seleccionada no está disponible")
                continue
            }



        }catch (ex: Exception){
            println(ROJO+"ERROR! Valor inválido detectado")
        }



    }while (!salir)

}
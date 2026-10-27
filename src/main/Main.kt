package main
import modelo.Usuario
import java.io.EOFException
import java.util.Scanner
import controlador.Cajero
val sc=  Scanner(System.`in`)
private val Usuario = Usuario("", 500.0)
private val cajero=Cajero()
//Colores mensaje Errores:
val ROJO="0xfff44336" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores



fun pedidaDatos(): Double{
    var cantidad=0.0
    try {
        println("Ingrese la cantidad de dinero que desee")
        cantidad = sc.nextDouble()
        cajero.ingresarDinero(cantidad)
    }catch (e: IllegalAccessError){
        println(ROJO+"ERROR!: VALOR INTRODUCIDO NO VÁLIDO")
    }
    return cantidad
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
            when(val opcion = sc.nextInt()){
                1->cajero.mostrarSaldo()
                2->{
                    cajero.ingresarDinero(pedidaDatos())
                }
                3-> {
                    cajero.retirarDinero(pedidaDatos())
                }
                4-> {
                    salir=true
                    println("Has salido del programa ")
                }

                else -> println("Opción introducida no disponible.")


            }


        }catch (ex: Exception){
            println(ROJO+"ERROR! Valor inválido detectado")
        }



    }while (!salir)
}
fun main() {
    menuCajero()
}
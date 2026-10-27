package main
import modelo.Usuario
import java.io.EOFException
import java.util.Scanner
import controlador.Cajero
import controlador.RESET
import controlador.ROJO
import java.util.InputMismatchException

val sc=  Scanner(System.`in`)
private val Usuario = Usuario("", 500.0)
private val cajero=Cajero(Usuario)
//Colores mensaje Errores:




fun pedidaDatos(): Double{
    var cantidad=0.0
   while (true) {
       try {
           println("Ingrese la cantidad de dinero ")
           cantidad = sc.nextDouble()
           return cantidad
       } catch (e: InputMismatchException) {
           println("${ROJO} ERROR!: VALOR INTRODUCIDO NO VÁLIDO$")
           sc.next()
       }
   }
}
fun pedidaNombreUsuario(){
    var salir=false
    while (!salir){
        try {
            print("Ingrese su nombre ")
            val nombre =  sc.nextLine().trim()

            if (nombre.isEmpty()){
                print("${ROJO}El nombre no debe de estar vacio$RESET")
            }else {
                Usuario.setNombre(nombre)
                return
            }
        }catch (e:NoSuchElementException){
            print("${ROJO} ERROR!: Has salido fuera del fichero")
            salir=true
        }catch (e: IllegalAccessError){
            print("${ROJO} ERROR! Valor introducido no válido")
        }
    }
}

fun menuCajero(){
var salir=false
    pedidaNombreUsuario()
    do {
        try {
            println("<=====CAJERO AUTOMÁTICO========>")
            println("<=======BIENVENIDO: ${Usuario.getNombre()} ----===========>")
            println("<=======1. Consultar saldo========>")
            println("<=======2. Ingresar dinero====>")
            println("<=======3. Retirar dinero========>")
            println("<=======4. Salir==>")
            println("<=======Seleccione una opción==========>")
            if(!sc.hasNextInt()) {
                sc.next()
                println("Error: La opción seleccionada no está disponible")
                continue
            }
            val opcion = sc.nextInt()
            when(opcion){
                1->cajero.mostrarSaldo()
                2->{
                   val cantidad= pedidaDatos()
                        cajero.ingresarDinero(cantidad)
                }
                3-> {
                   val cantidad=pedidaDatos()
                    cajero.retirarDinero(cantidad)
                }
                4-> {
                    salir=true
                    println("Has salido del programa ")
                }

                else -> println("Opción introducida no disponible.")


            }


        }catch (ex: Exception){
            println("${ROJO} ERROR! Valor inválido detectado $RESET")
        }catch ( e:NoSuchElementException){
            println("${ROJO} ERROR! ERROR!: Has salido fuera del fichero $RESET ")
            salir=true
        }

    }while (!salir)
}
fun main() {
    menuCajero()
}
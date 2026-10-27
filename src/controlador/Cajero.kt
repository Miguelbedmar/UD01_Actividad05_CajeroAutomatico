package controlador

import modelo.Usuario

private val usuario = Usuario("", 500.0)
private val saldo get()  = usuario.getSaldo() // Modificamos dinamicamente una constante
private val nombre get()= usuario.getNombre()

val ROJO="0xfff44336"
class Cajero {

    //Metodo para mostrar el saldo del usuario
    fun mostrarSaldo(){
    println("El saldo actual de $nombre,es $saldo\n")

        if (saldo<=50.0){ // Comprobamos si el saldo actual del usuario es inferior a 50
            println(ROJO+"ALERTA! SALDO BAJO")
        }
        if(saldo<=0.0){
            println(ROJO+"ALERTA! NO HAY SALDO DISPONIBLE")
        }
    }

    fun ingresarDinero(cantidad: Double){
        if(cantidad<0.0){
            println(ROJO+"No puedes ingresar una cantidad  negativa ")
        }else if(cantidad==0.0){
            print(ROJO+"No puedes ingresar cero como cantidad.")
        }else{
            usuario.modificaSaldo(cantidad)
            print("Has ingresado una cantidad de $cantidad €")
        }
    }

    fun retirarDinero(cantidad: Double){
        if(cantidad==0.0){
            print(ROJO+"No puedes Retirar , No hay saldo Disponible")
        }else{
            usuario.modificaSaldo(-cantidad)
            print("Has retirado una cantidad de $cantidad €")
        }

    }
}
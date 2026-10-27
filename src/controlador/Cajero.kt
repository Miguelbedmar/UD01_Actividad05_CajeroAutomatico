package controlador

import modelo.Usuario

val ROJO="\u001B[31m"
val RESET = "\u001B[0m"
class Cajero( private val usuario :Usuario) {

    private val saldo get()  = usuario.getSaldo() // Modificamos dinamicamente una constante
    private val nombre get()= usuario.getNombre()
    //Metodo para mostrar el saldo del usuario

    fun mostrarSaldo(){
    println("El saldo actual de $nombre,es $saldo\n")

        if (saldo<=50.0){ // Comprobamos si el saldo actual del usuario es inferior a 50
            println("${ROJO}  ALERTA! SALDO BAJO $RESET")
        }
        if(saldo<=0.0){
            println("${ROJO}ALERTA! NO HAY SALDO DISPONIBLE $RESET")
        }
    }

    fun ingresarDinero(cantidad: Double){
        if(cantidad<0.0){
            println("${ROJO}No puedes ingresar una cantidad  negativa $RESET")
        }else if(cantidad==0.0){
            print("${ROJO}No puedes ingresar cero como cantidad $RESET.")
        }else{
            usuario.modificaSaldo(cantidad)
            print("Has ingresado una cantidad de $cantidad €")
        }
    }

    fun retirarDinero(cantidad: Double){
        if(cantidad<=0.0){
            println("${ROJO} No puedes Retirar , no hay saldo Disponible $RESET")
        }else if (cantidad>saldo){
            println("${ROJO} ERROR! Fondos insuficientes! $RESET")
        }else{
            usuario.modificaSaldo(-cantidad)
            println("Has retirado una cantidad de $cantidad €")
        }


    }
}
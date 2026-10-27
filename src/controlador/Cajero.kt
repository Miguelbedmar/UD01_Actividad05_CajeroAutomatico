package controlador

import modelo.Usuario

val ROJO="\u001B[31m" // Creamos una variable con el nombre del color  para perzonalizar los mensajes de errores
val RESET = "\u001B[0m" // Reseteamos el color al terminar el mensaje de error
class Cajero( private val usuario :Usuario) {

    private val saldo get()  = usuario.getSaldo() // Modificamos dinamicamente una constante
    private val nombre get()= usuario.getNombre()
    //Metodo para mostrar el saldo del usuario

    fun mostrarSaldo(){
    println("El saldo actual de $nombre,es $saldo\n")

        if (saldo<=50.0){ // Hacemos saltar una alerta en el caso de que el saldo del usuario este por debajo  o igual que ciencuenta.
            println("${ROJO}  ALERTA! SALDO BAJO $RESET")
        }
        if(saldo<=0.0){ // Salta  la alerta si el usuario  se le ha acabado el saldo
            println("${ROJO}ALERTA! NO HAY SALDO DISPONIBLE $RESET")
        }
    }
    /** La función ingresarDinero se encarga  de comprobar  si la cantidad es menor  que cero
     * en ese caso saltara un mensaje de error lo mismo si la cantidad es 0
     * Si no se cumple ninguna condición entonces se llama al metodo modificar saldo  de la clase modelo Usuario
     * para sumarle la cantidad ingresada */
    fun ingresarDinero(cantidad: Double){
        if(cantidad<0.0){
            println("${ROJO}No puedes ingresar una cantidad  negativa $RESET")
        }else if(cantidad==0.0){
            print("${ROJO}No puedes ingresar cero como cantidad $RESET.")
        }else{
            usuario.modificaSaldo(cantidad)
            print("Has ingresado una cantidad de $cantidad €\n")
        }
    }
    /**
     * La función retirarDinero tiene la misma responsabilidad que ingresarDinero
     * Pero  con la diferencia de que comprueba que la cantidad no sea superior
     * al saldo actual  si se cumple está condición entonces se imprimira un mensaje
     * de error. Si no se cumple ninguna entonces se llama a modificar saldo pero
     * con la cantidad en negativa para realizar la operación correspondiente.**/

    fun retirarDinero(cantidad: Double){
        if(cantidad<=0.0){
            println("${ROJO} No puedes Retirar , no hay saldo Disponible $RESET")
        }else if (cantidad>saldo){
            println("${ROJO} ERROR! Fondos insuficientes! $RESET")
        }else{
            usuario.modificaSaldo(-cantidad)
            println("Has retirado una cantidad de $cantidad € \n")
        }


    }
}
package controlador

import modelo.Usuario

private val Usuario = Usuario("", 500.0)
private var saldo= Usuario.getSaldo()
private var nombre= Usuario.getNombre()
class Cajero {

    //Metodo para mostrar el saldo del usuario

    fun mostrarSaldo(){
    println("El saldo actual de $nombre,es $saldo\n")
    }

    fun saldoBajo(){
    }

}
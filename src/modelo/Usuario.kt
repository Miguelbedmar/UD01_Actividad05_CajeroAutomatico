package modelo

class Usuario {
    // Atributos
    private var nombre = ""
    private var saldo = 500.0

    //Constructor

    constructor(nombre: String, saldo: Double) {
        this.nombre = nombre
        this.saldo = saldo
    }

    //GETTERS Y SETTES
    fun getNombre(): String {
        return nombre
    }
    fun setNombre(nombre: String) {
        this.nombre = nombre
    }
    fun getSaldo(): Double {
        return saldo
    }
    fun setSaldo(saldo: Double) {
        this.saldo = saldo
    }

    //TOSTRING

    override fun toString(): String {
        return "Usuario(nombre='$nombre', saldo=$saldo)"
    }

}
fun main() {
    println("Digital Bank")
    println()

    val contaRogerio = Conta("Rogério", 1326)
    contaRogerio.deposita(3215.00)

    val contaLais = Conta(titular = "Laís", numeroConta = 3220)
    contaLais.deposita(633.00)

    val contaIsabel = Conta("Maria", 2244)
    contaIsabel.deposita(100.00)

    val contaThanatos = Conta("Thanatos", 8746)
    contaThanatos.deposita(3512.33)

    println("Thanatos saldo: ${contaThanatos.saldo}")


    println("Tituar: ${contaRogerio.titular}")
    println("Numero conta: ${contaRogerio.numeroConta}")
    println("Rogério saldo: ${contaRogerio.saldo}")
    println()

//    println("Tituar: ${contaLais.titular}")
//    println("Numero conta: ${contaLais.numeroConta}")
//    println("Saldo: ${contaLais.saldo}")
//    println()

    if(contaRogerio.transfere(destino = contaThanatos, valor = 100.0)){
        println("Transferência realizada com sucesso!")
        println("Saldo atualizado na conta ${contaThanatos.titular}, saldo atual: R$ ${contaThanatos.saldo} ")
    } else {
        println("Houve uma falha na transferência!")
    }
}


class Conta(val titular: String, val numeroConta: Int) {
    var saldo = 0.0
        private set

    fun saca(valor: Double) {
        if (saldo >= valor) this.saldo -= valor
    }

    fun deposita(valor: Double) {
        if(valor > 0){
            this.saldo += valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

}


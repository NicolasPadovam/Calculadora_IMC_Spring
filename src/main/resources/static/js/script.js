function validarAltura(){
    const auxAltura = document.getElementById("altura")
    const auxErro =  document.getElementById("erro")

    auxErro.textContent = ""

    // atribua o valor OU uma string vazia (tipo um If)
    const valor = (auxAltura.value || "").trim().replace(",", ".")
    const altura = Number(valor)

    if (!Number.isFinite(altura)){
        auxErro.textContent = "Você deve digitar um número válido (ex:1,75) "
        auxAltura.focus()
        return false
    }

    if (altura < 0.5 || altura > 2.5){
        auxErro.textContent = "A altura deve estar entre 0.65m e 2.15m"
        auxAltura.focus()
        return false
    }
    
    return true
}
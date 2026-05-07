import static java.lang.IO.*;

void main (){
    // Entrada do CPF
    String cpf = readln("Informe seu CPF: ");

    // Tratamento do dado (remoção de tudo o que nao for numero)
    cpf = cpf.replaceAll("\\D", "");

    // Tratamento do dado (garante que o cpf tenha 11 numeros e que nao sejam numero iguais)
    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
        System.out.println("CPF inválido!");
        return;
    }

    //Calculo de validação do primeiro digito

    int soma = 0;

    for(int i = 0; i < 9; i++){
        soma += (cpf.charAt(i) - '0') * (10 - i);
    }

    int dig1 = 11 - (soma % 11);
    if (dig1 >=10) dig1 = 0;


    //Calculo de validação do segundo digito

    soma = 0;

    for (int i = 0; i < 10; i++) {
        soma += (cpf.charAt(i) - '0') * (11 - i);
    }

    int dig2 = 11 - (soma % 11);
    if (dig2 >= 10) dig2 = 0;

    //Comparativo dos 2 Ultimos digitos
    if (dig1 == (cpf.charAt(9) - '0') && dig2 == (cpf.charAt(10) - '0')) {
        print("CPF válido!");
    } else {
        print("CPF inválido!");
    }
}

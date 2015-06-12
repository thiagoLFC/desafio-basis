package br.com.basis.desafio.main;

public class Main {

	private static final String PARENTESIS_DIREITO = "(";
	private static final String PARENTESIS_ESQUERDO = ")";

	public static void main(String[] args) {
		//Colocar uma String para testar o balanceamento
		String teste = "";
		System.out.println(validarBalanceamento(teste , 0, 0));
	}

	/**
	 * Metodo para verificar o balanceamento de parentesis
	 * @param texto String contendo um texto qualquer para ser verificado
	 * @param qtdParenteses Quantidade de parenteses encontrados
	 * @param posicaoControlStr Posicao de controle para iterar entr o texto
	 * @return true caso haja o balanceamento correto dos parenteses, false caso nao haja o balanceamento correto dos parenteses
	 */
	private static boolean validarBalanceamento(String texto, int qtdParenteses , int posicaoControlStr) {
		if(!(texto.toCharArray().length == posicaoControlStr)) {
			if(new Character(texto.toCharArray()[posicaoControlStr]).toString().equals(PARENTESIS_DIREITO)) {
				return validarBalanceamento(texto.substring(posicaoControlStr+1 , texto.toCharArray().length), ++qtdParenteses, posicaoControlStr++);
			} else if(new Character(texto.toCharArray()[posicaoControlStr]).toString().equals(PARENTESIS_ESQUERDO)) {
				return validarBalanceamento(texto.substring(posicaoControlStr+1 , texto.toCharArray().length), --qtdParenteses, posicaoControlStr++);
			} else {
				return validarBalanceamento(texto.substring(posicaoControlStr+1 , texto.toCharArray().length), qtdParenteses, posicaoControlStr++);
			}
		}
		return qtdParenteses == 0;
	}
}

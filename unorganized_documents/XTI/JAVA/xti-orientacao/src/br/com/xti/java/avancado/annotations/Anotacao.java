package br.com.xti.java.avancado.annotations;

import java.io.Serializable;

@Cabecalho(
		instituicao="XTI",
		projeto = "Sistema de avaliações",
		dataCriacao = "03/10/2017",
		criador= "Lucas Barretto",
		revisao = 2
		)
@ErrosCorrigidos(erros = {"0001", "0002"})
@SuppressWarnings("serial")
public class Anotacao implements Serializable{
		
		@SuppressWarnings("unused")
		private int x;
		
		@Deprecated
		public void anotar() {
		}
		@Override
		public String toString() {
			return null;
		}
}

import java.io.IOException;
import java.io.RandomAccessFile;

import questão1.Registro;

public class Principalquestão2 {

	public static void main(String[] args) {
		try {
			RandomAccessFile arq1 = new RandomAccessFile("arq1.dat", "r");
			RandomAccessFile arq2 = new RandomAccessFile("arq2.dat","rw");
			Registro registro = new Registro();
			long inicio = 0;
			long seguinte;
			long fim = arq1.length();
			String aux, cortado;
			while(inicio<fim) {
				seguinte = (inicio + 100);
				arq1.seek(inicio);
				registro.leRegistro(arq1);
				aux = registro.getEmail();
				cortado = aux.trim();
				if(terminaCom(cortado,"gmail.com")==true) {
					registro.escreveRegistro(arq2);
				}
				inicio = seguinte;
				
				
			}
			arq2.close();
		}
		catch(IOException e) {
			System.out.println("Erro: "+ e.getMessage());
		}

	}

}

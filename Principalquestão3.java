import java.io.IOException;
import java.io.RandomAccessFile;

import questão1.Registro;

public class Principalquestão3 {

	public static void main(String[] args) {
		try {
		RandomAccessFile arq1 = new RandomAccessFile("arq1.dat", "r");
		RandomAccessFile arq2 = new RandomAccessFile("arq2.dat","r");
		RandomAccessFile arq3 = new RandomAccessFile("arq3.dat", "rw");
		Registro registro = new Registro();
		String aux;
		String aux2;
		long inicioarq1 = 0;
		long seguinte;
		long fimarq1 = arq1.length()/100;
		long inicioarq2 = 0;
		long meio;
		long fimarq2 = arq2.length()/100;
		while(inicioarq1<=fimarq1) {
			seguinte = inicioarq1+1;
			arq1.seek(inicioarq1*100);
			registro.leRegistro(arq1);
			aux = registro.getChave();
			while(inicioarq2<=fimarq2) {
				meio = (inicioarq2+fimarq2)/2;
				arq2.seek(meio*100);
				registro.leRegistro(arq2);
				aux2 = registro.getChave();
				if(aux>aux2) {//autorizado na hora da prova pelo professor.
					inicioarq2 = (meio)+1;
					
				}else
					if(aux<aux2) {
						inicioarq2 = (meio)-1;
						
					}else
						if(aux == aux2) {
							registro.escreveRegistro(arq3);
							break;
						}
			}
			inicioarq1 = seguinte;
		}
		arq3.close();
		}
		catch(IOException e) {
			System.out.println("ERRO: "+ e.getMessage());
		}
	}

}

//
import java.io.IOException;
import java.io.RandomAccessFile;

public class Principalquestão1 {

	public static void main(String[] args) {
		try {
			RandomAccessFile arq1 = new RandomAccessFile("arq1.dat", "r");
			RandomAccessFile arq2 = new RandomAccessFile("arq2.dat","rw");
			Registro registro = new Registro();
			long fim = (arq1.length()-100);
			long anterior;
			long inicio = 0;
			while(fim>inicio) {
				anterior = (fim-100);
				arq1.seek(fim);
				registro.leRegistro(arq1);
				registro.escreveRegistro(arq2);
				fim = anterior;
				
			}
			arq2.close();
		}
		catch(IOException e) {
			System.out.println("ERRO: "+ e.getMessage());
		}
		
	}

}

package br.cefet.rj;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Endereco e = new Endereco();
		long meio, menor = 0;
		long maior = f.length()-1;
		
		while(f.getFilePointer() <= f.length()) {
			meio = menor + ((maior - menor) / 2);
			f.seek(meio);
			e.leEndereco(f);
			long cep = Integer.parseInt(e.getCep());
			if(Integer.parseInt(args[0]) < cep) {
				maior = meio - 1;
			} else if (Integer.parseInt(args[0]) > cep){
				menor = meio + 1;
			} else {
				System.out.println(e.getCep());
				System.out.println(e.getBairro());
			}
		}
		f.close();
	}

}

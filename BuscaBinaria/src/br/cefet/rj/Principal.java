package br.cefet.rj;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
       
        RandomAccessFile f = new RandomAccessFile("cep_ordenado.dat", "r");
        Endereco e = new Endereco();
        long inicio = 0;
        long fim = (f.length()/300)-1;
        long meio;
	int cepProcurado = Integer.parseInt(args[0]);
       
        while(inicio <= fim) {
            meio = (inicio+fim)/2;
            f.seek(meio*300);
            e.leEndereco(f);
            long cep = Integer.parseInt(e.getCep());
            if(cepProcurado < cep) {
                fim = meio-1;
            } else if (cepProcurado > cep){
                inicio = meio + 1;
            } else {
                System.out.println(e.getCep());
                System.out.println(e.getBairro());
                break;
            }
        }
        f.close();
    }

}


package analisador;

import java.util.ArrayList;

public class Analisador {
    ArrayList<String> tabela = new ArrayList();
    ArrayList<Character> pilha = new ArrayList();
    String token, topo, entrada;
    public Analisador(){
        tabela.add("i;E;TE");
        tabela.add("i;T;FY");
        tabela.add("i;F;i");
        tabela.add("v;X;vTX");
        tabela.add("v;Y;%");
        tabela.add("&;Y;&FY");
        tabela.add("~;E;TX");
        tabela.add("~;T;FY");
        tabela.add("~;F;~F");
        tabela.add("%;X;%");
        tabela.add("%;Y;%");
        token = null;
        topo = "E";
        pilha.add('$');
        pilha.add(topo.charAt(0));
        entrada = null;
    }
    public String verificacao(String entrada){
        String retorno = null;
        int cont = 0;
        boolean achou = false;
        this.entrada = entrada;
        token = ""+this.entrada.charAt(cont);
        do{
            if(!token.equals(topo)){
                achou=false;
                for(int i=0; i<tabela.size(); i++){
                    for(int j=0; j<tabela.get(j).length(); j++){
                        if(token.charAt(0)==tabela.get(i).charAt(j)&&topo.charAt(0)==tabela.get(i).charAt(j+2)){
                            achou = true;
                            pilha.remove(pilha.size()-1);
                            for(int k=j+4; k<tabela.get(j).length(); k++){
                                pilha.add(tabela.get(i).charAt(k));
                            }
                            topo = pilha.get(pilha.size()-1)+"";
                        }
                    }
                }
                if(achou==false){
                    retorno = "Terminal não esperado";
                    return retorno;
                }
            }
            else{
                cont++;
                pilha.remove(pilha.size()-1);
                token = ""+this.entrada.charAt(cont);
            }
        }while(topo!="$");
        return retorno;
    }
}

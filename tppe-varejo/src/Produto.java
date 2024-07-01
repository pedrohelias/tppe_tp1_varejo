public class Produto {

//     String codigoProduto;
//     String descricaoProduto;
//     double valorVenda;
//     String unidadeMedida;
    
//     public Produto(String codigo, String descricao, double valorVenda, String unidadeMedida){
//         this.codigoProduto = codigo;
//         this.descricaoProduto = descricao;
//         this.valorVenda = valorVenda;
//         this.unidadeMedida = unidadeMedida;
        
//     }



//     public static String getNome (String nome){
//         return nome;
//     }

    public static Boolean verificaCodigo(String codigoProduto){ //produto deve ter 8 caracteres
        int tamanho = codigoProduto.length();
        if(tamanho != 8){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean verificaDescricao(String descricaoProduto){ //produto deve ter até 20 caracteres
        int tamanho = descricaoProduto.length();
        if(tamanho <= 20){
            return true;
        }else{
            return false;
        }
    }

    public static Boolean verificaValorVenda(double valorVenda){ //valor de venda não pode ser 0 ou menor
        if(valorVenda <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean verificaUnMedida(String unidadeMedida){ //naõ pode passar de 3 caracteres
        int tamanho = unidadeMedida.length();
        if(tamanho > 0 && tamanho <= 3){
            return true;
        }else{
            return false;
        }
        
    }

}


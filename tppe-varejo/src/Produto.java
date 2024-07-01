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

    public static Boolean verificaDescricao(String descricaoProduto){
        return null;
    }

}


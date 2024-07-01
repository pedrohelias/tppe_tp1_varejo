public class Imposto {
    
    public static double ICMS(String regiao, double valorCompra){
        if(regiao == "DF"){
            return valorCompra * 0.18;
        }else{
            return valorCompra * 0.12; 
        }
    }


}

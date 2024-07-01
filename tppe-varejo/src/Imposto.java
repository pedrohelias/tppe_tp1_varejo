public class Imposto {
    
    public static double ICMS(String regiao, double valorCompra){
        if(regiao == "DF"){
            return valorCompra * 0.18;
        }else{
            return valorCompra * 0.12; 
        }
    }

    public static double ImpMunicipal(String regiao, double valorCompra){
        if(regiao == "DF"){
            return valorCompra;
        }else{
            return valorCompra * 0.04;
        }
    }


}

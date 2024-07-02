public class Imposto {

    public String regiao;
    public double valorCompra;
    
    public Imposto(String regiao, double valorCompra) {
        //TODO Auto-generated constructor stub
        this.regiao = regiao;
        this.valorCompra = valorCompra;
    }

    public double ICMS(String regiao, double valorCompra){
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

public class Imposto {

    public String regiao;
    public double valorCompra;
    public double impostoMun;
    public double impostoIcms;
    
    public Imposto(String regiao, double valorCompra) {
        //TODO Auto-generated constructor stub
        this.regiao = regiao;
        this.valorCompra = valorCompra;
    }

    public double ICMS(String regiao, double valorCompra){
        double calculo;
        if(regiao == "Distrito_Federal"){
            calculo = valorCompra * 0.18;
            setImpostoIcms(calculo);
            return impostoIcms;
        }else{
            calculo = valorCompra * 0.12;
            setImpostoIcms(calculo);
            return impostoIcms; 
        }
    }

    public double ImpMunicipal(String regiao, double valorCompra){
        double calculo;

        if(regiao == "Distrito_Federal"){
            setImpostoMun(valorCompra);
            return impostoMun;
        }else{
            calculo = valorCompra * 0.04;
            setImpostoMun(calculo);
            return impostoMun; 
        }
    }

    public double valorTotalImpostos(){
        double total = getImpostoIcms() + getImpostoMun();
        return total;
    }

    double getImpostoMun(){
        return impostoMun;
    }

    void setImpostoMun(double impostoMun){
        this.impostoMun = impostoMun;
    }

    double getImpostoIcms(){
        return impostoIcms;
    }

    void setImpostoIcms(double impostoIcms){
        this.impostoIcms = impostoIcms;
    }

}

public class Imposto {

    //classe imposto municipal 

    class impostoMun {
        public double valor;
        public double fatorCalcDF; //fator de calculo se tiver no DF
        public double fatorCalcNac; //fator de calculo se tiver fora do DF

        public impostoMun(double fatorCalcDF, double fatorCalcNac) {
            this.fatorCalcDF = fatorCalcDF;
            this.fatorCalcNac = fatorCalcNac;
        }

        void setValor(double valor){
            this.valor = valor;
        }
    
        double getValor(){
            return valor;
        }


    }

    //classe imposto ICMS

    class impostoIcms {
        public double valor;
        public double fatorCalcDF; //fator de calculo se tiver no DF
        public double fatorCalcNac; //fator de calculo se tiver fora do DF

        public impostoIcms(double fatorCalcDF, double fatorCalcNac) {
            this.fatorCalcDF = fatorCalcDF;
            this.fatorCalcNac = fatorCalcNac;
        }


        void setValor(double valor){
            this.valor = valor;
        }
    
        double getValor(){
            return valor;
        }
    }


    //aqui começa as variaveis da classe imposto 


    public String regiao;
    public double valorCompra;
    public impostoMun impostoMun;
    public impostoIcms impostoIcms;


    //construtor da classe
    
    public Imposto(String regiao, double valorCompra, double fatorCalcDFMun, double fatorCalcNacMun, double fatorCalcDFIcms, double fatorCalcNacIcms ) {
        this.regiao = regiao;
        this.valorCompra = valorCompra;
        this.impostoMun = new impostoMun(fatorCalcDFMun, fatorCalcNacMun);
        this.impostoIcms = new impostoIcms(fatorCalcDFIcms, fatorCalcNacIcms);
    }
    
    //vai definir icms
    public double ICMS(String regiao, double valorCompra){
        double calculo;
        if(regiao == "Distrito_Federal"){
            calculo = valorCompra * impostoIcms.fatorCalcDF;
            impostoIcms.setValor(calculo);
            return impostoIcms.getValor();
        }else{
            calculo = valorCompra * impostoIcms.fatorCalcNac;
            impostoIcms.setValor(calculo);
            return impostoIcms.getValor();
        }
    }

    //vai definir impMunicipal

    public double ImpMunicipal(String regiao, double valorCompra){
        double calculo;

        if(regiao == "Distrito_Federal"){
            calculo = valorCompra + impostoMun.fatorCalcDF; //correção de calculo
            impostoMun.setValor(calculo);
            return impostoMun.getValor();
        }else{
            calculo = valorCompra * impostoMun.fatorCalcNac;
            impostoMun.setValor(calculo);
            return impostoMun.getValor(); 
        }
    }

    //vai totalizar os impostos

    public double valorTotalImpostos(String regiao, double valorCompra){
        double valorICMS = ICMS(regiao, valorCompra);
        double impMun = ImpMunicipal(regiao, valorCompra);
        double total = valorICMS + impMun;
        return total;
    }

    String getRegiao(){
        return regiao;
    }

    void setRegiao(String regiao){
        this.regiao = regiao;
    }

    double getValorCompra(){
        return valorCompra;
    }

    void setValorCompra(double valorCompra){
        this.valorCompra = valorCompra;
    }



}

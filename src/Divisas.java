
public enum Divisas {
		C$_a_USD("C$","D","De Cordobas a Dolares",0.027,"$"),
        C$_a_EUR("C$","D","De Cordobas a Euros", 0.026,"€"),        
        C$_a_GBP("C$","D","De Cordobas a Libra Esterlina", 0.023,"£"),
        C$_a_JPY("C$","D","De Cordobas a Yen Japones", 3.74,"¥"),
        C$_a_KRW("C$","D","De Cordobas a Won Sur Coreano", 36.39,"₩"),
        USD_a_C$("$","M","De Dolares a Cordobas",36.32,"C$"),
        EUR_a_C$("€","M","De Euros a Cordobas",38.55,"C$"),
        GBP_a_C$("£","M","De Libra Esterlina a Cordobas",43.42,"C$"),
        JPY_a_C$("¥","M","De Yen Japones a Cordobas",0.27,"C$"),
        KRW_a_C$("₩","M","De Won Sur Coreano a Cordobas",0.028,"C$");
	

        final String texto;
        final double factor;
        final String signoOrigen;
        final String signoDestino;
        final String operacion;

        Divisas(String signo, String operador, String texto, double factor, String destino) {
            this.signoOrigen = signo;
            this.operacion = operador;
            this.texto = texto;
            this.factor = factor;
            this.signoDestino = destino;
        }
        
        public String getSignoOrigen() {
        	return signoOrigen;
        }
        public String getSignoDestino() {
        	return signoDestino;
        }
        
        public String getOperacion() {
        	return operacion;
        }

        public String getTexto() {
            return texto;
        }        
        
        public double getFactorConversion() { 
        	return factor; 
        }
    }
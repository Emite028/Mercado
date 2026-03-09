package Mercado;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utilitarios {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static NumberFormat nf = new DecimalFormat("R$ #,##0.00" , new DecimalFormatSymbols( new Locale("pt", "BR")));

    public static String dataParaDouble( Date data ){
        return Utilitarios.sdf.format(data);
    }

    public static String doubleParaString( Double valor ){
        return Utilitarios.nf.format(valor);
    }

    public static Double stringParaDouble( String valor){
        try {
            return (Double)Utilitarios.nf.parse(valor);
        }catch (ParseException e){
            return null;
        }
    }

    public static void pausar(int segundos) {
        try{
            TimeUnit.SECONDS.sleep(segundos);
        }catch (InterruptedException e) {
            System.out.println("Erro ao Pausar por " + segundos + " segundos");
        }
    }
}

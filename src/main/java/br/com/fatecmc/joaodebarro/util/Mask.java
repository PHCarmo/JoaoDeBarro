package br.com.fatecmc.joaodebarro.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Mask {
    private static final NumberFormat MOEDA_BR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private static final SimpleDateFormat MONTH_YEAR = new SimpleDateFormat("MM/YYYY");
    private static final SimpleDateFormat DATE_HOUR = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    
    public static String toCPF(String cpf){
        while(cpf.length() < 11) { cpf += "*"; }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
    public static String toMoney(double value){
        return MOEDA_BR.format(value);
    }
    
    public static double fromMoney(String value) throws ParseException{
        return Double.parseDouble(MOEDA_BR.parse(value).toString());
    }
    
    public static String toMonthYear(Date data){
        return MONTH_YEAR.format(data);
    }
    
    public static String toDateHour(Date data){
        return DATE_HOUR.format(data);
    }
    
}

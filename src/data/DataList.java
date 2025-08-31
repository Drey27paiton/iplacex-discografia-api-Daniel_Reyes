package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataList {
    private final List<String> marcas = new ArrayList<>();

    public DataList(){
        this.marcas.add("Hyper X");
        this.marcas.add("MSI");
        this.marcas.add("Asus");
        this.marcas.add("Samsung");
        this.marcas.add("Cougar");
        this.marcas.add("Aero Cool");
        this.marcas.add("Xiaomi");
        this.marcas.add("TCL");
    }

    public String RetonarMarcaRandom(){
        Random rnd  = new Random();
        int el = rnd.nextInt(this.marcas.size());
        return this.marcas.get(el);
    }

    public boolean MostrarConId(){
        Random rnd = new Random();
        double value = rnd.nextDouble();
        
        return value > 0.5 ? true : false;
    }
}

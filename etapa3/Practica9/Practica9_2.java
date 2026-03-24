public class Practica9_2 {
    enum Mes {
        ENERO,
        FEBRERO,
        MARZO,
        ABRIL,
        MAYO,
        JUNIO,
        JULIO,
        AGOSTO,
        SEPTIEMBRE,
        OCTUBRE,
        NOVIEMBRE,
        DICIEMBRE
    }

    public static void main(String args[]) {
        System.out.println("--- Meses del año ---");
        for (Mes m : Mes.values()){
            System.out.println(m);
        }
    }
}

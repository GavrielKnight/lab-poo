public class Practica9_1 {
    enum diaSemana{
        LUNES,
        MARTES,
        MIERCOLES,
        JUEVES,
        VIERNES,
        SABADO,
        DOMINGO
    }
    
    public static void main(String args[]) {
        System.out.println("--- Dias de la semana ---");
        for (diaSemana dia : diaSemana.values()){
            System.out.println(dia);
        }
    }
}

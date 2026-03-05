package practica4;

public class Practica4 {
     
    public static void main(String[] args) {
        TV tv = new TV("Samsung", "Grande", "Negro");
        
        tv.imprimeInfo();
        
        tv.cambiaCanal(2);
        tv.cambiaVolumen(20);
        
        tv.enciende();
        
        for (int i=0; i<=5; i++) {
            tv.cambiaCanal(i);
        }
        
        for (int i=-1; i<=32; i++) {
            tv.cambiaVolumen(i);
        }
        
        tv.apaga();
    }
}

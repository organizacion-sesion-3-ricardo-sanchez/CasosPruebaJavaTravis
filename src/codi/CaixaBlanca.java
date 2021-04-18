package codi;

public class CaixaBlanca {
    
    
    public static float calcularMedia(float x, float y) {
        float resultat = 0;
        
        if(x < 0 || y < 0) {
            throw new IllegalArgumentException("Els numeros han de ser positius");
        } else {
            resultat = (x + y) / 2;
        }
        
        return resultat;
    }

}

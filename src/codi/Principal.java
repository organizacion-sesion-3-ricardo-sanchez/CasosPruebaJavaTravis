package codi;

public class Principal {

    public static void main(String[] args) {
        
        
        try {
            System.out.println(CaixaBlanca.calcularMedia(25, 50)); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }

}

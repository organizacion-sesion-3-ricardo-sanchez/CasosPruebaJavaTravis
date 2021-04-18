package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import codi.CaixaBlanca;
import org.junit.Assert;
import org.junit.Assume;


@RunWith (value = Parameterized.class)
public class TestCalcularMedia {
    enum TipoClase {valida, eNegativo};
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {TipoClase.valida, 3.4F, 23.5F, 13.45F},
                {TipoClase.valida, 3.4F, 0.0F, 1.7F},
                {TipoClase.valida, 3.4F, Float.MAX_VALUE, 1.7014117E38F},
                {TipoClase.valida, 0.0F, 23.5F, 11.75F},
                {TipoClase.valida, Float.MAX_VALUE, 23.5F, 1.7014117E38F },
                
                {TipoClase.eNegativo, 3.4F, -37.33F, 0 },
                {TipoClase.eNegativo, -7.8F, 23.25F, 0 },
                {TipoClase.eNegativo, -7.8F, -37.33F, 0 } 
                
        });
    }
    
    private float x, y, expected;
    private TipoClase tipo;
    
    public TestCalcularMedia(TipoClase tipo, float x, float y, float expected) {
        this.tipo=tipo;
        this.x = x;
        this.y = y;
        this.expected = expected;
    }
    
    
    @Test
    public void validResults() {
        Assume.assumeTrue(tipo == TipoClase.valida);
        Assert.assertEquals(expected, CaixaBlanca.calcularMedia(x, y), 0.0);
        System.out.println(CaixaBlanca.calcularMedia(x, y));
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void invalidResultsNegative() {
        Assume.assumeTrue(tipo == TipoClase.eNegativo);
        Assert.assertEquals(expected, CaixaBlanca.calcularMedia(x, y), 0.0);        
    }    
    
   

}

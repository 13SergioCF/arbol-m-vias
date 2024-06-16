/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvias;

/**
 *
 * @author FINOR
 */
public interface IArbolMVias 
{
    
    public void insertarElemento(int dato);
    public int contar();
    public int menor ();
    public int mayor ();
    public boolean buscar (int d);
    public int altura ();
    public void modificar (int ant, int nuevo);
    public int sumarHojas ();
    public int contarPares();
    //public int contarImpares();
    //public int sumar();
    //public boolean existe(int datoBuscar);// si existe=true; si no existe=false;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvias;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import static mvias.ArbolMVias.Nodo.Nulo;

/** 
 *
 * @author FINOR
 */
public class ArbolMVias implements IArbolMVias
{   
    int vias;
    Nodo raiz;


   
    public class Nodo{
        int dato[];// el vector de datos que tendra cada nodo
        Nodo hijo[];// vector de hijos que tenda el nodo
        int nD;// cantidad de datos que tendra el vector que estara dentro del nodo
        public Nodo(){
            dato=new int [vias-1];
            hijo= new Nodo[vias];
            nD=0;
        }
    }
    
    public ArbolMVias(int _vias){
        if(_vias>2){
            vias=_vias;
        }else{
            System.out.println("las vias tienen que ser mayor a 4");
        }
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
   
    public JPanel getdibujo() 
    {
        return new Grafica(this);
    }
    public void insertarElemento(int dato){
        raiz=insertarElemento(raiz, dato);
    }
    private Nodo insertarElemento(Nodo a, int dato){
        boolean insertoDato=false;
        if(a==null){// el arbol no tiene datos
            Nodo nuevo=new Nodo();
            nuevo.dato[nuevo.nD]=dato;
            nuevo.nD++;
            a=nuevo;
        }else{
            if(a.nD <vias-1){
                a.dato[a.nD]=dato;
                a.nD++;
                ordenar(a);
            }else{
                int i=0;
                while(i<a.nD && insertoDato==false){
                    if(dato<a.dato[i]){
                        a.hijo[i]=insertarElemento(a.hijo[i], dato);
                        insertoDato=true;
                    }
                    i++;
                }
                if(insertoDato==false){
                    a.hijo[i]=insertarElemento(a.hijo[i], dato);
                }
            }
        
        }
        return a;
    }
    
    private void ordenar(Nodo param){
        for(int i=0; i<vias-2; i++){
            if(param.dato[i]>param.dato[i+1]){
                int auxiliar=param.dato[i+1];
                param.dato[i+1]=param.dato[i];
                param.dato[i]=auxiliar;
            }
        }
    }
    
    public int contar(){
        return contar(raiz);
    }
    
    private int contar(Nodo a){
      
        int cantidad=0;
        if(a!=null){
            for(int i=0; i<a.nD; i++){
                cantidad++;
            }
            for(int j=0; j<vias;j++){
                cantidad=contar(a.hijo[j])+cantidad;
            }
        }
        return cantidad;
    }
    /////////////////////////////////////////////////////////
    private  int mayor (Nodo a){
     int mayor=0;
      if (a==null){
          
      }else{
          if (a.hijo[vias-1]== null){
              mayor=a.dato[a.nD-1];
          }else{
              mayor=mayor(a.hijo[vias-1]);
          }
      }
      return mayor;
 }
  
    
  public int mayor (){
      return mayor (raiz);
        
 }
  /////////////////////////////////////////////////////////
    private  int menor (Nodo a){
        int menor=0;
        if (a== null){
            
        }else{
            if (a.hijo[0]== null){
                menor=a.dato[0];
                
            }else{
                menor=menor(a.hijo[0]);
                
            }
        }
        return menor;
      
 }

   
  public int menor (){
      return menor (raiz);
 }
  /////////////////////////////////////////////////////////
  private boolean esHoja (Nodo a){
    boolean h = true;
     if (a==null){
                 
     }else {
         int i=0;
         while (i<=a.nD && h==true){
             if (a.hijo[i]== null ){
                 h= true;
             }else{
                 h=false;
             }
             i++;
         }
     }
     return h;
 }
  
  
  /////////////////////////////////////////////////////////
  // CORREGIR 
   public int altura (){
       return altura (raiz);
   }
  private int  altura (Nodo a){
      int p;
     
      if (a==null){
       p=0;
        }else {
            if (esHoja(a)){
                p=1;
            }else{
                int i=0; 
                int  ah;
                int may=0;
                while (i<=a.nD){
                    ah = altura(a.hijo[i])
                            if (ah>may){
                                may=ah;
                            }
                            i++;
                            p=may+1;
                }
            }
             
         }
        return p;
       
   
   }
  
////////////////////////////////////
  
  private int buscarDato(Nodo a,int d){//buscar entre el rango |0 a 2| caso contrario -1
        int n=-1;
        int i=0;
        boolean pillo=false;
        while(i<a.nD && pillo==false) {  //fualta verificar/
            if(a.dato[i]==d) {
                n=i;
                pillo=true;
            }
            i++;
        }
        return n;
    }
  
  
  
  ////////////////// METODO BUSCAR EN PRIVADO ///  HACER 
   public boolean buscar(int d){
        return buscar(raiz,d);
    }
    
    private boolean buscar(Nodo a,int d){
        boolean esta=true;
        if (a==null) {
            esta=false;
        }
        else{
            if (esHoja(a)) {
                int pos=buscarDato(a,d);//buscar entre el rango |0 a 2| caso contrario -1
                if (pos>=0 && pos<a.nD) {//otra forma de preguntar seria |si(pos>=0 && pos<p.nDato)|
                    esta=true;
                }
                else{
                    esta=false;
                }
            }
            else{//si no es hoja 
                int pos=buscarDato(a,d);
                if (pos>=0 && pos<a.nD) { // si es valido 
                    esta=true;
                }
                else{
                    int i=0;
                    boolean ingreso=false;
                    while(i<a.nD && ingreso==false){
                        if (d<a.dato[i]) {
                            esta=buscar(a.hijo[i],d);
                            ingreso=true;
                        }
                        i++;
                    }
                    if (ingreso==false) {
                        esta=buscar(a.hijo[i],d);
                    }
                }
            }
        }
        return esta;
    }
  ////////////////////////////////////////////////////
    
    /// FALTA CORREGIR 
    public void modificar (int ant, int nuevo){
        Nodo t=new Nodo ();
        int pos;
        if (a==null){
            // nada 
        }else {
             t=buscar(raiz, ant);
             if (t!= null){
                 pos = buscarDato(t, ant);
                 if (pos>=0 && pos<a.nD){
                     t.dato=[pos]=nuevo;
                    
                     
                 }
             }
             
            
            
        }
    }
    /////////////////////////////////////////77
    
    public int sumarHojas (){
        
        return sumarHojas (raiz);
               
    }

    private int sumarHojas (Nodo a){
        int cantHojas=0 ;
        if (a!=null){
          if (esHoja(a)){
               cantHojas=1; 
            }else {
                    int i=0;
                     while(i<= a.nD){ 
                         if (a.hijo[i]!=null){
                                 cantHojas= sumarHojas(a.hijo[i])+cantHojas; 
                                
                                 
                             }
                            i++; 
                         } 
               }  
        }              
        return cantHojas;
    }
    //////////////////////////////////////////////////////
    public int contarPares(){
        return contarPares (raiz);
        
    }
    /// FALATA HACER
    private int contarPares (Nodo a){
        int pares=0;
        if (a!=null){
            if (esHoja(a)){
                
            }
        }
        return pares;
    }
// Llave final  
}


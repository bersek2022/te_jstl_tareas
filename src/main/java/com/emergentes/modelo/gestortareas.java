
package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;


public class gestortareas {
private ArrayList<tarea> lista;
    public gestortareas() {
        lista =new ArrayList<tarea>();
    }

    public ArrayList<tarea> getLista() {
        return lista;
    }

    public void setLista(ArrayList<tarea> lista) {
        this.lista = lista;
    }
    
    public void insertartarea(tarea item){
    lista.add(item); }
     public void modificartarea(int pos,tarea item){
    lista.set(pos,item); }
      public void eliminartarea(int pos){
    lista.remove(pos); }
      public int obtieneid(){
          int idaux=0;
          for(tarea item:lista)
          {idaux = item.getId();}
          return idaux + 1 ;
      }
      public int ubicartarea(int id){
      int pos = -1;
      Iterator<tarea> it = lista.iterator();
      while(it.hasNext())
      {++ pos;
      tarea aux = it.next();
      if(aux.getId() == id)
      {break;}}return pos;
      }
}

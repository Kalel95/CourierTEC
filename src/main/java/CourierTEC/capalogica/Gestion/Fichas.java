/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourierTEC.capalogica.Gestion;

/**
 *
 * @author Joel
 */
public class Fichas {
    String Nombre; String Correo;int TipoUsuario; int TipoPaquete;String Ficha;
    long tiempoE;
    //Constructores
    public Fichas(String Nombre,String Correo,int TipoUsuario,int TipoPaquete,String Ficha,long tiempoE){
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.TipoUsuario=TipoUsuario;
        this.TipoPaquete=TipoPaquete;
        this.Ficha=Ficha;
        this.tiempoE=tiempoE;
    }
    public Fichas(int TipoUsuario,String Ficha,long tiempoE) {
        this.Nombre= "";
        this.Correo= "";
        this.TipoUsuario=TipoUsuario;
        this.TipoPaquete= 0;
        this.Ficha=Ficha;
        this.tiempoE=tiempoE;
    }
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getNombre(){
        return this.Nombre;
    }
    
    public void setCorreo(String Correo){
        this.Correo=Correo;
    }
    public String getCorreo(){
        return this.Correo;
    }
    
    public void setTipoUsuario(int TipoUsuario){
        this.TipoUsuario=TipoUsuario;
    }
    public int getTipoUsuario(){
        return this.TipoUsuario;
    }
          
    public void setTipoPaquete(int TipoPaquete){
        this.TipoPaquete=TipoPaquete;
    }
    public int getTipoPaquete(){
        return this.TipoPaquete;
    }
    public void setFicha(String Ficha){
        this.Ficha=Ficha;
    }
    public String getFicha(){
        return this.Ficha;
    }
    public long getTiempo() {
        return this.tiempoE;
    }
    public void setTiempo(long tiempoE) {
        this.tiempoE=tiempoE;
    }
}

import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

//Hacemos la clase base de "Empleado"
class Empleado{
    protected int codigo;
    protected String nombre;
    protected Calendar FechaDeContratacion;
    protected double salarioBase;
    protected int horasTrabajadas;
    
    public Empleado(int codigo, String nombre, double salarioBase){
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = 0;
        this.FechaDeContratacion = Calendar.getInstance();
    }
    public void registroHorasTrabajadas(int horas){
        this.horasTrabajadas += horas;
    }
    
    public double calculoPago(){
        double salarioProporcional =(salarioBase/160)*horasTrabajadas;
        return salarioProporcional*0.965; //Esto para deducir el 3.5%
    }
    public String mostrarLaInformación(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Codigo: "+ codigo +"\nNombre: " + nombre +"\nFecha de contratación: "+ sdf.format(FechaDeContratacion.getTime());
    }
}
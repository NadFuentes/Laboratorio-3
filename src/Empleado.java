import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

//Hacemos la clase base de "Empleado"
class Empleado{
    protected int codigo;
    protected String nombre;
    protected Calendar FechaDeContratación;
    protected double salarioBase;
    protected int horasTrabajadas;
    
    public Empleado(int codigo, String nombre, double salarioBase){
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = 0;
        this.FechaDeContratación = Calendar.getInstance();
    }
    public void registroHorasTrabajadas(int horas){
        this.horasTrabajadas += horas;
    }
    
    public double calculoPago(){
        double salario
    }
}
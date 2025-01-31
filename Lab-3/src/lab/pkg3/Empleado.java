/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg3;

/**
 *
 * @author chung
 */
 
import javax.swing.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Arrays;

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
//La subclase para el empleado estándar
class EmpleadoEstandar extends Empleado{
    public EmpleadoEstandar(int codigo, String nombre, double salarioBase){
    super(codigo, nombre, salarioBase);
 }

    
}

//La subclase para el empleado temporal
class EmpleadoTemporal extends Empleado{
    private Calendar FechaFinalContrato;
    
    public EmpleadoTemporal(int codigo, String nombre, double salarioBase){
        super(codigo, nombre, salarioBase);
        this.FechaFinalContrato =FechaFinalContrato;
    }
    public double calcularPago(){
        Calendar hoy = Calendar.getInstance();
        if(hoy.before(FechaFinalContrato) || hoy.equals(FechaFinalContrato)){
           double salarioProporcional = (salarioBase/168)*horasTrabajadas;
           return salarioProporcional*0.965; //Para deducir el 3.5%
         }else{
            return 0; //Va retonar 0 si el contrato a expirado el tiempo estimado
        }
    }
    public void actualizarFechaFinalContrato(Calendar nuevaFecha){
        this.FechaFinalContrato = nuevaFecha;
    }
    
    String mostrarInformacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.mostrarLaInformación() + "\nFecha Final del contrato: "+ sdf.format(FechaFinalContrato.getTime());
        
    }
}
//Subclase para las ventas del empleado
class EmpleadoVentas extends Empleado{
    private double[] ventasMensuales;
    private double TasaDeComision;
    public EmpleadoVentas (int codigo, String nombre, double salarioBase, double TasaDeComision){
        super(codigo, nombre, salarioBase);
        this.TasaDeComision = TasaDeComision;
        this.ventasMensuales = new double[12]; //Esto para inicializar las ventas en 0
        Arrays.fill(this.ventasMensuales,0.0);
    }
    public void registrarVenta(double monto){
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        this.ventasMensuales[mesActual]+= monto;
    }
    public double calcularLaComision(){
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        return this.ventasMensuales[mesActual]*this.TasaDeComision;
    }
    public double calcularPago(){
        double salarioProporcional = (salarioBase/160)*horasTrabajadas;
        return (salarioProporcional *0.0965)+calcularLaComision(); //Este es el salario base mas la comision
    }
    public double calcularLasVentasAnuales(){
        double totalVentas = 0;
        for (double venta : ventasMensuales){
            totalVentas +=venta;
        }
        return totalVentas;
    }
    public String mostrarInformación(){
        return super.mostrarLaInformación()+"\nVentas Anuales: "+ calcularLasVentasAnuales();
        }
}

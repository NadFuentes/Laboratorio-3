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
    public String mostrarInformación(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.mostrarLaInformación() + "\nFecha Final del contrato: "+ sdf.format(FechaFinalContrato.getTime());
    }
}



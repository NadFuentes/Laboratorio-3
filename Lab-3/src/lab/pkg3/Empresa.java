/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class Empresa {
    
    
    protected String codigo;
    protected String nombre;
    protected double horasTrabajadas;
    protected double tarifaHora;

    public Empresa(String codigo, String nombre, double horasTrabajadas, double tarifaHora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    public double calcularPago() {
        return horasTrabajadas * tarifaHora;
    }


    public String getCodigo() {
        return codigo;
    }

    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Horas Trabajadas: " + horasTrabajadas + ", Tarifa Hora: " + tarifaHora;
    }
}

class EmpleadoEstandar extends Empresa {
    private double deduccionFija;

    public EmpleadoEstandar(String codigo, String nombre, double horasTrabajadas, double tarifaHora, double deduccionFija) {
        super(codigo, nombre, horasTrabajadas, tarifaHora);
        this.deduccionFija = deduccionFija;
    }

     public double calcularPago() {
        return (horasTrabajadas * tarifaHora) - deduccionFija;
    }
}

class EmpleadoTemporal extends Empresa {
    private String fechaFinContrato;

    public EmpleadoTemporal(String codigo, String nombre, double horasTrabajadas, double tarifaHora, String fechaFinContrato) {
        super(codigo, nombre, horasTrabajadas, tarifaHora);
        this.fechaFinContrato = fechaFinContrato;
    }

    public void setFechaFinContrato(String nuevaFechaFin) {
        this.fechaFinContrato = nuevaFechaFin;
    }

    public double calcularPago() {
        return horasTrabajadas * tarifaHora;
    }
}

class EmpleadoVentas extends Empresa {
    private double comisiones;

    public EmpleadoVentas(String codigo, String nombre, double horasTrabajadas, double tarifaHora, double comisiones) {
        super(codigo, nombre, horasTrabajadas, tarifaHora);
        this.comisiones = comisiones;
    }

    public double calcularPago() {
        return (horasTrabajadas * tarifaHora) + comisiones;
    }
}

class GestorEmpleados {
    private List<Empresa> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empresa empleado) {
        empleados.add(empleado);
    }

 public Empresa buscarEmpleadoPorCodigo(String codigo) {
        for (Empresa empleado : empleados) {
            if (empleado.getCodigo().equals(codigo)) {
                return empleado;
            }
        }
        return null;
    }

    public void actualizarFechaFinContrato(String codigo, String nuevaFechaFin) {
        Empresa empleado = buscarEmpleadoPorCodigo(codigo);
        if (empleado instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) empleado).setFechaFinContrato(nuevaFechaFin);
            System.out.println("Fecha de fin de contrato actualizada.");
        } else {
            System.out.println("El empleado no es temporal o no se encontro.");
        }
    }

    public void generarReportes() {
        int totalEstandar = 0, totalTemporal = 0, totalVentas = 0;

        for (Empresa empleado : empleados) {
            if (empleado instanceof EmpleadoEstandar) {
                totalEstandar++;
            } else if (empleado instanceof EmpleadoTemporal) {
                totalTemporal++;
            } else if (empleado instanceof EmpleadoVentas) {
                totalVentas++;
            }
            System.out.println(empleado);
        }

        System.out.println("Total Empleados Estandar: " + totalEstandar);
        System.out.println("Total Empleados Temporales: " + totalTemporal);
        System.out.println("Total Empleados de Ventas: " + totalVentas);
    }

    public double calcularPagoMensual(String codigo) {
        Empresa empleado = buscarEmpleadoPorCodigo(codigo);
        if (empleado != null) {
            return empleado.calcularPago();
        }
        System.out.println("Empleado no encontrado.");
        return 0;
    } 
    
    EmpleadoEstandar[] empleadosEstandar = new EmpleadoEstandar[100];
    EmpleadoTemporal[] empleadosTemporal = new EmpleadoTemporal[100];
    EmpleadoVentas[] empleadosVentas = new EmpleadoVentas[100];
    public void registrarEmpleados(){
         String nombre;
         int salario,cantidadEmpleados=0;
         String codigo;
         
         String tipoEmpleado= JOptionPane.showInputDialog("Que tipo de empleado desea registrar?\nA.Empleado Estandar\nB.Empleado Temporal\nC.Empleado de Ventas").toLowerCase();
        
        switch(tipoEmpleado){
            case "a":
                nombre = JOptionPane.showInputDialog("Nombre: ");
                salario = Integer.parseInt(JOptionPane.showInputDialog("Salario: "));
                codigo = JOptionPane.showInputDialog("Codigo: ");
                
                boolean codigoValido=true;
                
                for (int index =0; index<empleadosEstandar.length;index ++){
                if (empleadosEstandar[index].codigo == codigo){
                JOptionPane.showMessageDialog(null, "Codigo ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                codigoValido = false;
                break;
                }
                }
                
                for(int index = 0;index<empleadosEstandar.length;index++){
                    while(empleadosEstandar[index] !=null){
                    cantidadEmpleados++;
                    }
                }
                
                if (codigoValido){
//                EmpleadoEstandar empleado = new EmpleadoEstandar(codigo,nombre,salario);
//                empleadosEstandar[cantidadEmpleados+1] = empleado;
                break;
                
                }
            
            case "b":
                nombre = JOptionPane.showInputDialog("Nombre: ");
                salario = Integer.parseInt(JOptionPane.showInputDialog("Salario: "));
                codigo = JOptionPane.showInputDialog("Codigo: ");
                
                
                codigoValido=true;
                
                for (int index =0; index<empleadosTemporal.length;index ++){
                if (empleadosTemporal[index].codigo == codigo){
                JOptionPane.showMessageDialog(null, "Codigo ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                codigoValido = false;
                break;
                }
                }
                
                for(int index = 0;index<empleadosTemporal.length;index++){
                    while(empleadosTemporal[index] !=null){
                    cantidadEmpleados++;
                    }
                }
                
                if (codigoValido){
//                EmpleadoTemporal empleado= new EmpleadoTemporal(codigo,nombre,salario);
//                empleadosTemporal[cantidadEmpleados+1] = empleado;
                break;
                
                }
                
            case "c":
                nombre = JOptionPane.showInputDialog("Nombre: ");
                salario = Integer.parseInt(JOptionPane.showInputDialog("Salario: "));
                codigo =JOptionPane.showInputDialog("Codigo");
                double tasaComision = Double.parseDouble(JOptionPane.showInputDialog("Tasa de comisión :"));
                
                codigoValido=true;
                
                for (int index =0; index<empleadosVentas.length;index ++){
                if (empleadosVentas[index].codigo == codigo){
                JOptionPane.showMessageDialog(null, "Codigo ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                codigoValido = false;
                break;
                }
                }
                
                for(int index = 0;index<empleadosVentas.length;index++){
                    while(empleadosVentas[index] !=null){
                    cantidadEmpleados++;
                    }
                }
                
                if (codigoValido){
//                EmpleadoVentas empleado= new EmpleadoVentas(codigo,nombre,salario,tasaComision);
//                empleadosVentas[cantidadEmpleados+1] = empleado;
                break;
                
                }
                
                
                
                
        }
    }
  
}    


package militar.rangos;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import militar.Operaciones.OperacionesMilitares;


//la clase Capitan con las implementaciones de operacionesMilitares y extencion de Rango
public class Capitan extends Rango implements OperacionesMilitares, Persona {
    private int cantSoldados;
    private String id;
    private String nombre;
    private String rango;
    private String mision;
    private String message;


    public Capitan(int cantSoldados) {
        
        //se asigna el rango con un numero para darle valor numerico superior a quienes manda
        super(3);
        this.cantSoldados = cantSoldados;
    }


    // diversas tareas para que la gestion de las misiones funcione correctamente
    @Override
    public void realizarAccion(String message) {
        try {
            // Genera un numero random del 1 al 3
            int randomNum = random.nextInt(3) + 1;
            // Si el numero es 1, realiza un sondeo
            if (randomNum == 1) {
                this.message = ("El Capitán realiza un sondeo a sus: " + cantSoldados + " soldados");
                return;
            }
            // Si el numero es 2, realiza una inspeccion
            if (randomNum == 2) {
                this.message = ("El Capitán realiza una inspección a sus: " + cantSoldados + " soldados");
                return;
            }
            // Si el numero es 3, realiza una mision
            if (randomNum == 3) {
                this.message = ("El Capitán realiza una misión con sus: " + cantSoldados + " soldados");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Capitán no ha podido realizar ninguna acción.");
            System.out.println(e);;
        }
    }


    @Override
    public void reportarEstado(){
        try {
            if(random.nextBoolean()) {
                message = ("El Capitán lidera la misión con sus " + cantSoldados + " soldados... " + "¡La misión fue exitosa!");
            } else {
                int soldadosPerdidos = random.nextInt(cantSoldados + 1);
                message = ("El Capitán lidera la misión con sus " + cantSoldados + " soldados.." + "La misión fracasó. Soldados perdidos: " + soldadosPerdidos + "/" + cantSoldados);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Capitán no ha podido reportar su estado.");
            System.out.println(e);
        }
        
    }

    public void planificarMision() {
        // Panel para ingresar detalles de la mision
        JTextField objetivo = new JTextField();
        JTextField estrategia = new JTextField();
        Object[] message = {
            "Ingrese el objetivo del rescate:", objetivo,
            "Ingrese la estrategia:", estrategia
        };

        //Se muestra el mensaje  de la mision
        int option = JOptionPane.showConfirmDialog(null, message, "Planificacion de Rescate", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            //se evalua si se ingresaron los datos
            String objetivoTexto = objetivo.getText();
            String estrategiaTexto = estrategia.getText();
            if (objetivoTexto.isEmpty() || estrategiaTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Resultado de la mision
            String mensaje;
            int resultado = random.nextInt(2); // 0: exito, 1: fracaso
            if (resultado == 0) {
                mensaje = "La mision de rescate fue un exito. El objetivo \n" + objetivoTexto + "\n ha sido asegurado!";
            }
            else {
                mensaje =  "La mision de rescate fallo. La estrategia \n" + estrategiaTexto + "\n no funcionó.";
            }
                
            JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.OK_OPTION);
        }
    }

    public int getCantSoldados() {
        return cantSoldados;
    }

    public void setCantSoldados(int cantSoldados) {
        this.cantSoldados = cantSoldados;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id.trim();
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String getRango() {
        return rango;
    }

    @Override
    public void setCualidad(String cualidad) {
        String a = Integer.toString(cantSoldados);
        a = cualidad;
    }

    @Override
    public String getCualidad() {
        return Integer.toString(cantSoldados) + " soldados a su mando";
    }


    public void regañar(int id){
        try {
            message = ("El Capitán ha regañado a el soldado " + id);
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El Capitán no ha podido regañar a el soldado " + id);
            System.out.println(e);
        }
    }


    // Metodo de regaño
    @Override
    public void regañado() {
        try {
            nivel = nivel - 1;
            String message = ("El Capitán fue regañado por no cumplir con su deber. Por lo tanto será degradado");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);

        } catch (Exception e) {
            String message = ("Este soldado no ha podido ser regañado.");
            JOptionPane.showConfirmDialog(null, message, "¡!", JOptionPane.OK_OPTION);
        }
    }

    
    // metodo para asignar mision
    @Override
    public void asignarMision(String mision){
        this.mision = mision;
    }

    @Override
    public String getMision(){
        return mision;
    }

}
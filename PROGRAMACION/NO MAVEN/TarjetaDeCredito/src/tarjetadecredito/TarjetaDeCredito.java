/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarjetadecredito;

import es.daw.poo.model.Tarjeta;
import java.util.Scanner;
import javax.swing.JOptionPane;
import es.daw.Util.Utilidades;

/**
 *
 * @author VSPC
 */
public class TarjetaDeCredito {

    public static Tarjeta[] tarjetas = new Tarjeta[Utilidades.pidoNumTarjetas()];

    public static Scanner lector = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Tarjeta t1 = new Tarjeta("666", "Mari", 500);

        Tarjeta t2 = new Tarjeta("11111", "Paula", 1000);

        Tarjeta t3 = new Tarjeta("22222", "Ivan G", 5000, 10);*/
        // estos son para que den error los pagos los obligamos t1.pagar(550);
        // los mismo que el de arriba t3.pagar(11);
        //Simulamos que se dan de alta 3 tarjetas
        //Esto se ha pedido por scanner
        
        
        
        int opcion = 0;
        while (opcion != 6) {

            Utilidades.pintaMenu();
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    Utilidades.darAltaTarjetas();
                    break;
                case 2:
                    Utilidades.imprimeInformacionTarjetas();
                    break;
                case 3:
                    System.out.println("Introduce bien el numero mamon");
                    String num = lector.next();
                    Utilidades.informacionPorNumero(num);
                    break;
                case 4:

                    System.out.println("Pasame el importe");
                    float importe = lector.nextFloat();
                    System.out.println("Con que tarjeta quieres trabajar");
                    tarjetas[lector.nextInt()].pagar(importe);

                    /*String tarjeti = (String) JOptionPane.showInputDialog(null, "Elige su entidad bancaria", "menú banco",
                            JOptionPane.QUESTION_MESSAGE, null, tarjetas, tarjetas[0]);
                    System.out.println("Datos de tarjeti"+tarjeti. );
                    
                    //tarjetas[0] = */
                    break;
                case 5:
                    System.out.println("Desactivamos");
                    tarjetas[0].desactivarTarjeta();
                    break;
                case 6:
                    System.out.println("Vas a salir del programa");
                    System.exit(0);

                default:
                    System.out.println("Has elegido una opcion incorrecta prueba otra");

            }

        }

    }

}

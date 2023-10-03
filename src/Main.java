//librerias a importar
import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //variables variadas (no pun intended)
        double min = -1.0; //minimo del lienzo
        double max = 1.0; //máximo del lienzo
        Color curColor = StdDraw.BLACK; //color actual
        Color[] colores = {StdDraw.BLACK, StdDraw.WHITE, StdDraw.RED, StdDraw.BLUE, StdDraw.GREEN, StdDraw.YELLOW}; //lista de colores
        StdDraw.setXscale(-1.0, 1.0); //lienzo en X
        StdDraw.setYscale(-1.0, 1.0); //lienzo en Y
        StdDraw.enableDoubleBuffering();
        Scanner s = new Scanner(System.in);
        boolean seguirCiclo = true; //booleano para seguir corriendo el programa
        while (seguirCiclo) { //ciclo while del menú
            String relleno = ""; //relleno del circulo
            mostrarMenu(); //prints del menú
            String opcionMenuPrinc = s.nextLine();
            switch (opcionMenuPrinc) {
                //Agregar linea
                case "1":
                    agregarLinea(false, 0, 0);

                    //agregar circunferencia
                case "2":
                    relleno = "no";
                    agregarCirculo(relleno);

                    //cambiar color
                case "3":
                    curColor = cambiarColor(colores);
                    StdDraw.setPenColor(curColor);

                    //anillos en capa
                case "4":
                    relleno = "capa";
                    agregarCirculo(relleno);

                    //borrar dibujo
                case "5":
                    StdDraw.clear();
                    System.out.println("Su dibujo ha sido borrado");

                    //insertar texto
                case "6":
                    crearTexto();

                    //agregar circulo
                case "7":
                    relleno = "si";
                    agregarCirculo(relleno);

                    //crear acpia
                case "8":

                    //circunferencia con linea
                case "9":
                    relleno = "linea";
                    StdDraw.clear();
                    agregarCirculo(relleno);

                    //detener programa
                case "10":
                    seguirCiclo = false;
                    break;

                //cualquier otro caso
                default:
                    System.out.println("Ha ingresado un valor incorrecto, por favor elija nuevamente");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido al programa de edición de Oasis\n\nElija una opción:\n");
        System.out.println("1: Agregar una Línea\n2:Placeholder\n3:Placeholder\n4:Placeholder\n5:Placeholder\n6:Placeholder\n7:Placeholder\n8:Placeholder\n9:Placeholder\n10:Salir\nIngrese una opción:");
    }

    //función para agregar una línea
    public static void agregarLinea(boolean rotar, double equis, double yGriega) {
        double min = -1.0;
        double max = 1.0;
        Scanner s = new Scanner(System.in);
        if (rotar == false) {
            String lineaX1 = "";
            String elPepe = "";
            double lineX1 = 0;
            while (true) {
                System.out.println("Recuerde: Las coordenadas solo van del -100 al 100, solo puede poner números enteros y\npara los numeros menores a 10 debe anteponer un 0.\ncualquier número mayor o menor que el rango dado será considerado\ncomo 100 y -100 respectivamente\n");
                try {
                    System.out.println("Ingrese coordenada X de donde quiere empezar la línea:");
                    lineaX1 = s.nextLine();
                    if ((Integer.parseInt(lineaX1) < 100) && (Integer.parseInt(lineaX1) > -100)) { //esto lo tuve que buscar
                        elPepe = "0." + Math.abs(Integer.parseInt(lineaX1)); //habia pensado en dividirlo por potencias de 10, pero tendría
                        // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                        // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                        // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                        lineX1 = Double.parseDouble(elPepe); //esto también lo tuve que buscar
                        if (Integer.parseInt(lineaX1) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                            lineX1 *= -1;
                        }
                    }
                    if (Integer.parseInt(lineaX1) >= 100) {
                        lineX1 = 1.0;
                    }
                    if (Integer.parseInt(lineaX1) <= -100) {
                        lineX1 = -1.0;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
                }
            }

            System.out.println("Ingrese coordenada Y de donde quiere empezar la línea:");
            String lineaY1 = "";
            String eteSech = "";
            double lineY1 = 0;
            while (true) {
                try {
                    System.out.println("Ingrese coordenada X de donde quiere empezar la línea:");
                    lineaX1 = s.nextLine();
                    if ((Integer.parseInt(lineaX1) < 100) && (Integer.parseInt(lineaX1) > -100)) { //esto lo tuve que buscar
                        elPepe = "0." + Math.abs(Integer.parseInt(lineaX1)); //habia pensado en dividirlo por potencias de 10, pero tendría
                        // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                        // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                        // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                        lineX1 = Double.parseDouble(elPepe); //esto también lo tuve que buscar
                        if (Integer.parseInt(lineaX1) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                            lineX1 *= -1;
                        }
                    }
                    if (Integer.parseInt(lineaX1) >= 100) {
                        lineX1 = 1.0;
                    }
                    if (Integer.parseInt(lineaX1) <= -100) {
                        lineX1 = -1.0;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
                }
            }
            System.out.println("Ingrese coordenada X de donde quiere terminar la línea:");
            int lineaX2 = s.nextInt();
            String esoTilin = "";
            double lineX2 = 0;
            if ((lineaX2 < 100) && (lineaX2 > -100)) {
                esoTilin = "0." + Math.abs(lineaX2);

                lineX2 = Double.parseDouble(esoTilin);
                if (lineaX2 < 0) {
                    lineX2 *= -1;
                }
            }
            if (lineaX2 >= 100) {
                lineX2 = 1.0;
            }
            if (lineaX2 <= -100) {
                lineX2 = -1.0;
            }
            System.out.println("Ingrese coordenada Y de donde quiere terminar la línea:");
            int lineaY2 = s.nextInt();
            String pintamosTodaLaCasa = "";
            double lineY2 = 0;
            if ((lineaY2 < 100) && (lineaY2 > -100)) {
                pintamosTodaLaCasa = "0." + Math.abs(lineaY2);

                lineY2 = Double.parseDouble(pintamosTodaLaCasa);

                if (lineaY2 < 0) {
                    lineY2 *= -1;
                }
            }
            if (lineaY2 >= 100) {
                lineY2 = 1.0;
            }
            if (lineaY2 <= -100) {
                lineY2 = -1.0;
            }

            StdDraw.line(lineX1, lineY1, lineX2, lineY2);
            StdDraw.show();
        }
        if (rotar == true){
            String X2 = "0." + equis;
            double equis2 = Double.parseDouble(X2) + equis;
            String Y2 = "0." + equis;
            double yGriega2 = Double.parseDouble(X2) + equis;
            StdDraw.line(equis, yGriega, equis2, yGriega2);
        }
    }

    public static void agregarCirculo(String modoRelleno) {
        double min = -1.0;
        double max = 1.0;
        Scanner s = new Scanner(System.in);
        String x = "";
        String elPepe = "";
        double equis = 0;
        String y = "";
        String eteSech = "";
        double yGriega = 0;
        String radio = "";
        String esoTilin = "";
        double diametroPartidoEnDos = 0;

        while (true) {
            try {
                System.out.println("Ingrese coordenada X:");
                x = s.nextLine();
                if ((Integer.parseInt(x) < 100) && (Integer.parseInt(x) > -100)) { //esto lo tuve que buscar
                    elPepe = "0." + Math.abs(Integer.parseInt(x)); //habia pensado en dividirlo por potencias de 10, pero tendría
                    // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                    // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                    // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                    equis = Double.parseDouble(elPepe); //esto también lo tuve que buscar
                    if (Integer.parseInt(x) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                        equis *= -1;
                    }
                }
                if (Integer.parseInt(x) >= 100) {
                    equis = 1.0;
                }
                if (Integer.parseInt(x) <= -100) {
                    equis = -1.0;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
            }
        }
        while (true) {
            try {
                System.out.println("Ingrese coordenada Y:");
                y = s.nextLine();
                if ((Integer.parseInt(y) < 100) && (Integer.parseInt(y) > -100)) { //esto lo tuve que buscar
                    eteSech = "0." + Math.abs(Integer.parseInt(x)); //habia pensado en dividirlo por potencias de 10, pero tendría
                    // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                    // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                    // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                    yGriega = Double.parseDouble(eteSech); //esto también lo tuve que buscar
                    if (Integer.parseInt(y) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                        equis *= -1;
                    }
                }
                if (Integer.parseInt(y) >= 100) {
                    equis = 1.0;
                }
                if (Integer.parseInt(y) <= -100) {
                    equis = -1.0;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
            }
        }
        while (true) {
            try {
                System.out.println("Ingrese radio:");
                radio = s.nextLine();
                if ((Integer.parseInt(radio) < 100) && (Integer.parseInt(radio) > -100)) { //esto lo tuve que buscar
                    esoTilin = "0." + Math.abs(Integer.parseInt(x)); //habia pensado en dividirlo por potencias de 10, pero tendría
                    // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                    // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                    // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                    diametroPartidoEnDos = Double.parseDouble(esoTilin); //esto también lo tuve que buscar
                    if (Integer.parseInt(radio) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                        diametroPartidoEnDos *= -1;
                    }
                }
                if (Integer.parseInt(radio) >= 100) {
                    diametroPartidoEnDos = 1.0;
                }
                if (Integer.parseInt(radio) <= -100) {
                    diametroPartidoEnDos = -1.0;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
            }
        }
        if (modoRelleno == "no") {
            StdDraw.circle(equis, yGriega, diametroPartidoEnDos);
        }
        if (modoRelleno == "si") {
            StdDraw.filledCircle(equis, yGriega, diametroPartidoEnDos);
        }
        if (modoRelleno == "capa"){
            while (true) {
                try {
                    System.out.println("Ingrese valor de reducción de radio: ");
                    double reduccion = s.nextInt();

                    StdDraw.filledCircle(equis, yGriega, diametroPartidoEnDos);
                    StdDraw.filledCircle(equis, yGriega, diametroPartidoEnDos * Double.parseDouble("0." + String.valueOf(reduccion)));
                    StdDraw.filledCircle(equis, yGriega, diametroPartidoEnDos * Double.parseDouble("0." + String.valueOf(reduccion)) * 0.5);

                } catch (InputMismatchException e) {
                    System.out.println("Ha ingresado un valor inválido");
                }
            }
        }
        if (modoRelleno == "linea"){
            StdDraw.circle(equis, yGriega, diametroPartidoEnDos);
            agregarLinea(true, equis, yGriega);

        }

    }

    public static Color cambiarColor(Color[] colores) {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("¿Que color quiere usar?\n1: Negro\n2: Blanco\n3: Rojo\n4: Azul\n5: Verde\n6: Amarillo\nIngrese una opción: ");
                int colorSel = s.nextInt();
                Color curColor = colores[colorSel - 1];
                return curColor;
            } catch (InputMismatchException e) {
                System.out.println("Ha ingresado un valor inválido");
            }
        }
    }
    public static void crearTexto(){
        double min = -1.0;
        double max = 1.0;
        Scanner s = new Scanner(System.in);
        String x = "";
        String elPepe = "";
        double equis = 0;
        String y = "";
        String eteSech = "";
        double yGriega = 0;
        while (true) {
            try {
                System.out.println("Ingrese coordenada X:");
                x = s.nextLine();
                if ((Integer.parseInt(x) < 100) && (Integer.parseInt(x) > -100)) { //esto lo tuve que buscar
                    elPepe = "0." + Math.abs(Integer.parseInt(x)); //habia pensado en dividirlo por potencias de 10, pero tendría
                    // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                    // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                    // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                    equis = Double.parseDouble(elPepe); //esto también lo tuve que buscar
                    if (Integer.parseInt(x) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                        equis *= -1;
                    }
                }
                if (Integer.parseInt(x) >= 100) {
                    equis = 1.0;
                }
                if (Integer.parseInt(x) <= -100) {
                    equis = -1.0;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
            }
        }
        while (true) {
            try {
                System.out.println("Ingrese coordenada Y:");
                y = s.nextLine();
                if ((Integer.parseInt(y) < 100) && (Integer.parseInt(y) > -100)) { //esto lo tuve que buscar
                    eteSech = "0." + Math.abs(Integer.parseInt(x)); //habia pensado en dividirlo por potencias de 10, pero tendría
                    // que agregar numeros a la potencia dependiendo de la cantidad de dígitos del número y eso
                    // sería más complicado, así que lo que se me ocurrio es transformar el número a string usando valor absoluto
                    // y agregarle un "0." adelante y luego pasarlo a double nuevamente
                    yGriega = Double.parseDouble(eteSech); //esto también lo tuve que buscar
                    if (Integer.parseInt(y) < 0) { //Si el valor ingresado fue negativo, multiplicar el valor final por -1
                        equis *= -1;
                    }
                }
                if (Integer.parseInt(y) >= 100) {
                    equis = 1.0;
                }
                if (Integer.parseInt(y) <= -100) {
                    equis = -1.0;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\nHa ingresado un valor incorrecto, por favor inténtelo de nuevo\n");
            }
        }
        System.out.println("Ingrese un texto: ");
        String texto = s.nextLine();
        StdDraw.text(equis, yGriega, texto);
    }
}
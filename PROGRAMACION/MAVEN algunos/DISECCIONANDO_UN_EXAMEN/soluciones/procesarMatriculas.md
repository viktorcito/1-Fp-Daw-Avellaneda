# Solución procesado de matrículas
Se ha cargado el array de matrículas en arrays unidimensionales (vectores) con cada tipo de información

```
        String[] matriculas = {
            "Ana,11111111A,18,6,GM",
            "Juan,11111111B,25,3,GS",
            "Sonia,22222222A,42,6,GS",
            "Pepe,22222222B,21,2,Gm",
            "Lucas,11111111B,32,2,gs",
            "Lola,33333333B,32,4,gs",
            "Lucas,33333333B,32,2,gs",};

        String[] nombres = new String[matriculas.length];
        String[] dnis = new String[matriculas.length];
        int[] edades = new int[matriculas.length];
        int[] numModulos = new int[matriculas.length];
        String[] ciclos = new String[matriculas.length];

        String[] matricula;
        // Cargo los datos en arrays diferentes de la misma longitud
        for (int i = 0; i < matriculas.length; i++) {
            matricula= matriculas[i].split(",");
            nombres[i]= matricula[0]; //nombre
            dnis[i] = matricula[1]; //dni
            edades[i] = Integer.parseInt(matricula[2]); //edad
            numModulos[i] = Integer.parseInt(matricula[3]); //numModulos
            ciclos[i] = matricula[4]; //ciclo
        }

```
 

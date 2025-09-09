# Diseccionando un examen
El objetivo de esta práctica es **realizar paso a paso los diferentes ejercicios de un examen.**

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/ab67a0e9-7659-4516-829f-3c6581f69f99) ![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/55ec1193-b823-403b-aada-f4f75c987c0e)



Comprobaremos cómo dividiendo el problema en problemas más sencillos podemos resolverlo.

También iremos detectando **problemas que se pueden resolver por "imitación"** aplicando los conceptos aprendidos en clase en ejercicios similares.

Finalmente nos daremos cuenta que dichos ejercicios eran más fácil de solucionar de lo que en un principio nos pueda parecer.

Vamos a aprender estrategias para en un ambiente hostil, como es un examen, podamos salir victoriosos!!!!

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/0d2b8014-ce1b-42fa-8506-072a2853934f)

# EJERCICIO 1: manipular información de un array de String
Vamos a partir del siguiente array de cadenas que contiene información de matrículas de alumnos:

```
String[] matriculas = {
            "Ana,11111111A,18,6,GM",
            "Juan,11111111B,25,3,GS",
            "Sonia,22222222A,42,6,GS",
            "Pepe,22222222B,21,2,Gm",
            "Lucas,11111111B,32,2,gs",
            "Lola,33333333B,32,4,gs",
            "Lucas,33333333B,32,2,gs",};
```

Cada cadena está compuesta por: 
- nombre del alumno.
- su DNI
- su edad
- el número de módulos en los que se ha matriculado
- el ciclo (Grado Medio: GM, Grado Superior: GS).


Para poder realizar las tres métodos que se detallan a continuación es necesario procesar cada una de las cadenas para **diseccionar** la información y clasificarlas en diferentes arrays unidimensionales (vectores), ya que los métodos van a recibir dicha información en ese formato.

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/8fdc94dc-eaf4-4356-91fe-5d30955ae7f7) En el reto de Heterograma aplicamos la forma de dividir una cadena en diferentes cadenas usando un carácter separador https://github.com/profeMelola/Programacion-04-2023-24/tree/main/Retos#reto-4-heterograma

Después es tener claro que la posición 0 de todos los arrays guardarán información del alumno1, la posición 1 de todos los arrays guardarán información del alumno2...


En el caso de que no supieras hacerlo, se daba la opción de crear dichos arrays a mano (con la siguiente penalización lógicamente). Tal que así:

```
  String[] nombres = {"Ana","Juan","Sonia","Pepe","Lucas"};
  String[] dnis = {"11111111A","11111111B","22222222A","22222222B","11111111A"};
  String[] edades = {"18","25","42","21","32"};
  String[] numModulos = {"6","3","6","2","2"};
  String[] ciclos = {"GM","GS","Gm","gs"};
```
o directamente haciendo la conversión a entero de los datos numéricos

```
  String[] nombres = {"Ana","Juan","Sonia","Pepe","Lucas"};
  String[] dnis = {"11111111A","11111111B","22222222A","22222222B","11111111A"};
  int[] edades = {18,25,42,21,32};
  int[] numModulos = {6,3,6,2,2};
  String[] ciclos = {"GM","GS","Gm","gs"};
```

## Comprobar DNIs repetidos (comprobarDNIs)
Debes implementar un método estático privado en base a los siguientes requisitos:

- Comprueba si hay DNIs repetidos y si es así, devuelve la posición del primer DNI repetido que encuentre.
- Recibe como argumento un array unidimensional con los DNIs.
- Debe devolver la posición del primer DNI encontrado o -1 en caso de que no haya repetidos.

### Ejemplo de salida por consola:
```
1. El primer DNI repetido es: 11111111B
```

## Obtener la edad media de los alumnos (obtenerEdadMedia)
Debes implementar un método estático privado en base a los siguientes requisitos:

- Calcula la edad media de todos los alumnos matriculados.
- Recibe como argumento un array con las edades.
- Debe devolver la edad media sin decimales, con redondeo por defecto.

### Ejemplo de salida por consola:
```
2. La edad media de los alumnos matriculados es: 29
```


## Obtener nombre del alumno que ha pagado mayor importe por la matrícula (obtenerNombreAlumnoMayorImporte)
Debes implementar un método estático privado en base a los siguientes requisitos:

- Obtiene el nombre del alumno que ha pagado más por la matrícula, teniendo en cuenta que la matrícula de un módulo en GS son 70 euros y en GM son 50 euros.
- Tú decides los argumentos.
- Obligatoriamente debe devolver una cadena con el nombre del alumno.

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/492bc568-eef5-4312-9ff2-2bdeb1253080)**Piensa en el algoritmo y sus pasos para lograr el objetivo:**

- Necesito saber el mayor importe. Para ello tengo que multiplicar el número de módulos por su correspondiente precio sabiendo que GM y GS tienen importes diferentes.
- Por tanto necesito un bucle para que por cada alumno obtenga su número de módulos, su ciclo (teniendo en cuenta que no sea sensible a may y min) y hacer el cálculo.
- Además debo comprobar si ese importe es mayor que el importe anteriormente calculado para así ir guardando el importe mayor. ¿No te recuerda esto a los métodos de ordenación vistos en clase?
- No olvides que además de guardar el importe mayor en cada iteración, debes guardar la posición para luego devolver el nombre del alumno en cuestión.
  

### Ejemplo de salida por consola:
```
3. El nombre del alumno que ha pagado más por la matrícula es: Sonia
```

# EJERCICIO 2: matrices

El cine Avellaneda tiene una sala compuesta de 5 filas de 8 asientos cada una. 

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/ececa393-1813-4996-83e3-fe46a3754cd9)


Está representado por la siguiente matriz, donde los asientos libres se representan con un guión (-) y los asientos ocupados con una (X).

```
        char[][] cine = {
            {'-', '-', '-', '-', 'X', 'X', 'X', 'X'},
            {'-', '-', '-', 'X', 'X', 'X', '-', '-'},
            {'-', 'X', '-', '-', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X', 'X', '-', '-', '-'},
            {'X', 'X', '-', '-', '-', '-', '-', '-'}};
```

Debes implementar las siguientes funcionalidades como consideres en base a los siguientes requisitos:

## Mostrar el estado del cine por consola

Ten en cuenta que tu código debe ser reutilizable y valer para mostrar el estado de cualquier cine (con más o menos filas y columnas).

Esto significa que la matriz puede tener más o menos filas y más o menos columnas. Por tanto lo mejor es hacer un método que reciba un cine (matriz de char) y lo muestre por consola de la siguiente manera:

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/1112d484-b6f1-413a-bd38-476d24fc0e9f)

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/6e44a993-6274-4aa7-a225-69a3316344ca)**¿Te has dado cuenta que cada fila tiene el formato de lo que devuelve el método Arrays.toString ?**


## Ampliar cine
Se decide ampliar el cine con más filas.

Debes tener en cuenta a la hora de programar esta funcionalidad que:
- Pueden realizarse ampliaciones a lo largo del tiempo.
- El número de filas a añadir puede variar en cada ampliación.
- Los asientos de esas nuevas filas deben quedar especificados como vacíos.

Por tanto, lo mejor es implementar un método que reciba la matriz (el cine) y el número de filas. En el examen se ponía el caso de prueba de ampliar con dos filas, dando como resultado lo siguiente:

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/b30a4435-a49b-4291-a513-d43090fde68f)

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/6e44a993-6274-4aa7-a225-69a3316344ca) **Piensa los pasos que debes de hacer para llegar a ampliar el cine y obtener la captura anterior:**

Vamos a pensarlos en clase juntos

![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/80b5c61a-5beb-4df0-86f0-4d639af9915b)


¿Recuerdas el ejercicio del puzzle y cómo se realizaba el clonado de una matriz para tener una copia del puzzle? https://github.com/profeMelola/Programacion-04-2023-24/tree/main/ARRAYS/EJERCICIOS/4.Puzzle



## Comprar entradas y devolver asientos de forma automática

Estas son las especificaciones:
- Se indicará el número de entradas a comprar.
- La asignación automática empezará por la Fila 1, asiento A.
- Su compra debe ser consecutiva y en la misma fila. Si no hay asientos libres consecutivos en la misma fila, no se realizará la compra y se mostrará un aviso.
- Tras comprar correctamente las entradas:
  
            - Debe mostrarse los asientos asignados a cada entrada.
  
            - El cine debe quedar actualizado con los nuevos asientos ocupados.


![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/492bc568-eef5-4312-9ff2-2bdeb1253080)**Vamos por partes:**
  
![image](https://github.com/profeMelola/Programacion-04-2023-24/assets/91023374/74b54511-1d97-4e8a-a14a-767e2a3c4769)

1. ¿Y si hago un método que reciba el cine (la matriz) y el número de filas y devuelva la fila donde hay asientos consecutivos libres y en caso contrario -1?
2. Ya puedo saber y avisar con un mensaje en el caso de que no hayas filas libre (numFila == -1) y por tanto no se realizará la compra.
3. Si hay fila con asientos consecutivos libres (suficientes para el número de entradas), con ese número de fila puedo realizar la compra y gestionar los asientos.
   
            3.1 Piensa en un método que reciba el cine, el número de entradas, el número de fila y devuelva un array de String con los asientos, por ejemplo ["A1","A2"]





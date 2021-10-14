/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @IKER CIA 
 */
public class Podometro {
    private final char MUJER = 'M';
    private final char HOMBRE = 'H';
    private final  double ZANCADA_HOMBRE = 0.45;
    private final  double ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;
    

    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;

        
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
       return marca;   

    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if(sexo == 'H'){
         longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
        }
        else{
         longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }

        
    }

     /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
                            int horaFin) {
    double distancia = pasos * longitudZancada;
    totalDistanciaSemana += distancia;
    tiempo += (horaFin / 100 * 60 + horaFin % 100)-(horaInicio / 100 * 60 + horaInicio % 100);
    if(horaInicio > 2100){
    caminatasNoche ++;
    }
    switch(dia){
            case 1: totalPasosLaborables += pasos;
            break;
            case 2: totalPasosLaborables += pasos;
            break;
            case 3: totalPasosLaborables += pasos;
            break;
            case 4: totalPasosLaborables += pasos;
            break;
            case 5: totalPasosLaborables += pasos;
            break;
            case 6: totalDistanciaFinSemana += distancia; totalPasosSabado += pasos;  
            break;
            case 7: totalDistanciaFinSemana += distancia; totalPasosDomingo += pasos;
            break;
            
        }  
    }
    
    
    /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
     public void printConfiguracion() {
        String sexo1 = "";
        if(sexo == 'H'){
        sexo1 = "HOMBRE";
        }
        else{
        sexo1 = "MUJER";
    }
        System.out.println("Configuración del podómetro\n********************\nAltura: " + 
         altura / 100 + " mtos\nSexo: " + sexo1 + "\nLongitud zancada:" + 
         longitudZancada / 100 + " mtos\n\n");

    }
    
    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
      
        System.out.println("Estadísticas\n************************\nDistancia recorrida toda la semana:"+
        totalDistanciaSemana / 100000 + "Km\nDistancia recorrida fin de semana:" + 
        totalDistanciaFinSemana / 100000 + "Km\n\n\nNumero de pasos días laborables:"+ 
        totalPasosLaborables + "\nNumero de pasos SÁBADO:"+ 
        totalPasosSabado + "\nNumero de pasos DOMINGO:"+ 
        totalPasosDomingo + "\n\n\nNumero de caminatas realizadas a partir de las 21h.: " +
        caminatasNoche + "\n\n\nTiempo total caminado en la semana  "+ tiempo/60 +"h. y " + 
        tiempo%60 + "m." );

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
          String diaMayor = "";
         if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo){
            diaMayor = "LABORABLES";
            }
           else if(totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
            diaMayor = "SÁBADO";
            }
            
            else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado){
            diaMayor = "DOMINGO";
        
            }      
        
            else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo == totalPasosSabado){
            diaMayor = "DOMINGO SABADO";
        
            }
            else if(totalPasosSabado > totalPasosDomingo && totalPasosSabado == totalPasosLaborables){
            diaMayor = "LABORABLES SABADO";
        
            }
            else if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables == totalPasosDomingo){
            diaMayor = "LABORABLES DOMINGO";
        
            }
            
            
            else {
            diaMayor = "LABORABLES SABADO DOMINGO";
            } 
            return diaMayor;
    }
    
    
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;

        

    }
    
    

}

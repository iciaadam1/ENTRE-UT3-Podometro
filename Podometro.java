/**
 * La clase modela un sencillo pod�metro que registra informaci�n
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
     * Inicializa el pod�metro con la marca indicada por el par�metro.
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
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
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
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
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
     * Muestra en pantalla la configuraci�n del pod�metro
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
        System.out.println("Configuraci�n del pod�metro\n********************\nAltura: " + 
         altura / 100 + " mtos\nSexo: " + sexo1 + "\nLongitud zancada:" + 
         longitudZancada / 100 + " mtos\n\n");

    }
    
    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
      
        System.out.println("Estad�sticas\n************************\nDistancia recorrida toda la semana:"+
        totalDistanciaSemana / 100000 + "Km\nDistancia recorrida fin de semana:" + 
        totalDistanciaFinSemana / 100000 + "Km\n\n\nNumero de pasos d�as laborables:"+ 
        totalPasosLaborables + "\nNumero de pasos S�BADO:"+ 
        totalPasosSabado + "\nNumero de pasos DOMINGO:"+ 
        totalPasosDomingo + "\n\n\nNumero de caminatas realizadas a partir de las 21h.: " +
        caminatasNoche + "\n\n\nTiempo total caminado en la semana  "+ tiempo/60 +"h. y " + 
        tiempo%60 + "m." );

    }

   

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
          String diaMayor = "";
         if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo){
            diaMayor = "LABORABLES";
            }
           else if(totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
            diaMayor = "S�BADO";
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
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
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

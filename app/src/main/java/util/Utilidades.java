package util;

public class Utilidades {

    public static final String NOMBRE_TABLA = "loteria";
//    public static final String NOMBRE = "nombre";
    public static final String ID = "fecha";
    public static final String PRIMERO = "primero";
    public static final String SEGUNDO = "segundo";
    public static final String TERCERO = "tercero";

//    public static final String C_TABLA = "CREATE TABLE "+NOMBRE_TABLA+"("+NOMBRE+" TEXT)";

    public static final String CREAR_TABLA = "CREATE TABLE "+NOMBRE_TABLA+"" +
            "("+ID+" TEXT(12),"+PRIMERO+" TEXT(2) NOT NULL,"+SEGUNDO+"" +
            " TEXT(2), "+TERCERO+" TEXT(2))";


}

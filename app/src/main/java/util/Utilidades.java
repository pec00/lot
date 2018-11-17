package util;

public class Utilidades {

    public static final String TABLA_NACIONAL = "loterianacional";
    public static final String TABLA_LOTEKA = "loterialoteka";
    public static final String TABLA_REAL = "loteriareal";

    public static final String ID = "fecha";
    public static final String PRIMERO = "primero";
    public static final String SEGUNDO = "segundo";
    public static final String TERCERO = "tercero";



    public static final String CREAR_TABLA_NACIONAL = "CREATE TABLE "+TABLA_NACIONAL+"" +
            "("+ID+" TEXT(12),"+PRIMERO+" TEXT(2) NOT NULL,"+SEGUNDO+"" +
            " TEXT(2), "+TERCERO+" TEXT(2))";

    public static final String CREAR_TABLA_LOTEKA = "CREATE TABLE "+TABLA_LOTEKA+"" +
            "("+ID+" TEXT(12),"+PRIMERO+" TEXT(2) NOT NULL,"+SEGUNDO+"" +
            " TEXT(2), "+TERCERO+" TEXT(2))";

    public static final String CREAR_TABLA_REAL = "CREATE TABLE "+TABLA_REAL+"" +
            "("+ID+" TEXT(12),"+PRIMERO+" TEXT(2) NOT NULL,"+SEGUNDO+"" +
            " TEXT(2), "+TERCERO+" TEXT(2))";


}

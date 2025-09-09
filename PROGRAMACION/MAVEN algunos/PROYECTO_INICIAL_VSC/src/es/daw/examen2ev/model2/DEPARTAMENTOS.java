package es.daw.examen2ev.model2;

public enum DEPARTAMENTOS {
    DESARROLLO("DES"),
    CONTABILIDAD("CNT"),
    RRHH("RH"),
    CONSULTORIA("CST");

    private final String codigo;

    DEPARTAMENTOS(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}


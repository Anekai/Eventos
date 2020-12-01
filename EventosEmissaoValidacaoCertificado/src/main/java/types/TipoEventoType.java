
package types;

public enum TipoEventoType {
    
    PALESTRA("Palestra"),
    SEMINARIO("Seminário"),
    OFICINA("Oficina");

    private String value;

    private TipoEventoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}

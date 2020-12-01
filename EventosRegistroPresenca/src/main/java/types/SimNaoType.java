
package types;

public enum SimNaoType {
    
    SIM("Sim"),
    NAO("Não");

    private String value;

    private SimNaoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}


public class Entry {
    private int id;
    private int valor;
    private String fonte;
    private boolean dOL;
    //True=entrada, false=saida

    public Entry(int valor, String fonte, boolean dOL) {
        this.valor = valor;
        this.fonte = fonte;
        this.dOL = dOL;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public boolean isdOL() {
        return dOL;
    }

    public void setdOL(boolean dOL) {
        this.dOL = dOL;
    }








}

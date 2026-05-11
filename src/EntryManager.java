import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntryManager {
    private ArrayList<Entry> listaEntries = new ArrayList<>();
    private Map<String, Integer> totalPorFonteGanho = new HashMap<>();
    private Map<String, Integer> totalPorFonteDispesa = new HashMap<>();




    public ArrayList<Entry> getListaEntries() {
        return listaEntries;
    }



    //METODOS

    public void addEntry(Entry entry){
        listaEntries.add(entry);
    }

    public void criaCategorias(){
        totalPorFonteGanho.clear();
        totalPorFonteDispesa.clear();

        for (Entry e: listaEntries){
            String fonte = e.getFonte();
            int valor = e.getValor();

            if (e.isdOL()){
                if (totalPorFonteGanho.containsKey(fonte)){
                    int totalAtual = totalPorFonteGanho.get(fonte);
                    totalPorFonteGanho.put(fonte, totalAtual + valor);
                } else {
                    totalPorFonteGanho.put(fonte, valor);
                }
            }else{
                if (totalPorFonteDispesa.containsKey(fonte)){
                    int totalAtual = totalPorFonteDispesa.get(fonte);
                    totalPorFonteDispesa.put(fonte, totalAtual + valor);
                } else {
                    totalPorFonteDispesa.put(fonte, valor);
                }
            }

        }
    }
    public void printaGanhos(){
        totalPorFonteGanho.forEach((fonte, total) ->
                System.out.println(fonte+": R$"+total)
        );
    }
    public int totalGanhos(){
        int totalGanhos = 0;
        for (int e : totalPorFonteGanho.values()) {
            totalGanhos = totalGanhos+e;
        }
        return totalGanhos;
    }
    public void printaDispesas(){
        totalPorFonteDispesa.forEach((fonte, total) ->
                System.out.println(fonte+": R$"+total)
        );
    }
    public int totalDispesas(){
        int totalDispesas = 0;
        for (int e : totalPorFonteDispesa.values()) {
            totalDispesas = totalDispesas+e;
        }
        return totalDispesas;
    }


    public int balanco(){
        int totalGanhos =  this.totalGanhos();
        int totalDispesas = this.totalDispesas();

        int balanco = totalGanhos - totalDispesas;
        return balanco;
    }

    public void removerEntry(int id) {
        listaEntries.removeIf(e -> e.getId() == id);
    }

    public void atualizarEntry(Entry entry) {
        for (int i = 0; i < listaEntries.size(); i++) {
            if (listaEntries.get(i).getId() == entry.getId()) {
                listaEntries.set(i, entry);
            }
        }
    }



}

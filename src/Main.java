import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //declara a lista que guarda as infos
        EntryManager manager = new EntryManager();
        EntryDAO dao = new EntryDAO();
        ArrayList<Entry> entries = dao.buscarTodos();
        for (Entry e : entries){
            manager.addEntry(e);
        }

        int limite = 0;

        while (true){
            System.out.println("tudo OK, pode mandar o comando!");
            String comando = scanner.nextLine();
            if (comando.equals("parar")) {
                break;
            }
            if (comando.equals("adicionar ganho")) {
                //pede infos e salva como variavel para criar o objeto entry
                System.out.println("Valor:");
                int valor = Integer.valueOf(scanner.nextLine());

                System.out.println("Fonte:");
                String fonte = scanner.nextLine();

                //cria objeto entry aqui
                Entry entry = new Entry(valor, fonte, true);
                dao.salvar(entry); //SQL
                manager.addEntry(entry); //LEGADO (ainda serve pra jogar no manager, que é usado pra printar o relatorio)

            }
            if (comando.equals("adicionar dispesa")) {
                System.out.println("valor:");
                int valor = Integer.valueOf(scanner.nextLine());

                System.out.println("Fonte:");
                String fonte = scanner.nextLine();

                Entry entry = new Entry(valor, fonte, false);
                dao.salvar(entry); //SQL
                manager.addEntry(entry); //LEGADO (ainda serve pra jogar no manager, que é usado pra printar o relatorio)
            }


            if (comando.equals("relatorio")) {
                //printa dispesas totais - DONE
                //printa gastos por categoria - DONE
                //printa quanto tem disponivel até atingir o limite - DONE

                //printa boletos fixos com a data, valor e se foi pago ou não.

                manager.criaCategorias();
                System.out.println("// Ganhos totais: R$" + manager.totalGanhos());
                manager.printaGanhos();

                System.out.println("// Dispesas totais: R$" + manager.totalDispesas());
                manager.printaDispesas();

                System.out.println("// Balanço: R$" + manager.balanco());

            }

            if (comando.equals("editar")) {
                //edita o entri escolhido pelo id
                System.out.println("Digite o id que quer editar:");
                for (Entry e : manager.getListaEntries()) {
                    System.out.println("id:" + e.getId() + " | " + e.getValor() + " | " + e.getFonte() + " | " + e.isdOL());
                }
                int id = Integer.valueOf(scanner.nextLine());

                System.out.println("Novo valor:");
                int valor = Integer.valueOf(scanner.nextLine());

                System.out.println("Nova fonte:");
                String fonte = scanner.nextLine();

                System.out.println("É ganho ou despesa? (ganho/despesa)");
                boolean dol = scanner.nextLine().equals("ganho");

                Entry entry = new Entry(valor, fonte, dol);
                entry.setId(id);
                dao.atualizar(entry);
                manager.atualizarEntry(entry);
                System.out.println("Entry atualizada!");


            }

            if (comando.equals("apagar")) {
                //apaga o entry selecionado pelo id
                System.out.println("Digite o id que quer apagar:");
                for (Entry e : manager.getListaEntries()) {
                    System.out.println("id:" + e.getId() + " | " + e.getValor() + " | " + e.getFonte() + " | " + e.isdOL());
                }
                int id = Integer.valueOf(scanner.nextLine());
                dao.deletar(id);
                manager.removerEntry(id);
                System.out.println("Entry apagada!");
            }

        }

    }




}

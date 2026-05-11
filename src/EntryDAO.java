import java.sql.*;
import java.util.ArrayList;

public class EntryDAO {
    public void salvar(Entry entry){
        String sql = "INSERT INTO entries (valor, fonte, dOL) VALUES (?,?,?)";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1,entry.getValor());
            stmt.setString(2,entry.getFonte());
            stmt.setBoolean(3,entry.isdOL());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                int idGerado = rs.getInt(1);
                entry.setId(idGerado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Entry> buscarTodos(){
        String sql = "SELECT * FROM entries";
        ArrayList<Entry> lista = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int valor = rs.getInt("valor");
                String fonte = rs.getString("fonte");
                boolean dOL = rs.getBoolean("dol");

                Entry entry = new Entry(valor, fonte, dOL);
                entry.setId(id);
                lista.add(entry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void atualizar(Entry entry){
        String sql = "UPDATE entries SET valor = ?, fonte = ?, dol = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,entry.getValor());
            stmt.setString(2,entry.getFonte());
            stmt.setBoolean(3,entry.isdOL());
            stmt.setInt(4,entry.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(int id){
        String sql = "DELETE FROM entries WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

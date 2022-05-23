import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FrmGrid extends JFrame {
    List<Transaction> tr;
    private JFrame f;
    private JTable j;

    public FrmGrid(List<Transaction> tr){
        this.tr = tr;

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Date");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Type");

        tr.forEach(Transaction -> {
            if (Transaction != null){
            Object[] o = new Object[3];
            o[0] = Transaction.getAmount();
            o[1] = Transaction.getDateTr();
            o[2] = (Transaction instanceof Deposit) ? "+" : "-";
            tableModel.addRow(o);
            }
        });

        JFrame f = new JFrame();
        f.setSize(550, 350);
        f.setLocation(600,200);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.add(new JScrollPane(table));
        f.setVisible(true);
        f.setVisible(true);
    }
}

import java.awt.event.*;

public class HapusHandler implements ActionListener {

    private FormMahasiswa form;

    public HapusHandler(FormMahasiswa form) {
        this.form = form;
    }

    public void actionPerformed(ActionEvent e) {
        form.getTfNama().setText("");
        form.getTfNim().setText("");
        form.getTfJurusan().setText("");
    }
}

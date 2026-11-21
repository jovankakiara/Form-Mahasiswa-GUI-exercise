import javax.swing.*;
import java.awt.event.*;

public class TambahHandler implements ActionListener {

    private FormMahasiswa form;
    private int jumlah = 0; // ngitung ada berapa mahasiswa yang sudah ditambah

    public TambahHandler(FormMahasiswa form) {
        this.form = form;
    }

    public void actionPerformed(ActionEvent e) {
        String nama = form.getTfNama().getText();
        String nim = form.getTfNim().getText();
        String jurusan = form.getTfJurusan().getText();

        // cek dulu kalau ada yang kosong
        if (nama.equals("") || nim.equals("") || jurusan.equals("")) {
            JOptionPane.showMessageDialog(form.getFrame(), "Semua data harus diisi ya!");
        } else {
            Mahasiswa m = new Mahasiswa(nama, nim, jurusan);
            jumlah++;
            form.getAreaOutput().append(jumlah + ". " + m.toString() + "\n");

            form.getTfNama().setText("");
            form.getTfNim().setText("");
            form.getTfJurusan().setText("");
            form.getTfNama().requestFocus();
        }
    }
}

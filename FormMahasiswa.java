import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FormMahasiswa {

    // warna-warna soft (pastel)
    private Color warnaBackground = new Color(246, 243, 252);  // ungu muda 
    private Color warnaJudul = new Color(214, 200, 240);       // lavender
    private Color warnaTeks = new Color(70, 60, 90);           // ungu tua 
    private Color warnaGaris = new Color(200, 190, 225);
    private Color warnaTambah = new Color(190, 228, 212);      // hijau mint
    private Color warnaHapus = new Color(252, 222, 196);       // peach
    private Color warnaKeluar = new Color(245, 192, 202);      // pink soft

    // Atribut
    private JFrame frame;

    // intermediate component (container)
    private JPanel panelJudul;
    private JPanel panelInput;
    private JPanel panelTombol;
    private JPanel panelOutput;

    // atomic component
    private JLabel lblJudul;
    private JLabel lblNama;
    private JLabel lblNim;
    private JLabel lblJurusan;
    private JTextField tfNama;
    private JTextField tfNim;
    private JTextField tfJurusan;
    private JButton btnTambah;
    private JButton btnHapus;
    private JButton btnKeluar;
    private JTextArea areaOutput;

    // Constructor
    public FormMahasiswa() {
        frame = new JFrame("Data Mahasiswa");

        panelJudul = new JPanel();
        panelInput = new JPanel();
        panelTombol = new JPanel();
        panelOutput = new JPanel();

        lblJudul = new JLabel("Form Data Mahasiswa", JLabel.CENTER);
        lblNama = new JLabel("Nama");
        lblNim = new JLabel("NIM");
        lblJurusan = new JLabel("Jurusan");

        tfNama = new JTextField(20);
        tfNim = new JTextField(20);
        tfJurusan = new JTextField(20);

        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus Isian");
        btnKeluar = new JButton("Keluar");

        areaOutput = new JTextArea(8, 30);
        areaOutput.setEditable(false);
    }

    // method buat ngatur tampilan tombol biar gak nulis berulang-ulang
    private void aturTombol(JButton tombol, Color warna) {
        tombol.setBackground(warna);
        tombol.setForeground(warnaTeks);
        tombol.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tombol.setFocusPainted(false);
        tombol.setPreferredSize(new Dimension(110, 32));
    }

    // method buat ngatur tampilan textfield
    private void aturTextField(JTextField tf) {
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tf.setForeground(warnaTeks);
        tf.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(warnaGaris, 1),
                new EmptyBorder(4, 6, 4, 6)));
    }

    // method buat ngatur tampilan label
    private void aturLabel(JLabel lbl) {
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(warnaTeks);
    }

    // Frame & isinya
    public void launchFrame() {
        // layout utama frame pakai BorderLayout
        frame.setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(warnaBackground);

        // panel judul (atas)
        panelJudul.setLayout(new BorderLayout());
        panelJudul.setBackground(warnaJudul);
        panelJudul.setBorder(new EmptyBorder(12, 10, 12, 10));
        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblJudul.setForeground(warnaTeks);
        panelJudul.add(lblJudul, BorderLayout.CENTER);

        // panel input pakai GridBagLayout 
        // kolom label dibuat sempit, kolom textfield melebar
        panelInput.setLayout(new GridBagLayout());
        panelInput.setBackground(warnaBackground);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        aturLabel(lblNama);
        aturLabel(lblNim);
        aturLabel(lblJurusan);
        aturTextField(tfNama);
        aturTextField(tfNim);
        aturTextField(tfJurusan);

        // baris 1 : Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelInput.add(lblNama, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInput.add(tfNama, gbc);

        // baris 2 : NIM
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelInput.add(lblNim, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInput.add(tfNim, gbc);

        // baris 3 : Jurusan
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelInput.add(lblJurusan, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInput.add(tfJurusan, gbc);

        //  panel tombol pakai FlowLayout 
        panelTombol.setLayout(new FlowLayout(FlowLayout.CENTER, 12, 8));
        panelTombol.setBackground(warnaBackground);
        aturTombol(btnTambah, warnaTambah);
        aturTombol(btnHapus, warnaHapus);
        aturTombol(btnKeluar, warnaKeluar);
        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnKeluar);

        //  panel output (bawah)
        areaOutput.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaOutput.setForeground(warnaTeks);
        areaOutput.setMargin(new Insets(6, 8, 6, 8));

        JScrollPane scroll = new JScrollPane(areaOutput);
        scroll.setBorder(new LineBorder(warnaGaris, 1));

        panelOutput.setLayout(new BorderLayout());
        panelOutput.setBackground(warnaBackground);
        panelOutput.setBorder(new EmptyBorder(0, 16, 16, 16));
        JLabel lblOutput = new JLabel("Daftar Mahasiswa");
        aturLabel(lblOutput);
        lblOutput.setBorder(new EmptyBorder(0, 0, 6, 0));
        panelOutput.add(lblOutput, BorderLayout.NORTH);
        panelOutput.add(scroll, BorderLayout.CENTER);

        // panel yang isinya input + tombol, ditaruh di tengah
        JPanel panelTengah = new JPanel();
        panelTengah.setLayout(new BorderLayout());
        panelTengah.setBackground(warnaBackground);
        panelTengah.setBorder(new EmptyBorder(14, 16, 4, 16));
        panelTengah.add(panelInput, BorderLayout.NORTH);
        panelTengah.add(panelTombol, BorderLayout.CENTER);

        // daftarin listener ke tombol (source registers listener)
        // "this" dikirim supaya handler bisa akses komponen di form ini
        TambahHandler tambahListener = new TambahHandler(this);
        btnTambah.addActionListener(tambahListener);
        btnHapus.addActionListener(new HapusHandler(this));
        btnKeluar.addActionListener(new KeluarHandler());

        // tekan Enter di textfield jurusan sama aja kayak klik Tambah
        tfJurusan.addActionListener(tambahListener);

        // masukin semua ke frame
        frame.add(panelJudul, BorderLayout.NORTH);
        frame.add(panelTengah, BorderLayout.CENTER);
        frame.add(panelOutput, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // biar muncul di tengah layar
        frame.setVisible(true);
    }

    // getter, soalnya handler ada di file lain jadi gak bisa akses private langsung
    public JFrame getFrame() {
        return frame;
    }

    public JTextField getTfNama() {
        return tfNama;
    }

    public JTextField getTfNim() {
        return tfNim;
    }

    public JTextField getTfJurusan() {
        return tfJurusan;
    }

    public JTextArea getAreaOutput() {
        return areaOutput;
    }
}
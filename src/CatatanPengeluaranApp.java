import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Pengeluaran {
    String nama;
    String jenis;
    double nominal;
    String tanggal;

    public Pengeluaran(String nama, String jenis, double nominal, String tanggal) {
        this.nama = nama;
        this.jenis = jenis;
        this.nominal = nominal;
        this.tanggal = tanggal;
    }
}

public class CatatanPengeluaranApp {
    private JFrame frame;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnInput;
    private JButton btnLihat;
    private JButton btnAnalisis;
    private JButton btnRencana;
    private JButton btnUtang;
    private JTextField tfNama;
    private JTextField tfJenis;
    private JTextField tfNominal;
    private JTextField tfTanggal;
    private JTextArea taPengeluaran;
    private JTextField tfPendapatan;
    private JTextField tfTargetAnggaran;
    private JTextArea taRencanaAnggaran;
    private JTextArea taManajemenUtang;

    private ArrayList<Pengeluaran> listPengeluaran = new ArrayList<>();
    private double pendapatan = 0;
    private double totalPengeluaran = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new CatatanPengeluaranApp();
        });
    }

    public CatatanPengeluaranApp() {
        initializeLogin();
    }

    private void initializeLogin() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        frame.setLayout(null);

        JLabel lblTitle = new JLabel("TRACKMO - Tracking Your Money");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(50, 10, 400, 30);
        frame.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 70, 100, 20);
        frame.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 70, 150, 20);
        frame.add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 110, 100, 20);
        frame.add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 110, 150, 20);
        frame.add(pfPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 150, 80, 30);
        frame.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateLogin()) {
                    frame.getContentPane().removeAll();
                    initializeApp();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login failed. Please check your credentials.");
                }
            }
        });

        frame.setVisible(true);
    }

    private boolean validateLogin() {
        // Implement your login validation logic here
        // For simplicity, let's consider it always successful
        return true;
    }

    private void initializeApp() {
        frame.getContentPane().setBackground(new Color(173, 216, 230));
        frame.setBounds(100, 100, 800, 600);

        JLabel lblTitle = new JLabel("TRACKMO - Tracking Your Money");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(400, 10, 400, 30);
        frame.add(lblTitle);

        btnInput = new JButton("Input Pengeluaran");
        btnInput.setBounds(50, 70, 150, 30);
        frame.add(btnInput);

        btnLihat = new JButton("Lihat Pengeluaran");
        btnLihat.setBounds(50, 120, 150, 30);
        frame.add(btnLihat);

        btnAnalisis = new JButton("Analisis dan Laporan Keuangan");
        btnAnalisis.setBounds(50, 170, 250, 30);
        frame.add(btnAnalisis);

        btnRencana = new JButton("Rencana Keuangan dan Anggaran");
        btnRencana.setBounds(50, 220, 250, 30);
        frame.add(btnRencana);

        btnUtang = new JButton("Manajemen Utang dan Hutang");
        btnUtang.setBounds(50, 270, 250, 30);
        frame.add(btnUtang);

        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInputPanel();
            }
        });

        btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLihatPanel();
            }
        });

        btnAnalisis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAnalisisPanel();
            }
        });

        btnRencana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRencanaPanel();
            }
        });

        btnUtang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUtangPanel();
            }
        });

        frame.setVisible(true);
    }

    private void showInputPanel() {
        frame.getContentPane().removeAll();

        JLabel lblTitle = new JLabel("TRACKMO - Tracking Your Money");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(400, 10, 400, 30);
        frame.add(lblTitle);

        JLabel lblNama = new JLabel("Nama Pengeluaran:");
        lblNama.setBounds(50, 70, 150, 20);
        frame.add(lblNama);

        tfNama = new JTextField();
        tfNama.setBounds(200, 70, 200, 20);
        frame.add(tfNama);

        JLabel lblJenis = new JLabel("Jenis Pengeluaran:");
        lblJenis.setBounds(50, 110, 150, 20);
        frame.add(lblJenis);

        tfJenis = new JTextField();
        tfJenis.setBounds(200, 110, 200, 20);
        frame.add(tfJenis);

        JLabel lblNominal = new JLabel("Nominal:");
        lblNominal.setBounds(50, 150, 150, 20);
        frame.add(lblNominal);

        tfNominal = new JTextField();
        tfNominal.setBounds(200, 150, 200, 20);
        frame.add(tfNominal);

        JLabel lblTanggal = new JLabel("Tanggal:");
        lblTanggal.setBounds(50, 190, 150, 20);
        frame.add(lblTanggal);

        tfTanggal = new JTextField();
        tfTanggal.setBounds(200, 190, 200, 20);
        frame.add(tfTanggal);

        JButton btnInputPengeluaran = new JButton("Input Pengeluaran");
        btnInputPengeluaran.setBounds(50, 230, 150, 30);
        frame.add(btnInputPengeluaran);

        taPengeluaran = new JTextArea();
        taPengeluaran.setBounds(450, 70, 300, 400);
        frame.add(taPengeluaran);

        btnInputPengeluaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPengeluaran();
                updateTextArea();
            }
        });

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(600, 500, 150, 30);
        frame.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApp();
            }
        });

        frame.setVisible(true);
    }

    private void showLihatPanel() {
        frame.getContentPane().removeAll();

        JLabel lblTitle = new JLabel("TRACKMO - Tracking Your Money");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(400, 10, 400, 30);
        frame.add(lblTitle);

        taPengeluaran = new JTextArea();
        taPengeluaran.setBounds(50, 70, 500, 400);
        frame.add(taPengeluaran);

        updateTextArea();

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(600, 500, 150, 30);
        frame.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApp();
            }
        });

        frame.setVisible(true);
    }

    private void showAnalisisPanel() {
        frame.getContentPane().removeAll();

        // Implementasikan logika untuk menampilkan analisis dan laporan keuangan
        // ...

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(600, 500, 150, 30);
        frame.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApp();
            }
        });

        frame.setVisible(true);
    }

    private void showRencanaPanel() {
        frame.getContentPane().removeAll();

        JLabel lblTitle = new JLabel("TRACKMO - Tracking Your Money");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(400, 10, 400, 30);
        frame.add(lblTitle);

        JLabel lblPendapatan = new JLabel("Pendapatan Bulanan:");
        lblPendapatan.setBounds(50, 70, 150, 20);
        frame.add(lblPendapatan);

        tfPendapatan = new JTextField();
        tfPendapatan.setBounds(200, 70, 200, 20);
        frame.add(tfPendapatan);

        JLabel lblTargetAnggaran = new JLabel("Target Anggaran Bulanan:");
        lblTargetAnggaran.setBounds(50, 110, 150, 20);
        frame.add(lblTargetAnggaran);

        tfTargetAnggaran = new JTextField();
        tfTargetAnggaran.setBounds(200, 110, 200, 20);
        frame.add(tfTargetAnggaran);

        JButton btnSimpanRencana = new JButton("Simpan Rencana");
        btnSimpanRencana.setBounds(50, 150, 150, 30);
        frame.add(btnSimpanRencana);

        taRencanaAnggaran = new JTextArea();
        taRencanaAnggaran.setBounds(450, 70, 300, 400);
        frame.add(taRencanaAnggaran);

        btnSimpanRencana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanRencana();
                updateRencanaTextArea();
            }
        });

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(600, 500, 150, 30);
        frame.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApp();
            }
        });

        frame.setVisible(true);
    }

    private void simpanRencana() {
        pendapatan = Double.parseDouble(tfPendapatan.getText());
        double targetAnggaran = Double.parseDouble(tfTargetAnggaran.getText());

        // Reset input fields
        tfPendapatan.setText("");
        tfTargetAnggaran.setText("");

        // Simpan data rencana anggaran
        String rencana = "Pendapatan Bulanan: " + pendapatan + "\n"
                + "Target Anggaran Bulanan: " + targetAnggaran + "\n\n";
        taRencanaAnggaran.setText(rencana);
    }

    private void updateRencanaTextArea() {
        taRencanaAnggaran.append("Akumulasi Pengeluaran Bulan Ini: " + totalPengeluaran + "\n\n");
    }

    private void showUtangPanel() {
        frame.getContentPane().removeAll();

        // Implementasikan logika untuk menampilkan manajemen utang dan hutang
        // ...

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setBounds(600, 500, 150, 30);
        frame.add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeApp();
            }
        });

        frame.setVisible(true);
    }

    private void inputPengeluaran() {
        String nama = tfNama.getText();
        String jenis = tfJenis.getText();
        double nominal = Double.parseDouble(tfNominal.getText());
        String tanggal = tfTanggal.getText();

        Pengeluaran pengeluaran = new Pengeluaran(nama, jenis, nominal, tanggal);
        listPengeluaran.add(pengeluaran);
        totalPengeluaran += nominal;

        // Reset input fields
        tfNama.setText("");
        tfJenis.setText("");
        tfNominal.setText("");
        tfTanggal.setText("");
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (Pengeluaran pengeluaran : listPengeluaran) {
            sb.append("Nama: ").append(pengeluaran.nama).append(", ");
            sb.append("Jenis: ").append(pengeluaran.jenis).append(", ");
            sb.append("Nominal: ").append(pengeluaran.nominal).append(", ");
            sb.append("Tanggal: ").append(pengeluaran.tanggal).append("\n");
        }
        taPengeluaran.setText(sb.toString());
    }
}

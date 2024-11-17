import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe UI", Font.PLAIN, 16); // Fonte suave e delicada

    public void initialize() {
        /******** FORM PANEL *****************************/
        JLabel lbUsername = new JLabel("Seu nominho :");
        lbUsername.setFont(mainFont);
        lbUsername.setForeground(Color.BLACK); // Preto para contraste

        JTextField tfUsername = new JTextField();
        tfUsername.setFont(mainFont);
        tfUsername.setBackground(new Color(255, 228, 225)); // Rosa claro
        tfUsername.setForeground(Color.BLACK); // Texto em preto

        JLabel lbPassword = new JLabel("sua senhazinha :");
        lbPassword.setFont(mainFont);
        lbPassword.setForeground(Color.BLACK);

        JPasswordField pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);
        pfPassword.setBackground(new Color(255, 228, 225));
        pfPassword.setForeground(Color.BLACK);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setFont(mainFont);
        btnLogin.setBackground(Color.PINK);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borda em preto

        // Adiciona ActionListener ao botão
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                if ("wombats".equals(username) && "wombats".equals(password)) {
                    try {
                        // Caminho do arquivo HTML que você criou
                        File htmlFile = new File("C:\\Users\\giova\\Desktop\\java\\PrimeiroProjeto\\lemurs.html"); // Caminho corrigido
                        Desktop.getDesktop().browse(htmlFile.toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(MainFrame.this, "Erro ao abrir a página!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1, 10, 10));
        formPanel.setBackground(new Color(245, 222, 230)); // Fundo rosa pastel
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.add(btnLogin);

        /******** MAIN PANEL *****************************/
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 192, 203)); // Fundo principal em rosa suave
        mainPanel.add(formPanel, BorderLayout.CENTER);

        /******** FRAME SETTINGS *****************************/
        add(mainPanel);

        setTitle("Login Delicado ✨");
        setSize(400, 400);
        setMinimumSize(new Dimension(300, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.initialize();
    }
}

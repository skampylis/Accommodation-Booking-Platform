package GUI;
import Logic.*;

import javax.swing.*;
import java.awt.*;

public class UserInterfaceGUI extends JDialog {

    private final UserLogin userLogin;

    private final UserRegistration userRegistration;

    private final UsersList allUsers;

    private final BookingsList allBookings;

    private final AccommodationsList allAccommodations;

    public UserInterfaceGUI(UsersList allUsers, BookingsList allBookings, AccommodationsList allAccommodations) {
        this.allUsers = allUsers;
        this.allBookings = allBookings;
        this.allAccommodations = allAccommodations;
        this.userLogin = new UserLogin(allUsers);
        this.userRegistration = new UserRegistration(allUsers);
    }

    public void loginVerification(int number) {
        JLabel label1 = new JLabel("Username:");
        JTextField textField1 = new JTextField(20);
        JLabel label2 = new JLabel("Password:");
        JTextField textField2 = new JPasswordField(20);
        JButton button = new JButton("Next");
        JLabel label3 = new JLabel();
        JFrame logInMenu = new JFrame("Login Menu");
        logInMenu.setSize(1000, 500);
        logInMenu.setLocationRelativeTo(null);
        logInMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        logInMenu.setLayout(new GridLayout(0,2,10,20));
        switch (number) {
            case 1 -> button.addActionListener(e -> {
                AccommodationProvider  accommodationProvider = (AccommodationProvider) userLogin.userLoginVerification(textField1.getText(),textField2.getText(),1);
                if (accommodationProvider != null) {
                    printingMenuAccommodationProvider(accommodationProvider);
                    logInMenu.dispose();
                } else {
                    label3.setText("Wrong input.Please try again!");
                }
            });
            case 2 -> button.addActionListener(e -> {
                Client client = (Client) userLogin.userLoginVerification(textField1.getText(),textField2.getText(),2);
                if (client != null) {
                    printingMenuClient(client);
                    logInMenu.dispose();
                } else {
                    label3.setText("Wrong input.Please try again!");
                }
            });
            case 3 -> button.addActionListener(e -> {
                Administrator administrator = (Administrator)userLogin.userLoginVerification(textField1.getText(),textField2.getText(),3);
                if (administrator != null) {
                    printingMenuAdministrator(administrator);
                    logInMenu.dispose();
                } else {
                    label3.setText("Wrong input.Please try again!");
                }
            });
        }

        logInMenu.add(label1);
        logInMenu.add(textField1);
        logInMenu.add(label2);
        logInMenu.add(textField2);
        logInMenu.add(label3);
        logInMenu.add(button);
        logInMenu.pack();
        logInMenu.setLocationRelativeTo(null);
        logInMenu.setVisible(true);

    }

    public void printingMenuAccommodationProvider(AccommodationProvider accommodationProvider) {
         new AccommodationProviderGUI(accommodationProvider,allUsers,allAccommodations,allBookings);
    }

    public void printingMenuClient(Client client) {
        new ClientGUI(client,allUsers,allAccommodations,allBookings);
    }

    public void printingMenuAdministrator(Administrator administrator) {
        new AdministratorGUI(administrator,allUsers,allAccommodations,allBookings);
    }

    public void startingMenuNewAccount() {
        JButton newAccommodationProvider = new JButton("New Accommodation Provider");
        newAccommodationProvider.addActionListener(e -> {
            JLabel label1 = new JLabel("Username:");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel("Password:");
            JTextField textField2 = new JTextField(20);
            JLabel label3 = new JLabel("Email:");
            JTextField textField3 = new JTextField(20);
            JLabel label4 = new JLabel("Seat:");
            JComboBox<String> comboBox = new JComboBox<>();
            comboBox.addItem("Athens");
            comboBox.addItem("Thessaloniki");
            JLabel label5 = new JLabel();
            JButton create = new JButton("Create");
            create.addActionListener(e1 -> {
                if (userRegistration.userCreatesAccommodationProvider(textField1.getText(),textField2.getText(),textField3.getText(),(String)comboBox.getSelectedItem())){
                    label5.setText("Account created!");
                } else {
                    label5.setText("Something went wrong(@gmail.com).Please try again!");
                }
            });

            JFrame createAccommodationProvider = new JFrame("Accommodation Provider Sign Up");
            createAccommodationProvider.setSize(1000, 500);
            createAccommodationProvider.setLocationRelativeTo(null);
            createAccommodationProvider.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            createAccommodationProvider.setLayout(new GridLayout(0,2,10,20));

            createAccommodationProvider.add(label1);
            createAccommodationProvider.add(textField1);
            createAccommodationProvider.add(label2);
            createAccommodationProvider.add(textField2);
            createAccommodationProvider.add(label3);
            createAccommodationProvider.add(textField3);
            createAccommodationProvider.add(label4);
            createAccommodationProvider.add(comboBox);
            createAccommodationProvider.add(create);
            createAccommodationProvider.add(label5);
            createAccommodationProvider.pack();
            createAccommodationProvider.setLocationRelativeTo(null);
            createAccommodationProvider.setVisible(true);
        });

        JButton newClient = new JButton("New Client");
        newClient.addActionListener(e -> {
            JLabel label1 = new JLabel("Username:");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel("Password:");
            JTextField textField2 = new JTextField(20);
            JLabel label3 = new JLabel("Email:");
            JTextField textField3 = new JTextField(20);
            JButton create = new JButton("Create");
            JLabel label4 = new JLabel();
            create.addActionListener(e12 -> {
                if(userRegistration.userCreatesClient(textField1.getText(),textField2.getText(),textField3.getText())){
                    label4.setText("Account created!");
                }else {
                    label4.setText("Something went wrong(@gmail.com).");
                    dispose();
                }
            });
            JFrame client = new JFrame("Client Sign Up");
            client.setSize(1000, 500);
            client.setLocationRelativeTo(null);
            client.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            client.setLayout(new GridLayout(0, 2,10,20));

            client.add(label1);
            client.add(textField1);
            client.add(label2);
            client.add(textField2);
            client.add(label3);
            client.add(textField3);
            client.add(create);
            client.add(label4);
            client.pack();
            client.setLocationRelativeTo(null);
            client.setVisible(true);
        });

        JLabel label1 = new JLabel("Choose your role:");
        JButton back = new JButton("Back");
        back.addActionListener(e -> dispose());
        JFrame signUpWindow = new JFrame("Sign Up");
        signUpWindow.setSize(1000, 500);
        signUpWindow.setLocationRelativeTo(null);
        signUpWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpWindow.setLayout(new GridLayout(4, 1));

        signUpWindow.add(label1);
        signUpWindow.add(newAccommodationProvider);
        signUpWindow.add(newClient);
        signUpWindow.setLocationRelativeTo(null);
        signUpWindow.setVisible(true);

    }

}

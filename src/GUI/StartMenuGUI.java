package GUI;

import Logic.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StartMenuGUI extends JFrame {

    public StartMenuGUI(UsersList allUsers, BookingsList allBookings, AccommodationsList allAccommodations) {
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("usersList.dat"))) {
            allUsers = (UsersList) in1.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("accommodationsList.dat"))) {
            allAccommodations = (AccommodationsList) in2.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("bookingsList.dat"))) {
            allBookings = (BookingsList) in3.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        JFrame mainWindow = new JFrame("My Booking!");
        mainWindow.setSize(1000, 500);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new GridLayout(3, 1));

        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");
        JButton exitButton = new JButton("Exit Application");
        signInButton.setBackground(Color.WHITE);
        signInButton.setForeground(Color.BLACK);

        signUpButton.setBackground(Color.WHITE);
        signUpButton.setForeground(Color.BLACK);

        mainWindow.add(signInButton);
        mainWindow.add(signUpButton);
        mainWindow.add(exitButton);
        mainWindow.setVisible(true);

        UserInterfaceGUI userInterfaceGUI = new UserInterfaceGUI(allUsers, allBookings, allAccommodations);

        signInButton.addActionListener(e -> {
            JButton accommodationProviderButton = new JButton("Accommodation Provider");
            accommodationProviderButton.addActionListener(e1 -> userInterfaceGUI.loginVerification(1));
            JButton clientButton = new JButton("Client");
            clientButton.addActionListener(e2 -> userInterfaceGUI.loginVerification(2));
            JButton administratorButton = new JButton("Administrator");
            administratorButton.addActionListener(e3 -> userInterfaceGUI.loginVerification(3));
            JLabel label1 = new JLabel("Sign In as:");
            JFrame signInWindow = new JFrame("Sign In as:");
            signInWindow.setSize(1000, 500);
            signInWindow.setLocationRelativeTo(null);
            signInWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            signInWindow.setLayout(new GridLayout(0, 1,10,20));

            signInWindow.add(label1);
            signInWindow.add(accommodationProviderButton);
            signInWindow.add(clientButton);
            signInWindow.add(administratorButton);
            signInWindow.setVisible(true);

        });

        signUpButton.addActionListener(e -> userInterfaceGUI.startingMenuNewAccount());

        UsersList finalAllUsers = allUsers;
        AccommodationsList finalAllAccommodations = allAccommodations;
        BookingsList finalAllBookings = allBookings;
        exitButton.addActionListener(e -> {
            new WriteObjectsInFiles(finalAllUsers, finalAllAccommodations, finalAllBookings);
            System.exit(0);
        });
    }
}
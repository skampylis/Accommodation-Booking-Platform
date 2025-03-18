package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccommodationProviderGUI {

    private final CheckingClass checkingClass = new CheckingClass();

    private void printAccommodations(ArrayList<Accommodation> list) {

        JFrame printAccommodation = new JFrame("Accommodation Provider's Menu");
        printAccommodation.setSize(1000, 500);
        printAccommodation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        printAccommodation.setLayout(new GridLayout(0,1,20,20));
        int counter = 1;
        for(Accommodation acc : list) {
            JLabel label0 = new JLabel(counter + ": " + "code:" + acc.getCode() + " " + " ,square meters:" + acc.getSquareMeters() + " " +
                    " ,price/night:" + acc.getPricePerNight() + " " + ",Number of beds:" + " " + acc.getBeds() + " " + ",Number of rooms:" + " " +
                    acc.getRooms() + " " + " ,Type:" + acc.getType() + " " + " ,Seat:" + acc.getSeat());

            printAccommodation.add(label0);
            printAccommodation.pack();
            printAccommodation.setLocationRelativeTo(null);
            printAccommodation.setVisible(true);
            counter++;
        }
    }

    public AccommodationProviderGUI(AccommodationProvider accommodationProvider,UsersList allUsers,AccommodationsList allAccommodations,BookingsList allBookings){
        JButton button1 = new JButton("Add Accommodation");
        JButton button2 = new JButton("Show Accommodations");
        JButton button3 = new JButton("Remove an Accommodation");
        JButton button4 = new JButton("Accommodation Processing");
        JButton button5 = new JButton("Show Profile Information");
        JButton button6 = new JButton("Show Messages");
        JButton button7 = new JButton("Sign Out");
        JLabel labelMain = new JLabel();

        JFrame accommodationProviderMenu = new JFrame("Accommodation Provider's Menu");
        accommodationProviderMenu.setSize(1000, 500);
        accommodationProviderMenu.setLocationRelativeTo(null);
        accommodationProviderMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accommodationProviderMenu.setLayout(new GridLayout(0,1,10,20));

        button1.addActionListener(e -> {
            JLabel label1 = new JLabel("Choose the type of accommodation you want to add:");
            JLabel labelExtra = new JLabel();
            JLabel label = new JLabel();
            JButton button8 = new JButton("New Apartment");
            button8.addActionListener(e1 -> {

                JLabel label2 = new JLabel("Give the Code of the Accommodation:");
                JTextField textField1 = new JTextField(20);
                JLabel label3 = new JLabel("Give the Price per Night:");
                JTextField textField2 = new JTextField(20);
                JLabel label4 = new JLabel("Give the Square Meters of the Accommodation:");
                JTextField textField3 = new JTextField(20);
                JLabel label5 = new JLabel("Number of beds");
                JComboBox<Integer> comboBox1 = new JComboBox<>();
                comboBox1.addItem(1);
                comboBox1.addItem(2);
                comboBox1.addItem(3);
                comboBox1.addItem(4);
                comboBox1.addItem(5);

                JLabel label6 = new JLabel("Floor");
                JComboBox<Integer> comboBox2 = new JComboBox<>();
                comboBox2.addItem(1);
                comboBox2.addItem(2);
                comboBox2.addItem(3);
                comboBox2.addItem(4);
                comboBox2.addItem(5);
                comboBox2.addItem(6);
                comboBox2.addItem(7);
                comboBox2.addItem(8);

                JLabel label7 = new JLabel("Number of rooms");
                JComboBox<Integer> comboBox4 = new JComboBox<>();
                comboBox4.addItem(1);
                comboBox4.addItem(2);
                comboBox4.addItem(3);
                comboBox4.addItem(4);
                comboBox4.addItem(5);
                comboBox4.addItem(6);

                JFrame addApartmentMenu = new JFrame("Accommodation Provider's Menu");
                addApartmentMenu.setSize(1000, 500);
                addApartmentMenu.setLocationRelativeTo(null);
                addApartmentMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addApartmentMenu.setLayout(new GridLayout(0,2,10,20));

                JButton addButton = new JButton("Add");
                addButton.addActionListener(e4 -> {
                    if(checkingClass.checkCode(textField1.getText())) {
                        if(checkingClass.checkPrice(textField2.getText())) {
                            if(checkingClass.checkSqMeters(textField3.getText())) {
                                int code = Integer.parseInt(textField1.getText());
                                if (checkingClass.checkDigitsOfCodeName(code)) {
                                    Accommodation acc = new Accommodation();
                                    for(Accommodation acc1 : allAccommodations.getAccommodationsList()) {
                                        if(acc1.getCode() == code) {
                                            acc = acc1;
                                        }
                                    }
                                    if(acc.getCode() == 0) {
                                        Accommodation accommodation = new Apartment(code, textField2.getText(), textField3.getText(), accommodationProvider.getSeat(), comboBox1.getSelectedIndex() + 1, comboBox2.getSelectedIndex(), comboBox4.getSelectedIndex());
                                        accommodationProvider.addNewAccommodation(accommodation);
                                        allAccommodations.addAccommodation(accommodation);
                                        labelExtra.setText("Accommodation added!");
                                        addApartmentMenu.dispose();
                                        new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                                    } else {
                                        label.setText("Accommodation with the same code already exists!Please give a different one!");
                                    }
                                } else {
                                    label.setText("The code is Invalid!Please give a four digit number!");
                                }
                            } else {
                                label.setText("The square meters is invalid!Please give the square Meters in number!");
                            }
                        } else {
                            label.setText("The price is invalid!Please give the price in number!");
                        }
                    } else {
                        label.setText("The code is invalid!Please give a four digit number!");
                    }
                });

                addApartmentMenu.add(label2);
                addApartmentMenu.add(textField1);
                addApartmentMenu.add(label3);
                addApartmentMenu.add(textField2);
                addApartmentMenu.add(label4);
                addApartmentMenu.add(textField3);
                addApartmentMenu.add(label5);
                addApartmentMenu.add(comboBox1);
                addApartmentMenu.add(label6);
                addApartmentMenu.add(comboBox2);
                addApartmentMenu.add(label7);
                addApartmentMenu.add(comboBox4);
                addApartmentMenu.add(addButton);
                addApartmentMenu.add(label);
                addApartmentMenu.pack();
                addApartmentMenu.setLocationRelativeTo(null);
                addApartmentMenu.setVisible(true);

            });

            JButton button9 = new JButton("New Hotel Room");
            button9.addActionListener(e2 -> {
                JLabel label2 = new JLabel("Give the Code of the Accommodation:");
                JTextField textField1 = new JTextField(20);
                JLabel label3 = new JLabel("Give the Price per Night:");
                JTextField textField2 = new JTextField(20);
                JLabel label4 = new JLabel("Give the Square Meters of the Accommodation:");
                JTextField textField3 = new JTextField(20);
                JLabel label5 = new JLabel("Number of beds");
                JComboBox<Integer> comboBox1 = new JComboBox<>();
                comboBox1.addItem(1);
                comboBox1.addItem(2);
                comboBox1.addItem(3);
                comboBox1.addItem(4);
                comboBox1.addItem(5);

                JLabel label6 = new JLabel("Floor");
                JComboBox<Integer> comboBox2 = new JComboBox<>();
                comboBox2.addItem(1);
                comboBox2.addItem(2);
                comboBox2.addItem(3);
                comboBox2.addItem(4);
                comboBox2.addItem(5);
                comboBox2.addItem(6);
                comboBox2.addItem(7);
                comboBox2.addItem(8);

                JFrame addHotelRoomMenu = new JFrame("Accommodation Provider's Menu");
                addHotelRoomMenu.setSize(1000, 500);
                addHotelRoomMenu.setLocationRelativeTo(null);
                addHotelRoomMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addHotelRoomMenu.setLayout(new GridLayout(0,2,10,20));

                JButton addButton = new JButton("Add");
                addButton.addActionListener(e4 -> {
                    if(checkingClass.checkCode(textField1.getText())) {
                        if (checkingClass.checkPrice(textField2.getText())) {
                            if (checkingClass.checkSqMeters(textField3.getText())) {
                                int code = Integer.parseInt(textField1.getText());
                                if (checkingClass.checkDigitsOfCodeName(code)) {
                                    Accommodation acc = new Accommodation();
                                    for (Accommodation acc1 : allAccommodations.getAccommodationsList()) {
                                        if(acc1.getCode() == code) {
                                            acc = acc1;
                                        }
                                    }
                                    if(acc.getCode() == 0) {
                                        Accommodation accommodation = new HotelRoom(code, textField2.getText(), textField3.getText(), accommodationProvider.getSeat(), comboBox1.getSelectedIndex() + 1, comboBox2.getSelectedIndex(), 1);
                                        accommodationProvider.addNewAccommodation(accommodation);
                                        allAccommodations.addAccommodation(accommodation);
                                        labelExtra.setText("Accommodation added!");
                                        addHotelRoomMenu.dispose();
                                        new WriteObjectsInFiles(allUsers, allAccommodations, allBookings);
                                    }else{
                                        label.setText("Accommodation with the same code already exists!Please give a different one!");
                                    }
                                } else {
                                    label.setText("The coe is Invalid!Please give a four digit number!");
                                }
                            }else{
                                label.setText("The square meters is invalid!Please give the square Meters in number!");
                            }
                        }else{
                            label.setText("The price is invalid!Please give the price in number!");
                        }
                    }else {
                        label.setText("The code is invalid!Please give a four digit number!");
                    }
                });

                addHotelRoomMenu.add(label2);
                addHotelRoomMenu.add(textField1);
                addHotelRoomMenu.add(label3);
                addHotelRoomMenu.add(textField2);
                addHotelRoomMenu.add(label4);
                addHotelRoomMenu.add(textField3);
                addHotelRoomMenu.add(label5);
                addHotelRoomMenu.add(comboBox1);
                addHotelRoomMenu.add(label6);
                addHotelRoomMenu.add(comboBox2);
                addHotelRoomMenu.add(addButton);
                addHotelRoomMenu.add(label);
                addHotelRoomMenu.pack();
                addHotelRoomMenu.setLocationRelativeTo(null);
                addHotelRoomMenu.setVisible(true);

            });

            JButton button10 = new JButton("New Maisonette");
            button10.addActionListener(e3 -> {
                JLabel label2 = new JLabel("Give the Code of the Accommodation:");
                JTextField textField1 = new JTextField(20);
                JLabel label3 = new JLabel("Give the Price per Night:");
                JTextField textField2 = new JTextField(20);
                JLabel label4 = new JLabel("Give the Square Meters of the Accommodation:");
                JTextField textField3 = new JTextField(20);
                JLabel label5 = new JLabel("Number of beds");
                JComboBox<Integer> comboBox1 = new JComboBox<>();
                comboBox1.addItem(1);
                comboBox1.addItem(2);
                comboBox1.addItem(3);
                comboBox1.addItem(4);
                comboBox1.addItem(5);
                comboBox1.addItem(6);

                JLabel label7 = new JLabel("Number of rooms");
                JComboBox<Integer> comboBox4 = new JComboBox<>();
                comboBox4.addItem(1);
                comboBox4.addItem(2);
                comboBox4.addItem(3);
                comboBox4.addItem(4);
                comboBox4.addItem(5);
                comboBox4.addItem(6);

                JLabel label11 = new JLabel("Has pool");
                JLabel label12 = new JLabel("Number of floors");
                JComboBox<Integer> comboBox3 = new JComboBox<>();
                comboBox3.addItem(1);
                comboBox3.addItem(2);
                comboBox3.addItem(3);
                JCheckBox checkBox =new JCheckBox();

                JFrame addMaisonetteMenu = new JFrame("Accommodation Provider's Menu");
                addMaisonetteMenu.setSize(1000, 500);
                addMaisonetteMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addMaisonetteMenu.setLayout(new GridLayout(0,2,10,20));

                JButton addButton = new JButton("Add");
                addButton.addActionListener(e4 -> {
                    if (checkingClass.checkCode(textField1.getText())) {
                        if (checkingClass.checkPrice(textField2.getText())) {
                            if (checkingClass.checkSqMeters(textField3.getText())) {
                                int code = Integer.parseInt(textField1.getText());
                                if (checkingClass.checkDigitsOfCodeName(code)) {
                                    Accommodation acc = new Accommodation();
                                    for (Accommodation acc1 : allAccommodations.getAccommodationsList()) {
                                        if(acc1.getCode() == code) {
                                            acc = acc1;
                                        }
                                    }
                                    if (acc.getCode() == 0) {
                                        Accommodation accommodation = new Maisonette(code, textField2.getText(), textField3.getText(), accommodationProvider.getSeat(), comboBox1.getSelectedIndex() + 1, checkBox.isSelected(), comboBox4.getSelectedIndex(), comboBox3.getSelectedIndex());
                                        accommodationProvider.addNewAccommodation(accommodation);
                                        allAccommodations.addAccommodation(accommodation);
                                        labelExtra.setText("Accommodation added!");
                                        addMaisonetteMenu.dispose();
                                        new WriteObjectsInFiles(allUsers, allAccommodations, allBookings);
                                    }else{
                                        label.setText("Accommodation with the same code already exists!Please give a different one!");
                                    }
                                } else {
                                    label.setText("The code is Invalid!Please give a four digit number!");
                                }
                            }else{
                                label.setText("The square meters is invalid!Please give the square Meters in number!");
                            }
                        }else{
                            label.setText("The price is invalid!Please give the price in number!");
                        }
                    }else {
                        label.setText("The code is invalid!Please give a four digit number!");
                    }
                });

                addMaisonetteMenu.add(label2);
                addMaisonetteMenu.add(textField1);
                addMaisonetteMenu.add(label3);
                addMaisonetteMenu.add(textField2);
                addMaisonetteMenu.add(label4);
                addMaisonetteMenu.add(textField3);
                addMaisonetteMenu.add(label5);
                addMaisonetteMenu.add(comboBox1);
                addMaisonetteMenu.add(label12);
                addMaisonetteMenu.add(comboBox3);
                addMaisonetteMenu.add(label7);
                addMaisonetteMenu.add(comboBox4);
                addMaisonetteMenu.add(label11);
                addMaisonetteMenu.add(checkBox);
                addMaisonetteMenu.add(addButton);
                addMaisonetteMenu.add(label);
                addMaisonetteMenu.pack();
                addMaisonetteMenu.setLocationRelativeTo(null);
                addMaisonetteMenu.setVisible(true);

            });



            JFrame addAccommodationMenu = new JFrame("Accommodation Provider's Menu");
            addAccommodationMenu.setSize(1000, 500);
            addAccommodationMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addAccommodationMenu.setLayout(new GridLayout(0,1,10,20));

            addAccommodationMenu.add(label1);
            addAccommodationMenu.add(button8);
            addAccommodationMenu.add(button9);
            addAccommodationMenu.add(button10);
            addAccommodationMenu.add(labelExtra);
            addAccommodationMenu.setLocationRelativeTo(null);
            addAccommodationMenu.setVisible(true);
        });

        button2.addActionListener(e -> printAccommodations(accommodationProvider.getAccommodationList()));

        button3.addActionListener(e -> {
            JLabel label1 = new JLabel("Give the code of the accommodation you want to be removed:");
            JTextField textField = new JTextField(20);
            JLabel label2 = new JLabel();
            JButton remove = new JButton("Remove");
            JFrame removeAccommodationMenu = new JFrame("Accommodation Provider's Menu");
            removeAccommodationMenu.setSize(1000, 500);
            removeAccommodationMenu.setLocationRelativeTo(null);
            removeAccommodationMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            removeAccommodationMenu.setLayout(new GridLayout(0,2,10,20));

            remove.addActionListener(e1 -> {
                if(checkingClass.checkCode(textField.getText())) {
                    int code = Integer.parseInt(textField.getText());
                    if (checkingClass.checkDigitsOfCodeName(code)) {
                        Accommodation accommodation = new Accommodation();
                        for(Accommodation acc : accommodationProvider.getAccommodationList())
                        {
                            if(acc.getCode() == code)
                            {
                                accommodation = acc;
                            }
                        }
                        if (accommodation.getCode() != 0) {
                            accommodationProvider.removeAccommodation(code, allAccommodations);
                            removeAccommodationMenu.dispose();
                            labelMain.setText("Accommodation removed!");
                            new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                        } else {
                            label2.setText("There is not accommodation with such code.Please try again!");
                        }
                    } else {
                        label2.setText("Wrong Input.Please give a four digit number!");
                    }
                }else {
                    label2.setText("Wrong Input.Please give a four digit number!");
                }
            });

            removeAccommodationMenu.add(label1);
            removeAccommodationMenu.add(textField);
            removeAccommodationMenu.add(label2);
            removeAccommodationMenu.add(remove);
            removeAccommodationMenu.pack();
            removeAccommodationMenu.setLocationRelativeTo(null);
            removeAccommodationMenu.setVisible(true);
        });

        button4.addActionListener(e -> {
            JLabel label1 = new JLabel("Give the code of the accommodation you want to process:");
            JTextField textField = new JTextField(20);
            JLabel label2 = new JLabel();
            JButton next = new JButton("Next");
            next.addActionListener(e1 -> {
                if(checkingClass.checkCode(textField.getText())) {
                    int code = Integer.parseInt(textField.getText());
                    if (checkingClass.checkDigitsOfCodeName(code)) {
                        Accommodation accommodation = new Accommodation() ;
                        for(Accommodation acc : accommodationProvider.getAccommodationList())
                        {
                            if(acc.getCode() == code)
                            {
                                accommodation = acc;
                            }
                        }
                        if (accommodation.getCode() != 0) {
                            printingProcessMenuOfAccommodation(accommodation,allUsers,allAccommodations,allBookings);
                        } else {
                            label2.setText("There is not accommodation with such code.Please try again!");
                        }
                    }else {
                        label2.setText("Invalid code.Please give four digits number!");
                    }
                }else{
                    label2.setText("Invalid code.Please give four digits number!");
                }
            });

            JFrame processAccommodation = new JFrame("Accommodation Provider's Menu");
            processAccommodation.setSize(1000, 500);
            processAccommodation.setLocationRelativeTo(null);
            processAccommodation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            processAccommodation.setLayout(new GridLayout(0,2,10,20));

            processAccommodation.add(label1);
            processAccommodation.add(textField);
            processAccommodation.add(label2);
            processAccommodation.add(next);
            processAccommodation.pack();
            processAccommodation.setLocationRelativeTo(null);
            processAccommodation.setVisible(true);

        });

        button5.addActionListener(e -> {
            JLabel label1 = new JLabel("UserName: " + accommodationProvider.getName());
            JLabel label2 = new JLabel("Email: " + accommodationProvider.getAddress());
            JLabel label3 = new JLabel("Seat: " + accommodationProvider.getSeat());

            JFrame showProfileInfo = new JFrame("Accommodation Provider's Menu");
            showProfileInfo.setSize(500, 150);
            showProfileInfo.setLocationRelativeTo(null);
            showProfileInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showProfileInfo.setLayout(new GridLayout(0,1,10,20));

            showProfileInfo.add(label1);
            showProfileInfo.add(label2);
            showProfileInfo.add(label3);
            showProfileInfo.setLocationRelativeTo(null);
            showProfileInfo.setVisible(true);
        });

        button6.addActionListener(e -> {
            JFrame showMessages = new JFrame("Accommodation Provider's Menu");
            showMessages.setSize(1000, 500);
            showMessages.setLocationRelativeTo(null);
            showMessages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showMessages.setLayout(new GridLayout(0,1,20,20));

            int counter = 1;
            for(String message : accommodationProvider.getMessages()){
                JLabel label1 = new JLabel(counter + ": " + message);
                showMessages.add(label1);
                showMessages.pack();
                showMessages.setLocationRelativeTo(null);
                showMessages.setVisible(true);
                counter++;
            }
        });

        button7.addActionListener(e -> {
            new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
            accommodationProviderMenu.dispose();
        });

        accommodationProviderMenu.add(button1);
        accommodationProviderMenu.add(button2);
        accommodationProviderMenu.add(button3);
        accommodationProviderMenu.add(button4);
        accommodationProviderMenu.add(button5);
        accommodationProviderMenu.add(button6);
        accommodationProviderMenu.add(button7);
        accommodationProviderMenu.add(labelMain);
        accommodationProviderMenu.setLocationRelativeTo(null);
        accommodationProviderMenu.setVisible(true);

    }

    private void printingProcessMenuOfAccommodation(Accommodation accommodation,UsersList allUsers,AccommodationsList allAccommodations,BookingsList allBookings){
        JButton button1 = new JButton("Change the code of the Accommodation");
        JButton button2 = new JButton("Change the price of the Accommodations");
        JButton button3 = new JButton("Change the square meters of the Accommodation");
        JButton button4 = new JButton("Change the number of beds");
        JButton button5 = new JButton("Change the number of rooms");
        JButton button6 = new JButton("Go Back");
        JLabel label = new JLabel();
        JFrame processAccommodationMenu = new JFrame("Accommodation process Menu");
        processAccommodationMenu.setSize(1000, 500);
        processAccommodationMenu.setLocationRelativeTo(null);
        processAccommodationMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        processAccommodationMenu.setLayout(new GridLayout(0,1,10,20));

        button1.addActionListener(e -> {
            JLabel label1 = new JLabel("Give the new code you want the accommodation to have: ");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel();
            JButton makeChanges = new JButton("Make changes");
            JFrame changeCode = new JFrame("Accommodation process Menu");
            changeCode.setSize(500, 150);
            changeCode.setLocationRelativeTo(null);
            changeCode.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            changeCode.setLayout(new GridLayout(0,2,20,20));

            makeChanges.addActionListener(e1 -> {
                int code = Integer.parseInt(textField1.getText());
                if(checkingClass.checkCode(textField1.getText()) && checkingClass.checkDigitsOfCodeName(code)){
                        accommodation.setCode(code);
                        changeCode.dispose();
                        label.setText("Accommodation Code changed.");
                    new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                    }else{
                        label2.setText("Invalid code.Please give a four digit number!");
                    }
            });
            changeCode.add(label1);
            changeCode.add(textField1);
            changeCode.add(makeChanges);
            changeCode.add(label2);
            changeCode.pack();
            changeCode.setLocationRelativeTo(null);
            changeCode.setVisible(true);
        });

        button2.addActionListener(e -> {
            JLabel label1 = new JLabel("Give the new price you want the accommodation to have: ");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel();
            JButton makeChanges = new JButton("Make changes");
            JFrame changePrice = new JFrame("Accommodation process Menu");
            changePrice.setSize(1000, 500);
            changePrice.setLocationRelativeTo(null);
            changePrice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            changePrice.setLayout(new GridLayout(0,2,20,20));

            makeChanges.addActionListener(e1 -> {
                if(checkingClass.checkPrice(textField1.getText())){
                    accommodation.setPricePerNight(textField1.getText());
                    changePrice.dispose();
                    label.setText("Accommodation price changed.");
                    new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                }else{
                    label2.setText("Invalid price.Please try again!");
                }
            });
            changePrice.add(label1);
            changePrice.add(textField1);
            changePrice.add(makeChanges);
            changePrice.add(label2);
            changePrice.pack();
            changePrice.setLocationRelativeTo(null);
            changePrice.setVisible(true);
        });

        button3.addActionListener(e -> {
            JLabel label1 = new JLabel("Give the new square meters you want the accommodation to have: ");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel();
            JButton makeChanges = new JButton("Make changes");
            JFrame changeSqMeters = new JFrame("Accommodation process Menu");
            changeSqMeters.setSize(500, 150);
            changeSqMeters.setLocationRelativeTo(null);
            changeSqMeters.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            changeSqMeters.setLayout(new GridLayout(0,2,20,20));

            makeChanges.addActionListener(e1 -> {
                if(checkingClass.checkSqMeters(textField1.getText())){
                    accommodation.setPricePerNight(textField1.getText());
                    changeSqMeters.dispose();
                    label.setText("Accommodation square meters changed.");
                    new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                }else{
                    label2.setText("Invalid square meters.Please give a number!");
                }
            });
            changeSqMeters.add(label1);
            changeSqMeters.add(textField1);
            changeSqMeters.add(makeChanges);
            changeSqMeters.add(label2);
            changeSqMeters.pack();
            changeSqMeters.setLocationRelativeTo(null);
            changeSqMeters.setVisible(true);
        });

        button4.addActionListener(e -> {
            JLabel label1 = new JLabel("Number of beds:");
            JComboBox<Integer> comboBox = new JComboBox<>();
            JButton makeChanges = new JButton("Make changes");
            comboBox.addItem(1);
            comboBox.addItem(2);
            comboBox.addItem(3);
            comboBox.addItem(4);
            comboBox.addItem(5);
            comboBox.addItem(6);

            JFrame changeNumberOfBeds = new JFrame("Accommodation process Menu");
            changeNumberOfBeds.setSize(500, 250);
            changeNumberOfBeds.setLocationRelativeTo(null);
            changeNumberOfBeds.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            changeNumberOfBeds.setLayout(new GridLayout(0,2,20,20));

            makeChanges.addActionListener(e1 -> {
                accommodation.setBeds(comboBox.getSelectedIndex() + 1);
                changeNumberOfBeds.dispose();
                label.setText("Number of beds changed");
                new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
            });

            changeNumberOfBeds.add(label1);
            changeNumberOfBeds.add(comboBox);
            changeNumberOfBeds.add(makeChanges);
            changeNumberOfBeds.pack();
            changeNumberOfBeds.setLocationRelativeTo(null);
            changeNumberOfBeds.setVisible(true);
        });

        button5.addActionListener(e -> {
            JLabel label1 = new JLabel("Number of rooms:");
            JComboBox<Integer> comboBox = new JComboBox<>();
            JButton makeChanges = new JButton("Make changes");
            comboBox.addItem(1);
            comboBox.addItem(2);
            comboBox.addItem(3);
            comboBox.addItem(4);
            comboBox.addItem(5);
            comboBox.addItem(6);

            JFrame changeNumberOfRooms = new JFrame("Accommodation process Menu");
            changeNumberOfRooms.setSize(500, 250);
            changeNumberOfRooms.setLocationRelativeTo(null);
            changeNumberOfRooms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            changeNumberOfRooms.setLayout(new GridLayout(0,2,20,20));

            makeChanges.addActionListener(e1 -> {
                accommodation.setRooms(comboBox.getSelectedIndex() + 1);
                changeNumberOfRooms.dispose();
                label.setText("Number of rooms changed");
                new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
            });

            changeNumberOfRooms.add(label1);
            changeNumberOfRooms.add(comboBox);
            changeNumberOfRooms.add(makeChanges);
            changeNumberOfRooms.pack();
            changeNumberOfRooms.setLocationRelativeTo(null);
            changeNumberOfRooms.setVisible(true);
        });

        button6.addActionListener(e -> processAccommodationMenu.dispose());

        processAccommodationMenu.add(button1);
        processAccommodationMenu.add(button2);
        processAccommodationMenu.add(button3);
        processAccommodationMenu.add(button4);
        processAccommodationMenu.add(button5);
        processAccommodationMenu.add(button6);
        processAccommodationMenu.add(label);
        processAccommodationMenu.setLocationRelativeTo(null);
        processAccommodationMenu.setVisible(true);
    }

}

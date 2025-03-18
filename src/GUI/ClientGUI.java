package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClientGUI {

    private final CheckingClass checkingClass = new CheckingClass();


    public ClientGUI(Client client, UsersList allUsers, AccommodationsList allAccommodations, BookingsList allBookings) {
        JButton button1 = new JButton("Search accommodation");
        JButton button3 = new JButton("Cancel booking");
        JButton button4 = new JButton("Show bookings");
        JButton button5 = new JButton("Show cancellations");
        JButton button6 = new JButton("Show messages");
        JButton button7 = new JButton("Show profile info");
        JButton button8 = new JButton("Sign Out");
        JLabel labelMain = new JLabel();

        JFrame clientMenu = new JFrame("Client's Menu");
        clientMenu.setSize(1000, 500);
        clientMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientMenu.setLayout(new GridLayout(0,1,10,20));

        button1.addActionListener(e ->{
            JLabel label2 = new JLabel("Give the maximum price/night you are willing to give:");
            JTextField textField1 = new JTextField(20);
            JLabel label3 = new JLabel("Give the location of the accommodations you wish to search");
            JComboBox<String> comboBox1 = new JComboBox<>();
            comboBox1.addItem("Athens");
            comboBox1.addItem("Thessaloniki");
            JLabel label4 = new JLabel("Give the type of accommodation you wish to search");
            JComboBox<String> comboBox2 = new JComboBox<>();
            comboBox2.addItem("Apartment");
            comboBox2.addItem("Hotel Room");
            comboBox2.addItem("Maisonette");
            JLabel label5 = new JLabel("Give the number of people you will be");
            JComboBox<Integer> comboBox3 = new JComboBox<>();
            comboBox3.addItem(1);
            comboBox3.addItem(2);
            comboBox3.addItem(3);
            comboBox3.addItem(4);
            comboBox3.addItem(5);
            comboBox3.addItem(6);

            JButton search =new JButton("Search");
            JLabel labelExtra = new JLabel();
            JFrame searchMenu = new JFrame("Give the criteria for searching:");
            searchMenu.setSize(1000, 500);
            searchMenu.setLocationRelativeTo(null);
            searchMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            searchMenu.setLayout(new GridLayout(0,2,10,20));

            search.addActionListener(e1 -> {
                if(checkingClass.checkPrice(textField1.getText())){
                    double maxPrice = Double.parseDouble(textField1.getText());
                    String location = (String) comboBox1.getSelectedItem();
                    String type = (String) comboBox2.getSelectedItem();
                    int numberOfPeople = comboBox3.getSelectedIndex() + 1;
                    int counter = 1;
                    JFrame printAccommodation = new JFrame("Accommodation's Menu");
                    printAccommodation.setSize(1000, 500);
                    printAccommodation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    printAccommodation.setLayout(new GridLayout(0,2,20,20));
                    for (Accommodation acc : allAccommodations.getAccommodationsList()) {
                        if(client.checkAccommodationCriteria(maxPrice,location,type,numberOfPeople,acc)){
                            JLabel label0 = new JLabel(counter + ": " + "code:" + acc.getCode() + " " + " ,square meters:" + acc.getSquareMeters() + " " +
                                    " ,price/night:" + acc.getPricePerNight() + " " + ",Number of beds:" + " " + acc.getBeds() + " " + ",Number of rooms:" + " " +
                                    acc.getRooms() + " " + " ,Type:" + acc.getType() + " " + " ,Seat:" + acc.getSeat());
                            JButton book = new JButton("Book Accommodation");

                            book.addActionListener(e2 -> {

                                Date date = new Date();
                                JLabel labelDummy3 = new JLabel();
                                JLabel label00 = new JLabel("From:");
                                JLabel label01 = new JLabel("Day:");
                                JTextField textField01 = new JTextField(10);
                                JLabel label02 = new JLabel("Month:");
                                JTextField textField02 = new JTextField(10);
                                JLabel label03 = new JLabel("Year:");
                                JTextField textField03 = new JTextField(10);
                                JLabel label04 = new JLabel("Until:");
                                JLabel labelDummy2 = new JLabel();
                                JLabel label05 = new JLabel("Day:");
                                JTextField textField04 = new JTextField(10);
                                JLabel label06 = new JLabel("Month:");
                                JTextField textField05 = new JTextField(10);
                                JLabel label07 = new JLabel("Year:");
                                JTextField textField06 = new JTextField(10);
                                JButton makeBooking = new JButton("Make Booking");
                                JLabel labelExtra0 = new JLabel();

                                JFrame bookAccommodation = new JFrame("Booking Menu");
                                bookAccommodation.setSize(1000, 500);
                                bookAccommodation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                bookAccommodation.setLayout(new GridLayout(0,2,20,20));

                                Calendar dateFrom = new GregorianCalendar();
                                Calendar dateUntil = new GregorianCalendar();

                                makeBooking.addActionListener(e3 -> {
                                    if(checkingClass.checkCode(textField02.getText()) && checkingClass.checkMonth(Integer.parseInt(textField02.getText()))){
                                        if(checkingClass.checkCode(textField01.getText()) && checkingClass.checkDay(Integer.parseInt(textField01.getText()),Integer.parseInt(textField02.getText()))){
                                            if(checkingClass.checkCode(textField03.getText()) && checkingClass.checkDigitsOfCodeName(Integer.parseInt(textField03.getText()))){
                                                int day1 = Integer.parseInt(textField01.getText());
                                                int month1 = Integer.parseInt(textField02.getText());
                                                int year1 = Integer.parseInt(textField03.getText());
                                                dateFrom.set(year1,month1,day1);

                                                if(checkingClass.checkCode(textField05.getText()) && checkingClass.checkMonth(Integer.parseInt(textField05.getText()))){
                                                    if(checkingClass.checkCode(textField04.getText()) && checkingClass.checkDay(Integer.parseInt(textField04.getText()),Integer.parseInt(textField05.getText()))){
                                                        if(checkingClass.checkCode(textField06.getText()) && checkingClass.checkDigitsOfCodeName(Integer.parseInt(textField06.getText()))){
                                                            int day2 = Integer.parseInt(textField04.getText());
                                                            int month2 = Integer.parseInt(textField05.getText());
                                                            int year2 = Integer.parseInt(textField06.getText());
                                                            dateUntil.set(year2,month2,day2);

                                                            if(dateFrom.before(date) || dateUntil.before(date)) {
                                                                labelExtra0.setText("You gave a date before the current date of System!Please try again!");
                                                            }else{
                                                                if (dateUntil.before(dateFrom)) {
                                                                    labelExtra0.setText("The date 'until' is before the date 'from'.Please try again!");
                                                                }else{
                                                                    AccommodationBooking accommodationBooking = new AccommodationBooking(acc,dateFrom,dateUntil);
                                                                    if(allBookings.checkDatesInBookingsList(accommodationBooking)){
                                                                        client.bookAccommodation(accommodationBooking);
                                                                        allBookings.addBooking(accommodationBooking);
                                                                        bookAccommodation.dispose();
                                                                        labelMain.setText("Accommodation Booked");
                                                                        new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                                                                    }else{
                                                                        labelExtra0.setText("The accommodation is booked a the time period you gave.Pleas choose another!");
                                                                    }
                                                                }
                                                            }

                                                        }else{
                                                            labelExtra0.setText("Invalid second year!Please try again!");
                                                        }
                                                    }else{
                                                        labelExtra0.setText("Invalid second day!Please try again!");
                                                    }
                                                }else{
                                                    labelExtra0.setText("Invalid second month!Please try again!");
                                                }

                                            }else{
                                                labelExtra0.setText("Invalid first year!Please try again!");
                                            }
                                        }else{
                                            labelExtra0.setText("Invalid first day!Please try again!");
                                        }
                                    }else{
                                        labelExtra0.setText("Invalid first month!Please try again!");
                                    }
                                });

                                bookAccommodation.add(label00);
                                bookAccommodation.add(labelDummy2);
                                bookAccommodation.add(label01);
                                bookAccommodation.add(textField01);
                                bookAccommodation.add(label02);
                                bookAccommodation.add(textField02);
                                bookAccommodation.add(label03);
                                bookAccommodation.add(textField03);
                                bookAccommodation.add(label04);
                                bookAccommodation.add(labelDummy3);
                                bookAccommodation.add(label05);
                                bookAccommodation.add(textField04);
                                bookAccommodation.add(label06);
                                bookAccommodation.add(textField05);
                                bookAccommodation.add(label07);
                                bookAccommodation.add(textField06);
                                bookAccommodation.add(labelExtra0);
                                bookAccommodation.add(makeBooking);
                                bookAccommodation.pack();
                                bookAccommodation.setLocationRelativeTo(null);
                                bookAccommodation.setVisible(true);
                            });

                            printAccommodation.add(label0);
                            printAccommodation.add(book);
                            printAccommodation.pack();
                            printAccommodation.setLocationRelativeTo(null);
                            printAccommodation.setVisible(true);
                            counter++;
                        }
                    }
                    searchMenu.dispose();

                }else{
                    labelExtra.setText("Invalid price.Please give a number!");
                }
            });


            searchMenu.add(label2);
            searchMenu.add(textField1);
            searchMenu.add(label3);
            searchMenu.add(comboBox1);
            searchMenu.add(label4);
            searchMenu.add(comboBox2);
            searchMenu.add(label5);
            searchMenu.add(comboBox3);
            searchMenu.add(search);
            searchMenu.add(labelExtra);
            searchMenu.pack();
            searchMenu.setLocationRelativeTo(null);
            searchMenu.setVisible(true);

        });

        button3.addActionListener(e ->{
            JLabel label1 = new JLabel("Give the code of the booked accommodation you want to cancel:");
            JTextField textField1 = new JTextField(20);
            JButton cancel = new JButton("Cancel");
            JLabel labelExtra = new JLabel();
            JFrame cancelBookingMenu = new JFrame("Client's Menu");
            cancelBookingMenu.setSize(1000, 500);
            cancelBookingMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cancelBookingMenu.setLayout(new GridLayout(0,2,10,20));

            cancel.addActionListener(e1 -> {
                if(checkingClass.checkCode(textField1.getText())){
                    int code = Integer.parseInt(textField1.getText());
                    if(checkingClass.checkDigitsOfCodeName(code)){
                        Accommodation acc = new Accommodation();
                        for(Accommodation acc1 : allAccommodations.getAccommodationsList())
                        {
                            if(acc1.getCode() == code)
                            {
                                acc = acc1;
                            }
                        }
                        if(acc.getCode() != 0) {
                            client.cancelBooking(code, allBookings);
                            cancelBookingMenu.dispose();
                            labelMain.setText("Booking canceled!");
                            new WriteObjectsInFiles(allUsers, allAccommodations, allBookings);
                        }else{
                            labelExtra.setText("The code does not exist.");
                        }
                    }else{
                        labelExtra.setText("Invalid code.Please give a four digit number!");
                    }
                }else{
                    labelExtra.setText("Invalid code.Please give a four digit number!");
                }
            });

            cancelBookingMenu.add(label1);
            cancelBookingMenu.add(textField1);
            cancelBookingMenu.add(cancel);
            cancelBookingMenu.add(labelExtra);
            cancelBookingMenu.pack();
            cancelBookingMenu.setLocationRelativeTo(null);
            cancelBookingMenu.setVisible(true);
        });

        button4.addActionListener(e ->{
            int counter = 1;
            JFrame showBookings = new JFrame("Accommodation Provider's Menu");
            showBookings.setSize(1000, 500);
            showBookings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showBookings.setLayout(new GridLayout(0,1,20,20));
            for(AccommodationBooking acc : client.getBookings()){
                JLabel label = new JLabel(counter + ": " + "code:" + acc.getBookedAccommodation().getCode() + " " + " ,square meters:" + acc.getBookedAccommodation().getSquareMeters() + " " +
                        " ,price/night:" + acc.getBookedAccommodation().getPricePerNight() + " " + ",Number of beds:" + " " + acc.getBookedAccommodation().getBeds() + " " + ",Number of rooms:" + " " +
                        acc.getBookedAccommodation().getRooms() + " " + " ,Type:" + acc.getBookedAccommodation().getType() + " " + " ,Seat:" + acc.getBookedAccommodation().getSeat());
                JLabel label1 = new JLabel("From: " + acc.getDateFrom().get(Calendar.DATE) + "/" + acc.getDateFrom().get(Calendar.MONTH) + "/" + acc.getDateFrom().get(Calendar.YEAR));
                JLabel label2 = new JLabel("Until: " + acc.getDateUntil().get(Calendar.DATE) + "/" + acc.getDateUntil().get(Calendar.MONTH) + "/" + acc.getDateUntil().get(Calendar.YEAR));
                showBookings.add(label);
                showBookings.add(label1);
                showBookings.add(label2);
                showBookings.pack();
                showBookings.setLocationRelativeTo(null);
                showBookings.setVisible(true);
                counter++;
            }
        });

        button5.addActionListener(e ->{
            int counter = 1;
            JFrame showCancellations = new JFrame("Accommodation Provider's Menu");
            showCancellations.setSize(1000, 500);
            showCancellations.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showCancellations.setLayout(new GridLayout(0,1,20,20));
            for(AccommodationBooking acc : client.getCancellations()){
                JLabel label = new JLabel(counter + ": " + "code:" + acc.getBookedAccommodation().getCode() + " " + " ,square meters:" + acc.getBookedAccommodation().getSquareMeters() + " " +
                        " ,price/night:" + acc.getBookedAccommodation().getPricePerNight() + " " + ",Number of beds:" + " " + acc.getBookedAccommodation().getBeds() + " " + ",Number of rooms:" + " " +
                        acc.getBookedAccommodation().getRooms() + " " + " ,Type:" + acc.getBookedAccommodation().getType() + " " + " ,Seat:" + acc.getBookedAccommodation().getSeat());
                JLabel label1 = new JLabel("From: " + acc.getDateFrom().get(Calendar.DATE) + "/" + acc.getDateFrom().get(Calendar.MONTH) + "/" + acc.getDateFrom().get(Calendar.YEAR));
                JLabel label2 = new JLabel("Until: " + acc.getDateUntil().get(Calendar.DATE) + "/" + acc.getDateUntil().get(Calendar.MONTH) + "/" + acc.getDateUntil().get(Calendar.YEAR));
                showCancellations.add(label);
                showCancellations.add(label1);
                showCancellations.add(label2);
                showCancellations.pack();
                showCancellations.setLocationRelativeTo(null);
                showCancellations.setVisible(true);
                counter++;
            }
        });

        button6.addActionListener(e ->{
            JFrame showMessages = new JFrame("Accommodation Provider's Menu");
            showMessages.setSize(1000, 500);
            showMessages.setLocationRelativeTo(null);
            showMessages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showMessages.setLayout(new GridLayout(0,1,20,20));

            int counter = 1;
            for(String message : client.getMessages()){
                JLabel label1 = new JLabel(counter + ": " + message);
                showMessages.add(label1);
                showMessages.pack();
                showMessages.setLocationRelativeTo(null);
                showMessages.setVisible(true);
                counter++;
            }
        });

        button7.addActionListener(e ->{
            JLabel label1 = new JLabel("UserName: " + client.getName());
            JLabel label2 = new JLabel("Email: " + client.getAddress());

            JFrame showProfileInfo = new JFrame("Accommodation Provider's Menu");
            showProfileInfo.setSize(500, 150);
            showProfileInfo.setLocationRelativeTo(null);
            showProfileInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            showProfileInfo.setLayout(new GridLayout(0,1,10,20));

            showProfileInfo.add(label1);
            showProfileInfo.add(label2);
            showProfileInfo.setLocationRelativeTo(null);
            showProfileInfo.setVisible(true);
        });

        button8.addActionListener(e ->{
            clientMenu.dispose();
            new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
        });

        clientMenu.add(button1);
        clientMenu.add(button3);
        clientMenu.add(button4);
        clientMenu.add(button5);
        clientMenu.add(button6);
        clientMenu.add(button7);
        clientMenu.add(button8);
        clientMenu.add(labelMain);
        clientMenu.setLocationRelativeTo(null);
        clientMenu.setVisible(true);
    }
}

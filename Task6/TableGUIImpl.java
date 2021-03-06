/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Dongyu Zhao 27356094
 */
package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;

public class TableGUIImpl extends JFrame implements MonthlyPaymentCalculatorandRealEstateAgencyGUIInterface {

    private static final String[] TABLE_COLUMNS = {"ID", "Address", "No. of Bedrooms", "Size", "Price", "Contact Person"};
    private static final String TAG_SEPARATOR = ",";

    private final JButton closeButton;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton searchButton;
    private final JButton updateButton;
    private final JButton deleteButton;

    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    ///
    private final JPanel realEstateAgencyPanel;

    private final JPanel calcPanel;

    private final JLabel propertyIdLabel;
    private final JLabel numberOfBedroomLabel;
    private final JLabel sizeLabel;
    private final JLabel priceLabel;
    private final JLabel streetNumberLabel;
    private final JLabel streetAddressLabel;
    private final JLabel suburbLabel;
    private final JLabel postcodeLabel;
    private final JLabel stateLabel;
    private final JLabel contactPersonLabel;
    private final JLabel tagLabel;

    private final JTextField propertyIdTextField;
    private final JTextField numberOfBedroomTextField;
    private final JTextField sizeTextField;
    private final JTextField priceTextField;
    private final JTextField streetNumberTextField;
    private final JTextField streetAddressTextField;
    private final JTextField suburbTextField;
    private final JTextField postcodeTextField;
    private final JTextField stateTextField;
    private final JTextField tagTextField;

    private final JTable propertyTable;

    private final JComboBox contactPersonComboBox;

    //declare new attribute
    private final JTextField principleTextField, interestRateTextField, noOfYearsTextField;
    private final JLabel resultLabel;
    private final JButton calculateButton;

    Property property;

    public TableGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener) {
        super("Monash Real Estate Agency");

        // create buttons
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("View");
        this.searchButton = new JButton("Search");
        this.addButton = new JButton("Add");
        this.updateButton = new JButton("Update");
        this.deleteButton = new JButton("Delete");

        // create container
        Container container = this.getContentPane();

        // create labels
        this.propertyIdLabel = new JLabel("Property ID:");
        this.streetNumberLabel = new JLabel("Street Number:");
        this.streetAddressLabel = new JLabel("Street Address:");
        this.suburbLabel = new JLabel("Suburb:");
        this.postcodeLabel = new JLabel("Postcode:");
        this.stateLabel = new JLabel("State:");
        this.numberOfBedroomLabel = new JLabel("No. Of Bedroom:");
        this.sizeLabel = new JLabel("Size:");
        this.priceLabel = new JLabel("Price:");
        this.contactPersonLabel = new JLabel("Contact Person:");
        this.tagLabel = new JLabel("Tag(s):");

        // create text fields
        this.propertyIdTextField = new JTextField();
        this.numberOfBedroomTextField = new JTextField();
        this.sizeTextField = new JTextField();
        this.priceTextField = new JTextField();
        this.streetNumberTextField = new JTextField();
        this.streetAddressTextField = new JTextField();
        this.suburbTextField = new JTextField();
        this.postcodeTextField = new JTextField();
        this.stateTextField = new JTextField();
        this.tagTextField = new JTextField();

        // create table
        this.propertyTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.propertyTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        //this.propertyTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        
        TableColumnModel propertyTableColumnModel = this.propertyTable.getColumnModel();

        //create combobox
        this.contactPersonComboBox = new JComboBox();

        // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();

        this.realEstateAgencyPanel = new JPanel();

        // set layout manager
        //container.setLayout(new BorderLayout());
        container.setLayout(new BoxLayout(getContentPane(), 1));
        this.inputPanel.setLayout(new GridLayout(11, 2));
        this.buttonPanel.setLayout(new GridLayout(1, 4));

        // add action listeners
        this.closeButton.addActionListener(actionListener);
        this.addButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);
        this.updateButton.addActionListener(actionListener);
        this.deleteButton.addActionListener(actionListener);

        // add components
        this.inputPanel.add(propertyIdLabel);
        this.inputPanel.add(propertyIdTextField);

        this.inputPanel.add(this.streetNumberLabel);
        this.inputPanel.add(this.streetNumberTextField);

        this.inputPanel.add(this.streetAddressLabel);
        this.inputPanel.add(this.streetAddressTextField);

        this.inputPanel.add(this.suburbLabel);
        this.inputPanel.add(this.suburbTextField);

        this.inputPanel.add(this.postcodeLabel);
        this.inputPanel.add(this.postcodeTextField);

        this.inputPanel.add(this.stateLabel);
        this.inputPanel.add(this.stateTextField);

        this.inputPanel.add(this.streetNumberLabel);
        this.inputPanel.add(this.streetNumberTextField);

        this.inputPanel.add(this.streetAddressLabel);
        this.inputPanel.add(this.streetAddressTextField);

        this.inputPanel.add(this.suburbLabel);
        this.inputPanel.add(this.suburbTextField);

        this.inputPanel.add(this.postcodeLabel);
        this.inputPanel.add(this.postcodeTextField);

        this.inputPanel.add(this.stateLabel);
        this.inputPanel.add(this.stateTextField);

        this.inputPanel.add(numberOfBedroomLabel);
        this.inputPanel.add(numberOfBedroomTextField);

        this.inputPanel.add(sizeLabel);
        this.inputPanel.add(sizeTextField);

        this.inputPanel.add(priceLabel);
        this.inputPanel.add(priceTextField);

        this.inputPanel.add(this.contactPersonLabel);
        this.inputPanel.add(this.contactPersonComboBox);

        this.inputPanel.add(this.tagLabel);
        this.inputPanel.add(this.tagTextField);

        // add buttons to panel
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.updateButton);
        this.buttonPanel.add(this.deleteButton);
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.viewButton);
        this.buttonPanel.add(this.closeButton);

        realEstateAgencyPanel.setLayout(new BorderLayout());

        realEstateAgencyPanel.add(inputPanel, BorderLayout.NORTH);
        realEstateAgencyPanel.add(new JScrollPane(this.propertyTable), BorderLayout.CENTER);
        realEstateAgencyPanel.add(buttonPanel, BorderLayout.SOUTH);

        principleTextField = new JTextField();
        interestRateTextField = new JTextField();
        noOfYearsTextField = new JTextField();

        resultLabel = new JLabel();

        calculateButton = new JButton("Calculate");
        this.calculateButton.addActionListener(actionListener);

        principleTextField.setHorizontalAlignment(JTextField.CENTER);
        interestRateTextField.setHorizontalAlignment(JTextField.CENTER);
        noOfYearsTextField.setHorizontalAlignment(JTextField.CENTER);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        calcPanel = new JPanel(new GridLayout(5, 2));
        calcPanel.add(new JLabel("Principle:"));
        calcPanel.add(principleTextField);
        calcPanel.add(new JLabel("Interest Rate:"));
        calcPanel.add(interestRateTextField);
        calcPanel.add(new JLabel("No. of Years:"));
        calcPanel.add(noOfYearsTextField);
        calcPanel.add(new JLabel("Result:"));
        calcPanel.add(resultLabel);
        calcPanel.add(new JLabel(""));
        calcPanel.add(calculateButton);

        //getContentPane().add(calcPanel);
        container.add(realEstateAgencyPanel);
        container.add(calcPanel);
        
        
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void displayContactPeople(List<ContactPerson> contactPeople) {
        this.contactPersonComboBox.removeAllItems();

        this.contactPersonComboBox.addItem("");

        for (ContactPerson contactPerson : contactPeople) {
            this.contactPersonComboBox.addItem(contactPerson);
        }
    }

    @Override
    public ContactPerson getSelectedContactPerson() {
        if (this.contactPersonComboBox.getItemCount() > 0 && this.contactPersonComboBox.getSelectedIndex() > 0) {
            return (ContactPerson) this.contactPersonComboBox.getSelectedItem();
        } else {
            return null;
        }
    }

    @Override
    public int getPropertyId() {
        String id = this.propertyIdTextField.getText();
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);
    }

    @Override
    public double getBudget() {
        String price = this.priceTextField.getText();
        return price == null || price.isEmpty() ? 0 : Double.parseDouble(price);
    }

    public boolean isPropertySelected() {
        return (this.propertyTable.getSelectedRow() >= 0);
    }

    @Override
    public int getSelectedPropertyId() {
        int selectedRowIndex = this.propertyTable.getSelectedRow();

        String propertyId = this.propertyTable.getValueAt(selectedRowIndex, 0).toString();
        return Integer.parseInt(propertyId);
    }

    @Override
    public Property getPropertyDetails() {
        return new Property(Integer.parseInt(propertyIdTextField.getText()),
                new Address(this.streetNumberTextField.getText(), this.streetAddressTextField.getText(), this.suburbTextField.getText(), this.postcodeTextField.getText(), this.stateTextField.getText()),
                Integer.parseInt(numberOfBedroomTextField.getText()),
                Double.parseDouble(sizeTextField.getText()),
                Double.parseDouble(priceTextField.getText()),
                (ContactPerson) this.contactPersonComboBox.getSelectedItem(),
                this.getPropertyTags());
    }

    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void displayPropertyDetails(Property property) {
        this.clearPropertyTable();
        this.clearInput();

        ((DefaultTableModel) this.propertyTable.getModel()).addRow(new Object[]{property.getPropertyId(),
            property.getAddress(),
            property.getNumberOfBedrooms(),
            property.getSize(),
            property.getPrice(),
            property.getContactPerson().getName()});

    }

    @Override
    public void displayPropertyDetails(List<Property> properties) {
        this.clearPropertyTable();
        this.clearInput();

        for (Property property : properties) {
            ((DefaultTableModel) this.propertyTable.getModel()).addRow(new Object[]{property.getPropertyId(),
                property.getAddress(),
                property.getNumberOfBedrooms(),
                property.getSize(),
                property.getPrice(),
                property.getContactPerson().getName()});
        }
    }

    @Override
    public void displayPropertyDetails(Set<Property> properties) {
        this.clearPropertyTable();
        this.clearInput();

        for (Property property : properties) {
            ((DefaultTableModel) this.propertyTable.getModel()).addRow(new Object[]{property.getPropertyId(),
                property.getAddress(),
                property.getNumberOfBedrooms(),
                property.getSize(),
                property.getPrice(),
                property.getContactPerson().getName()});
        }
    }

    @Override
    public void displaySelectedPropertyDetails(Property property) {
        this.propertyIdTextField.setText(String.valueOf(property.getPropertyId()));
        Address address = property.getAddress();
        this.streetNumberTextField.setText(address.getStreetNumber());
        this.streetAddressTextField.setText(address.getStreetAddress());
        this.suburbTextField.setText(address.getSuburb());
        this.postcodeTextField.setText(address.getPostcode());
        this.stateTextField.setText(address.getState());
        this.sizeTextField.setText(String.valueOf(property.getSize()));
        this.priceTextField.setText(String.valueOf(property.getPrice()));
        this.numberOfBedroomTextField.setText(String.valueOf(property.getNumberOfBedrooms()));
        this.contactPersonComboBox.setSelectedItem(property.getContactPerson());
        this.tagTextField.setText(this.getTagsString(property.getTags()));

        this.principleTextField.setText(String.valueOf(property.getPrice()));
    }

    private Set<String> getPropertyTags() {
        StringTokenizer tokenizer = new StringTokenizer(this.tagTextField.getText(), TAG_SEPARATOR);
        Set<String> tags = new HashSet<>();
        String tag = null;

        while (tokenizer.hasMoreTokens()) {
            tag = tokenizer.nextToken();
            tags.add(tag.trim());
        }

        return tags;
    }

    private String getTagsString(Set<String> tags) {
        if (tags != null && !tags.isEmpty()) {
            StringBuilder tagsBuilder = new StringBuilder();
            int index = 0;
            for (String tag : tags) {
                if (index != 0) {
                    tagsBuilder.append(TAG_SEPARATOR).append(" ");
                }

                tagsBuilder.append(tag.trim());
                index++;
            }

            return tagsBuilder.toString();
        }

        return "";
    }

    @Override
    public void clearPropertyTable() {
        int numberOfRow = this.propertyTable.getModel().getRowCount();

        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.propertyTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index--) {
                tableModel.removeRow(index);
            }
        }
    }

    @Override
    public void clearInput() {
        this.clearTextFields();
        this.clearComboBoxes();
    }

    @Override
    public void clearTextFields() {
        this.propertyIdTextField.setText("");
        this.streetNumberTextField.setText("");
        this.streetAddressTextField.setText("");
        this.suburbTextField.setText("");
        this.postcodeTextField.setText("");
        this.stateTextField.setText("");
        this.numberOfBedroomTextField.setText("");
        this.sizeTextField.setText("");
        this.priceTextField.setText("");
        this.tagTextField.setText("");

    }

    @Override
    public void clearComboBoxes() {
        if (this.contactPersonComboBox.getItemCount() > 0) {
            this.contactPersonComboBox.setSelectedIndex(0);
        }
    }

    @Override
    public JButton getUpdateButton() {
        return updateButton;
    }

    @Override
    public JButton getDeleteButton() {
        return deleteButton;
    }

    @Override
    public JTable getPropertyTable() {
        return propertyTable;
    }

    @Override
    public JButton getViewButton() {
        return viewButton;
    }

    @Override
    public JButton getAddButton() {
        return addButton;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }

    @Override
    public JButton getCalculateButton() {
        return calculateButton;
    }

    /**
     * Return the principle the user has entered
     *
     * @return the principle the user has entered
     */
    @Override
    public double getPrinciple() {
        return Double.parseDouble(this.principleTextField.getText());
    }

    /**
     * Return the interest rate the user has entered
     *
     * @return the interest rate the user has entered
     */
    @Override
    public double getInterestRate() {
        return Double.parseDouble(this.interestRateTextField.getText());
    }

    /**
     * Return the number of years the user has entered
     *
     * @return the number of years the user has entered
     */
    @Override
    public int getNoOfYears() {
        return Integer.parseInt(this.noOfYearsTextField.getText());
    }

    /**
     * Display the result
     *
     * @param the result to display
     */
    @Override
    public void updateResult(double result) {
        this.resultLabel.setText(NumberFormat.getCurrencyInstance().format(result));
    }

}

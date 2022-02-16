package com.company;

import com.company.Controller.PhoneBookManagement;
import com.company.Model.PhoneContact;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);


    public  void run() {
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        int choice  = -1;
        do{
            mainMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    showDisplayAllContact(phoneBookManagement);
                    break;
                }
                case 2:{
                    showAddNewContact(phoneBookManagement);
                    break;
                }
                case 3:{
                    showUpdateContactByName(phoneBookManagement);
                    break;
                }
                case 4:{
                    showDeleteContact(phoneBookManagement);
                    break;
                }
                case 5:{
                    showSearchByName(phoneBookManagement);
                    break;
                }

                case 6:{
                    showReadFile(phoneBookManagement);
                    break;
                }

                case 7:{
                    showWriteFile(phoneBookManagement);
                    break;
                }

            }
        }while (choice !=8);
    }

    private void showSearchByName(PhoneBookManagement phoneBookManagement) {
        System.out.println("---Tìm kiếm liên lạc theo tên---");
        System.out.println("Nhập tên bạn muốn tìm kiếm");
        String searchContactName = scanner.nextLine();
        boolean isExist = phoneBookManagement.checkExistByName(searchContactName);
        if(isExist){
            PhoneContact foundPhoneContact = phoneBookManagement.getInfoByName(searchContactName);
            System.out.println(foundPhoneContact);
        }else {
            System.out.println("Không tìm thấy tên liên lạc");
        }
    }

    private void showWriteFile(PhoneBookManagement phoneBookManagement) {
        System.out.println("---Ghi vào file---");
        System.out.println("---Nhập tên file muốn ghi---");
        String filePath = scanner.nextLine();
        try {
            phoneBookManagement.writeFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showReadFile(PhoneBookManagement phoneBookManagement) {
        System.out.println("--Đọc một danh sách có sẵn---");
        System.out.println("Nhập tên file bạn muốn đọc");
        String filePath = scanner.nextLine();
        try {
            phoneBookManagement.readFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteContact(PhoneBookManagement phoneBookManagement) {
        System.out.println("--Xóa một liên lạc---");
        System.out.println("Nhập tên liên lạc cần xóa");
        String deleteContactName = scanner.nextLine();
        boolean isExist = phoneBookManagement.checkExistByName(deleteContactName);
        if(isExist){
            int index = phoneBookManagement.getIndexByName(deleteContactName);
            phoneBookManagement.deleteContact(index);
            try {
                phoneBookManagement.writeFile("contact.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Xóa liên lạc thành công");
        }else   {
            System.out.println("Tên liên lạc không tồn tại");
        }
    }

    private void showUpdateContactByName(PhoneBookManagement phoneBookManagement) {
        System.out.println("---Cập nhật danh bạ---");
        System.out.println("Nhập tên liên lạc cần cập nhật");
        String changeContactName = scanner.nextLine();
        boolean isExist = phoneBookManagement.checkExistByName(changeContactName);
        if(isExist){
            int index = phoneBookManagement.getIndexByName(changeContactName);
            System.out.println("---Thay đổi thông tin---");
            PhoneContact changePhoneContact = inputInfoContact();
            phoneBookManagement.updateContact(index,changePhoneContact);
            try {
                phoneBookManagement.writeFile("contact.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Thay đổi thông tin thành công");
        }else{
            System.out.println("Tên liên lạc không đúng");
        }
    }

    private void showDisplayAllContact(PhoneBookManagement phoneBookManagement) {
        int size = phoneBookManagement.getSize();
        if(size == 0){
            System.out.println("Danh sách liên lạc rỗng");
        }else {
            System.out.println("--Danh sách các liên lạc có trong danh bạ---");
            phoneBookManagement.displayALL();
        }
    }

    private static PhoneContact inputInfoContact() {

        System.out.println("Nhập tên:");
        scanner.nextLine();
        String contactName = scanner.nextLine();
        System.out.println("Nhập số điện thoại");

        String contactPhoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm liên lạc");
        String contactType = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String contactGender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String contactAddress = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String contactDOB = scanner.nextLine();
        System.out.println("Nhập email:");
        String contactEmail = scanner.nextLine();

        PhoneContact newPhoneContact = new PhoneContact(contactPhoneNumber,contactType,contactName,contactGender,contactAddress,contactDOB,contactEmail);
        return newPhoneContact;
    }

    private void showAddNewContact(PhoneBookManagement phoneBookManagement){
        System.out.println("---Thêm một liên lạc mới---");
        PhoneContact newPhoneContact = inputInfoContact();
        phoneBookManagement.addNewContact(newPhoneContact);
        try {
            phoneBookManagement.writeFile("contact.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Thêm liên lạc mới thành công");
    }

    private static void mainMenu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng");
    }
}

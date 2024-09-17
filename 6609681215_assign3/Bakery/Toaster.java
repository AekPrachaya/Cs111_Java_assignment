//Prachaya Kheawchan
//6609681215

package Bakery;

import java.util.ArrayList;

public class Toaster {
    private ArrayList<Toastable> items;

    // สร้างเครื่องปิ้งขนม
    public Toaster() {
        items = new ArrayList<>();
    }

    // เพิ่มขนมลงในเครื่องปิ้ง
    public void add(Toastable item) {
        items.add(item);
    }

    // ทำการปิ้งขนมทั้งหมดในเครื่อง    
    public void print() {
        System.out.println("Items in the toaster:");
        for (Toastable item : items) {
            System.out.println(item.toString());
        }
    }
}


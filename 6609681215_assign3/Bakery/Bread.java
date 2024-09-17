//Prachaya Kheawchan
//6609681215

package Bakery;

// สถานะขนมปัง
public class Bread implements Toastable {
    public static final String BURNT = "Burn";
    public static final String CRISP ="Crisp";
    public static final String SOFT = "Soft";
    private String state;

    // สร้างขนมปัง
    public Bread() {
        state = SOFT;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // ทำการปิ้งขนม
    public void toast() {
        if (state.equals(SOFT)) {
            state = CRISP;
        } else if (state.equals(CRISP)) {
            state = BURNT;
        }
    }

    // รับสถานะของขนมที่ถูกปิ้ง
    public void getToastState() {
        System.out.println("Bread toast state: " + state);
    }

    // แสดงข้อความสถานะขนมปัง
    public String toString() {
        return "Bread is now: " + state;
    }
}

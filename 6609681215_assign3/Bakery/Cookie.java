//Prachaya Kheawchan
//6609681215

package Bakery;

// สถานะคุกกี้
public class Cookie implements Toastable {
    public static final String SOFT = "Soft";
    public static final String CRISP = "Crisp";
    private String state;

    // สร้างคุกกี้
    public Cookie() {
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
        }
    }

    // รับสถานะของขนมที่ถูกปิ้ง
    public void getToastState() {
        System.out.println("Cookie toast state: " + state);
    }

    // แสดงข้อความสถานะคุกกี้
    public String toString() {
        return "Cookie is now: " + state;
    }
}

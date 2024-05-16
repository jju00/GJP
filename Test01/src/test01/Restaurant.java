package test01;

import java.util.ArrayList;
import java.util.List;

class Restaurant {
    private final String name;
    private final Owner owner;
    private List<PartTimer> partTimers;
    private List<Customer> customers;
    private List<Menu> menus;
    private int x, y;
    private final int SIZE = 50; // 음식점 크기

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return SIZE;
    }

    public Restaurant() {
		this.name = "";
		this.owner = null;
	}

	public Restaurant(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
        this.partTimers = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public Owner getOwner() {
    	return owner;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    // 파트타이머 목록에 추가
    public void addPartTimer(PartTimer partTimer) {
        partTimers.add(partTimer);
    }

    // 고객 목록에 추가
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getName() + " is now visiting " + name);
    }

    // 고객 목록에서 제거
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    // 메뉴 목록에 추가
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    // 서비스 시작
    public void startService() {
        System.out.println(name + " is now open for service.");
        owner.manageRestaurant();
        for (PartTimer partTimer : partTimers) {
            partTimer.work();
        }
    }

    // 현재 고객 목록
    public void listCustomers() {
        System.out.println("Current customers at " + name + ":");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }

    // 메뉴 목록 출력
    public void listMenus() {
        System.out.println("Menu items at " + name + ":");
        for (Menu menu : menus) {
            System.out.println("- " + menu.getName() + ": $" + menu.getPrice());
        }
    }
}
package entity;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

public class Cart implements Serializable {
    private int id;
    private Account account;
    private List<Item> items;
    private int status;

    public Cart(List<Item> items) {
        this.items = items;
    }

    public double totalMoney() {
        double money = 0;
        for (Item item : items) {
            money += item.getPrice() * item.getQuantity();
        }
        return money;
    }

    public List<Item> removeItem(int id) {
        items.remove(id);
        return items;
    }

    public Cart() {
        this.status = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

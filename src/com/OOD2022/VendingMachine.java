package com.OOD2022;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Inventory> inventories;

    private List<String> inventoriesName;

    private int tmpQuarterPool;

    private int quarterPool;

    public VendingMachine(List<Inventory> inventories) {

        this.inventories = inventories;
        this.inventoriesName = new ArrayList<String>();
        for (Inventory inv : inventories) {
            this.inventoriesName.add(inv.getProduct());
        }
    }

    public int takeQuarter() {
        this.tmpQuarterPool = this.tmpQuarterPool + 25;
        return this.tmpQuarterPool;
    }

    // return all the product names in the machine, even it has been sold out.
    public List<String> listInventory() {
        return this.inventoriesName;
    }

    // return all the buyable product names based on the money and inventory status.
    public List<String> listCanBuy() {
        List<String> canBuy = new ArrayList<String>();
        for (Inventory curr : this.inventories) {
            if (curr.canVend(this.tmpQuarterPool) && curr.getAmount() > 0) {
                canBuy.add(curr.getProduct());
            }
        }
        return canBuy;
    }

    // return the change, note there is no guarantee that the product has not been sold out.
    public int vend(String product) {
        for (Inventory inventory : this.inventories) {
            if (inventory.getProduct().equals(product) && inventory.canVend(this.tmpQuarterPool) && inventory.getAmount() > 0) {
                inventory.vend(this.tmpQuarterPool);
                this.tmpQuarterPool = this.tmpQuarterPool - inventory.getPrice();
            }
        }
        return this.refund();
    }

    // return the money fed by the current customer.
    public int refund() {
        int res = this.tmpQuarterPool;
        this.tmpQuarterPool = 0;
        return res;
    }
}

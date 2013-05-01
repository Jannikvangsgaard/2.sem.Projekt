/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class Package {
    
    private int packageNo;
    private ArrayList<Item> items = new ArrayList();

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    private int price;
    
    public Package(String packageName, ArrayList items , int price){
        this.packageName=packageName;
        this.items=items;
        this.price=price;
    }

    public int getPackageNo() {
        return packageNo;
    }

    public void setPakkeNo(int pakkeNo) {
        this.packageNo = pakkeNo;
    }
    public Package(int packageNo, String packageName, ArrayList items, int price){
        this.packageNo=packageNo;
        this.packageName=packageName;
        this.items=items;
        this.price =price;
    
    }
    
}

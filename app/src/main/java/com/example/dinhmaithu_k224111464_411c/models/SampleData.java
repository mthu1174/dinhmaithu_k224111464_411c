package com.example.dinhmaithu_k224111464_411c.models;

import java.util.ArrayList;

public class SampleData {
    private static final ArrayList<Account> accountList = new ArrayList<>();
    private static final ArrayList<Product> productList = new ArrayList<>();

    public static ArrayList<Account> getAccounts() {
        if (accountList.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                accountList.add(new Account(i, "user" + i, "pass" + i));
            }
        }
        return accountList;
    }
    public static ArrayList<Product> getProducts() {
        if (productList.isEmpty()) {
            productList.add(new Product(1, "PRD01", "Coca Cola", 10.0, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lxwow5hxjqhn42.webp"));
            productList.add(new Product(2, "PRD02", "Pepsi", 9.5, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lyw36df3wl9d07.webp"));
            productList.add(new Product(3, "PRD03", "7Up", 8.5, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvu023jlmeaha0.webp"));
            productList.add(new Product(4, "PRD04", "Fanta", 9.0, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvu14lvyycijf9.webp"));
            productList.add(new Product(5, "PRD05", "Sprite", 9.2, "https://down-vn.img.susercontent.com/file/vn-11134207-7ra0g-m76b9fm1bfdtca.webp"));
            productList.add(new Product(6, "PRD06", "Mountain Dew", 11.0, "https://down-vn.img.susercontent.com/file/vn-11134207-7ra0g-m76bawhpw5egeb.webp"));
            productList.add(new Product(7, "PRD07", "Red Bull", 12.0, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvu2ugq43a3f64.webp"));
            productList.add(new Product(8, "PRD08", "Dr Pepper", 10.5, "https://down-vn.img.susercontent.com/file/sg-11134201-7reqj-m8p2d4sryjl3f0.webp"));
            productList.add(new Product(9, "PRD09", "Est Cola", 9.8, "https://down-vn.img.susercontent.com/file/vn-11134207-7ra0g-m76c55g4c6k8a4@resize_w900_nl.webp"));
            productList.add(new Product(10, "PRD10", "Mirinda", 10.0, "https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lvu14lvyu4t79b.webp"));

            productList.add(new Product(11, "PRD11", "Pocari Sweat", 14.0, "https://cdn.nhathuoclongchau.com.vn/unsafe/https://cms-prod.s3-sgn09.fptcloud.com/00015165_pocari_sweet_500ml_6751_5d15_large_88460a0edd.JPG"));
            productList.add(new Product(12, "PRD12", "Revive", 13.5, "https://cdn.tgdd.vn/Products/Images/3226/83581/bhx/nuoc-ngot-revive-vi-muoi-khoang-chai-500ml-201812060918208543.jpg"));
            productList.add(new Product(13, "PRD13", "Number 1", 12.5, "https://cdn.tgdd.vn/Products/Images/3226/90710/bhx/nuoc-tang-luc-number1-330ml-202407241104383683.jpg"));
            productList.add(new Product(14, "PRD14", "Monster Energy", 18.0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0_3Fx2eF48bj71p_W5CIP4oC-4zh59GDO9A&s"));
            productList.add(new Product(15, "PRD15", "Aquafina", 7.0, "https://sonhawater.vn/wp-content/uploads/2020/10/aquafina-15-lit.jpg"));
            productList.add(new Product(16, "PRD16", "Dasani", 7.5, "https://prod-cdn.pharmacity.io/e-com/images/ecommerce/P01500_11.jpg"));
            productList.add(new Product(17, "PRD17", "Lavie", 8.0, "https://sonhawater.vn/wp-content/uploads/2020/05/lavie-500ml-chai-moi-2.jpg"));
            productList.add(new Product(18, "PRD18", "Ion Life", 9.0, "https://anbinhphat.com/wp-content/uploads/2018/08/chai-i-on-life-330ml.png"));
            productList.add(new Product(19, "PRD19", "Vĩnh Hảo", 7.8, "https://nuocvinhhao.com.vn/wp-content/uploads/2015/12/vinh-hao-350ml.png"));
            productList.add(new Product(20, "PRD20", "Satori", 8.2, "https://www.lottemart.vn/media/catalog/product/cache/0x0/8/9/8938512632025.jpg.webp"));
        }
        return productList;
    }



    public static void addProduct(Product p) {
        productList.add(p);
    }
}

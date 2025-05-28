package com.example.dinhmaithu_k224111464_411c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinhmaithu_k224111464_411c.models.Product;
import com.example.dinhmaithu_k224111464_411c.models.SampleData;

public class ProductAddActivity extends AppCompatActivity {

    EditText edtCode, edtName, edtPrice, edtImage;
    Button btnAddProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        edtCode = findViewById(R.id.edtCode);
        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        edtImage = findViewById(R.id.edtImage);
        btnAddProduct = findViewById(R.id.btnAddProduct);

        btnAddProduct.setOnClickListener(view -> {
            String code = edtCode.getText().toString().trim();
            String name = edtName.getText().toString().trim();
            String priceStr = edtPrice.getText().toString().trim();
            String imageLink = edtImage.getText().toString().trim();

            if (code.isEmpty() || name.isEmpty() || priceStr.isEmpty() || imageLink.isEmpty()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Giá không hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }

            Product newProduct = new Product(
                    SampleData.getProducts().size() + 1, // id auto tăng
                    code,
                    name,
                    price,
                    imageLink
            );

            SampleData.addProduct(newProduct);
            Toast.makeText(this, "Thêm sản phẩm thành công!", Toast.LENGTH_SHORT).show();
            finish(); // Quay lại ProductListActivity
        });
    }
}

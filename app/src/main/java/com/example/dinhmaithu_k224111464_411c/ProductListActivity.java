package com.example.dinhmaithu_k224111464_411c;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinhmaithu_k224111464_411c.adapters.ProductAdapter;
import com.example.dinhmaithu_k224111464_411c.models.Product;
import com.example.dinhmaithu_k224111464_411c.models.SampleData;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerViewProduct;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerViewProduct = findViewById(R.id.recyclerViewProduct);
        productList = SampleData.getProducts(); // Dữ liệu chung
        adapter = new ProductAdapter(this, productList);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProduct.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged(); // 🔄 cập nhật khi quay lại từ ProductAddActivity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            startActivity(new Intent(this, ProductAddActivity.class));
            return true;
        } else if (item.getItemId() == R.id.menuAbout) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

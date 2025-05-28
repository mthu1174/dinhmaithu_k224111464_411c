package com.example.dinhmaithu_k224111464_411c.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinhmaithu_k224111464_411c.R;
import com.example.dinhmaithu_k224111464_411c.models.Product;

import java.net.URL;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    ArrayList<Product> productList;

    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtProductName, txtProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.txtProductName.setText(p.getProductName());
        holder.txtProductPrice.setText(String.format("$ %.2f", p.getUnitPrice()));

        // Load ảnh từ link internet
        new Thread(() -> {
            try {
                URL url = new URL(p.getImageLink());
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                ((Activity) context).runOnUiThread(() -> {
                    holder.imgProduct.setImageBitmap(bmp);
                });
            } catch (Exception e) {
                Log.e("IMG_ERROR", "Lỗi load ảnh: " + e.getMessage());
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

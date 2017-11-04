package com.example.ixvar.mushroomhandbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ixvar.mushroomhandbook.Activity.ScrollingActivity;
import com.example.ixvar.mushroomhandbook.R;
import com.example.ixvar.mushroomhandbook.Model.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Suleiman on 02/03/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductVh> {

    private List<Product> products;
    private Context mContext;

    public ProductAdapter(List<Product> products,Context mContext){
        this.products = products;
        this.mContext = mContext;
    }

    @Override
    public ProductVh onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductVh(view);
    }

    @Override
    public void onBindViewHolder(ProductVh holder, final int position) {
        Product product = products.get(position);

        holder.mName.setText(product.getName());
        holder.mOtherNames.setText(product.getOtherNames());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ScrollingActivity.class);
                intent.putExtra("id", Integer.toString(products.get(position).getId()));
                context.startActivity(intent);

            }
        });


        try {
            // получаем входной поток
            InputStream ims = mContext.getAssets().open(product.getPicture());
            // загружаем как Drawable
            Drawable drawable = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            holder.mPicture.setImageDrawable(drawable);
        }
        catch(IOException ex) {
            return;
        }


        //holder.mPicture.setImageResource(product.getPicture());

    }

    @Override
    public int getItemCount() {
        return products == null ? 0 : products.size();
    }


    public static class ProductVh extends RecyclerView.ViewHolder {

        private ImageView mPicture;
        private TextView mName;
        private TextView mOtherNames;
        private CardView mCardView;


        public ProductVh(View itemView) {
            super(itemView);


            mName = (TextView) itemView.findViewById(R.id.textViewNameProduct);
            mOtherNames = (TextView) itemView.findViewById(R.id.textViewOtherNamesProducts);
            mPicture = (ImageView) itemView.findViewById(R.id.imageViewProduct);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);

        }
    }
}
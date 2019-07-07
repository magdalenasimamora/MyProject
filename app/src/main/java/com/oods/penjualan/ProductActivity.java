package com.oods.penjualan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class ProductActivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private LinearLayout mRootLayout;

    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        Bitmap[] bitmaps = getBitmaps();
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(bitmaps);
        rvMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvMain.setAdapter(myRecyclerAdapter);

        mContext = getApplicationContext();
        mActivity = ProductActivity.this;

        mRootLayout = (LinearLayout) findViewById(R.id.root_layout);
    }
    protected void openDialer(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+6282274496243"));
        startActivity(intent);
    }

    private  Bitmap[] getBitmaps(){
         Bitmap[] tempBitmaps = new Bitmap[10];
         tempBitmaps[0]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_1);
         tempBitmaps[1]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_2);
         tempBitmaps[2]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_3);
         tempBitmaps[3]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_4);
         tempBitmaps[4]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_5);
         tempBitmaps[5]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_6);
         tempBitmaps[6]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_7);
         tempBitmaps[7]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_8);
         tempBitmaps[8]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_9);
         tempBitmaps[9]= BitmapFactory.decodeResource(getResources(), R.drawable.icon_10);

         return tempBitmaps;
    }
    private class MyRecyclerAdapter extends RecyclerView.Adapter<GridHolder>{
        Bitmap [] bitmaps;

        public MyRecyclerAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public GridHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater .from(ProductActivity.this).inflate(R.layout.product_rv, parent,false);
                return new GridHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GridHolder holder, int position) {
            holder.imageView.setImageBitmap(bitmaps[position]);
            holder.textView.setText("Caption:" + position);
        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }
    private class GridHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        Button mBtnDoTask;
        public GridHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivMainImage);
            textView = itemView.findViewById(R.id.tvCaption);
            mBtnDoTask = itemView.findViewById(R.id.btn_do_task);

            mBtnDoTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialer();
                }
            });
        }
    }
}

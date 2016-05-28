package com.android.botao.quxing;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.botao.R;
import com.android.botao.quxing.tool.SelectPicPopupWindow;
import com.iimedia.analytics.MobileClickAgent;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ReleaseActivity extends Activity {
    public final static int PHOTO_ZOOM = 0;
    public final static int TAKE_PHOTO = 1;
    public final static int PHOTO_RESULT = 2;
    public static final String IMAGE_UNSPECIFIED = "image/*";
    private String imageDir;
    private Uri imageUri;
    private String img_url;
    private Toolbar toolbar;
    private ImageView back;
    private EditText et_plan;
    private EditText et_time_start;
    private EditText et_time_end;
    private EditText et_address;
    private EditText et_detail;
    private ImageView img_photo;
    private ImageView img_add_photo;
    private ImageView imageView;
    private SelectPicPopupWindow menuWindow;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        et_plan = (EditText) findViewById(R.id.et_plan);
        et_time_start = (EditText) findViewById(R.id.et_time_start);
        et_time_end = (EditText) findViewById(R.id.et_time_end);
        et_address = (EditText) findViewById(R.id.et_address);
        et_detail = (EditText) findViewById(R.id.et_detail);
        img_photo = (ImageView) findViewById(R.id.img_photo);

        imageView = (ImageView) findViewById(R.id.imageView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        img_add_photo=(ImageView)findViewById(R.id.img_add_photo);
        img_add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tv_save.setClickable(false);
                menuWindow = new SelectPicPopupWindow(ReleaseActivity.this, itemsOnClick);
                menuWindow.showAtLocation(ReleaseActivity.this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //toolbar.setNavigationIcon(R.mipmap.cmenu);//设置导航栏图标
        //toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
       // toolbar.setTitle("");//设置主标题
        //toolbar.setSubtitle("Subtitle");//设置子标题
//        toolbar.inflateMenu(R.menu.menu_main);
        init();


    }
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.tv_call_camera:
                    imageDir = "temp.jpg";
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(new File(Environment.getExternalStorageDirectory(), imageDir)));
                    startActivityForResult(intent, TAKE_PHOTO);
                    break;
                case R.id.tv_call_gallery:
                    File outputImage = new File(Environment.getExternalStorageDirectory()
                            , "output_Image.jpg");
                    try {
                        if (outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    imageUri = Uri.fromFile(outputImage);
                    Intent intent2 = new Intent("android.intent.action.PICK");
                    intent2.setType("image/*");
                    intent2.putExtra("crop", true);
                    intent2.putExtra("scale", true);
                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                    startActivityForResult(intent2, PHOTO_ZOOM);//参数传TAKE_PHOTO
                    break;
                default:
                    break;
            }


        }

    };

    public void photoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);

        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("return-data", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        startActivityForResult(intent, PHOTO_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == PHOTO_ZOOM) {
                photoZoom(data.getData());
            }
            if (requestCode == TAKE_PHOTO) {
                File picture = new File(Environment.getExternalStorageDirectory() + "/" + imageDir);
                photoZoom(Uri.fromFile(picture));
            }

            if (requestCode == PHOTO_RESULT) {
                Bundle extras = data.getExtras();

                if (extras != null) {


                    final Bitmap photo = extras.getParcelable("data");
                    ByteArrayOutputStream bStream =new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 30, bStream);
                    img_add_photo.setImageBitmap(photo);




                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onResume() {
        MobileClickAgent.onResume(this);
        super.onResume();
    }
    private void init(){
        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        MobileClickAgent.onPause(this);
        super.onPause();
    }
}

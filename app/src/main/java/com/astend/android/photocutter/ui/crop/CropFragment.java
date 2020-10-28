package com.astend.android.photocutter.ui.crop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.astend.android.photocutter.R;
import com.astend.android.photocutter.ui.camera.CameraFragment;
import com.astend.android.photocutter.ui.crop.view.CropView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

import static android.app.Activity.RESULT_OK;


public class CropFragment extends Fragment {


  private static final int REQUEST_IMAGE_CAPTURE = 1;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_crop, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    TextView textOk = view.findViewById(R.id.ok);
    TextView textCancel = view.findViewById(R.id.cancel);
    Button btnCrop = view.findViewById(R.id.btnCrop);
    CropView cropView = view.findViewById(R.id.imagePhoto);


    btnCrop.setOnClickListener(v -> {
      btnCrop.setVisibility(View.INVISIBLE);
      textOk.setVisibility(View.VISIBLE);
      textCancel.setVisibility(View.VISIBLE);
    });

    textCancel.setOnClickListener(v -> {
      btnCrop.setVisibility(View.VISIBLE);
      textOk.setVisibility(View.INVISIBLE);
      textCancel.setVisibility(View.INVISIBLE);

    });


    textOk.setOnClickListener(v -> {
      Navigation.findNavController(view).navigate(R.id.action_cropFragment_to_finishFragment);
    });

  //  String photoPath = getArguments().getString("photoPath");
  //  Bitmap myBitmap = BitmapFactory.decodeFile(photoPath);
    Bitmap myBitmap = BitmapFactory.decodeFile("/data/user/0/com.astend.android.photocutter/cache/2020-10-28-20-07-25-529.jpg");
    cropView.setImageBitmap(myBitmap);


  }



}
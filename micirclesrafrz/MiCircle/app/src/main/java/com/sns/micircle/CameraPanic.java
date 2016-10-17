package com.sns.micircle;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import android.widget.Toast;

import com.sns.micircle.utility.MarshMallowPermission;

@SuppressWarnings("deprecation")
public class CameraPanic extends Activity implements SurfaceHolder.Callback {


	MarshMallowPermission marshMallowPermission;
	Camera camera;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	int nCount;
	File mediaFile;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camerapanic);

		marshMallowPermission= new MarshMallowPermission(CameraPanic.this);
		if (!marshMallowPermission.checkPermissionForCamera()) {
			marshMallowPermission.requestPermissionForCamera();
		} else {
			if (!marshMallowPermission.checkPermissionForExternalStorage()) {
				marshMallowPermission.requestPermissionForExternalStorage();
			} else {
				surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
				surfaceHolder = surfaceView.getHolder();
				surfaceHolder.addCallback(this);

				surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			}
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	private void start_camera() {
		try {

			camera = Camera.open();

		} catch (RuntimeException e) {

			return;
		}

		try {
			camera.setPreviewCallback(new PreviewCallback() {

				@Override
				public void onPreviewFrame(byte[] data, Camera camera) {
					// TODO Auto-generated method stub
					//camera.takePicture(null, null, getJpegCallback());
				camera.takePicture(null,null, getJpegCallback());

				}
			});

			camera.setDisplayOrientation(90);
			camera.setPreviewDisplay(surfaceHolder);
			camera.startPreview();
			// camera.takePicture(shutter, raw, jpeg)
		} catch (Exception e) {

			return;
		}

	}

	protected PictureCallback getJpegCallback() {

		PictureCallback jpeg = new PictureCallback() {
			@Override
			public void onPictureTaken(byte[] data, Camera mCamera) {
				/******************************************/
				FileOutputStream fos;
				File pictureFile = getOutputMediaFile();

				if (pictureFile != null) {
					surfaceDestroyed(surfaceHolder);

				}
				try {
					fos = new FileOutputStream(pictureFile);
					fos.write(data);
					fos.close();
				} catch (IOException e) {
					// do something about it
					Toast.makeText(CameraPanic.this, e.toString(), Toast.LENGTH_LONG).show();
				}

			};

		};
		return jpeg;
	}

	@SuppressWarnings("deprecation")
	private void stop_camera() {
		camera.stopPreview();
		camera.setPreviewCallback(null);

		camera.release();
		camera = null;
		onStop();
	}

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(CameraPanic.this, "surfaceChanged", Toast.LENGTH_LONG).show();
		start_camera();
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

		Toast.makeText(CameraPanic.this, "surfaceCreated", Toast.LENGTH_LONG).show();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Toast.makeText(CameraPanic.this, "surfaceDestroyed", Toast.LENGTH_LONG).show();
		if (camera != null)
			stop_camera();
	}

	/** Create a File for saving an image or video */
	private File getOutputMediaFile() {
		// To be safe, you should check that the SDCard is mounted
		// using Environment.getExternalStorageState() before doing this.
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory() + "/MyFilesAzhar");

		if (!mediaStorageDir.exists()) {
			if (mediaStorageDir.mkdirs()) {
				;// directory is created!
			}
		}

		String mImageName = "MI_" + nCount + ".jpg";
		mediaFile = new File(mediaStorageDir + File.separator + mImageName);

		return mediaFile;
	}




	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}

}

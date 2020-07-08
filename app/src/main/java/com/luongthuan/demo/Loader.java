package com.luongthuan.demo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

// input, tiến trình kiểu đếm, output
public class Loader extends AsyncTask<String, Long, String> {
    ProgressBar progressBar;

    public Loader(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    // phương thức xử lý
    @Override
    protected String doInBackground(String... strings) {
        String link = strings[0];
        int count = 0;
        for (int i = 0; i < link.length(); i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;

            // cập nhật tiến trình
            publishProgress((long) i);
        }
        return String.valueOf(count);
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        // giao tiếp với giao diện tại hàm này
        progressBar.setProgress(Math.round(values[0]));
    }

    //call back
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.e("HaHa", s);
    }

    // được gọi trước doInBackground
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
}

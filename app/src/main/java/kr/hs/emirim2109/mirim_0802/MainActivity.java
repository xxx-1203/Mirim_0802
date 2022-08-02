package kr.hs.emirim2109.mirim_0802;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,
            R.drawable.m6, R.drawable.m7, R.drawable.m8, R.drawable.m9, R.drawable.m10,
            R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,
            R.drawable.m6, R.drawable.m7, R.drawable.m8, R.drawable.m9, R.drawable.m10,
            R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,
            R.drawable.m6, R.drawable.m7, R.drawable.m8, R.drawable.m9, R.drawable.m10,};
    String[] posterName = {"조커", "나홀로 집에", "레옹", "크루엘라", "마션",
            "엔드게임", "파 프롬 홈", "가디언즈 오브 겔럭시", "캡틴마블", "블랙팬서",
            "조커", "나홀로 집에", "레옹", "크루엘라", "마션",
            "엔드게임", "파 프롬 홈", "가디언즈 오브 겔럭시", "캡틴마블", "블랙팬서",
            "조커", "나홀로 집에", "레옹", "크루엘라", "마션",
            "엔드게임", "파 프롬 홈", "가디언즈 오브 겔럭시", "캡틴마블", "블랙팬서"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("인기영화포스터(내맘대로");
        gridv = findViewById(R.id.gridv);
        posterAdapter adapter = new posterAdapter(this);
        gridv.setAdapter(adapter);

    }
    public class posterAdapter extends BaseAdapter{
        Context context;
        public posterAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final int pos =i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.movie);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dlalog, null);
                    ImageView imgDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });
            return imgv;
        }
    }
}
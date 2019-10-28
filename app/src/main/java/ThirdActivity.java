import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hw1.R;

import java.util.Random;

public class ThirdActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.third);
        setTitle("Third 액티비티");


        Button start_lottery = (Button) findViewById(R.id.start_lottery);
        start_lottery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random generator = new Random();
                int a = generator.nextInt(45) + 1;
                String b = ""+a;
                TextView num1 = findViewById(R.id.input_1th);
                 num1.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num2 = findViewById(R.id.input_2th);
                num2.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num3 = findViewById(R.id.input_3th);
                num3.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num4 = findViewById(R.id.input_4th);
                num4.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num5 = findViewById(R.id.input_5th);
                num5.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num6 = findViewById(R.id.input_6th);
                num6.setText(b);

                a = generator.nextInt(45) + 1;
                b = ""+a;
                TextView num7 = findViewById(R.id.input_7th);
                num7.setText(b);

                TextView result = findViewById(R.id.result);
                result.setText("짜잔~~ 좋은 하루 되세요~");
            }
        });

        Button go_back2 = (Button) findViewById(R.id.go_back2);
        go_back2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

}

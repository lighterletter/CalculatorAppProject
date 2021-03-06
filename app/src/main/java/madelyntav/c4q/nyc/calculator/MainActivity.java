package madelyntav.c4q.nyc.calculator;

import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.EmptyStackException;


public class MainActivity extends ActionBarActivity {
    private String ans = "";
    private String toBeEvaluated = "";
    private TextView calcScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getButtonText(View v) {
        Button button = (Button) findViewById(v.getId());

        toBeEvaluated += button.getText();

        calcScreen = (TextView) findViewById(R.id.calcScreen);

        calcScreen.setText(toBeEvaluated);

    }

    public void negButton(View v) {
        if (toBeEvaluated.charAt(0) != '-' && toBeEvaluated.charAt(0) != '+') {
            toBeEvaluated = "-" + toBeEvaluated;
        }
        else if (toBeEvaluated.charAt(0) == '-') {
            toBeEvaluated = toBeEvaluated.replace(toBeEvaluated.charAt(0), ' ');
            toBeEvaluated=toBeEvaluated.trim();

        }
        calcScreen.setText(toBeEvaluated);
    }

    public void allClear(View v) {
        toBeEvaluated = "";
        calcScreen = (TextView) findViewById(R.id.calcScreen);
        calcScreen.setText(toBeEvaluated);
    }

    public void Sohcahtoa(View v) {

        Button button = (Button) findViewById(v.getId());


            if (calcScreen.getText() == null) {

                toBeEvaluated = button.getText() + "(";

            } else {

                toBeEvaluated = button.getText() + "(" + toBeEvaluated + ")";

            }

            calcScreen.setText(toBeEvaluated);

        }


    public void ans(View v) {

        if ((calcScreen.getText() != "") && ans == "") {
            Expressions expressions = new Expressions(calcScreen.getText().toString());
            BigDecimal res = new BigDecimal(String.valueOf(expressions.eval()));
            ans = ((res.toPlainString()));
        } else if (ans != "") {
            toBeEvaluated += ans;
            calcScreen.setText(toBeEvaluated);
        }
    }
    public void absoluteval(View v){
            toBeEvaluated = toBeEvaluated.replace('-', ' ');
            toBeEvaluated = toBeEvaluated.trim();
            calcScreen.setText(toBeEvaluated);

    }



    private void checkParenthesis() {
        int p = 0;

        for (int i = 0; i < toBeEvaluated.length(); i++) {
            if (toBeEvaluated.charAt(i) == '(') {
                p++;
            } else if (toBeEvaluated.charAt(i) == ')') {
                p--;
            }

            if (p > 0) {
                toBeEvaluated += ")";
            }
        }
    }






    public void evaluateExpression(View v){






        //TODO Close Parens  (Madelyn)
        //TODO fix parens for SOHCAHTOA


        //TODO Switch to Anti's (Madelyn)

        //TODO fix EXP and x^Y (THINK)

        //TODO Figure out percent(MAYBE)

        //TODO Clear Screen after answer

        //TODO Close Parens  (Madelyn)
        //TODO Switch to Anti's (Madelyn)

        //TODO fix EXP and x^Y (THINK)
        //TODO Figure out percent(MAYBE)
        //TODO fix log function

        //TODO Add Textview that shows ans

        //TODO fix paren




        try {
            calcScreen = (TextView) findViewById(R.id.calcScreen);
            toBeEvaluated=calcScreen.getText().toString();
            Expressions expressions = new Expressions(toBeEvaluated);
            BigDecimal result = new BigDecimal(String.valueOf(expressions.eval()));
            toBeEvaluated=result.toPlainString();
            calcScreen.setText((toBeEvaluated));


        }catch (EmptyStackException e){
            calcScreen.setText("Err. Nothing Here, Clear Screen.");
        } catch (NullPointerException e){
            calcScreen.setText("Err. Invalid input, Clear Screen.");
        } catch (RuntimeException r){
            calcScreen.setText("You broke me. :( Clear.");
        }
        ans ="";


    }


}

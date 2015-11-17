package br.edu.ifpb.si.pdm.arroxa_game;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView intervalo;
    private EditText num;
    private Jogo jogo;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn = (Button)this.findViewById(R.id.botao);
        this.intervalo = (TextView)this.findViewById(R.id.numIntervalo);
        this.num = (EditText)this.findViewById(R.id.numero);
        this.jogo = new Jogo(0,100);
        this.intervalo.setText(jogo.getMin()+" - "+jogo.getMax());
        this.btn.setOnClickListener(new OnClickBotao());

            }

        private class OnClickBotao implements View.OnClickListener {
            @Override
            public void onClick(View v) {


                switch (jogo.chute(Integer.parseInt(num.getText().toString()))) {

                    case GANHOU:
                        intervalo.setText(" VOCÊ VENCEU! ");
                        btn.setVisibility(View.INVISIBLE);
                        num.setVisibility(View.INVISIBLE);
                        layout.setBackgroundColor(Color.GREEN);
                        break;
                    case PERDEU:
                        intervalo.setText(" VOCÊ PERDEU! ");
                        break;
                    case TENTAR_DE_NOVO:
                        intervalo.setText(jogo.getMin() + " - " + jogo.getMax());
                        break;

                }

            }


        }
}

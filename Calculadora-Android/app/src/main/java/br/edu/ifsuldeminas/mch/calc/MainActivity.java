package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao, btnPorcento, btnVirgula, btnIgual, btnLimpar, btnApagar;
    private boolean haveDot = false;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;
    private Button btnZero, btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis, btnSete, btnOito, btnNove;
    private String expressao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        btnZero = findViewById(R.id.buttonZeroID);
        btnUm = findViewById(R.id.buttonUmID);
        btnDois = findViewById(R.id.buttonDoisID);
        btnTres = findViewById(R.id.buttonTresID);
        btnQuatro = findViewById(R.id.buttonQuatroID);
        btnCinco = findViewById(R.id.buttonCincoID);
        btnSeis = findViewById(R.id.buttonSeisID);
        btnSete = findViewById(R.id.buttonSeteID);
        btnOito = findViewById(R.id.buttonOitoID);
        btnNove = findViewById(R.id.buttonNoveID);

        btnVirgula = findViewById(R.id.buttonVirgulaID);
        btnPorcento = findViewById(R.id.buttonPorcentoID);
        btnMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        btnDivisao = findViewById(R.id.buttonDivisaoID);
        btnSubtracao = findViewById(R.id.buttonSubtracaoID);
        btnSoma = findViewById(R.id.buttonSomaID);
        btnIgual = findViewById(R.id.buttonIgualID);
        btnLimpar = findViewById(R.id.buttonResetID);
        btnApagar = findViewById(R.id.buttonDeleteID);


        btnPorcento.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (ultimoChar == '-' && (expressao.charAt(expressao.length() - 2) == '*' || expressao.charAt(expressao.length() - 2) == '÷')) {
                            return;
                        }
                        if (haveOperator(ultimoChar)) {
                            expressao = expressao.substring(0, expressao.length() - 1);
                        }
                        showScreen(btnPorcento);
                        haveDot = false;
                    } else {
                        if (!textViewResultado.getText().equals("0")) {
                            pickResultText(btnPorcento);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnMultiplicacao.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);

                        if (ultimoChar == '-' && (expressao.charAt(expressao.length() - 2) == '*' || expressao.charAt(expressao.length() - 2) == '÷')) {
                            return;
                        }
                        if (haveOperator(ultimoChar)) {
                            expressao = expressao.substring(0, expressao.length() - 1);
                        }
                        showScreen(btnMultiplicacao);
                        haveDot = false;
                    } else {
                        if (!textViewResultado.getText().equals("0")) {
                            pickResultText(btnMultiplicacao);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnDivisao.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (ultimoChar == '-' && (expressao.charAt(expressao.length() - 2) == '*' || expressao.charAt(expressao.length() - 2) == '÷')) {
                            return;
                        }

                        if (haveOperator(ultimoChar)) {
                            expressao = expressao.substring(0, expressao.length() - 1);
                        }

                        showScreen(btnDivisao);
                        haveDot = false;
                    } else {
                        if (!textViewResultado.getText().equals("0")) {
                            pickResultText(btnDivisao);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnSubtracao.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (negativeNumber(ultimoChar)) {
                            showScreen(btnSubtracao);
                        } else {
                            if (ultimoChar == '-') {
                                expressao = expressao.substring(0, expressao.length() - 1);
                            } else {
                                if (haveOperator(ultimoChar)) {
                                    expressao = expressao.substring(0, expressao.length() - 1);
                                }
                            }
                            showScreen(btnSubtracao);
                        }
                        haveDot = false;
                    } else {
                        if (!textViewResultado.getText().equals("0")) {
                            pickResultText(btnSubtracao);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnSoma.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (!(ultimoChar == '-' && (expressao.charAt(expressao.length() - 2) == '*' || expressao.charAt(expressao.length() - 2) == '÷'))) {
                            if (haveOperator(ultimoChar)) {
                                expressao = expressao.substring(0, expressao.length() - 1);
                            }
                            showScreen(btnSoma);
                            haveDot = false;
                        }

                    } else {
                        if (!textViewResultado.getText().equals("0")) {
                            pickResultText(btnSoma);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnVirgula.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.equals("")) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (haveOperator(ultimoChar)) {
                            return;
                        }
                    }

                    if (haveDot == false) {
                        if (expressao.equals("")) {
                            pickResultText(btnVirgula);
                        } else {
                            showScreen(btnVirgula);
                        }
                        haveDot = true;
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnLimpar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressao = "";
                textViewResultado.setText("0");
                haveDot = false;
                textViewUltimaExpressao.setText(expressao);
            }
        }));

        btnApagar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!expressao.isEmpty()) {
                        char ultimoChar = expressao.charAt(expressao.length() - 1);
                        if (ultimoChar == btnVirgula.getText().charAt(0)) {
                            haveDot = false;
                        }
                        expressao = expressao.substring(0, expressao.length() - 1);
                        textViewUltimaExpressao.setText(expressao);
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }));

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    expressao = expressao.replace("÷", "/");
                    char ultimoChar = expressao.charAt(expressao.length() - 1);
                    char penultimoChar = expressao.charAt(expressao.length() - 2);
                    if (haveOperator(ultimoChar)) {
                        expressao = expressao.substring(0, expressao.length() - 1);
                        if(haveOperator(penultimoChar)){
                            expressao = expressao.substring(0, expressao.length() - 1);
                        }
                    }
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = avaliadorExpressao.calculate();


                    expressao = "";
                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText(String.format("%.2f", resultado));
                } catch (
                        Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

        btnZero.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnZero);
            }
        }));

        btnUm.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnUm);
            }
        }));

        btnDois.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnDois);
            }
        }));

        btnTres.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnTres);
            }
        }));

        btnQuatro.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnQuatro);
            }
        }));

        btnCinco.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnCinco);
            }
        }));

        btnSeis.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnSeis);
            }
        }));

        btnSete.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnSete);
            }
        }));

        btnOito.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnOito);
            }
        }));

        btnNove.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(btnNove);
            }
        }));
    }

    public void showScreen(Button btn) {
        expressao += btn.getText();
        textViewUltimaExpressao.setText(expressao);
    }

    public boolean negativeNumber(char ultimoChar) {
        if (ultimoChar == btnDivisao.getText().charAt(0) || ultimoChar == btnMultiplicacao.getText().charAt(0) || expressao.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean secondOperator(char penultimoChar) {
        if (expressao.charAt(penultimoChar) == btnDivisao.getText().charAt(0) ||
                expressao.charAt(penultimoChar) == btnMultiplicacao.getText().charAt(0))
            return true;
        return false;
    }

    public boolean haveOperator(char ultimoChar) {
        if ((ultimoChar == btnDivisao.getText().charAt(0) ||
                ultimoChar == btnMultiplicacao.getText().charAt(0) ||
                ultimoChar == btnSubtracao.getText().charAt(0) ||
                ultimoChar == btnSoma.getText().charAt(0) ||
                ultimoChar == btnPorcento.getText().charAt(0) ||
                ultimoChar == btnPorcento.getText().charAt(0)))
            return true;

        return false;
    }

    public void pickResultText(Button btn) {
        expressao += textViewResultado.getText();
        expressao += btn.getText();
        textViewUltimaExpressao.setText(expressao);
        textViewResultado.setText("0");
    }
}
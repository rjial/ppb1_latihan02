package com.rijal.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Complex;
import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;
import org.scijava.parsington.ExpressionParser;
import org.scijava.parsington.eval.DefaultTreeEvaluator;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnTitik, btnKurungBuka, btnKurungTutup, btnPangkat;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    Button btnHapus, btnExec;
    TextView txtPreview, txtHistory;
    Boolean incept = false;
    double hasil = 0;
    String hasil_string = "";
    List<String> cacheList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String cache = "";
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnKali = (Button) findViewById(R.id.btnKali);
        btnBagi = (Button) findViewById(R.id.btnBagi);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        btnExec = (Button) findViewById(R.id.btnExec);
        btnKurungBuka = (Button) findViewById(R.id.btnKurungBuka);
        btnKurungTutup = (Button) findViewById(R.id.btnKurungTutup);
        btnTitik = (Button) findViewById(R.id.btnTitik);
        btnExec = (Button) findViewById(R.id.btnExec);
        btnPangkat = (Button) findViewById(R.id.btnPangkat);
        txtPreview = (TextView) findViewById(R.id.txtPreview);
        txtPreview.setHorizontallyScrolling(true);
        txtPreview.setMovementMethod(ScrollingMovementMethod.getInstance());
        txtHistory = (TextView) findViewById(R.id.txtHistory);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("1", cacheList, view, txtPreview);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("2", cacheList, view, txtPreview);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("3", cacheList, view, txtPreview);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("4", cacheList, view, txtPreview);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("5", cacheList, view, txtPreview);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("6", cacheList, view, txtPreview);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("7", cacheList, view, txtPreview);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("8", cacheList, view, txtPreview);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("9", cacheList, view, txtPreview);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("0", cacheList, view, txtPreview);
            }
        });
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("+", cacheList, view, txtPreview);
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("kurang", cacheList, view, txtPreview);
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("/", cacheList, view, txtPreview);
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("kali", cacheList, view, txtPreview);
            }
        });
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("Hapus", cacheList, view, txtPreview);
            }
        });
        btnHapus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tekanTombol("hapus_semua", cacheList, view, txtPreview);
                hapusSemua(txtHistory, txtPreview);
                return false;
            }
        });
        btnExec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("exec", cacheList, view, txtPreview, txtHistory);
            }
        });
        btnKurungBuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("(", cacheList, view, txtPreview);
            }
        });
        btnKurungTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol(")", cacheList, view, txtPreview);
            }
        });
        btnTitik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol(".", cacheList, view, txtPreview);
            }
        });
        btnPangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekanTombol("^", cacheList, view, txtPreview);
            }
        });
    }
    private void addItem(String action, List<String> cacheList) {
        String terakhir = "";
        if (cacheList.size() > 0) {
            terakhir = cacheList.get(cacheList.size() - 1).toString();
        }
        switch (action) {
            case "1":
                cacheList.add("1");
                break;
            case "2":
                cacheList.add("2");
                break;
            case "3":
                cacheList.add("3");
                break;
            case "4":
                cacheList.add("4");
                break;
            case "5":
                cacheList.add("5");
                break;
            case "6":
                cacheList.add("6");
                break;
            case "7":
                cacheList.add("7");
                break;
            case "8":
                cacheList.add("8");
                break;
            case "9":
                cacheList.add("9");
                break;
            case "0":
                cacheList.add("0");
                break;
            case "+":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString())) {
                        cacheList.add("+");
                    } else {
                        if(cacheList.get(0) == "-") {
                            cacheList.set(cacheList.size() - 1, "");
                        } else if(terakhir.toString() == ")") {
                            cacheList.add("+");
                        } else if(terakhir.toString() == "-") {
                            cacheList.set(cacheList.size() - 1, "+");
                        } else {
                            cacheList.set(cacheList.size() - 1, "+");
                        }
                    }
                } else {

                }

                break;
            case "kurang":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString())) {
                        cacheList.add("-");
                        } else {
                            cacheList.set(cacheList.size() - 1, "-");
                        }
                } else {

                }
                break;
            case "kali":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString())) {
                        cacheList.add("*");
                    } else {
                        if(cacheList.get(0) == "-") {
                            cacheList.set(cacheList.size() - 1, "*");
                        } else if(terakhir.toString() == ")") {
                            cacheList.add("*");
                        } else if(terakhir.toString() == "-") {
                            cacheList.set(cacheList.size() - 1, "*");
                        } else {
                            cacheList.set(cacheList.size() - 1, "*");
                        }
                    }
                } else {

                }

                break;
            case "/":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString())) {
                        cacheList.add("/");
                    } else {
                        if(cacheList.get(0) == "-") {
                            cacheList.set(cacheList.size() - 1, "/");
                        } else if(terakhir.toString() == ")") {
                            cacheList.add("/");
                        } else if(terakhir.toString() == "-") {
                            cacheList.set(cacheList.size() - 1, "/");
                        } else {
                            cacheList.set(cacheList.size() - 1, "/");
                        }
                    }
                }
                break;
            case "Hapus":
                if (cacheList.size() > 0) {
                    cacheList.remove(cacheList.size() - 1);
                }
                break;
            case "hapus_semua":
                if (cacheList.size() > 0) {
                    cacheList.clear();
                }
                break;
            case "exec":
                Symbols sym = new Symbols();

                try {
                    hasil = (new Symbols()).eval(TextUtils.join("", cacheList));
                } catch (SyntaxException e) {
                    e.printStackTrace();
                }
                    if (hasil % 1 == 0) {
                        hasil_string = String.valueOf(Math.round(hasil));
                    } else {
                        hasil_string = String.valueOf(hasil);
                    }
                    incept = true;

                break;
            case "(":
                cacheList.add("(");
                break;
            case ")":
                cacheList.add(")");
                break;
            case ".":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString()) && terakhir.toString() != ".") {
                        cacheList.add(".");
                    }
                }
                break;
            case "^":
                if (cacheList.size() > 0) {
                    if (identifiedInt(terakhir.toString())) {
                        cacheList.add("^");
                    } else {
                        if(cacheList.get(0) == "-") {
                            cacheList.set(cacheList.size() - 1, "^");
                        } else if(terakhir.toString() == ")") {
                            cacheList.add("^");
                        } else if(terakhir.toString() == "-") {
                            cacheList.set(cacheList.size() - 1, "^");
                        } else {
                            cacheList.set(cacheList.size() - 1, "^");
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
    private void tekanTombol(String action, List<String> cacheList, View view, TextView txtPreview, TextView txtHistory) {
        addItem(action, cacheList);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (incept) {
                    List<String> list_cache = Arrays.asList(String.valueOf(hasil_string).split(""));
                    txtHistory.setText(TextUtils.join("", cacheList));
                    txtPreview.setText(hasil_string);
                    cacheList.clear();
                    cacheList.addAll(list_cache);
                    incept = false;
                } else {
                    txtPreview.setText(TextUtils.join("", cacheList));
                }
            }
        });
    }
    private void hapusSemua(TextView txtHistory, TextView txtPreview) {
        txtHistory.setText("");
        txtPreview.setText("");
    }
    private void tekanTombol(String action, List<String> cacheList, View view, TextView txtPreview) {
        addItem(action, cacheList);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (incept) {
                    List<String> list_cache = Arrays.asList(String.valueOf(hasil).split(""));
                    txtPreview.setText(String.valueOf(hasil));
                    cacheList.clear();
                    int i = 0;
                    while(i < list_cache.size()) {
                        cacheList.add(list_cache.get(i));
                    }
                    incept = false;
                } else {
                    txtPreview.setText(TextUtils.join("", cacheList));
                }

            }
        });

    }
    private boolean identifiedInt(String uhhhhh) {
        if (uhhhhh == null) {
            return false;
        }
        try {
            int coba = Integer.parseInt(uhhhhh);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
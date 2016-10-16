package id.sch.smktelkom_mlg.tugas01.xiirpl1027.pendaftaranendurocross;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner kelas;
    Button submit;
    TextView tvhasil;
    RadioButton rbPR, rbWN;
    CheckBox mkn, jrs, htl;
    EditText nama, tgl, alamat;
    String jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kelas = (Spinner) findViewById(R.id.Kelas);
        tvhasil = (TextView) findViewById(R.id.textviewhasil);
        rbPR = (RadioButton) findViewById(R.id.rbp);
        rbWN = (RadioButton) findViewById(R.id.rbw);
        jrs = (CheckBox) findViewById(R.id.jersey);
        mkn = (CheckBox) findViewById(R.id.makan);
        htl = (CheckBox) findViewById(R.id.hotel);
        nama = (EditText) findViewById(R.id.nama);
        alamat = (EditText) findViewById(R.id.alamat);
        tgl = (EditText) findViewById(R.id.tgl_lahir);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doclick();
            }
        });
    }

    private void doclick() {
        String name = nama.getText().toString();
        String lahir = tgl.getText().toString();
        String almt = alamat.getText().toString();
        if (isValid()) {
            if (rbPR.isChecked()) {
                jk = rbPR.getText().toString();
            } else if (rbWN.isChecked()) {
                jk = rbWN.getText().toString();
            }
            String fasilitas = "Hobi Anda : \n";
            int leng = fasilitas.length();
            if (jrs.isChecked()) fasilitas += jrs.getText() + "\n";
            if (mkn.isChecked()) fasilitas += mkn.getText() + "\n";
            if (htl.isChecked()) fasilitas += htl.getText() + "\n";

            if (fasilitas.length() == leng) fasilitas += "Tidak ada pada pilihan";
            tvhasil.setText("Pendaftaran Berhasil! \n" + "Nama : " + name + "\nTanggal Lahir : " + lahir +
                    "\nAlamat : " + almt + "\nJenis Kelamin : " + jk + "\nKelas : " + kelas.getSelectedItem().toString() +
                    "\n" + fasilitas + "\n\n\t\tSelamat Begabung di Enduro Cross 2016!");
        }

    }

    private boolean isValid() {
        boolean valid = true;
        String name = nama.getText().toString();
        String almt = alamat.getText().toString();
        String lahir = tgl.getText().toString();

        if (name.isEmpty()) {
            nama.setError("Nama Belum Diisi!");
            valid = false;
        } else if (name.length() < 3) {
            nama.setError("Nama Minimal 3 Huruf!");
            valid = false;
        } else {
            nama.setError(null);
        }

        if (almt.isEmpty()) {
            alamat.setError("Alamat Belum Diisi!");
            valid = false;
        } else {
            alamat.setError(null);
        }

        if (lahir.isEmpty()) {
            tgl.setError("Tanggal Lahir Belum Diisi!");
            valid = false;
        } else {
            tgl.setError(null);
        }

        if ((!rbPR.isChecked()) && (!rbWN.isChecked())) {
            valid = false;
        }

        return valid;
    }
}

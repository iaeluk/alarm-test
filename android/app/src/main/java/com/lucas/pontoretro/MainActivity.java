package com.lucas.pontoretro;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // AQUI É A MÁGICA: Registramos o plugin que criamos acima
        registerPlugin(AlarmPlugin.class);
    }
}

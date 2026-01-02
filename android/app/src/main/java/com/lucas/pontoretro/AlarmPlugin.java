package com.lucas.pontoretro;

import android.content.Intent;
import android.provider.AlarmClock;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Alarm")
public class AlarmPlugin extends Plugin {

    @PluginMethod
    public void set(PluginCall call) {
        // Recebe os dados do Javascript
        Integer hour = call.getInt("hour");
        Integer minute = call.getInt("minute");

        // Validação simples
        if (hour == null || minute == null) {
            call.reject("Hora e minuto são obrigatórios");
            return;
        }

        // Cria a intenção nativa do Android usando a API oficial de Alarme
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, hour);
        i.putExtra(AlarmClock.EXTRA_MINUTES, minute);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Saída Ponto");
        
        // true = define em silêncio / false = abre o app do relógio para confirmar
        // O Android recomenda false para garantir que o usuário veja
        i.putExtra(AlarmClock.EXTRA_SKIP_UI, false); 

        // Executa a ação
        try {
            getActivity().startActivity(i);
            call.resolve();
        } catch (Exception e) {
            call.reject("Erro ao abrir Relógio: " + e.getMessage());
        }
    }
}

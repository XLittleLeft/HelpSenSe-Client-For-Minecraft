package cn.XLittleLeft.mod.mods.fun;

import cn.XLittleLeft.api.value.Mode;
import cn.XLittleLeft.mod.Mod;
import cn.XLittleLeft.mod.ModType;

import java.io.IOException;

public class ShutDown
        extends Mod {

    public Mode<Enum> shutdownmode = new Mode<Enum>("shutdownmode", "shutdownmode", shutdownmode1.values(), shutdownmode1.Shutdown);

    public ShutDown() {
        super("Magic button", new String[]{"shutdown", "ShutDown"}, ModType.Fun);
        super.addValues(this.shutdownmode);
        this.setSuffix(this.shutdownmode.getValue());
    }

    public void onEnable() {
        if (shutdownmode.getValue() == shutdownmode1.Shutdown) {
            Runtime run = Runtime.getRuntime();
            {
                try {
                    run.exec("Shutdown.exe -s -t 00");
                    run.exit(0);
                } catch (IOException e) {
                    run.exit(0);
                }
            }
        } else if (shutdownmode.getValue() == shutdownmode1.Reset) {
            Runtime run = Runtime.getRuntime();
            {
                try {
                    run.exec("Shutdown.exe -r 0");
                    run.exit(0);
                } catch (IOException e) {
                    run.exit(0);
                }
            }
        }
        this.setEnabled(false);
    }

    public enum shutdownmode1 {
        Shutdown,
        Reset;
	}

}

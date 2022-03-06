package cn.XLittleLeft.module.modules.fun;

import java.io.IOException;

import cn.XLittleLeft.module.Module;
import cn.XLittleLeft.module.ModuleType;

public class ShutDown
extends Module {

		public ShutDown() {
	    super("Magic button", new String[]{"shutdown", "ShutDown"}, ModuleType.Fun);
		this.setSuffix("Fast");
	}
		public void onEnable() {
		Runtime run = Runtime.getRuntime();{
        try {
            run.exec("Shutdown.exe -s -t 00");    //火树趋势
            run.exit(0);
        } catch (IOException e) {
            run.exit(0);
        		}
			}
		}
}

package cn.XLittleLeft.mod.mods.player;

import cn.XLittleLeft.api.EventHandler;
import cn.XLittleLeft.api.events.world.EventPreUpdate;
import cn.XLittleLeft.api.value.Numbers;
import cn.XLittleLeft.api.value.Option;
import cn.XLittleLeft.mod.Mod;
import cn.XLittleLeft.mod.ModType;
import cn.XLittleLeft.notifications.Notification;
import cn.XLittleLeft.utils.Helper;
import cn.XLittleLeft.utils.TimerUtil;

public class IQBooster extends Mod {
	
	TimerUtil Delay = new TimerUtil();
	
	public Option<Boolean> Booster = new Option<Boolean>("Booster", "Booster", true);
	public Option<Boolean> Keep = new Option<Boolean>("JustKeepSuffix", "JustKeepSuffix", true);
	public Option<Boolean> ChouSiLe = new Option<Boolean>("114514IQ", "114514IQ", false);
	public Numbers<Double> IQValue = new Numbers<Double>("IQValue", "IQValue", 10000.0,-10000.0,0.0,1.0);

	public IQBooster() {
		super("IQBooster", new String[] {"IQBooster"}, ModType.Player);
		super.addValues(this.IQValue,this.Booster,this.Keep,this.ChouSiLe);
	}
	
	@EventHandler
	public void onUpdate(EventPreUpdate e) {
		if(this.ChouSiLe.getValue()){
			this.setSuffix("114514");
			Notification.send("You Have A 114514 IQ", Notification.Type.INFO);
			Helper.sendMessageWithoutPrefix("You Have A 114514 IQ");
		} else {
		this.setSuffix("IQ: " + this.IQValue.getValue());
		}
		if(!this.Keep.getValue()) {
			if(this.Delay.delay(1000)) {
				if(this.IQValue.getValue() <= 0) {
					Notification.send("You Have A Low IQ", Notification.Type.ERROR);
					Helper.sendMessageWithoutPrefix("You Have A Low IQ");
				}
				Delay.reset();
							} else if (this.IQValue.getValue() <= 100 && this.IQValue.getValue() >=0) {
								if(this.Delay.delay(1000)) {
									Notification.send("You Have A Normal IQ", Notification.Type.INFO);
									Helper.sendMessageWithoutPrefix("You Have A Normal IQ");
								}
								Delay.reset();
											} else if (this.IQValue.getValue() >= 1000 && this.IQValue.getValue() <= 10000) {
												if(this.Delay.delay(1000)) {
													Notification.send("You Have A High IQ", Notification.Type.INFO);
													Helper.sendMessageWithoutPrefix("You Have A High IQ");
												}
												Delay.reset();
											}	
					}
	}
	
	public void onEnable() {
		if(this.Delay.delay(1500)) {
			this.setEnabled(false);
		}
		Delay.reset();
		super.onEnable();
	}
	
	public void onDisable() {
		if (this.Booster.getValue()) {
				if(this.Delay.delay(1500)) {
					this.setEnabled(true);
				}
				Delay.reset();
				super.onDisable();
		}
	}
	
}

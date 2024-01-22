package net.starlight.potato_core;

import net.fabricmc.api.ModInitializer;
import net.starlight.potato_core.mod.ModManager;
import net.starlight.potato_core.register.ModBlocks;
import net.starlight.potato_core.register.*;
import net.starlight.potato_core.screen.ModScreenHandlers;
import net.starlight.potato_core.sound.Sounds;
import net.starlight.potato_core.register.ModRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 主要的登记处
public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "potato_core";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ModManager modManager;

	@Override
	public void onInitialize() {
		/* Block和Item登记口 */
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		/* 图画和界面处理器登记口 */
		ModPaintings.registerPaintings();
		ModScreenHandlers.registerAllScreenHandles();
		/* 液体和生态群系登记口 */
		ModFluids.registerFluids();
		ModBiome.registerBiome();
		/* 声音登记口 */
		Sounds.registerSounds();
		/* 传送门登记口 */
		ModPortal.registerPortal();

		// Other Register
		/* 方块在生态群系中渲染颜色的登记处 */
		ModRegister.registerBlockColor();
	}

	/**
	 * <p>需要将manager在客户端主类中创建</p>
	 * <p>游戏启动时调用客户端主页中的run来创建</p>
	 * <p>在run方法被调用时，打印日志</p>
	 */
	public static void run() {
		modManager = new ModManager();
		modManager.load();
		FirstMod.LOGGER.info("FirstMod runing...");
	}
	/**
	 * <p>停止，模块禁用方法</p>
	 * <p>在stop方法被调用时，打印日志</p>
	 */
	public static void stop() {
		FirstMod.LOGGER.info("FirstMod stopping...");
	}
}

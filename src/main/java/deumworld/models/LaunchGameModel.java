/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deumworld.models;

import deumworld.Main;
//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author PrimalCat
 */
public class LaunchGameModel {
    private static String name = "Player";
    private static Configs config;
    private static String DosName = "Windows 10";
    private static String DosVersion = "10.0";

    public static String getName() {
        config = Main.getConfigs();
        name = config.getName();
        return name;
    }

    public static void setName(String name) {
        LaunchGameModel.name = name;
    }
    public void startGame(String server) throws IOException, InterruptedException{
        if(server == "messaland"){
            String name = getName();
            ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","start .\\Install\\runtime\\java-runtime-gamma\\windows-x64\\java-runtime-gamma\\bin\\javaw.exe -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump \"-Dos.name=Windows 10\" -Dos.version=10.0 -Xss1M -Djava.library.path=. -Dminecraft.launcher.brand=minecraft-launcher -Dminecraft.launcher.version=2.3.280 -cp .\\Install\\libraries\\net\\fabricmc\\tiny-mappings-parser\\0.3.0+build.17\\tiny-mappings-parser-0.3.0+build.17.jar;.\\Install\\libraries\\net\\fabricmc\\sponge-mixin\\0.11.4+mixin.0.8.5\\sponge-mixin-0.11.4+mixin.0.8.5.jar;.\\Install\\libraries\\net\\fabricmc\\tiny-remapper\\0.8.2\\tiny-remapper-0.8.2.jar;.\\Install\\libraries\\net\\fabricmc\\access-widener\\2.1.0\\access-widener-2.1.0.jar;.\\Install\\libraries\\org\\ow2\\asm\\asm\\9.3\\asm-9.3.jar;.\\Install\\libraries\\org\\ow2\\asm\\asm-analysis\\9.3\\asm-analysis-9.3.jar;.\\Install\\libraries\\org\\ow2\\asm\\asm-commons\\9.3\\asm-commons-9.3.jar;.\\Install\\libraries\\org\\ow2\\asm\\asm-tree\\9.3\\asm-tree-9.3.jar;.\\Install\\libraries\\org\\ow2\\asm\\asm-util\\9.3\\asm-util-9.3.jar;.\\Install\\libraries\\net\\fabricmc\\intermediary\\1.19\\intermediary-1.19.jar;.\\Install\\libraries\\net\\fabricmc\\fabric-loader\\0.14.8\\fabric-loader-0.14.8.jar;.\\Install\\libraries\\com\\mojang\\logging\\1.0.0\\logging-1.0.0.jar;.\\Install\\libraries\\com\\mojang\\blocklist\\1.0.10\\blocklist-1.0.10.jar;.\\Install\\libraries\\com\\mojang\\patchy\\2.2.10\\patchy-2.2.10.jar;.\\Install\\libraries\\com\\github\\oshi\\oshi-core\\5.8.5\\oshi-core-5.8.5.jar;.\\Install\\libraries\\net\\java\\dev\\jna\\jna\\5.10.0\\jna-5.10.0.jar;.\\Install\\libraries\\net\\java\\dev\\jna\\jna-platform\\5.10.0\\jna-platform-5.10.0.jar;.\\Install\\libraries\\org\\slf4j\\slf4j-api\\1.8.0-beta4\\slf4j-api-1.8.0-beta4.jar;.\\Install\\libraries\\org\\apache\\logging\\log4j\\log4j-slf4j18-impl\\2.17.0\\log4j-slf4j18-impl-2.17.0.jar;.\\Install\\libraries\\com\\ibm\\icu\\icu4j\\70.1\\icu4j-70.1.jar;.\\Install\\libraries\\com\\mojang\\javabridge\\1.2.24\\javabridge-1.2.24.jar;.\\Install\\libraries\\net\\sf\\jopt-simple\\jopt-simple\\5.0.4\\jopt-simple-5.0.4.jar;.\\Install\\libraries\\io\\netty\\netty-common\\4.1.77.Final\\netty-common-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-buffer\\4.1.77.Final\\netty-buffer-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-codec\\4.1.77.Final\\netty-codec-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-handler\\4.1.77.Final\\netty-handler-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-resolver\\4.1.77.Final\\netty-resolver-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-transport\\4.1.77.Final\\netty-transport-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-transport-native-unix-common\\4.1.77.Final\\netty-transport-native-unix-common-4.1.77.Final.jar;.\\Install\\libraries\\io\\netty\\netty-transport-classes-epoll\\4.1.77.Final\\netty-transport-classes-epoll-4.1.77.Final.jar;.\\Install\\libraries\\com\\google\\guava\\failureaccess\\1.0.1\\failureaccess-1.0.1.jar;.\\Install\\libraries\\com\\google\\guava\\guava\\31.0.1-jre\\guava-31.0.1-jre.jar;.\\Install\\libraries\\org\\apache\\commons\\commons-lang3\\3.12.0\\commons-lang3-3.12.0.jar;.\\Install\\libraries\\commons-io\\commons-io\\2.11.0\\commons-io-2.11.0.jar;.\\Install\\libraries\\commons-codec\\commons-codec\\1.15\\commons-codec-1.15.jar;.\\Install\\libraries\\com\\mojang\\brigadier\\1.0.18\\brigadier-1.0.18.jar;.\\Install\\libraries\\com\\mojang\\datafixerupper\\5.0.28\\datafixerupper-5.0.28.jar;.\\Install\\libraries\\com\\google\\code\\gson\\gson\\2.8.9\\gson-2.8.9.jar;.\\Install\\libraries\\com\\mojang\\authlib\\3.5.41\\authlib-3.5.41.jar;.\\Install\\libraries\\org\\apache\\commons\\commons-compress\\1.21\\commons-compress-1.21.jar;.\\Install\\libraries\\org\\apache\\httpcomponents\\httpclient\\4.5.13\\httpclient-4.5.13.jar;.\\Install\\libraries\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;.\\Install\\libraries\\org\\apache\\httpcomponents\\httpcore\\4.4.14\\httpcore-4.4.14.jar;.\\Install\\libraries\\it\\unimi\\dsi\\fastutil\\8.5.6\\fastutil-8.5.6.jar;.\\Install\\libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.17.0\\log4j-api-2.17.0.jar;.\\Install\\libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.17.0\\log4j-core-2.17.0.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl\\3.3.1\\lwjgl-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl\\3.3.1\\lwjgl-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl\\3.3.1\\lwjgl-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.1\\lwjgl-jemalloc-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.1\\lwjgl-jemalloc-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.1\\lwjgl-jemalloc-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-openal\\3.3.1\\lwjgl-openal-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-openal\\3.3.1\\lwjgl-openal-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-openal\\3.3.1\\lwjgl-openal-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.1\\lwjgl-opengl-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.1\\lwjgl-opengl-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.1\\lwjgl-opengl-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.1\\lwjgl-glfw-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.1\\lwjgl-glfw-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.1\\lwjgl-glfw-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-stb\\3.3.1\\lwjgl-stb-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-stb\\3.3.1\\lwjgl-stb-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-stb\\3.3.1\\lwjgl-stb-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.1\\lwjgl-tinyfd-3.3.1.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.1\\lwjgl-tinyfd-3.3.1-natives-windows.jar;.\\Install\\libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.1\\lwjgl-tinyfd-3.3.1-natives-windows-x86.jar;.\\Install\\libraries\\com\\mojang\\text2speech\\1.13.9\\text2speech-1.13.9.jar;.\\Install\\libraries\\com\\mojang\\text2speech\\1.13.9\\text2speech-1.13.9-natives-windows.jar;.\\Install\\versions\\fabric-loader-0.14.8-1.19\\fabric-loader-0.14.8-1.19.jar \"-DFabricMcEmu= net.minecraft.client.main.Main \" -Xmx4096m -Xms256m -Dminecraft.applet.TargetDirectory=.\\Instances\\MessaLandLauncher -Dfml.ignorePatchDiscrepancies=true -Dfml.ignoreInvalidMinecraftCertificates=true -Duser.language=en -Duser.country=US -Dlog4j.configurationFile=.\\Install\\assets\\log_configs\\client-1.12.xml net.fabricmc.loader.impl.launch.knot.KnotClient --username "+name.toString()+" --version fabric-loader-0.14.8-1.19 --gameDir .\\Instances\\MessaLandLauncher --assetsDir .\\Install\\assets --assetIndex 1.19 --accessToken null --userType msa --versionType release --width 1024 --height 768");
            builder.redirectErrorStream(true);
            builder.directory(new File(System.getenv("APPDATA")+"\\test"));
            Process p = builder.start();
        }
        
        
//        System.out.println("Launched");
    }

}

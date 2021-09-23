package com.github.opybbt.flutter_statusbar_text_color;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterStatusbarTextColorPlugin */
public class FlutterStatusbarTextColorPlugin implements MethodCallHandler, FlutterPlugin {
  private MethodChannel methodChannel;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    FlutterStatusbarTextColorPlugin instance = new FlutterStatusbarTextColorPlugin();
    instance.initInstance(registrar.messenger(), registrar.context());
  }

  public void initInstance(BinaryMessenger messenger, Context context){
    methodChannel = new MethodChannel(messenger, "flutter_statusbar_text_color");
    methodChannel.setMethodCallHandler(new FlutterStatusbarTextColorPlugin());
  }

  private void dispose(){
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
  }

  @Override 
  public void onAttachedToEngine(FlutterPluginBinding binding){
    initInstance(binding.getBinaryMessenger(), binding.getApplicationContext());
  }

  @Override
  public void onDetachedFromEngine(FlutterPlugin binding){
    dispose();
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    result.notImplemented();
  }
}

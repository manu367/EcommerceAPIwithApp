package com.example.ecommerceapp.activity;

import io.agora.rtc2.RtcEngine;
import io.agora.rtc2.RtcEngineConfig;
import io.agora.rtc2.IRtcEngineEventHandler;
import android.content.Context;

public class AgoraManager {
    private static RtcEngine rtcEngine;

    public static RtcEngine initAgoraEngine(Context context, String appId, IRtcEngineEventHandler handler) {
        if (rtcEngine == null) {
            try {
                RtcEngineConfig config = new RtcEngineConfig();
                config.mContext = context.getApplicationContext();
                config.mAppId = appId;
                config.mEventHandler = handler; // must not be null
                rtcEngine = RtcEngine.create(config);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return rtcEngine;
    }

    public static RtcEngine getEngine() {
        return rtcEngine;
    }
}

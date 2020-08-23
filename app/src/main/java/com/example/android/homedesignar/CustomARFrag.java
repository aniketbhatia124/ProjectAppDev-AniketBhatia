package com.example.android.homedesignar;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;

public class CustomARFrag extends ArFragment {
    @Override
    protected Config getSessionConfiguration(Session session) {
        Config config= super.getSessionConfiguration(session);
        config.setFocusMode(Config.FocusMode.AUTO);
        config.setCloudAnchorMode(Config.CloudAnchorMode.ENABLED);
        session.configure(config);
        return config;

    }
}

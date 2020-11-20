package com.vegazsdev.bobobot.utils;

import com.vegazsdev.bobobot.Main;
import com.vegazsdev.bobobot.core.CustomConfigFileObj;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class Config {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(Config.class);

    public boolean createDefConfig() {
        try {
            FileTools.createFolder("configs");
            Properties saveProps = new Properties();
            saveProps.setProperty("bot-token", "1414070106:AAEG7-F7U2G9dMUoHd6rdtwvX40YXGG7IBM");
            saveProps.setProperty("bot-username", "priyobakerbot");
            saveProps.setProperty("bot-master", "1032152179");
            saveProps.store(new FileOutputStream("configs/" +
                    Objects.requireNonNull(XMLs.getFromStringsXML(Main.DEF_CORE_STRINGS_XML, "config_file"))
            ), "Bo³+t config file");
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    public static String getDefConfig(String prop) {
        try {
            Properties getProps = new Properties();
            getProps.load(new FileInputStream("configs/config.prop"));
            return getProps.getProperty(prop);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public static boolean createCustomConfig(ArrayList<CustomConfigFileObj> configs, String configFile, String comment) {
        FileTools.createFolder("configs");
        try {
            Properties saveProps = new Properties();
            for (CustomConfigFileObj config : configs) {
                saveProps.setProperty(config.getConfName(), config.getConfDefValue());
            }
            saveProps.store(new FileOutputStream("configs/" + configFile), comment);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    public String getCustomConfig(String filename, String prop) {
        try {
            Properties getProps = new Properties();
            getProps.load(new FileInputStream(filename));
            return getProps.getProperty(prop);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}

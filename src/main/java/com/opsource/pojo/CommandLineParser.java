package com.opsource.pojo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Carla Teixeira
 * Class that parses the command line input
 */
public class CommandLineParser {

    /**
     * Parses command line input into command and parameters
     * @param option
     * @return string array with command and parameters
     */
    public static String[] parse(String option) {
        // remove whitespace from beginning and end
        // prevent spaces within command to affect parameters
        // prevent empty string to generate exception
        if (StringUtils.trim(option).isEmpty())
            return new String[] { StringUtils.EMPTY };

        return StringUtils.split(StringUtils.trim(option));
    }

}

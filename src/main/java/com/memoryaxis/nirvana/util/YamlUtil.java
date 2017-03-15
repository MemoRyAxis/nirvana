package com.memoryaxis.nirvana.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

/**
 * @author memoryaxis@gmail.com
 */
public class YamlUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper(new YAMLFactory());

    public static JsonNode loadFile(String resourceFile) throws IOException {
        return OBJECT_MAPPER.readTree(YamlUtil.class.getResourceAsStream(resourceFile));
    }

}

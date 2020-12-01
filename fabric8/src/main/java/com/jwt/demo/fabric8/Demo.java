package com.jwt.demo.fabric8;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.model.annotation.ApiVersion;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        Config config = new ConfigBuilder()
                .withMasterUrl("https://172.23.0.213:6443")
                .withTrustCerts(true)
                .withUsername("admin")
                .withPassword("1234567890qwertyuiop")
                .build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        NamespaceList list = client.namespaces().list();
        System.out.println(list);
    }
}
